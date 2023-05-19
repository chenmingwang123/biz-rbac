package com.cciet.biz.rbac.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * 账号查询条件
 *
 * @author cmw
 * @since 2023/5/16 18:09
 */
@Setter
@Getter
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "账号查询条件")
public class AccountQueryDTO {
    /**
     * 登录账号名称
     */
    @Schema(description = "登录账号名称")
    private String accountName;


    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickname;
}
