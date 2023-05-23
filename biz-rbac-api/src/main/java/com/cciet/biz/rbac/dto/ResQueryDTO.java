package com.cciet.biz.rbac.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * 系统资源查询条件
 *
 * @author cmw
 * @since 2023/5/16 18:09
 */
@Setter
@Getter
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "系统资源查询条件")
public class ResQueryDTO {
    /**
     * 系统资源名称
     */
    @Schema(description = "系统资源名称")
    private String name;

}
