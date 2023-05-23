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
 * 角色资源关联表
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
@Getter
@Setter
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_role_res")
public class RoleRes extends SupperEntity<RoleRes> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableField("role_id")
    private Long roleId;

    /**
     * 资源id
     */
    @TableField("res_id")
    private Long resId;
    public static final class Columns{
        private Columns(){}
        /**
        *  role_id:角色id
        */
        public static final String ROLE_ID = "role_id";
        /**
        *  res_id:资源id
        */
        public static final String RES_ID = "res_id";
    }
}
