package com.cciet.biz.rbac.service;

import com.cciet.biz.rbac.dto.UserDTO;
import com.cciet.biz.rbac.entity.Account;
import com.cciet.biz.rbac.vo.AccountVO;
import com.cciet.common.bean.Result;
import com.cciet.mybatis.supers.ISupperService;

/**
 * <p>
 * 用户账号表 服务类
 * </p>
 *
 * @author cmw
 * @since 2023/05/15 18:02
 */
public interface IAccountService extends ISupperService<Account> {

    Result<AccountVO> loginLogic(UserDTO userDTO);
}
