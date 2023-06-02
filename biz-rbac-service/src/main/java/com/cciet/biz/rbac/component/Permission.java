package com.cciet.biz.rbac.component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cciet.biz.rbac.entity.*;
import com.cciet.biz.rbac.mapper.*;
import com.cciet.common.interfaces.IPermission;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author huanghui
 * @since 2023/5/8 13:32
 */
@Component
public class Permission implements IPermission {
    static final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Resource
    IOrgAccountMapper orgAccountMapper;
    @Resource
    IOrgStructMapper orgStructMapper;
    @Resource
    IOrgRoleMapper orgRoleMapper;
    @Resource
    IRoleResMapper roleResMapper;
    @Resource
    IResMapper resMapper;
    @Resource
    IResWhiteListMapper resWhiteListMapper;

    @Override
    public Boolean isPermissionGranted(Long userId, String url) {
        //查询登录用户岗位和上级岗位
        LambdaQueryWrapper<OrgAccount> orgAccountQueryWrapper = new LambdaQueryWrapper<>();
        orgAccountQueryWrapper.eq(OrgAccount::getAccountId,userId);
        List<OrgAccount> orgAccounts = orgAccountMapper.selectList(orgAccountQueryWrapper);
        if (!CollectionUtils.isEmpty(orgAccounts)){
            Set<Long> orgIds = new HashSet<>();
            for (OrgAccount orgAccount : orgAccounts) {
                //查询父组织
                orgParent(orgAccount.getOrgId(),orgIds);
            }
            //查询岗位角色
            LambdaQueryWrapper<OrgRole> orgRoleQueryWrapper = new LambdaQueryWrapper<>();
            orgRoleQueryWrapper.eq(CollectionUtils.isEmpty(orgIds),OrgRole::getId,-1);
            orgRoleQueryWrapper.in(!CollectionUtils.isEmpty(orgIds),OrgRole::getOrgId,orgIds).select(OrgRole::getRoleId);
            List<Long> roleIds = orgRoleMapper.selectList(orgRoleQueryWrapper).stream().map(OrgRole::getRoleId).collect(Collectors.toList());
            //获取角色访问资源
            if (!CollectionUtils.isEmpty(roleIds)){
                LambdaQueryWrapper<RoleRes> roleResQueryWrapper = new LambdaQueryWrapper<>();
                roleResQueryWrapper.eq(CollectionUtils.isEmpty(roleIds),RoleRes::getId,-1);
                roleResQueryWrapper.in(!CollectionUtils.isEmpty(roleIds),RoleRes::getRoleId,roleIds).select(RoleRes::getResId);
                Set<Long> resIds = roleResMapper.selectList(roleResQueryWrapper).stream().map(RoleRes::getResId).collect(Collectors.toSet());
                //获取具体访问url
                if (!CollectionUtils.isEmpty(resIds)){
                    LambdaQueryWrapper<Res> resQueryWrapper = new LambdaQueryWrapper<>();
                    resQueryWrapper.eq(CollectionUtils.isEmpty(resIds),Res::getId,-1);
                    resQueryWrapper.in(!CollectionUtils.isEmpty(resIds),Res::getId,resIds).select(Res::getAddress);
                    List<String> addressList = resMapper.selectList(resQueryWrapper).stream().map(Res::getAddress).collect(Collectors.toList());
                    //url匹配上，有权访问
                    if(addressList.stream().anyMatch((u -> antPathMatcher.match(u, url)))){
                        return Boolean.TRUE;
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 查询父组织
     * @param id
     * @param orgIds
     */
    public void orgParent(Long id,Set<Long> orgIds){
        orgIds.add(id);
        //查询数据库中对应id的实体类
        OrgStruct orgStruct = orgStructMapper.selectById(id);
        //查询父级架构
        orgStruct = orgStructMapper.selectById(orgStruct.getPid());
        //查询出符合条件的对象
        if(orgStruct!=null){
            //如果查出的对象不为空，则将此对象的id存到全局变量中，并且继续调用自己
            orgIds.add(orgStruct.getId());
            orgParent(orgStruct.getId(),orgIds);
        }
    }

    @Override
    public Boolean isIgnore(String url) {
        //数据库读取白名单
        Set<String> addressSet = resWhiteListMapper.selectList(null).stream().map(ResWhiteList::getAddress).collect(Collectors.toSet());
        if(addressSet.stream().anyMatch((u -> antPathMatcher.match(u, url)))){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
