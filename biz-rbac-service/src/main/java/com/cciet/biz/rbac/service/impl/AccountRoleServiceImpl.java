package com.cciet.biz.rbac.service.impl;

import com.cciet.biz.rbac.entity.AccountRole;
import com.cciet.biz.rbac.mapper.IAccountRoleMapper;
import com.cciet.biz.rbac.service.IAccountRoleService;
import com.cciet.mybatis.supers.SupperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号角色关联表 服务实现类
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
@Service
public class AccountRoleServiceImpl extends SupperServiceImpl<IAccountRoleMapper, AccountRole> implements IAccountRoleService {

}
