package com.cciet.biz.rbac.constant;

import com.cciet.common.interfaces.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用状态枚举
 * @author cmw
 */
@Getter
@AllArgsConstructor
public enum StateEnum implements IEnum {
    NORMAL("启动"),
    DISABLE("停用"),
    ;
    String label;

    @Override
    public String toString() {
        return this.name().concat(":").concat(label);
    }
}
