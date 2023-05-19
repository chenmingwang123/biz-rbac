package com.cciet.biz.rbac.api;

import com.cciet.biz.rbac.dto.OrgSaveDTO;
import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
* <p>
* 组织架构表 前端控制器接口
* </p>
* @author cmw
* @since 2023/05/18 10:46
*/
@Validated
@Tag(name = "组织架构")
public interface IOrgStructApi {

    /**
     * 新增组织架构
     * @param orgSaveDTO
     * @return
     */
    @Operation(summary = "新增组织架构")
    @PostMapping("saveOrg")
    Result<OrgSaveDTO> saveOrg(@RequestBody OrgSaveDTO orgSaveDTO);

    /**
     * 修改组织架构
     * @param orgSaveDTO
     * @return
     */
    @Operation(summary = "修改组织架构")
    @PostMapping("updateOrg")
    Result<OrgSaveDTO> updateOrg(@RequestBody OrgSaveDTO orgSaveDTO);
}
