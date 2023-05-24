package com.cciet.biz.rbac.service;

import com.cciet.biz.rbac.dto.ResWhiteListDTO;
import com.cciet.biz.rbac.entity.ResWhiteList;
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
