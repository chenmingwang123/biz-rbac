package com.cciet.biz.rbac.controller;

import com.cciet.biz.rbac.bean.interpret.User;
import com.cciet.biz.rbac.entity.Account;
import com.cciet.biz.rbac.service.AccountService;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.bean.Result;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户账号 前端控制器
 * </p>
 *
 * @author huanghui
 * @since 2023/05/04 12:48
 */
@Validated
@RestController
@Tag(name = "用户接口")
@RequestMapping("/user/account")
public class AccountController {

    @Resource
    AccountService accountService;

    @Operation(summary = "获取全部用户")
    @GetMapping("/all")
    public Result<List<Account>> getAll(){
        return Result.ok(accountService.list());
    }






}
