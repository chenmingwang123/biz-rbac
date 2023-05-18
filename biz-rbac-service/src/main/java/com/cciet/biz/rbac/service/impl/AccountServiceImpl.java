package com.cciet.biz.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cciet.biz.rbac.constant.LoginInfo;
import com.cciet.biz.rbac.dto.UserDTO;
import com.cciet.biz.rbac.entity.Account;
import com.cciet.biz.rbac.mapper.IAccountMapper;
import com.cciet.biz.rbac.service.IAccountService;
import com.cciet.biz.rbac.vo.AccountVO;
import com.cciet.common.exception.BusinessException;
import com.cciet.mybatis.supers.SupperServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author cmw
 * @since 2023/05/18 15:56
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class AccountServiceImpl extends SupperServiceImpl<IAccountMapper, Account> implements IAccountService {

    @Resource
    public IAccountMapper accountMapper;
    @Override
    public AccountVO loginLogic(UserDTO userDTO) {
        //加密
        String passwordMd5 = SecureUtil.md5(userDTO.getPassword());
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getAccountName,userDTO.getAccount()).eq(Account::getPassword,passwordMd5);
        Account account = accountMapper.selectOne(queryWrapper);
        //登录失败
        if (ObjectUtils.isEmpty(account)){
            BusinessException.result(LoginInfo.PASSWORD_ERR);
        }
        AccountVO accountVO = new AccountVO();
        BeanUtil.copyProperties(account,accountVO);
        return accountVO;
    }

}
