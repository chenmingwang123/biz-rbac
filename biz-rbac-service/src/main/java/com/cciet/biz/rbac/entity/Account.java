package com.cciet.biz.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cciet.biz.rbac.constant.AccountStateEnum;
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
 * @since 2023/05/18 15:56
 */
@Getter
@Setter
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_account")
public class Account extends SupperEntity<Account> {

    private static final long serialVersionUID = 1L;


    /**
     * 组织id
     */
    @TableField("org_id")
    private Long orgId;

    /**
     * 部门id
     */
    @TableField("dep_id")
    private Long depId;

    /**
     * 账号
     */
    @TableField("account_name")
    private String accountName;

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
     * 状态
     */
    @TableField("state")
    private AccountStateEnum state;

    /**
     * 停用原因
     */
    @TableField("deactivate_reason")
    private String deactivateReason;

    /**
     * 停用时间
     */
    @TableField("disable_time")
    private LocalDateTime disableTime;

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
    public static final class Columns{
        private Columns(){}
        /**
        *  account_name:账号
        */
        public static final String ACCOUNT_NAME = "account_name";
        /**
        *  password:密码
        */
        public static final String PASSWORD = "password";
        /**
        *  head_sculpture:头像
        */
        public static final String HEAD_SCULPTURE = "head_sculpture";
        /**
        *  nick_name:昵称
        */
        public static final String NICK_NAME = "nick_name";
        /**
        *  password_update_time:修改密码时间
        */
        public static final String PASSWORD_UPDATE_TIME = "password_update_time";
        /**
        *  password_error_count:密码错误次数
        */
        public static final String PASSWORD_ERROR_COUNT = "password_error_count";
        /**
        *  change_password:要求登录后修改密码
        */
        public static final String CHANGE_PASSWORD = "change_password";
        /**
        *  state:状态
        */
        public static final String STATE = "state";
        /**
        *  deactivate_reason:停用原因
        */
        public static final String DEACTIVATE_REASON = "deactivate_reason";
        /**
        *  lock_time:锁定时间
        */
        public static final String LOCK_TIME = "lock_time";
        /**
        *  final_activation_time:最后激活时间
        */
        public static final String FINAL_ACTIVATION_TIME = "final_activation_time";
        /**
        *  auto_activation_time:自动激活时间
        */
        public static final String AUTO_ACTIVATION_TIME = "auto_activation_time";
        /**
        *  final_login_time:最后登录时间
        */
        public static final String FINAL_LOGIN_TIME = "final_login_time";
    }
}
