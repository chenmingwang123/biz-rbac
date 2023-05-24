package com.cciet.biz.rbac.controller;

import com.cciet.biz.rbac.api.IResApi;
import com.cciet.biz.rbac.constant.ParentConstant;
import com.cciet.biz.rbac.constant.StateEnum;
import com.cciet.biz.rbac.dto.ResDTO;
import com.cciet.biz.rbac.dto.ResQueryDTO;
import com.cciet.biz.rbac.entity.Res;
import com.cciet.biz.rbac.service.IResService;
import com.cciet.biz.rbac.vo.ResMenuVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.bean.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* <p>
* 系统资源表 前端控制器
* </p>
*
* @author cmw
* @since 2023/05/23 09:47
*/
@RestController
@RequestMapping("/rbac/res")
public class ResController implements IResApi{

    @Resource
    IResService resService;
    @Override
    public Result<ResDTO> getById(Long id) {
        return Result.ok(resService.getById(id));
    }

    @Override
    public Result<Boolean> state(Long id, StateEnum state) {
        return Result.ok(resService.state(id,state));
    }

    /**
     * 保存/修改 菜单资源
     * @param resDTO ResDTO
     * @return
     */
    @Override
    public Result<ResDTO> save(ResDTO resDTO) {
        return Result.ok(resService.save(resDTO));
    }

    @Override
    public Result<PageResponse<ResDTO>> page(PageRequest<ResQueryDTO> pageRequest) {
        return Result.ok(resService.page(pageRequest));
    }

    /**
     * 获取菜单资源
     * @return
     */
    @Override
    public Result<List<ResMenuVO>> getAllMenu() {
        List<Res> list = resService.list();
        return Result.ok(resService.getAllMenu(ParentConstant.TOP, list));
    }
}
