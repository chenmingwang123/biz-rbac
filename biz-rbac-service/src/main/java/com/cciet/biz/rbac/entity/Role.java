package com.cciet.biz.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cciet.mybatis.supers.SupperEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
@Getter
@Setter
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_role")
public class Role extends SupperEntity<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @TableField("name")
    private String name;

    /**
     * 角色编码
     */
    @TableField("code")
    private String code;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 状态(启用，停用)
     */
    @TableField("state")
    private String state;

    /**
     * 停用原因
     */
    @TableField("stop_reason")
    private String stopReason;
    public static final class Columns{
        private Columns(){}
        /**
        *  name:角色名称
        */
        public static final String NAME = "name";
        /**
        *  code:角色编码
        */
        public static final String CODE = "code";
        /**
        *  remarks:备注
        */
        public static final String REMARKS = "remarks";
        /**
        *  state:状态(启用，停用)
        */
        public static final String STATE = "state";
        /**
        *  stop_reason:停用原因
        */
        public static final String STOP_REASON = "stop_reason";
    }
}
