package com.cciet.biz.rbac.controller;

import com.cciet.biz.rbac.api.IOrgStructApi;
import com.cciet.biz.rbac.dto.OrgSaveDTO;
import com.cciet.biz.rbac.service.IOrgStructService;
import com.cciet.common.bean.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* <p>
* 组织架构表 前端控制器
* </p>
*
* @author cmw
* @since 2023/05/18 15:56
*/
@RestController
@RequestMapping("/rbac/orgStruct")
public class OrgStructController implements IOrgStructApi{

    @Resource
    public IOrgStructService orgStructService;
    @Override
    public Result<OrgSaveDTO> saveOrg(OrgSaveDTO orgSaveDTO) {
        return Result.ok(orgStructService.saveOrg(orgSaveDTO));
    }

    @Override
    public Result<OrgSaveDTO> updateOrg(OrgSaveDTO orgSaveDTO) {
        return null;
    }
}
