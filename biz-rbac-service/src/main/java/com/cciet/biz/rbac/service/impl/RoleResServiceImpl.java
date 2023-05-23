package com.cciet.biz.rbac.service.impl;

import com.cciet.biz.rbac.entity.RoleRes;
import com.cciet.biz.rbac.mapper.IRoleResMapper;
import com.cciet.biz.rbac.service.IRoleResService;
import com.cciet.mybatis.supers.SupperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色资源关联表 服务实现类
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
@Service
public class RoleResServiceImpl extends SupperServiceImpl<IRoleResMapper, RoleRes> implements IRoleResService {

}
