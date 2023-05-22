package com.cciet.biz.rbac.constant;

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
    ORG_NAME_EXIST(1201, "用户id不存在");

    final Integer code;
    final String msg;

}
