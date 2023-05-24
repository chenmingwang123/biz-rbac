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
    ORG("公司组织"),
    DEP("部门"),
    GROUP("小组"),
    POST("岗位")
    ;
    String label;

    /**
     * 根据key获取枚举
     * @param key
     * @return
     */
    public static OrgTypeEnum parse(String key){
        for (OrgTypeEnum item : OrgTypeEnum.values()){
            if (item.name().toString().equals(key)) {
                return item;
            }
        }
        return null;
    }
}
