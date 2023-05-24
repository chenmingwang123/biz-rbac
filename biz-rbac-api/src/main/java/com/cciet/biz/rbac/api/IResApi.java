package com.cciet.biz.rbac.api;

import com.cciet.biz.rbac.constant.StateEnum;
import com.cciet.biz.rbac.dto.ResDTO;
import com.cciet.biz.rbac.dto.ResQueryDTO;
import com.cciet.biz.rbac.vo.ResMenuVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
* <p>
* 系统资源表 前端控制器接口
* </p>
* @author cmw
* @since 2023/05/23 09:47
*/
@Validated
@Tag(name = "系统资源表")
public interface IResApi {

    /**
     * 根据ID查询系统资源信息
     *
     * @param id ID
     * @return Result<AccountVO>
     */
    @GetMapping("/get/id")
    @Operation(summary = "根据ID查询系统资源信息")
    @Parameter(name = "id", description = "ID", required = true)
    Result<ResDTO> getById(@RequestParam(value = "id") Long id);

    /**
     * 根据ID更新系统资源状态
     *
     * @param id           ID
     * @param state        账号状态
     * @return Result<Boolean>
     */
    @PostMapping("/state")
    @Operation(summary = "根据ID更新系统资源状态", parameters = {
            @Parameter(name = "id", description = "ID", required = true),
            @Parameter(name = "state", description = "账号状态", required = true,schema = @Schema(implementation = StateEnum.class))
    })
    Result<Boolean> state(@RequestParam(value = "id") Long id, @RequestParam(value = "state") StateEnum state);

    /**
     * 保存系统资源信息
     *
     * @param resDTO ResDTO
     * @return Result<RoleDTO>
     */
    @PostMapping("/save")
    @Operation(summary = "保存系统资源信息")
    Result<ResDTO> save(@RequestBody ResDTO resDTO);


    /**
     * 分页条件查询系统资源信息
     *
     * @param pageRequest PageRequest<ResQueryDTO>
     * @return Result<PageResponse < ResDTO>>
     */
    @PostMapping("/page")
    @Operation(summary = "分页条件查询系统资源信息")
    Result<PageResponse<ResDTO>> page(@RequestBody PageRequest<ResQueryDTO> pageRequest);

    /**
     * 获取菜单列表
     *
     * @return Result<List<ResMenuVO>>
     */
    @PostMapping("/getAllMenu")
    @Operation(summary = "获取菜单列表")
    Result<List<ResMenuVO>> getAllMenu();

}
