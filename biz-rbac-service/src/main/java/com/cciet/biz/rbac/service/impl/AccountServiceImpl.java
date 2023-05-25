package com.cciet.biz.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.cciet.biz.rbac.constant.AccountStateEnum;
import com.cciet.biz.rbac.constant.OrgTypeEnum;
import com.cciet.biz.rbac.constant.StateEnum;
import com.cciet.biz.rbac.constant.errinfo.LoginInfo;
import com.cciet.biz.rbac.dto.AccountDTO;
import com.cciet.biz.rbac.dto.AccountQueryDTO;
import com.cciet.biz.rbac.entity.Account;
import com.cciet.biz.rbac.entity.OrgAccount;
import com.cciet.biz.rbac.entity.OrgStruct;
import com.cciet.biz.rbac.mapper.IAccountMapper;
import com.cciet.biz.rbac.mapper.IOrgAccountMapper;
import com.cciet.biz.rbac.mapper.IOrgStructMapper;
import com.cciet.biz.rbac.service.IAccountService;
import com.cciet.biz.rbac.vo.AccountSummaryVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.exception.BusinessException;
import com.cciet.mybatis.supers.SupperEntity;
import com.cciet.mybatis.supers.SupperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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

    @Resource
    public IOrgStructMapper orgStructMapper;

    @Resource
    public IOrgAccountMapper orgAccountMapper;


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
    public Boolean state(Long id, StateEnum state, String disableCause) {
        UpdateChainWrapper<Account> updateChainWrapper =  this.update();
        updateChainWrapper.set(Account.Columns.DEACTIVATE_REASON, disableCause);
        updateChainWrapper.set(Account.Columns.STATE, state);
        if (StateEnum.DISABLE==state){
            updateChainWrapper.set(Account.Columns.DISABLE_TIME, new Date());
        }
        updateChainWrapper.eq(SupperEntity.Columns.ID,id);
        return updateChainWrapper.update();
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public AccountDTO save(AccountDTO accountDto) {
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        if (accountDto.getId()==null){
            accountDto.setState(AccountStateEnum.NORMAL);
            accountDto.setPassword(SecureUtil.md5(accountDto.getPassword()));
            accountDto.setPasswordErrorCount(0);
            queryWrapper.eq(Account::getAccountName,accountDto.getAccountName());
        }else {
            queryWrapper.eq(Account::getAccountName,accountDto.getAccountName());
            queryWrapper.ne(Account::getId,accountDto.getId());
        }
        List<Account> resList = accountMapper.selectList(queryWrapper);
        if (!CollectionUtils.isEmpty(resList)){
            BusinessException.result(LoginInfo.ACCOUNT_NAME_EXIST);
        }
        AccountDTO accountDTO = saveOrUpdate(accountDto.getId(), accountDto);
        //保存岗位
        saveOrgAccount(accountDto);
        return accountDTO;
    }

    /**
     * 新增账号组织关联
     * @param accountDto
     */
    private void saveOrgAccount(AccountDTO accountDto) {
        LambdaQueryWrapper<OrgStruct> orgQueryWrapper = new LambdaQueryWrapper<>();
        orgQueryWrapper.eq(CollectionUtils.isEmpty(accountDto.getOrgId()), OrgStruct::getId,-1);
        orgQueryWrapper.in(!CollectionUtils.isEmpty(accountDto.getOrgId()),OrgStruct::getId, accountDto.getOrgId());
        List<OrgStruct> orgStructs = orgStructMapper.selectList(orgQueryWrapper);
        //获取是组织类型
        orgStructs.forEach(o ->{
            OrgTypeEnum orgType = OrgTypeEnum.parse(o.getOrgType());
            OrgAccount orgAccount = new OrgAccount();
            orgAccount.setAccountId(accountDto.getId());
            orgAccount.setOrgId(o.getId());
            switch (Objects.requireNonNull(orgType)) {
                case ORG:
                    orgAccount.setOrgType(OrgTypeEnum.ORG.name());
                    break;
                case DEP:
                    orgAccount.setOrgType(OrgTypeEnum.DEP.name());
                    break;
                case GROUP:
                    orgAccount.setOrgType(OrgTypeEnum.GROUP.name());
                    break;
                case POST:
                    orgAccount.setOrgType(OrgTypeEnum.POST.name());
                    break;
                default:
            }
            orgAccountMapper.insert(orgAccount);
        });
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
