package com.cciet.biz.rbac.service;

import com.cciet.biz.rbac.dto.OrgSaveDTO;
import com.cciet.biz.rbac.entity.OrgStruct;
import com.cciet.mybatis.supers.ISupperService;

/**
 * <p>
 * 组织架构表 服务类
 * </p>
 *
 * @author cmw
 * @since 2023/05/18 15:56
 */
public interface IOrgStructService extends ISupperService<OrgStruct> {

    /**
     * 新增组织架构
     * @param orgSaveDTO
     * @return
     */
    OrgSaveDTO saveOrg(OrgSaveDTO orgSaveDTO);
}
