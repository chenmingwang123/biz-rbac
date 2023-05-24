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
 * 组织账号关联表
 * </p>
 *
 * @author cmw
 * @since 2023/05/24 10:24
 */
@Getter
@Setter
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_org_account")
public class OrgAccount extends SupperEntity<OrgAccount> {

    private static final long serialVersionUID = 1L;

    /**
     * 账号id
     */
    @TableField("account_id")
    private Long accountId;

    /**
     * 组织id
     */
    @TableField("org_id")
    private Long orgId;

    /**
     * 组织类型(公司组织，部门，小组，岗位)
     */
    @TableField("org_type")
    private String orgType;
    public static final class Columns{
        private Columns(){}
        /**
        *  account_id:账号id
        */
        public static final String ACCOUNT_ID = "account_id";
        /**
        *  org_id:组织id
        */
        public static final String ORG_ID = "org_id";
        /**
        *  org_type:组织类型(公司组织，部门，小组，岗位)
        */
        public static final String ORG_TYPE = "org_type";
    }
}
