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
 * 账号角色关联表
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
@Getter
@Setter
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_account_role")
public class AccountRole extends SupperEntity<AccountRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 账号id
     */
    @TableField("account_id")
    private Long accountId;

    /**
     * 角色id
     */
    @TableField("role_id")
    private Long roleId;
    public static final class Columns{
        private Columns(){}
        /**
        *  account_id:账号id
        */
        public static final String ACCOUNT_ID = "account_id";
        /**
        *  role_id:角色id
        */
        public static final String ROLE_ID = "role_id";
    }
}
