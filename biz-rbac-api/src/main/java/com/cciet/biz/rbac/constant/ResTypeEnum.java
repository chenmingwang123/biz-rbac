package com.cciet.biz.rbac.constant;

import com.cciet.common.interfaces.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统资源类型枚举
 * @author cmw
 */
@Getter
@AllArgsConstructor
public enum ResTypeEnum implements IEnum {
    CATALOGUE("目录"),
    MENU("菜单"),
    LINK("链接"),
    BUTTON("按钮")
    ;
    String label;
}
