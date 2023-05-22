package com.cciet.biz.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cciet.mybatis.supers.SupperEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 组织架构表
 * </p>
 *
 * @author cmw
 * @since 2023/05/18 15:56
 */
@Getter
@Setter
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_org_struct")
public class OrgStruct extends SupperEntity<OrgStruct> {

    private static final long serialVersionUID = 1L;

    /**
     * 组织全称
     */
    @TableField("org_name")
    private String orgName;

    /**
     * 组织简称
     */
    @TableField("org_abbreviation")
    private String orgAbbreviation;

    /**
     * 组织简码
     */
    @TableField("org_abbreviation_code")
    private String orgAbbreviationCode;

    /**
     * 组织编码
     */
    @TableField("org_code")
    private String orgCode;

    /**
     * 组织路径
     */
    @TableField("path")
    private String path;

    /**
     * 上级组织
     */
    @TableField("pid")
    private Long pid;

    @TableField(exist = false)
    private List<OrgStruct> childrens = new ArrayList<>();

    /**
     * 组织类型(公司，部门，小组，岗位)
     */
    @TableField("org_type")
    private String orgType;
    public static final class Columns{
        private Columns(){}
        /**
        *  org_full_name:组织全称
        */
        public static final String ORG_NAME = "org_name";
        /**
        *  org_abbreviation:组织简称
        */
        public static final String ORG_ABBREVIATION = "org_abbreviation";
        /**
        *  org_abbreviation_code:组织简码
        */
        public static final String ORG_ABBREVIATION_CODE = "org_abbreviation_code";
        /**
        *  org_code:组织编码
        */
        public static final String ORG_CODE = "org_code";
        /**
        *  path:组织路径
        */
        public static final String PATH = "path";
        /**
        *  pid:上级组织
        */
        public static final String PID = "pid";
        /**
        *  org_type:组织类型(公司，部门，小组，岗位)
        */
        public static final String ORG_TYPE = "org_type";
    }
}
