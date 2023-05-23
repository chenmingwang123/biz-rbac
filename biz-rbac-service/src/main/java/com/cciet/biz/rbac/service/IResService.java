package com.cciet.biz.rbac.service;

import com.cciet.biz.rbac.dto.ResDTO;
import com.cciet.biz.rbac.dto.ResQueryDTO;
import com.cciet.biz.rbac.entity.Res;
import com.cciet.biz.rbac.vo.ResMenuVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.mybatis.supers.ISupperService;

import java.util.List;

/**
 * <p>
 * 系统资源表 服务类
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
public interface IResService extends ISupperService<Res> {

    /**
     * 根据id查询系统资源
     * @param id
     * @return
     */
    ResDTO getById(Long id);

    /**
     * 更新状态
     * @param id
     * @param state
     * @return
     */
    Boolean state(Long id, String state);

    /**
     * 保存菜单
     * @param resDTO
     * @return
     */
    ResDTO save(ResDTO resDTO);

    /**
     * 分页条件查询系统资源信息
     *
     * @param pageRequest PageRequest<ResQueryDTO>
     * @return PageResponse<ResDTO>
     */
    PageResponse<ResDTO> page(PageRequest<ResQueryDTO> pageRequest);

    /**
     * 获取菜单列表
     * @return
     */
    List<ResMenuVO> getAllMenu(Long pid, List<Res> list);
}
