package com.cciet.biz.rbac.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

/**
 * 角色查询条件
 *
 * @author cmw
 * @since 2023/5/16 18:09
 */
@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "角色查询条件")
public class RoleQueryDTO {
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
}
