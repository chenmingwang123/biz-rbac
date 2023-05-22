package com.cciet.biz.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 账号摘要信息
 *
 * @author huanghui
 * @since 2023/5/16 18:20
 */
@Setter
@Getter
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "组织结构展示")
public class OrgQueryVO {
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "上级组织")
    private Long pid;

    @Schema(description = "组织路径")
    private String path;

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

    @Schema(description = "创建人")
    private Long createUserId;

    @Schema(description = "子数据")
    private List<OrgQueryVO> childrens;
}
