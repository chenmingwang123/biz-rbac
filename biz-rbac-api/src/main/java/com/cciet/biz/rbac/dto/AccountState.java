package com.cciet.biz.rbac.dto;

import com.cciet.common.interfaces.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author admin
 */

@Getter
@AllArgsConstructor
public enum AccountState implements IEnum {
    NORMAL("启动"),
    DISABLE("停用"),
    LOCK("锁定")
    ;
    String label;

    @Override
    public String toString() {
        return this.name().concat(":").concat(label);
    }
}
