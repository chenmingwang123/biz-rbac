package com.cciet.biz.rbac.controller.login;

import com.cciet.common.security.LoginParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author cmw
 */
@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginByPwdDTO extends LoginParam {
    /**
     * 登录密码
     */
    @NotBlank
    String password;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}