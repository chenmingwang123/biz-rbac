package com.cciet.biz.rbac.api;

import com.cciet.biz.rbac.dto.OrgSaveDTO;
import com.cciet.biz.rbac.dto.OrgUpateDTO;
import com.cciet.biz.rbac.vo.OrgQueryVO;
import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
     * 获取组织架构
     *
     * @param
     * @return OrgQueryVO
     */
    @GetMapping("/getAllOrg")
    @Operation(summary = "获取组织架构")
    Result<List<OrgQueryVO>> getAllOrg();

    /**
     * 修改组织架构
     * @param orgUpateDTO
     * @return
     */
    @Operation(summary = "修改组织架构")
    @PostMapping("updateOrg")
    Result<OrgUpateDTO> updateOrg(@RequestBody OrgUpateDTO orgUpateDTO);

    /**
     * 修改组织架构
     * @param id
     * @return
     */
    @Operation(summary = "根据id删除组织架构")
    @DeleteMapping("deleteOrgById")
    @Parameter(name = "id", description = "ID", required = true)
    Result<Boolean> deleteOrgById(@RequestParam(value = "id") Long id);

    /**
     * 根据ID列表逻辑删除账号信息
     * ID列表逗号分隔
     *
     * @param ids ID列表
     * @return Result<Boolean>
     */
    @DeleteMapping("/deleteOrgByIds")
    @Operation(summary = "根据ID列表逻辑删除账号信息", description = "ID列表逗号分隔")
    @Parameter(name = "ids", description = "ID列表", required = true)
    Result<Boolean> deleteOrgByIds(@RequestParam(value = "ids") Set<Long> ids);
}
