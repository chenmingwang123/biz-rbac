package com.cciet.biz.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.cciet.biz.rbac.constant.AccountStateEnum;
import com.cciet.biz.rbac.dto.AccountDTO;
import com.cciet.biz.rbac.dto.AccountQueryDTO;
import com.cciet.biz.rbac.entity.Account;
import com.cciet.biz.rbac.mapper.IAccountMapper;
import com.cciet.biz.rbac.service.IAccountService;
import com.cciet.biz.rbac.vo.AccountSummaryVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.mybatis.supers.SupperEntity;
import com.cciet.mybatis.supers.SupperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Set;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author cmw
 * @since 2023/05/18 15:56
 */
@Slf4j
@Service
@Transactional(rollbackFor = Throwable.class)
public class AccountServiceImpl extends SupperServiceImpl<IAccountMapper, Account> implements IAccountService {

    @Resource
    public IAccountMapper accountMapper;

    private static final String INIT_PWD = "123456";

    @Override
    public AccountDTO getById(Long id) {
        return BeanUtil.copyProperties(this.getBaseMapper().selectById(id), AccountDTO.class);
    }

    /**
     * 通过用户名查询用户
     * @param accountName
     * @return
     */
    @Override
    public Account getByAccountName(String accountName) {
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getAccountName,accountName);
        return accountMapper.selectOne(queryWrapper);
    }

    @Override
    public AccountSummaryVO summaryById(Long id) {
        Account accounts = this.getBaseMapper().selectById(id);
        if (Objects.nonNull(accounts)){
            return BeanUtil.copyProperties(accounts, AccountSummaryVO.class);
        }
        return null;
    }

    @Override
    public AccountSummaryVO summaryByAccountName(String accountName) {
        LambdaQueryWrapper<Account> wrapper = lambdaQueryWrapper();
        wrapper.eq(Account::getAccountName, accountName);
        Account account = this.getBaseMapper().selectOne(wrapper);
        if (ObjectUtil.isNotEmpty(account)){
            return BeanUtil.copyProperties(account, AccountSummaryVO.class);
        }
        return null;
    }

    @Override
    public Boolean resetPwd(Long id) {
        UpdateChainWrapper<Account> updateChainWrapper =  this.update();
        updateChainWrapper.set(Account.Columns.PASSWORD, INIT_PWD);
        updateChainWrapper.eq(SupperEntity.Columns.ID,id);
        return updateChainWrapper.update();
    }

    @Override
    public Boolean state(Long id, AccountStateEnum state, String disableCause) {
        UpdateChainWrapper<Account> updateChainWrapper =  this.update();
        updateChainWrapper.set(Account.Columns.DEACTIVATE_REASON, disableCause);
        updateChainWrapper.set(Account.Columns.STATE, state);
        updateChainWrapper.eq(SupperEntity.Columns.ID,id);
        return updateChainWrapper.update();
    }

    @Override
    public AccountDTO save(AccountDTO accountDto) {
        return saveOrUpdate(accountDto.getId(),accountDto);
    }

    @Override
    public PageResponse<AccountDTO> page(PageRequest<AccountQueryDTO> pageRequest) {
        AccountQueryDTO accountQuery =  pageRequest.getQuery();
        LambdaQueryWrapper<Account> wrapper = lambdaQueryWrapper();
        wrapper.orderByDesc(Account::getCreateTime);
        wrapper.orderByDesc(Account::getId);
        wrapper.like(CharSequenceUtil.isNotBlank(accountQuery.getAccountName()),Account::getAccountName,accountQuery.getAccountName());
        wrapper.eq(CharSequenceUtil.isNotBlank(accountQuery.getNickname()),Account::getNickName,accountQuery.getNickname());

        return this.pageBeans(pageRequest,wrapper,AccountDTO.class);
    }

    @Override
    public Boolean delete(Long id) {
        int count = logicDeleteById(id);
        log.debug("根据ID逻辑删除:{},影响：{}条",id,count);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deletes(Set<Long> ids) {
        int count = logicDeleteBatchIds(ids);
        log.debug("根据ID列表逻辑删除:{},影响：{}条",ids,count);
        return Boolean.TRUE;
    }

}
