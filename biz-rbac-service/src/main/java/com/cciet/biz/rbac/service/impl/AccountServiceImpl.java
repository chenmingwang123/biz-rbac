package com.cciet.biz.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cciet.biz.rbac.dto.UserDTO;
import com.cciet.biz.rbac.entity.Account;
import com.cciet.biz.rbac.mapper.IAccountMapper;
import com.cciet.biz.rbac.service.IAccountService;
import com.cciet.biz.rbac.vo.AccountVO;
import com.cciet.common.bean.Result;
import com.cciet.common.enums.AuthError;
import com.cciet.mybatis.supers.SupperServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author cmw
 * @since 2023/05/15 18:02
 */
@Service
public class AccountServiceImpl extends SupperServiceImpl<IAccountMapper, Account> implements IAccountService {

    @Resource
    public IAccountMapper accountMapper;

    /**
     * 登录
     * @param userDTO
     * @return
     */
    @Override
    public Result<AccountVO> loginLogic(UserDTO userDTO) {
        //加密
        String passwordMd5 = SecureUtil.md5(userDTO.getPassword());
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getAccount,userDTO.getAccount()).eq(Account::getPassword,passwordMd5);
        Account account = accountMapper.selectOne(queryWrapper);
        //登录失败
        if (ObjectUtils.isEmpty(account)){
            return AuthError.LOGIN_FAIL.resultMsg("账号或者密码错误!");
        }
        AccountVO accountVO = new AccountVO();
        BeanUtil.copyProperties(account,accountVO);
        return Result.ok(accountVO);
    }
}
