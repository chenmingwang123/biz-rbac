package com.cciet.biz.rbac.service.impl;

import com.cciet.biz.rbac.dto.OrgSaveDTO;
import com.cciet.biz.rbac.entity.OrgStruct;
import com.cciet.biz.rbac.mapper.IOrgStructMapper;
import com.cciet.biz.rbac.service.IOrgStructService;
import com.cciet.mybatis.supers.SupperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组织架构表 服务实现类
 * </p>
 *
 * @author cmw
 * @since 2023/05/18 15:56
 */
@Service
public class OrgStructServiceImpl extends SupperServiceImpl<IOrgStructMapper, OrgStruct> implements IOrgStructService {
    @Override
    public OrgSaveDTO saveOrg(OrgSaveDTO orgSaveDTO) {
        return saveOrUpdate(orgSaveDTO.getId(),orgSaveDTO);
    }
}
