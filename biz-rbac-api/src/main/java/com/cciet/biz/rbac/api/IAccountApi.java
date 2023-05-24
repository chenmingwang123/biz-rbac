package com.cciet.biz.rbac.api;

import com.cciet.biz.rbac.constant.StateEnum;
import com.cciet.biz.rbac.dto.AccountDTO;
import com.cciet.biz.rbac.dto.AccountQueryDTO;
import com.cciet.biz.rbac.vo.AccountSummaryVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * <p>
 * 用户账号表 前端控制器
 * </p>
 *
 * @author cmw
 * @since 2023/05/15 18:02
 */
@RestController
@RequestMapping("/rbac/account")
public interface IAccountApi {

    /**
     * 根据ID查询账号信息
     *
     * @param id ID
     * @return Result<AccountVO>
     */
    @GetMapping("/get/id")
    @Operation(summary = "根据ID查询账号信息")
    @Parameter(name = "id", description = "ID", required = true)
    Result<AccountDTO> getById(@RequestParam(value = "id") Long id);

    /**
     * 根据账号名称查询账号信息
     *
     * @param accountName 账号名称
     * @return Result<AccountVO>
     */
    @GetMapping("/get/account/name")
    @Operation(summary = "根据账号名称查询账号信息")
    @Parameter(name = "accountName", description = "账号名称", required = true)
    Result<AccountDTO> getAccountName(@RequestParam(value = "accountName") String accountName);

    /**
     * 根据账号ID获取摘要信息
     *
     * @param id ID
     * @return Result<AccountSummaryDto>
     */
    @Operation(summary = "根据账号ID获取摘要信息")
    @GetMapping("/get/summary/id")
    @Parameter(name = "id", description = "ID", required = true)
    Result<AccountSummaryVO> summaryById(@RequestParam(value = "id") Long id);

    /**
     * 根据账号名称获取摘要信息
     *
     * @param accountName 账号名称
     * @return Result<AccountSummaryVO>
     */
    @GetMapping("/get/summary/name")
    @Operation(summary = "根据账号名称获取摘要信息")
    @Parameter(name = "accountName", description = "账号名称", required = true)
    Result<AccountSummaryVO> summaryByAccountName(@RequestParam(value = "accountName") String accountName);

    /**
     * 根据ID重置密码(重置为123456)
     *
     * @param id ID
     * @return Result<Boolean>
     */
    @PostMapping("/reset/pwd")
    @Operation(summary = "根据ID重置密码")
    @Parameter(name = "id", description = "ID", required = true)
    Result<Boolean> resetPwd(@RequestParam(value = "id") Long id);

    /**
     * 根据ID更新账号状态
     *
     * @param id           ID
     * @param state        账号状态
     * @param disableCause 禁用原因
     * @return Result<Boolean>
     */
    @PostMapping("/state")
    @Operation(summary = "根据ID更新账号状态", parameters = {
            @Parameter(name = "id", description = "ID", required = true),
            @Parameter(name = "state", description = "账号状态", required = true,schema = @Schema(implementation = StateEnum.class)),
            @Parameter(name = "disableCause", description = "禁用原因")
    })
    Result<Boolean> state(@RequestParam(value = "id") Long id, @RequestParam(value = "state") StateEnum state,
                          @RequestParam(value = "disableCause", required = false) String disableCause);

    /**
     * 保存账号信息
     *
     * @param accountDto AccountDTO
     * @return Result<AccountDTO>
     */
    @PostMapping("/save")
    @Operation(summary = "保存账号信息")
    Result<AccountDTO> save(@RequestBody AccountDTO accountDto);

    /**
     * 分页条件查询账号信息
     *
     * @param pageRequest PageRequest<AccountQueryDTO>
     * @return Result<PageResponse < AccountDTO>>
     */
    @PostMapping("/page")
    @Operation(summary = "分页条件查询账号信息")
    Result<PageResponse<AccountDTO>> page(@RequestBody PageRequest<AccountQueryDTO> pageRequest);


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
