package com.cciet.biz.rbac.controller.login;

import com.cciet.biz.rbac.component.LogInterpret;
import com.cciet.common.bean.Result;
import com.cciet.common.security.ILoginApi;
import com.cciet.common.token.TokenVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author cmw
 */
@Slf4j
@RestController
@RequestMapping("/rbac/pwdLog")
public class LoginByPwdController implements ILoginApi<LoginByPwdDTO> {

    @Resource
    LogInterpret logInterpret;

    /**
     * 登录
     * @param loginByPwdDTO
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @Override
    public Result<TokenVo> login(@Valid LoginByPwdDTO loginByPwdDTO, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        TokenVo token = logInterpret.loginByPwd(loginByPwdDTO, loginByPwdDTO.getAccountName());
        return Result.ok(token);
    }

}
