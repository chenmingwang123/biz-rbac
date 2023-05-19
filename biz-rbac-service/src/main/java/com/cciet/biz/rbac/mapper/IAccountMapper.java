package com.cciet.biz.rbac.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cciet.biz.rbac.entity.Account;
import com.cciet.mybatis.supers.SupperMapper;

/**
 * <p>
 * 用户账号表 Mapper 接口
 * </p>
 *
 * @author cmw
 * @since 2023/05/18 15:56
 */
public interface IAccountMapper extends SupperMapper<Account> {
    /**
     * 根据用户名获取用户
     * @param accountName
     * @return
     */
    default Account getByAccountName(String accountName){
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getAccountName,accountName);
        return selectOne(queryWrapper);
    }
}
