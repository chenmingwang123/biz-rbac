package com.cciet.biz.rbac.vo;

import com.cciet.biz.rbac.constant.ResGroupEnum;
import com.cciet.biz.rbac.constant.ResOpenWithEnum;
import com.cciet.biz.rbac.constant.ResTypeEnum;
import com.cciet.biz.rbac.constant.StateEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * <p>
 * 菜单结果展示
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
@Setter
@Getter
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "菜单结果展示")
public class ResMenuVO {

    @Schema(description = "数据ID")
    private Long id;

    /**
     * 资源名称
     */
    @Schema(description = "资源名称")
    private String name;

    /**
     * 资源分类(目录，菜单，链接，按钮)
     */
    @Schema(description = "资源分类(目录，菜单，链接，按钮)",implementation = ResTypeEnum.class)
    private String assort;

    /**
     * 资源地址
     */
    @Schema(description = "资源地址")
    private String address;

    /**
     * 组件路径
     */
    @Schema(description = "组件路径")
    private String path;

    /**
     * 上级id
     */
    @Schema(description = "上级id")
    private Long pid;

    /**
     * 状态(启用，停用)
     */
    @Schema(description = "状态(启用，停用)",implementation = StateEnum.class)
    private String state;

    /**
     * 图标
     */
    @Schema(description = "图标")
    private String icon;

    /**
     * 打开方式(页签，弹窗，链接，内开)
     */
    @Schema(description = "打开方式(页签，弹窗，链接，内开)",implementation = ResOpenWithEnum.class)
    private String openWith;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remarks;

    /**
     * 资源分组(管理，用户，小程序)
     */
    @Schema(description = "资源分组(管理，用户，小程序)",implementation = ResGroupEnum.class)
    private String resGroup;

    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "子数据")
    private List<ResMenuVO> childrens;

    @Schema(description = "角色id")
    private List<Long> roleIds;
}
