package com.cciet.biz.rbac.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

/**
 * @author huanghui
 * @since 2023/5/9 11:12
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "登录DTO")
@Validated
public class UserDTO {
    @Schema(description = "账号")
    public String account;

    @Schema(description = "密码")
    public String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
