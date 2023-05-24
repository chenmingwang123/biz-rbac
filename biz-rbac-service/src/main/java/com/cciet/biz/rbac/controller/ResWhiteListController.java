package com.cciet.biz.rbac.controller;

import com.cciet.biz.rbac.api.IResWhiteListApi;
import com.cciet.biz.rbac.dto.ResWhiteListDTO;
import com.cciet.biz.rbac.service.IResWhiteListService;
import com.cciet.common.bean.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

/**
* <p>
* 系统资源白名单表 前端控制器
* </p>
*
* @author cmw
* @since 2023/05/24 18:08
*/
@RestController
@RequestMapping("/rbac/res-white-list")
public class ResWhiteListController implements IResWhiteListApi{

    @Resource
    IResWhiteListService resWhiteListService;
    @Override
    public Result<ResWhiteListDTO> saveWhiteList(ResWhiteListDTO resWhiteListDTO) {
        return Result.ok(resWhiteListService.saveWhiteList(resWhiteListDTO));
    }

    @Override
    public Result<Boolean> delete(Long id) {
        return Result.ok(resWhiteListService.delete(id));
    }

    @Override
    public Result<Boolean> deletes(Set<Long> ids) {
        return Result.ok(resWhiteListService.deletes(ids));
    }
}
