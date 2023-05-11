package com.cciet.biz.rbac.component;

import com.cciet.common.interfaces.IPermission;
import org.springframework.stereotype.Component;

/**
 * @author huanghui
 * @since 2023/5/8 13:32
 */
@Component
public class Permission implements IPermission {
    @Override
    public Boolean isPermissionGranted(Long userId, String url) {
        return Boolean.TRUE;
    }

    @Override
    public Boolean isIgnore(String url) {
        return Boolean.TRUE;
    }

}
