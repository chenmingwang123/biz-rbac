package com.cciet.biz.rbac.bean.interpret;

import com.cciet.common.interfaces.IEnum;
import lombok.AllArgsConstructor;

/**
 *
 * @author huanghui
 * @since 2023/5/10 16:33
 */
@AllArgsConstructor
public enum NodeType implements IEnum {
    ROOT("根节点"),
    LEAF("叶子节点");

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
