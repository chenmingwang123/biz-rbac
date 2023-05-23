package com.cciet.biz.rbac.constant.errinfo;

import com.cciet.common.interfaces.IResultInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cmw
 * 组织架构异常信息
 */
@Getter
@AllArgsConstructor
public enum OrgInfo implements IResultInfo {
    ORG_CODE_EXIST(1200, "组织编码已存在"),
    USER_DOES_NOT_EXIST(1201, "用户不存在");

    final Integer code;
    final String msg;

}
