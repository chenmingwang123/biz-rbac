package com.cciet.biz.rbac.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author cmw
 * @since 2023/5/9 11:12
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "组织修改DTO")
@Validated
public class OrgUpateDTO {

    @Schema(description = "ID")
    private Long id;
    @NotBlank
    @Schema(description = "组织编码")
    public String orgCode;

    @NotBlank
    @Schema(description = "组织简码")
    private String orgAbbreviationCode;

    @NotBlank
    @Schema(description = "组织全称")
    public String orgName;

    @NotBlank
    @Schema(description = "组织简称")
    private String orgAbbreviation;

    @Override
    public String toString() {
        return "OrgSaveDTO{" +
                "orgCode='" + orgCode + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgAbbreviation='" + orgAbbreviation + '\'' +
                ", orgAbbreviationCode='" + orgAbbreviationCode +
                '}';
    }
}
