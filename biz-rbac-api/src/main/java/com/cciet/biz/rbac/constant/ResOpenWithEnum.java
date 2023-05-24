package com.cciet.biz.rbac.constant;

import com.cciet.common.interfaces.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统资源打开方式枚举
 * @author cmw
 */
@Getter
@AllArgsConstructor
public enum ResOpenWithEnum implements IEnum {
    TABS("页签"),
    POP("弹窗"),
    LINK("链接"),
    INTERNAL("内开")
    ;
    String label;

}
