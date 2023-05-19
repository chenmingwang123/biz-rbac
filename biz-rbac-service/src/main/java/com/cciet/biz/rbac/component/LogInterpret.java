package com.cciet.biz.rbac.component;

import cn.hutool.crypto.SecureUtil;
import com.cciet.biz.rbac.constant.AccountStateEnum;
import com.cciet.biz.rbac.constant.LoginInfo;
import com.cciet.biz.rbac.controller.login.LoginByPwdDTO;
import com.cciet.biz.rbac.dto.AccountDTO;
import com.cciet.biz.rbac.service.IAccountService;
import com.cciet.common.exception.BusinessException;
import com.cciet.common.token.TokenVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author huanghui
 * @since 2023/5/8 13:32
 */
@Slf4j
@Component
public class LogInterpret {

    @Resource
    IAccountService accountService;

    public TokenVo loginByPwd(LoginByPwdDTO loginByPwdDTO, String accountName) {
        AccountDTO account = accountService.getByAccountName(accountName);
        String passwordMd5 = SecureUtil.md5(loginByPwdDTO.getPassword());
        //登录失败
        if (ObjectUtils.isEmpty(account) || !passwordMd5.equals(account.getPassword())){
            BusinessException.result(LoginInfo.PASSWORD_ERR);
        }
        //是否启用
        if (AccountStateEnum.DISABLE==account.getState()){
            BusinessException.result(LoginInfo.ACCOUNT_STOP);
        }
        if (AccountStateEnum.LOCK == account.getState()){
            BusinessException.result(LoginInfo.ACCOUNT_LOCK);
        }
//        //创建token
//        TokenContent content = new TokenContent();
//        content.setAccountName(account.getAccountName());
//        content.setDeptId(account.getDepId());
//        content.setOrgId(account.getOrgId());
//        content.setUserId(account.getId());
//        TokenVo token = TokenUtil.createToken(content);
//
//        TokenUser tokenUser = TokenUtil.getTokenUser();
//        tokenUser.getUserOrgId();
//        tokenUser.getUserDeptId();
//
//        log.debug("登录成功：{}",token);
//        return token;
        return null;
    }


}
