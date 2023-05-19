package com.cciet.biz.rbac.controller;

import com.cciet.biz.rbac.api.IAccountApi;
import com.cciet.biz.rbac.constant.AccountStateEnum;
import com.cciet.biz.rbac.dto.AccountDTO;
import com.cciet.biz.rbac.dto.AccountQueryDTO;
import com.cciet.biz.rbac.service.IAccountService;
import com.cciet.biz.rbac.vo.AccountSummaryVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.bean.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

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
    IAccountService accountService;

    @Override
    public Result<AccountDTO> getById(Long id) {
        return Result.ok(accountService.getById(id));
    }

    @Override
    public Result<AccountDTO> getAccountName(String accountName) {
        return Result.ok(accountService.getByAccountName(accountName));
    }

    @Override
    public Result<AccountSummaryVO> summaryById(Long id) {
        return Result.ok(accountService.summaryById(id));
    }

    @Override
    public Result<AccountSummaryVO> summaryByAccountName(String accountName) {
        return Result.ok(accountService.summaryByAccountName(accountName));
    }

    @Override
    public Result<Boolean> resetPwd(Long id) {
        return Result.ok(accountService.resetPwd(id));
    }

    @Override
    public Result<Boolean> state(Long id, AccountStateEnum state, String disableCause) {
        return Result.ok(accountService.state(id,state,disableCause));
    }

    @Override
    public Result<AccountDTO> save(AccountDTO accountDto) {
        return Result.ok(accountService.save(accountDto));
    }

    @Override
    public Result<PageResponse<AccountDTO>> page(PageRequest<AccountQueryDTO> pageRequest) {
        return Result.ok(accountService.page(pageRequest));
    }

    @Override
    public Result<Boolean> delete(Long id) {
        return Result.ok(accountService.delete(id));
    }

    @Override
    public Result<Boolean> deletes(Set<Long> ids) {
        return Result.ok(accountService.deletes(ids));
    }
}
