package com.cciet.biz.rbac.dto;

import com.cciet.biz.rbac.constant.AccountStateEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * AccountDto
 *
 * @author cmw
 * @since 2023/5/16 18:09
 */
@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "账号信息")
public class AccountDTO {
    /**
     * 数据ID
     */
    @Schema(description = "数据ID")
    private Long id;

    @Schema(description = "组织id")
    private List<Long> orgId;

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
    private String headSculpture;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickName;

    /**
     * 启(normal)/停(disable)/锁(lock)状态
     */
    @Schema(description = "启(normal)/停(disable)/锁(lock)状态",implementation = AccountStateEnum.class)
    private AccountStateEnum state;

    /**
     * 密码错误次数
     */
    @Schema(description = "密码错误次数")
    private Integer passwordErrorCount;

    /**
     * 停用原因
     */
    @Schema(description = "停用原因")
    private String deactivateReason;

}
