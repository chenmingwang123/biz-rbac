package com.cciet.biz.rbac.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author admin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrgRoleDTO {

  /**
   * 组织id
   */
  @Schema(description = "组织id")
  private Long orgId;

  /**
   * 角色id
   */
  @Schema(description = "角色id")
  private List<Long> roleId;
}
