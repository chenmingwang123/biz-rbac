package com.cciet.biz.rbac.feign;

import com.cciet.biz.rbac.component.LoginLock;
import com.cciet.common.apis.ILoginLockApi;
import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户登录锁定功能接口定义
 *
 * @author huanghui
 * @since 2023/5/8 13:36
 */
@Hidden
@RestController
@RequestMapping("/lock")
public class LoginLockFeignController implements ILoginLockApi {

    @Resource
    LoginLock loginLock;

    @Override
    public Result<Boolean> canAbleLoginApi(String accountName, int loginErrorLimit) {
        return Result.ok(loginLock.canAbleLogin(accountName,loginErrorLimit));
    }

    @Override
    public Result<Boolean> loginSuccessApi(String accountName) {
        loginLock.loginSuccess(accountName);
        return Result.ok(Boolean.TRUE);
    }

    @Override
    public Result<Boolean> loginFailedApi(String accountName,int loginErrorLimit) {
        loginLock.loginFailed(accountName,loginErrorLimit);
        return Result.ok(Boolean.TRUE);
    }

}
