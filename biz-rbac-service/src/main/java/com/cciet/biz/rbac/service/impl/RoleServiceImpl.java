package com.cciet.biz.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.cciet.biz.rbac.constant.StateEnum;
import com.cciet.biz.rbac.constant.errinfo.RoleInfo;
import com.cciet.biz.rbac.dto.OrgRoleDTO;
import com.cciet.biz.rbac.dto.RoleDTO;
import com.cciet.biz.rbac.dto.RoleQueryDTO;
import com.cciet.biz.rbac.entity.OrgRole;
import com.cciet.biz.rbac.entity.Role;
import com.cciet.biz.rbac.mapper.IOrgRoleMapper;
import com.cciet.biz.rbac.mapper.IRoleMapper;
import com.cciet.biz.rbac.service.IRoleService;
import com.cciet.biz.rbac.vo.OrgRoleCurrentVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.exception.BusinessException;
import com.cciet.mybatis.supers.SupperEntity;
import com.cciet.mybatis.supers.SupperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
@Service
@Slf4j
public class RoleServiceImpl extends SupperServiceImpl<IRoleMapper, Role> implements IRoleService {

    @Resource
    IRoleMapper roleMapper;
    @Resource
    IOrgRoleMapper orgRoleMapper;
    @Override
    public RoleDTO getById(Long id) {
        return BeanUtil.copyProperties(this.getBaseMapper().selectById(id), RoleDTO.class);
    }

    @Override
    public Boolean state(Long id, StateEnum state, String disableCause) {
        UpdateChainWrapper<Role> updateChainWrapper =  this.update();
        updateChainWrapper.set(Role.Columns.STOP_REASON, disableCause);
        updateChainWrapper.set(Role.Columns.STATE, state);
        updateChainWrapper.eq(SupperEntity.Columns.ID,id);
        return updateChainWrapper.update();
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        //新增
        if (roleDTO.getId() == null){
            LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Role::getName,roleDTO.getName());
            //名称存在
            if (!CollectionUtils.isEmpty(roleMapper.selectList(queryWrapper))){
                BusinessException.result(RoleInfo.ROLE_NAME_EXIST);
            }
            LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Role::getCode,roleDTO.getCode());
            //编码存在
            if (!CollectionUtils.isEmpty(roleMapper.selectList(wrapper))){
                BusinessException.result(RoleInfo.ROLE_CODE_EXIST);
            }
            return saveOrUpdate(roleDTO.getId(),roleDTO);
        }else {
            //修改
            LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Role::getName,roleDTO.getName());
            queryWrapper.ne(Role::getId,roleDTO.getId());
            List<Role> roleList = roleMapper.selectList(queryWrapper);
            //名称存在
            if (!CollectionUtils.isEmpty(roleList)){
                BusinessException.result(RoleInfo.ROLE_NAME_EXIST);
            }
            LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Role::getCode,roleDTO.getCode());
            queryWrapper.ne(Role::getId,roleDTO.getId());
            //编码存在
            if (!CollectionUtils.isEmpty(roleMapper.selectList(wrapper))){
                BusinessException.result(RoleInfo.ROLE_CODE_EXIST);
            }
            return saveOrUpdate(roleDTO.getId(),roleDTO);
        }
    }

    @Override
    public PageResponse<RoleDTO> page(PageRequest<RoleQueryDTO> pageRequest) {
        RoleQueryDTO roleQueryDTO =  pageRequest.getQuery();
        LambdaQueryWrapper<Role> wrapper = lambdaQueryWrapper();
        wrapper.orderByDesc(Role::getCreateTime);
        wrapper.orderByDesc(Role::getId);
        wrapper.like(CharSequenceUtil.isNotBlank(roleQueryDTO.getName()),Role::getName,roleQueryDTO.getName());
        wrapper.eq(CharSequenceUtil.isNotBlank(roleQueryDTO.getCode()),Role::getCode,roleQueryDTO.getCode());

        return this.pageBeans(pageRequest,wrapper, RoleDTO.class);
    }

    @Override
    public OrgRoleDTO saveOrgRole(OrgRoleDTO orgRoleDTO) {
        //先清空OrgRole
        LambdaQueryWrapper<OrgRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrgRole::getOrgId,orgRoleDTO.getOrgId());
        orgRoleMapper.delete(queryWrapper);
        if (!CollectionUtils.isEmpty(orgRoleDTO.getRoleId())){
            orgRoleDTO.getRoleId().forEach(roleId ->{
                OrgRole orgRole = new OrgRole();
                orgRole.setOrgId(orgRoleDTO.getOrgId());
                orgRole.setRoleId(roleId);
                orgRoleMapper.insert(orgRole);
            });
        }
        return orgRoleDTO;
    }

    @Override
    public List<OrgRoleCurrentVO> getRolesByOrgId(Long orgId) {
        //获取角色id
        LambdaQueryWrapper<OrgRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrgRole::getOrgId,orgId).select(OrgRole::getRoleId);
        List<Long> roleIds = orgRoleMapper.selectList(queryWrapper).stream().map(OrgRole::getRoleId).collect(Collectors.toList());
        //获取角色信息
        LambdaQueryWrapper<Role> roleQueryWrapper = new LambdaQueryWrapper<>();
        roleQueryWrapper.eq(CollectionUtils.isEmpty(roleIds),Role::getId,-1);
        roleQueryWrapper.in(!CollectionUtils.isEmpty(roleIds),Role::getId,roleIds);
        List<Role> roles = roleMapper.selectList(roleQueryWrapper);
        return BeanUtil.copyToList(roles, OrgRoleCurrentVO.class);
    }

    @Override
    public Boolean delete(Long id) {
        int count = logicDeleteById(id);
        log.debug("根据ID逻辑删除:{},影响：{}条",id,count);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deletes(Set<Long> ids) {
        int count = logicDeleteBatchIds(ids);
        log.debug("根据ID列表逻辑删除:{},影响：{}条",ids,count);
        return Boolean.TRUE;
    }
}
