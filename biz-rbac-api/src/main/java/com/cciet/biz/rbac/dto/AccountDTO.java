package com.cciet.biz.rbac.dto;

import com.cciet.biz.rbac.constant.AccountStateEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

/**
 * AccountDto
 *
 * @author cmw
 * @since 2023/5/16 18:09
 */
@Setter
@Getter
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
    private Long orgId;

    @Schema(description = "部门id")
    private Long depId;

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

    /**
     * 最近一次修改密码时间
     */
    @Schema(description = "最近一次修改密码时间")
    private LocalDateTime updatePwdTime;

    /**
     * 密码错误次数
     */
    @Schema(description = "密码错误次数")
    private Integer wrongPwdNum;

    /**
     * 登录后需要修改密码
     */
    @Schema(description = "登录后需要修改密码")
    private Boolean needChangePwd;

    /**
     * 资源id
     */
    @Schema(description = "资源id")
    private LocalDateTime lastLoginTime;

    /**
     * 启(normal)/停(disable)/锁(lock)状态
     */
    @Schema(description = "启(normal)/停(disable)/锁(lock)状态")
    private AccountStateEnum state;

    /**
     * 停用时间
     */
    @Schema(description = "停用时间")
    private LocalDateTime disableTime;

    /**
     * 停用原因
     */
    @Schema(description = "停用原因")
    private String disableCause;

    /**
     * 锁定时间
     */
    @Schema(description = "锁定时间")
    private LocalDateTime localTime;

    /**
     * 自动激活时间
     */
    @Schema(description = "自动激活时间")
    private LocalDateTime autoActivateTime;

    /**
     * 最后一次激活时间
     */
    @Schema(description = "最后一次激活时间")
    private LocalDateTime activateTime;
}
