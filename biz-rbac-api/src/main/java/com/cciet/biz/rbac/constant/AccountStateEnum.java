package com.cciet.biz.rbac.constant;

import com.cciet.common.interfaces.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author admin
 */

@Getter
@AllArgsConstructor
public enum AccountStateEnum implements IEnum {
    NORMAL("启动"),
    DISABLE("停用"),
    LOCK("锁定")
    ;
    String label;
}
