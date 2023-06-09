package com.cciet.biz.rbac.constant.errinfo;

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
    ERR_CEILING(1104, "错误次数已经达到上限"),
    NO_UNLOCK_TIME(1105, "账号未到解锁时间,请稍后重试"),
    ACCOUNT_NAME_EXIST(1106, "账号已存在");

    final Integer code;
    final String msg;

}
