package com.cciet.biz.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cciet.biz.rbac.constant.OrgConstant;
import com.cciet.biz.rbac.constant.OrgInfo;
import com.cciet.biz.rbac.dto.OrgSaveDTO;
import com.cciet.biz.rbac.dto.OrgUpateDTO;
import com.cciet.biz.rbac.entity.OrgStruct;
import com.cciet.biz.rbac.mapper.IOrgStructMapper;
import com.cciet.biz.rbac.service.IOrgStructService;
import com.cciet.biz.rbac.vo.OrgQueryVO;
import com.cciet.common.exception.BusinessException;
import com.cciet.mybatis.supers.SupperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 组织架构表 服务实现类
 * </p>
 *
 * @author cmw
 * @since 2023/05/18 15:56
 */
@Service
@Slf4j
public class OrgStructServiceImpl extends SupperServiceImpl<IOrgStructMapper, OrgStruct> implements IOrgStructService {
    @Resource
    IOrgStructMapper orgStructMapper;

    /**
     * 新增组织架构
     * @param orgSaveDTO
     * @return
     */
    @Override
    public OrgSaveDTO saveOrg(OrgSaveDTO orgSaveDTO) {
        LambdaQueryWrapper<OrgStruct> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrgStruct::getOrgCode,orgSaveDTO.orgCode);
        List<OrgStruct> orgStructs = orgStructMapper.selectList(queryWrapper);
        //判断不存在
        if (!CollectionUtils.isEmpty(orgStructs)){
            BusinessException.result(OrgInfo.ORG_CODE_EXIST);
        }
        //拼接path
        orgSaveDTO =  saveOrUpdate(orgSaveDTO.getId(),orgSaveDTO);
        if (OrgConstant.TOP.equals(orgSaveDTO.getPid())) {
            orgSaveDTO.setPath(orgSaveDTO.getId() + OrgConstant.SPLIT.toString());
        } else {
            OrgStruct orgStruct = orgStructMapper.selectById(orgSaveDTO.getPid());
            if (ObjectUtil.isNotEmpty(orgStruct)) {
                orgSaveDTO.setPath(OrgConstant.appendPath(orgStruct.getPath(), orgSaveDTO.getId()));
            }
        }
        return saveOrUpdate(orgSaveDTO.getId(),orgSaveDTO);
    }

    /**
     * 修改组织架构
     * @param orgUpateDTO
     * @return
     */
    @Override
    public OrgUpateDTO updateOrg(OrgUpateDTO orgUpateDTO) {
        OrgStruct orgStruct = orgStructMapper.selectById(orgUpateDTO.getId());
        if (ObjectUtil.isEmpty(orgStruct)){
            BusinessException.result(OrgInfo.ORG_NAME_EXIST);
        }
        return saveOrUpdate(orgUpateDTO.getId(),orgUpateDTO);
    }

    /**
     * 获取组织架构
     * @return
     */
    @Override
    public List<OrgQueryVO> getAllOrg() {
        List<OrgStruct> rslist = new ArrayList<>();
        List<OrgStruct> orgs = orgStructMapper.selectList(null);
        for (OrgStruct model : orgs) {
            //添加一级分类
            if (model.getPid()==0){
                rslist.add(model);
            }else {
                for (OrgStruct org : orgs) {
                    //判断不是一级分类的，添加进去
                    if (org.getId().equals(model.getPid())) {
                        org.getChildrens().add(model);
                    }
                }
            }
        }
        return BeanUtil.copyToList(rslist, OrgQueryVO.class);
    }

    @Override
    public Boolean deleteOrgById(Long id) {
        int count = logicDeleteById(id);
        log.debug("根据ID逻辑删除:{},影响：{}条",id,count);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteOrgByIds(Set<Long> ids) {
        int count = logicDeleteBatchIds(ids);
        log.debug("根据ID列表逻辑删除:{},影响：{}条",ids,count);
        return Boolean.TRUE;
    }
}
