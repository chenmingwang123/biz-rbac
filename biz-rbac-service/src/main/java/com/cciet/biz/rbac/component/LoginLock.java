package com.cciet.biz.rbac.component;

import com.cciet.common.interfaces.ILoginLock;
import org.springframework.stereotype.Component;

/**
 * LoginLock 实现
 *
 * @author huanghui
 * @since 2023/5/8 13:31
 */
@Component
public class LoginLock implements ILoginLock {
    @Override
    public boolean canAbleLogin(String accountName, int loginErrorLimit) {
        return true;
    }

    @Override
    public void loginSuccess(String accountName) {

    }

    @Override
    public void loginFailed(String accountName) {

    }
}
