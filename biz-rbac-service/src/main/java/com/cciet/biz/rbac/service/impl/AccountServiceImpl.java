package com.cciet.biz.rbac.service.impl;

import com.cciet.biz.rbac.entity.Account;
import com.cciet.biz.rbac.mapper.AccountMapper;
import com.cciet.biz.rbac.service.AccountService;
import com.cciet.mybatis.supers.SupperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账号 服务实现类
 * </p>
 *
 * @author huanghui
 * @since 2023/05/15 09:09
 */
@Service
public class AccountServiceImpl extends SupperServiceImpl<AccountMapper, Account> implements AccountService {

}
