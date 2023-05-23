package com.cciet.biz.rbac.constant.errinfo;

import com.cciet.common.interfaces.IResultInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cmw
 * 角色异常信息
 */
@Getter
@AllArgsConstructor
public enum RoleInfo implements IResultInfo {
    ROLE_NAME_EXIST(1300, "角色名称已存在"),
    ROLE_CODE_EXIST(1301, "角色编码已存在");

    final Integer code;
    final String msg;

}
