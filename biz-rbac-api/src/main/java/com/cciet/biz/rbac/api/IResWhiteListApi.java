package com.cciet.biz.rbac.api;

import com.cciet.biz.rbac.dto.ResWhiteListDTO;
import com.cciet.biz.rbac.dto.ResWhiteListQueryDTO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
* <p>
* 系统资源白名单表 前端控制器接口
* </p>
* @author cmw
* @since 2023/05/24 18:08
*/
@Validated
@Tag(name = "系统资源白名单")
public interface IResWhiteListApi {

    /**
     * 保存系统资源白名单
     *
     * @param resWhiteListDTO ResWhiteListDTO
     * @return Result<ResWhiteListDTO>
     */
    @PostMapping("/saveWhiteList")
    @Operation(summary = "保存系统资源信息")
    Result<ResWhiteListDTO> saveWhiteList(@RequestBody ResWhiteListDTO resWhiteListDTO);

    /**
     * 分页条件查询系统资源白名单
     *
     * @param pageRequest PageRequest<ResWhiteListQueryDTO>
     * @return Result<PageResponse < ResWhiteListDTO>>
     */
    @PostMapping("/page")
    @Operation(summary = "分页条件查询系统资源白名单")
    Result<PageResponse<ResWhiteListDTO>> page(@RequestBody PageRequest<ResWhiteListQueryDTO> pageRequest);

    /**
     * 根据ID逻辑删除账号信息
     *
     * @param id ID
     * @return Result<Boolean>
     */
    @DeleteMapping("/delete")
    @Operation(summary = "根据ID逻辑删除账号信息")
    @Parameter(name = "id", description = "ID", required = true)
    Result<Boolean> delete(@RequestParam(value = "id") Long id);

    /**
     * 根据ID列表逻辑删除账号信息
     * ID列表逗号分隔
     *
     * @param ids ID列表
     * @return Result<Boolean>
     */
    @DeleteMapping("/deletes")
    @Operation(summary = "根据ID列表逻辑删除账号信息", description = "ID列表逗号分隔")
    @Parameter(name = "ids", description = "ID列表", required = true)
    Result<Boolean> deletes(@RequestParam(value = "ids") Set<Long> ids);

}
