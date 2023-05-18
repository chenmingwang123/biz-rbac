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
    PASSWORD_ERR(1101, "账号或者密码错误");

    final Integer code;
    final String msg;

}
