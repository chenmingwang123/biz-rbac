package com.cciet.biz.rbac.controller.login;

import com.cciet.common.bean.Result;
import com.cciet.common.security.ILoginApi;
import com.cciet.common.token.TokenVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

public class LoginBySmsController implements ILoginApi<LoginBySms> {
    @Override
    public Result<TokenVo> login(@Valid LoginBySms loginBySms, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return null;
    }
}
