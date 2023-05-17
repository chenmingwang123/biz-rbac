package com.cciet.biz.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cciet.biz.rbac.dto.AccountState;
import com.cciet.mybatis.supers.SupperEntity;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_account")
public class Account extends SupperEntity<Account> {

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 头像
     */
    @TableField("head_sculpture")
    private String headSculpture;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 修改密码时间
     */
    @TableField("password_update_time")
    private LocalDateTime passwordUpdateTime;

    /**
     * 密码错误次数
     */
    @TableField("password_error_count")
    private Integer passwordErrorCount;

    /**
     * 要求登录后修改密码
     */
    @TableField("change_password")
    private Boolean changePassword;

    /**
     * 状态(NORMAL:启用 DISABLE:停用 LOCK:锁定)
     */
    @TableField("state")
    private AccountState state;

    /**
     * 停用原因
     */
    @TableField("deactivate_reason")
    private String deactivateReason;

    /**
     * 锁定时间
     */
    @TableField("lock_time")
    private LocalDateTime lockTime;

    /**
     * 最后激活时间
     */
    @TableField("final_activation_time")
    private LocalDateTime finalActivationTime;

    /**
     * 自动激活时间
     */
    @TableField("auto_activation_time")
    private LocalDateTime autoActivationTime;

    /**
     * 最后登录时间
     */
    @TableField("final_login_time")
    private LocalDateTime finalLoginTime;
}
