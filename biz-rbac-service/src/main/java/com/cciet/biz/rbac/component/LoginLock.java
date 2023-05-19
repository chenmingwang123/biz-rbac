package com.cciet.biz.rbac.component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cciet.biz.rbac.constant.LoginInfo;
import com.cciet.biz.rbac.entity.Account;
import com.cciet.biz.rbac.mapper.IAccountMapper;
import com.cciet.common.exception.BusinessException;
import com.cciet.common.interfaces.ILoginLock;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    @Override
    public boolean canAbleLogin(String accountName, int loginErrorLimit) {
        //登录验证错误次数
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getAccountName,accountName);
        Account account = accountMapper.selectOne(queryWrapper);
        if(Objects.isNull(account)){
            return false;
        }
        if (account.getPasswordErrorCount() != null && account.getPasswordErrorCount()<loginErrorLimit){
            BusinessException.result(LoginInfo.ERR_CEILING);
        }
        return true;
    }

    @Override
    public void loginSuccess(String accountName) {
        //登录成功清空错误次数，设置时间
        LambdaUpdateWrapper<Account> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Account::getAccountName,accountName).set(Account::getPasswordErrorCount,0)
                .set(Account::getFinalLoginTime,new Date());
        accountMapper.update(null,updateWrapper);

    }

    @Override
    public void loginFailed(String accountName) {
        //登录失败设置次数


    }
}
