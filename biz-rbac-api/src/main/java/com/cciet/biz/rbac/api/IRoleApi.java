package com.cciet.biz.rbac.api;

import com.cciet.biz.rbac.constant.StateEnum;
import com.cciet.biz.rbac.dto.OrgRoleDTO;
import com.cciet.biz.rbac.dto.RoleDTO;
import com.cciet.biz.rbac.dto.RoleQueryDTO;
import com.cciet.biz.rbac.vo.OrgRoleCurrentVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
* <p>
* 角色表 前端控制器接口
* </p>
* @author cmw
* @since 2023/05/23 09:47
*/
@Validated
@Tag(name = "角色管理")
public interface IRoleApi {

    /**
     * 根据ID查询角色信息
     *
     * @param id ID
     * @return Result<AccountVO>
     */
    @GetMapping("/get/id")
    @Operation(summary = "根据ID查询角色信息")
    @Parameter(name = "id", description = "ID", required = true)
    Result<RoleDTO> getById(@RequestParam(value = "id") Long id);

    /**
     * 根据ID更新角色状态
     *
     * @param id           ID
     * @param state        账号状态
     * @param disableCause 禁用原因
     * @return Result<Boolean>
     */
    @PostMapping("/state")
    @Operation(summary = "根据ID更新角色状态", parameters = {
            @Parameter(name = "id", description = "ID", required = true),
            @Parameter(name = "state", description = "账号状态 NORMAL：启用 DISABLE：停用", required = true, schema = @Schema(implementation = StateEnum.class)),
            @Parameter(name = "stopReason", description = "停用原因")
    })
    Result<Boolean> state(@RequestParam(value = "id") Long id, @RequestParam(value = "state") StateEnum state,
                          @RequestParam(value = "disableCause", required = false) String disableCause);

    /**
     * 保存角色信息
     *
     * @param roleDTO RoleDTO
     * @return Result<RoleDTO>
     */
    @PostMapping("/save")
    @Operation(summary = "保存角色信息")
    Result<RoleDTO> save(@RequestBody RoleDTO roleDTO);

    /**
     * 保存组织角色
     *
     * @param orgRoleDTO SysOrgRoleDTO
     * @return Result<SysOrgRoleDTO>
     */
    @PostMapping("/saveOrgRole")
    @Operation(summary = "保存组织角色")
    Result<OrgRoleDTO> saveOrgRole(@RequestBody OrgRoleDTO orgRoleDTO);

    /**
     * 获取当前组织的角色
     *
     * @param orgId
     * @return Result<OrgRoleCurrentVO>
     */
    @GetMapping("/getRolesByOrgId")
    @Operation(summary = "获取当前组织的角色",parameters = {
            @Parameter(name = "orgId", description = "orgId", required = true)
    })
    Result<List<OrgRoleCurrentVO>> getRolesByOrgId(@RequestParam(value = "orgId") Long orgId);

    /**
     * 分页条件查询角色信息
     *
     * @param pageRequest PageRequest<RoleQueryDTO>
     * @return Result<PageResponse < RoleDTO>>
     */
    @PostMapping("/page")
    @Operation(summary = "分页条件查询角色信息")
    Result<PageResponse<RoleDTO>> page(@RequestBody PageRequest<RoleQueryDTO> pageRequest);

    /**
     * 根据ID逻辑删除角色信息
     *
     * @param id ID
     * @return Result<Boolean>
     */
    @DeleteMapping("/delete")
    @Operation(summary = "根据ID逻辑删除角色信息")
    @Parameter(name = "id", description = "ID", required = true)
    Result<Boolean> delete(@RequestParam(value = "id") Long id);

    /**
     * 根据ID列表逻辑删除角色信息
     * ID列表逗号分隔
     *
     * @param ids ID列表
     * @return Result<Boolean>
     */
    @DeleteMapping("/deletes")
    @Operation(summary = "根据ID列表逻辑删除角色信息", description = "ID列表逗号分隔")
    @Parameter(name = "ids", description = "ID列表", required = true)
    Result<Boolean> deletes(@RequestParam(value = "ids") Set<Long> ids);

}
