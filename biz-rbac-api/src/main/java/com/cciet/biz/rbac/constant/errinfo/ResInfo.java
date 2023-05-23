package com.cciet.biz.rbac.constant.errinfo;

import com.cciet.common.interfaces.IResultInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cmw
 * 系统资源异常信息
 */
@Getter
@AllArgsConstructor
public enum ResInfo implements IResultInfo {
    RES_NAME_EXIST(1400, "系统资源已存在");

    final Integer code;
    final String msg;

}
