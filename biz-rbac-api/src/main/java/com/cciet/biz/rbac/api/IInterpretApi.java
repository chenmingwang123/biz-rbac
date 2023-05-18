package com.cciet.biz.rbac.api;

import com.cciet.biz.rbac.dto.UserDTO;
import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 字段翻译DEMO
 *
 * @author huanghui
 * @since 2023/5/12 9:15
 */
@Validated
@Tag(name = "字段翻译DEMO")
@RequestMapping("/account")
public interface IInterpretApi {

    /**
     * 登录
     * @param dto
     * @return
     */
    @Operation(summary = "登录")
    @PostMapping("login")
    Result<UserDTO> login(@RequestBody UserDTO dto);
}
