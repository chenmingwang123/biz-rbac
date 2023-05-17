package com.cciet.biz.rbac.api;

import com.cciet.biz.rbac.dto.UserDTO;
import com.cciet.biz.rbac.vo.AccountVO;
import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户账号表 前端控制器
 * </p>
 *
 * @author cmw
 * @since 2023/05/15 18:02
 */
@RestController
@RequestMapping("/rbac/account")
public interface IAccountApi {


    @Operation(summary = "登录")
    @PostMapping("login")
    Result<AccountVO> login(@RequestBody UserDTO dto);
}
