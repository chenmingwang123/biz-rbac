package com.cciet.biz.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cciet.mybatis.supers.SupperEntity;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

/**
 * <p>
 * 用户账号
 * </p>
 *
 * @author huanghui
 * @since 2023/05/04 13:00
 */
@Getter
@Setter
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@TableName("T_SYS_ACCOUNT")
public class Account extends SupperEntity<Account> {

    private static final long serialVersionUID = 1L;

    /**
     * 登录账号名称
     */
    @TableField("ACCOUNT_NAME")
    private String accountName;

    /**
     * 登录密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 头像地址
     */
    @TableField("PORTRAIT")
    private String portrait;

    /**
     * 昵称
     */
    @TableField("NICKNAME")
    private String nickname;

    /**
     * 最近一次修改密码时间
     */
    @TableField("UPDATE_PWD_TIME")
    private LocalDateTime updatePwdTime;

    /**
     * 密码错误次数
     */
    @TableField("WRONG_PWD_NUM")
    private Integer wrongPwdNum;

    /**
     * 登录后需要修改密码
     */
    @TableField("NEED_CHANGE_PWD")
    private Boolean needChangePwd;

    /**
     * 最后一次登录时间
     */
    @TableField("LAST_LOGIN_TIME")
    private LocalDateTime lastLoginTime;

    /**
     * 启(NORMAL)/停(DISABLE)/锁(LOCK)状态
     */
    @TableField("STATE")
    private String state;

    /**
     * 停用时间
     */
    @TableField("DISABLE_TIME")
    private LocalDateTime disableTime;

    /**
     * 停用原因
     */
    @TableField("DISABLE_CAUSE")
    private String disableCause;

    /**
     * 锁定时间
     */
    @TableField("LOCAL_TIME")
    private LocalDateTime localTime;

    /**
     * 自动激活时间
     */
    @TableField("AUTO_ACTIVATE_TIME")
    private LocalDateTime autoActivateTime;

    /**
     * 最后一次激活时间
     */
    @TableField("ACTIVATE_TIME")
    private LocalDateTime activateTime;

    @Override
    public Serializable pkVal() {
        return null;
    }
}
