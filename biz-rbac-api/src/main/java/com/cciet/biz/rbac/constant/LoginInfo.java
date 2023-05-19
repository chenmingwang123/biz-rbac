package com.cciet.biz.rbac.constant;

import com.cciet.common.interfaces.IResultInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cmw
 * 登录异常信息
 */
@Getter
@AllArgsConstructor
public enum LoginInfo implements IResultInfo {
    PASSWORD_ERR(1101, "账号或者密码错误"),
    ACCOUNT_STOP(1102, "账号已被停用"),
    ACCOUNT_LOCK(1103, "账号已被锁定"),
    ERR_CEILING(1104, "错误次数已经达到上限");

    final Integer code;
    final String msg;

}
