package com.cciet.biz.rbac.service;

import com.cciet.biz.rbac.dto.OrgSaveDTO;
import com.cciet.biz.rbac.dto.OrgUpateDTO;
import com.cciet.biz.rbac.entity.OrgStruct;
import com.cciet.biz.rbac.vo.OrgQueryVO;
import com.cciet.mybatis.supers.ISupperService;

import java.util.List;
import java.util.Set;

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

    /**
     * 修改组织架构
     * @param orgUpateDTO
     * @return
     */
    OrgUpateDTO updateOrg(OrgUpateDTO orgUpateDTO);

    /**
     * 获取组织架构
     * @return
     */
    List<OrgQueryVO> getAllOrg();

    /**
     * 根据id逻辑删除
     * @param id
     * @return
     */
    Boolean deleteOrgById(Long id);

    /**
     * 批量逻辑删除
     * @param ids
     * @return
     */
    Boolean deleteOrgByIds(Set<Long> ids);
}
