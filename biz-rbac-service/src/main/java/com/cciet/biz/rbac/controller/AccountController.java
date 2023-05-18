package com.cciet.biz.rbac.controller;

import com.cciet.biz.rbac.api.IAccountApi;
import com.cciet.biz.rbac.dto.UserDTO;
import com.cciet.biz.rbac.service.IAccountService;
import com.cciet.biz.rbac.vo.AccountVO;
import com.cciet.common.bean.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* <p>
* 用户账号表 前端控制器
* </p>
*
* @author cmw
* @since 2023/05/18 15:56
*/
@RestController
@RequestMapping("/rbac/account")
public class AccountController implements IAccountApi{

    @Resource
    public IAccountService accountService;
    /**
     * 登录
     * @param userDTO
     * @return
     */
    @Override
    public Result<AccountVO> login(UserDTO userDTO) {
        return Result.ok(accountService.loginLogic(userDTO));
    }

}
