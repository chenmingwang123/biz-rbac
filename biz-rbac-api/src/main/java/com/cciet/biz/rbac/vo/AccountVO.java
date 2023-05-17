package com.cciet.biz.rbac.vo;

import com.cciet.biz.rbac.dto.AccountState;
import com.cciet.common.interpret.Interpret;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户账号表
 * </p>
 *
 * @author cmw
 * @since 2023/05/15 18:02
 */
@Getter
@Setter
@FieldNameConstants
public class AccountVO {
    private static final long serialVersionUID = 1L;

    /**
     * 头像
     */
    @Schema(description = "头像")
    private String headSculpture;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickName;

    /**
     * 修改密码时间
     */
    @Schema(description = "修改密码时间")
    private LocalDateTime passwordUpdateTime;

    /**
     * 密码错误次数
     */
    @Schema(description = "密码错误次数")
    private Integer passwordErrorCount;

    /**
     * 要求登录后修改密码
     */
    @Schema(description = "要求登录后修改密码")
    private Boolean changePassword;

    /**
     * 状态(0:启用 1:停用 2:锁定)
     */
    @Interpret
    @Schema(description = "状态(0:启用 1:停用 2:锁定)")
    private AccountState state;

    /**
     * 停用原因
     */
    @Schema(description = "停用原因")
    private String deactivateReason;

    /**
     * 锁定时间
     */
    @Schema(description = "锁定时间")
    private LocalDateTime lockTime;

    /**
     * 最后激活时间
     */
    @Schema(description = "最后激活时间")
    private LocalDateTime finalActivationTime;

    /**
     * 自动激活时间
     */
    @Schema(description = "自动激活时间")
    private LocalDateTime autoActivationTime;

    /**
     * 最后登录时间
     */
    @Schema(description = "最后登录时间")
    private LocalDateTime finalLoginTime;

}
