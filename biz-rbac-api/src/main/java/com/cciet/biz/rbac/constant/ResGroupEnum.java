package com.cciet.biz.rbac.constant;

import com.cciet.common.interfaces.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统资源分组枚举
 * @author cmw
 */
@Getter
@AllArgsConstructor
public enum ResGroupEnum implements IEnum {
    ADMIN("管理"),
    USER("用户"),
    MINI_PROGRAM("小程序")
    ;
    String label;

}
