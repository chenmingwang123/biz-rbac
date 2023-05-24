package com.cciet.biz.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

/**
 * 账号摘要信息
 *
 * @author huanghui
 * @since 2023/5/16 18:20
 */
@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "账号摘要信息")
public class AccountSummaryVO {
    /**
     * 登录账号名称
     */
    @Schema(description = "登录账号名称")
    private String accountName;

    /**
     * 登录密码
     */
    @Schema(description = "登录密码")
    private String password;

    /**
     * 头像地址
     */
    @Schema(description = "头像地址")
    private String portrait;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickname;
}
