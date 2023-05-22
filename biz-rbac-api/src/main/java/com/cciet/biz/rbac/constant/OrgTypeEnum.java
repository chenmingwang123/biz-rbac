package com.cciet.biz.rbac.constant;

import com.cciet.common.interfaces.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author admin
 * 组织类型枚举
 */
@Getter
@AllArgsConstructor
public enum OrgTypeEnum implements IEnum {
    COMPANY("公司"),
    DEP("部门"),
    GROUP("小组"),
    POST("岗位")
    ;
    String label;

    @Override
    public String toString() {
        return this.name().concat(":").concat(label);
    }
}
