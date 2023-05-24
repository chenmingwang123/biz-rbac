package com.cciet.biz.rbac.service.impl;

import com.cciet.biz.rbac.dto.ResWhiteListDTO;
import com.cciet.biz.rbac.entity.ResWhiteList;
import com.cciet.biz.rbac.mapper.IResWhiteListMapper;
import com.cciet.biz.rbac.service.IResWhiteListService;
import com.cciet.mybatis.supers.SupperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 系统资源白名单表 服务实现类
 * </p>
 *
 * @author cmw
 * @since 2023/05/24 18:08
 */
@Service
@Slf4j
public class ResWhiteListServiceImpl extends SupperServiceImpl<IResWhiteListMapper, ResWhiteList> implements IResWhiteListService {

    @Override
    public ResWhiteListDTO saveWhiteList(ResWhiteListDTO resWhiteListDTO) {
        saveOrUpdate(resWhiteListDTO.getId(),resWhiteListDTO);
        return saveOrUpdate(resWhiteListDTO.getId(),resWhiteListDTO);
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
