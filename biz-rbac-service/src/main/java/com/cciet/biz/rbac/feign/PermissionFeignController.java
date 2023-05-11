package com.cciet.biz.rbac.feign;

import com.cciet.biz.rbac.component.Permission;
import com.cciet.common.apis.IPermissionApi;
import com.cciet.common.bean.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 权限服务Feign实现的接口
 *
 * @author huanghui
 * @since 2023/5/8 13:36
 */
@RestController
@RequestMapping("/permission")
public class PermissionFeignController implements IPermissionApi {

    @Resource
    Permission permission;

    @Override
    public Result<Boolean> isPermissionGrantedApi(Long userId, String url) {
        return Result.ok(permission.isPermissionGranted(userId,url));
    }

    @Override
    public Result<Boolean> isIgnoreApi(String url) {
        return Result.ok(permission.isIgnore(url));
    }

}
