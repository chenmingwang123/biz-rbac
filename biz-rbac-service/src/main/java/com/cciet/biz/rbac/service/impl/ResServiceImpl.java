package com.cciet.biz.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.cciet.biz.rbac.constant.ParentConstant;
import com.cciet.biz.rbac.constant.StateEnum;
import com.cciet.biz.rbac.constant.errinfo.ResInfo;
import com.cciet.biz.rbac.dto.ResDTO;
import com.cciet.biz.rbac.dto.ResQueryDTO;
import com.cciet.biz.rbac.entity.Res;
import com.cciet.biz.rbac.entity.RoleRes;
import com.cciet.biz.rbac.mapper.IResMapper;
import com.cciet.biz.rbac.mapper.IRoleResMapper;
import com.cciet.biz.rbac.service.IResService;
import com.cciet.biz.rbac.vo.ResMenuVO;
import com.cciet.common.bean.PageRequest;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.exception.BusinessException;
import com.cciet.mybatis.supers.SupperEntity;
import com.cciet.mybatis.supers.SupperServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统资源表 服务实现类
 * </p>
 *
 * @author cmw
 * @since 2023/05/23 09:47
 */
@Service
public class ResServiceImpl extends SupperServiceImpl<IResMapper, Res> implements IResService {

    @Resource
    IResMapper resMapper;
    @Resource
    IRoleResMapper roleResMapper;

    @Override
    public ResDTO getById(Long id) {
        List<Long> roleByResId = getRoleByResId(id);
        ResDTO resDTO = BeanUtil.copyProperties(this.getBaseMapper().selectById(id), ResDTO.class);
        resDTO.setRoleIds(roleByResId);
        return resDTO;
    }

    @Override
    public Boolean state(Long id, StateEnum state) {
        UpdateChainWrapper<Res> updateChainWrapper =  this.update();
        updateChainWrapper.set(Res.Columns.STATE, state);
        updateChainWrapper.eq(SupperEntity.Columns.ID,id);
        return updateChainWrapper.update();
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ResDTO save(ResDTO resDTO) {
        if (resDTO.getId() == null){
            LambdaQueryWrapper<Res> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Res::getName,resDTO.getName());
            List<Res> resList = resMapper.selectList(queryWrapper);
            //验证存在
            if (!CollectionUtils.isEmpty(resList)){
                BusinessException.result(ResInfo.RES_NAME_EXIST);
            }
            resDTO =  saveOrUpdate(resDTO.getId(),resDTO);
            //拼接path
            if (ParentConstant.TOP.equals(resDTO.getPid())) {
                resDTO.setPath(resDTO.getId() + ParentConstant.SPLIT.toString());
            } else {
                Res res = resMapper.selectById(resDTO.getPid());
                if (ObjectUtil.isNotEmpty(res)) {
                    resDTO.setPath(ParentConstant.appendPath(res.getPath(), resDTO.getId()));
                }
            }
        }else {
            LambdaQueryWrapper<Res> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Res::getName,resDTO.getName());
            queryWrapper.ne(Res::getId,resDTO.getId());
            List<Res> resList = resMapper.selectList(queryWrapper);
            if (!CollectionUtils.isEmpty(resList)){
                BusinessException.result(ResInfo.RES_NAME_EXIST);
            }
            //修改角色关联
            LambdaQueryWrapper<RoleRes> roleResLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roleResLambdaQueryWrapper.eq(RoleRes::getResId,resDTO.getId());
            roleResMapper.delete(roleResLambdaQueryWrapper);
        }
        //新增角色关联
        ResDTO finalResDTO = resDTO;
        resDTO.getRoleIds().forEach(r ->{
            RoleRes roleRes = new RoleRes();
            roleRes.setResId(finalResDTO.getId());
            roleRes.setRoleId(r);
            roleResMapper.insert(roleRes);
        });
        return  saveOrUpdate(resDTO.getId(),resDTO);
    }

    @Override
    public PageResponse<ResDTO> page(PageRequest<ResQueryDTO> pageRequest) {
        ResQueryDTO resQueryDTO =  pageRequest.getQuery();
        LambdaQueryWrapper<Res> wrapper = lambdaQueryWrapper();
        wrapper.orderByDesc(Res::getCreateTime);
        wrapper.orderByDesc(Res::getId);
        wrapper.like(CharSequenceUtil.isNotBlank(resQueryDTO.getName()),Res::getName,resQueryDTO.getName());

        return this.pageBeans(pageRequest,wrapper, ResDTO.class);
    }

    @Override
    public List<ResMenuVO> getAllMenu(Long pid, List<Res> resList) {
        List<ResMenuVO> resultList = new ArrayList<>();
        //排序 Sort降序
        List<Res> rslist =
                resList.stream()
                        .filter(t -> pid.equals(t.getPid()))
                        .sorted(Comparator.comparing(Res::getSort))
                        .collect(Collectors.toList());
        for (Res model : rslist) {
            ResMenuVO newRes = new ResMenuVO();
            BeanUtil.copyProperties(model, newRes, CopyOptions.create().ignoreNullValue());
            //递归
            List<ResMenuVO> children = getAllMenu(newRes.getId(), resList);
            if (!children.isEmpty()) {
                newRes.setChildrens(children);
            }
            //获取菜单角色
            List<Long> roleIds = getRoleByResId(model.getId());
            newRes.setRoleIds(roleIds);
            resultList.add(newRes);
        }
        return resultList;
    }

    /**
     * 根据资源id获取角色
     * @param id
     */
    private List<Long> getRoleByResId(Long id) {
        LambdaQueryWrapper<RoleRes> roleResLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleResLambdaQueryWrapper.eq(RoleRes::getResId, id).select(RoleRes::getRoleId);
        List<RoleRes> roleRes = roleResMapper.selectList(roleResLambdaQueryWrapper);
        return roleRes.stream().map(RoleRes::getRoleId).collect(Collectors.toList());
    }
}
