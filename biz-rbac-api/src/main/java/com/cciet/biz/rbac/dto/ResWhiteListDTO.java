package com.cciet.biz.rbac.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 * 系统资源白名单
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "系统资源白名单")
public class ResWhiteListDTO {

    @Schema(description = "数据ID")
    private Long id;

    /**
     * 资源名称
     */
    @Schema(description = "资源名称")
    private String name;

    /**
     * 资源地址
     */
    @Schema(description = "资源地址")
    private String address;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remarks;


}
