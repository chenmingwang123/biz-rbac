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
 * 系统资源表
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
@Getter
@Setter
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_res")
public class Res extends SupperEntity<Res> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源名称
     */
    @TableField("name")
    private String name;

    /**
     * 资源分类(目录，菜单，链接，按钮)
     */
    @TableField("assort")
    private String assort;

    /**
     * 资源地址
     */
    @TableField("address")
    private String address;

    /**
     * 组件路径
     */
    @TableField("path")
    private String path;

    /**
     * 上级id
     */
    @TableField("pid")
    private Long pid;

    /**
     * 状态(启用，停用)
     */
    @TableField("state")
    private String state;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 打开方式(页签，弹窗，链接，内开)
     */
    @TableField("open_with")
    private String openWith;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 资源分组(管理，用户，小程序)
     */
    @TableField("res_group")
    private String resGroup;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    @TableField(exist = false)
    private List<Res> childrens = new ArrayList<>();

    /**
     * 角色id
     */
    @TableField(exist = false)
    private List<Long> roleIds = new ArrayList<>();
    public static final class Columns{
        private Columns(){}
        /**
        *  name:资源名称
        */
        public static final String NAME = "name";
        /**
        *  assort:资源分类(目录，菜单，链接，按钮)
        */
        public static final String ASSORT = "assort";
        /**
        *  address:资源地址
        */
        public static final String ADDRESS = "address";
        /**
        *  path:组件路径
        */
        public static final String PATH = "path";
        /**
        *  pid:上级id
        */
        public static final String PID = "pid";
        /**
        *  state:状态(启用，停用)
        */
        public static final String STATE = "state";
        /**
        *  icon:图标
        */
        public static final String ICON = "icon";
        /**
        *  open_with:打开方式(页签，弹窗，链接，内开)
        */
        public static final String OPEN_WITH = "open_with";
        /**
        *  remarks:备注
        */
        public static final String REMARKS = "remarks";
        /**
        *  res_group:资源分组(管理，用户，小程序)
        */
        public static final String RES_GROUP = "res_group";
        /**
        *  sort:排序
        */
        public static final String SORT = "sort";
    }
}
