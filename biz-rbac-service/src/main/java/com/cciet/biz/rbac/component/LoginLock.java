package com.cciet.biz.rbac.component;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cciet.biz.rbac.constant.AccountStateEnum;
import com.cciet.biz.rbac.constant.errinfo.LoginInfo;
import com.cciet.biz.rbac.entity.Account;
import com.cciet.biz.rbac.mapper.IAccountMapper;
import com.cciet.biz.rbac.service.IAccountService;
import com.cciet.common.exception.BusinessException;
import com.cciet.common.interfaces.ILoginLock;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * LoginLock 实现
 *
 * @author huanghui
 * @since 2023/5/8 13:31
 */
@Component
public class LoginLock implements ILoginLock {
    @Resource
    public IAccountMapper accountMapper;
    @Resource
    public IAccountService accountService;

    /**
     * 登录前回调
     * @param accountName
     * @param loginErrorLimit
     * @return
     */
    @Override
    public boolean canAbleLogin(String accountName, int loginErrorLimit) {
        //登录验证错误次数
        Account account = accountService.getByAccountName(accountName);
        if(Objects.isNull(account)){
            return false;
        }
        //是否启用
        if (account.getAutoActivationTime() == null && AccountStateEnum.DISABLE==account.getState()){
            BusinessException.result(LoginInfo.ACCOUNT_STOP);
        }
        if (account.getAutoActivationTime() == null && AccountStateEnum.LOCK == account.getState()){
            BusinessException.result(LoginInfo.ACCOUNT_LOCK);
        }
        //没有激活时间，使用错误次数判断
        if (account.getPasswordErrorCount() != 0 && account.getAutoActivationTime() == null && account.getPasswordErrorCount()>=loginErrorLimit){
            BusinessException.result(LoginInfo.ERR_CEILING);
        }
        if (account.getAutoActivationTime() != null && account.getAutoActivationTime().isAfter(LocalDateTime.now())){
            BusinessException.result(LoginInfo.NO_UNLOCK_TIME);
        }
        return true;
    }

    /**
     * 登录成功回调
     * @param accountName
     */
    @Override
    public void loginSuccess(String accountName) {
        //登录成功清空错误次数，设置时间
        LambdaUpdateWrapper<Account> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Account::getAccountName,accountName).set(Account::getPasswordErrorCount,0)
                .set(Account::getFinalLoginTime,new Date()).set(Account::getAutoActivationTime,null)
                .set(Account::getState,AccountStateEnum.NORMAL.name());
        accountMapper.update(null,updateWrapper);

    }

    /**
     * 登录错误回调
     *
     * @param accountName
     * @param loginErrorLimit
     */
    @Override
    public void loginFailed(String accountName,int loginErrorLimit) {
        Account account = accountService.getByAccountName(accountName);
        //登录失败设置次数
        LambdaUpdateWrapper<Account> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Account::getAccountName,accountName).set(Account::getPasswordErrorCount,account.getPasswordErrorCount()+1);
        //最后一次登录锁定账号
        if ((account.getPasswordErrorCount()+1) % loginErrorLimit == 0){
            updateWrapper.set(Account::getState, AccountStateEnum.LOCK.name()).set(Account::getLockTime,new Date())
                    .set(Account::getAutoActivationTime,DateUtil.offsetDay(new Date(), 1));
        }
        accountMapper.update(null,updateWrapper);
    }
}
