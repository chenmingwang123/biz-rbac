package com.cciet.biz.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 组织当前的角色VO
 * @author cmw
 */
@Data
@Schema(description = "组织当前的角色VO")
public class OrgRoleCurrentVO {

  @Schema(description = "角色id")
  private Long id;

  @Schema(description = "角色名称")
  private String name;

  @Schema(description = "角色编码")
  private String code;

  @Schema(description = "状态")
  private String state;
}
