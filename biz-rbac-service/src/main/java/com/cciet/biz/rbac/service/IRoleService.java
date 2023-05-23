package com.cciet.biz.rbac.service;

import com.cciet.biz.rbac.dto.RoleDTO;
import com.cciet.biz.rbac.dto.RoleQueryDTO;
import com.cciet.biz.rbac.entity.Role;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.mybatis.supers.ISupperService;

import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
public interface IRoleService extends ISupperService<Role> {

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    RoleDTO getById(Long id);

    /**
     * 更新状态
     * @param id
     * @param state
     * @param disableCause
     * @return
     */
    Boolean state(Long id, String state, String disableCause);

    /**
     * 保存角色信息
     *
     * @param roleDTO RoleDTO
     * @return RoleDTO
     */
    RoleDTO save(RoleDTO roleDTO);

    /**
     * 分页条件查询角色信息
     *
     * @param pageRequest PageRequest<RoleQueryDTO>
     * @return PageResponse<RoleDTO>
     */
    PageResponse<RoleDTO> page(PageRequest<RoleQueryDTO> pageRequest);

    /**
     * 根据id逻辑删除
     * @param id
     * @return
     */
    Boolean delete(Long id);

    /**
     * 根据ID列表逻辑删除账号信息
     * @param ids
     * @return
     */
    Boolean deletes(Set<Long> ids);
}
