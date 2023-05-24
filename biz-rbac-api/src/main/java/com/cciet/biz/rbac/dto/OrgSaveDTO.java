package com.cciet.biz.rbac.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author cmw
 * @since 2023/5/9 11:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "组织新增DTO")
@Validated
public class OrgSaveDTO {

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

    @NotBlank
    @Schema(description = "组织类型(公司，部门，小组，岗位)")
    private String orgType;

    @Schema(description = "上级组织")
    private Long pid;

    @Schema(description = "组织路径")
    private String path;

}
