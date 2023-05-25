package com.cciet.biz.rbac.service;

import com.cciet.biz.rbac.dto.ResWhiteListDTO;
import com.cciet.biz.rbac.dto.ResWhiteListQueryDTO;
import com.cciet.biz.rbac.entity.ResWhiteList;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.mybatis.supers.ISupperService;

import java.util.Set;

/**
 * <p>
 * 系统资源白名单表 服务类
 * </p>
 *
 * @author cmw
 * @since 2023/05/24 18:08
 */
public interface IResWhiteListService extends ISupperService<ResWhiteList> {

    /**
     * 保存白名单
     * @param resWhiteListDTO
     * @return
     */
    ResWhiteListDTO saveWhiteList(ResWhiteListDTO resWhiteListDTO);

    /**
     * 分页条件查询系统资源白名单
     *
     * @param pageRequest PageRequest<ResWhiteListQueryDTO>
     * @return PageResponse<ResWhiteListDTO>
     */
    PageResponse<ResWhiteListDTO> page(PageRequest<ResWhiteListQueryDTO> pageRequest);

    /**
     * 根据id逻辑删除白名单
     * @param id
     * @return
     */
    Boolean delete(Long id);


    /**
     * 批量逻辑删除白名单
     * @param ids
     * @return
     */
    Boolean deletes(Set<Long> ids);
}
