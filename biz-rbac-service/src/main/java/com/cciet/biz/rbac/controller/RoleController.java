package com.cciet.biz.rbac.controller;

import com.cciet.biz.rbac.api.IRoleApi;
import com.cciet.biz.rbac.constant.StateEnum;
import com.cciet.biz.rbac.dto.OrgRoleDTO;
import com.cciet.biz.rbac.dto.RoleDTO;
import com.cciet.biz.rbac.dto.RoleQueryDTO;
import com.cciet.biz.rbac.service.IRoleService;
import com.cciet.biz.rbac.vo.OrgRoleCurrentVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.bean.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
* <p>
* 角色表 前端控制器
* </p>
*
* @author cmw
* @since 2023/05/23 09:47
*/
@RestController
@RequestMapping("/rbac/role")
public class RoleController implements IRoleApi{

    @Resource
    IRoleService roleService;

    @Override
    public Result<RoleDTO> getById(Long id) {
        return Result.ok(roleService.getById(id));
    }

    @Override
    public Result<Boolean> state(Long id, StateEnum state, String disableCause) {
        return Result.ok(roleService.state(id,state,disableCause));
    }

    @Override
    public Result<RoleDTO> save(RoleDTO roleDTO) {
        return Result.ok(roleService.save(roleDTO));
    }

    @Override
    public Result<OrgRoleDTO> saveOrgRole(OrgRoleDTO orgRoleDTO) {
        return Result.ok(roleService.saveOrgRole(orgRoleDTO));
    }

    @Override
    public Result<List<OrgRoleCurrentVO>> getRolesByOrgId(Long orgId) {
        return Result.ok(roleService.getRolesByOrgId(orgId));
    }

    @Override
    public Result<PageResponse<RoleDTO>> page(PageRequest<RoleQueryDTO> pageRequest) {
        return Result.ok(roleService.page(pageRequest));
    }

    @Override
    public Result<Boolean> delete(Long id) {
        return Result.ok(roleService.delete(id));
    }

    @Override
    public Result<Boolean> deletes(Set<Long> ids) {
        return Result.ok(roleService.deletes(ids));
    }
}
