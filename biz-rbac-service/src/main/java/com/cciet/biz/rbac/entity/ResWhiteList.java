package com.cciet.biz.rbac.entity;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cciet.mybatis.supers.SupperEntity;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

/**
 * <p>
 * 系统资源白名单表
 * </p>
 *
 * @author cmw
 * @since 2023/05/24 18:08
 */
@Getter
@Setter
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_res_white_list")
public class ResWhiteList extends SupperEntity<ResWhiteList> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源名称
     */
    @TableField("name")
    private String name;

    /**
     * 资源地址
     */
    @TableField("address")
    private String address;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;
    public static final class Columns{
        private Columns(){}
        /**
        *  name:资源名称
        */
        public static final String NAME = "name";
        /**
        *  address:资源地址
        */
        public static final String ADDRESS = "address";
        /**
        *  remarks:备注
        */
        public static final String REMARKS = "remarks";
    }
}
