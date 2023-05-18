package com.cciet.biz.rbac.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

/**
 * @author huanghui
 * @since 2023/5/9 11:12
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "组织新增DTO")
@Validated
public class OrgSaveDTO {

    @Schema(description = "ID")
    private Long id;
    @Schema(description = "组织编码")
    public String orgCode;

    @Schema(description = "组织简码")
    private String orgAbbreviationCode;

    @Schema(description = "组织全称")
    public String orgName;

    @Schema(description = "组织简称")
    private String orgAbbreviation;

    @Schema(description = "组织类型(公司，部门，小组)")
    private String orgType;

    @Schema(description = "上级组织")
    private Long pid;

    @Override
    public String toString() {
        return "OrgSaveDTO{" +
                "orgCode='" + orgCode + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgAbbreviation='" + orgAbbreviation + '\'' +
                ", orgAbbreviationCode='" + orgAbbreviationCode + '\'' +
                ", orgType='" + orgType + '\'' +
                ", pid=" + pid +
                '}';
    }
}
