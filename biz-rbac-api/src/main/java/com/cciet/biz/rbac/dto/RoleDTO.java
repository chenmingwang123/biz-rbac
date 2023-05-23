package com.cciet.biz.rbac.dto;

import com.cciet.biz.rbac.constant.StateEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 * 角色表
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
@Schema(description = "角色信息")
public class RoleDTO {

    @Schema(description = "ID")
    private Long id;

    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String name;

    /**
     * 角色编码
     */
    @Schema(description = "角色编码")
    private String code;

    /**
     * 描述
     */
    @Schema(description = "备注")
    private String remarks;

    /**
     * 状态(启用，停用)
     */
    @Schema(description = "状态(启用，停用)",implementation = StateEnum.class)
    private String state;

    /**
     * 停用原因
     */
    @Schema(description = "停用原因")
    private String stopReason;
}
