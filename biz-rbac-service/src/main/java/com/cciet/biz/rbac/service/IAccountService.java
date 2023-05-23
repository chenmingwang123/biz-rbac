package com.cciet.biz.rbac.service;

import com.cciet.biz.rbac.dto.AccountDTO;
import com.cciet.biz.rbac.dto.AccountQueryDTO;
import com.cciet.biz.rbac.entity.Account;
import com.cciet.biz.rbac.vo.AccountSummaryVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.mybatis.supers.ISupperService;

import java.util.Set;

/**
 * <p>
 * 用户账号表 服务类
 * </p>
 *
 * @author cmw
 * @since 2023/05/18 15:56
 */
public interface IAccountService extends ISupperService<Account> {

    /**
     *根据ID查询账号信息
     * @param id
     * @return
     */
    AccountDTO getById(Long id);

    /**
     * 根据用户名获取用户
     * @param accountName
     * @return
     */
    Account getByAccountName(String accountName);

    /**
     *根据账号ID获取摘要信息
     * @param id
     * @return
     */
    AccountSummaryVO summaryById(Long id);

    /**
     * 根据用户名获取摘要信息
     * @param accountName
     * @return
     */
    AccountSummaryVO summaryByAccountName(String accountName);

    /**
     * 重置密码为123456
     * @param id
     * @return
     */
    Boolean resetPwd(Long id);

    /**
     *更新状态
     * @param id
     * @param state
     * @param disableCause
     * @return
     */
    Boolean state(Long id, String state, String disableCause);

    /**
     * 保存账号信息
     *
     * @param accountDto AccountDTO
     * @return AccountDTO
     */
    AccountDTO save(AccountDTO accountDto);

    /**
     * 分页条件查询账号信息
     *
     * @param pageRequest PageRequest<AccountQueryDTO>
     * @return PageResponse<AccountDTO>
     */
    PageResponse<AccountDTO> page(PageRequest<AccountQueryDTO> pageRequest);

    /**
     * 根据id逻辑删除
     * @param id
     * @return
     */
    Boolean delete(Long id);

    /**
     * 根据ID列表逻辑删除账号信息
     * @param ids
     * @return
     */
    Boolean deletes(Set<Long> ids);
}
