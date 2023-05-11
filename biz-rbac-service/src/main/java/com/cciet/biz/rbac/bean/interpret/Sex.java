package com.cciet.biz.rbac.bean.interpret;

import com.cciet.common.interfaces.IEnum;
import lombok.AllArgsConstructor;

/**
 * 性别
 *
 * @author huanghui
 * @since 2023/5/9 11:13
 */
@AllArgsConstructor
public enum Sex implements IEnum {
    F("男"),
    M("女");

    final String label;

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return this.name().concat(":").concat(label);
    }
}
