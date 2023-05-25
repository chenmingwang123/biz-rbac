package com.cciet.biz.rbac.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * 系统资源白名单查询条件
 *
 * @author cmw
 * @since 2023/5/16 18:09
 */
@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "系统资源白名单查询条件")
public class ResWhiteListQueryDTO {
    /**
     * 名称
     */
    @Schema(description = "名称")
    private String name;

}
