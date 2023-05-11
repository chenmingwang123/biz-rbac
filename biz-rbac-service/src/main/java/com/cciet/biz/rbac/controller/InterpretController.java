package com.cciet.biz.rbac.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.cciet.biz.rbac.bean.interpret.*;
import com.cciet.biz.rbac.component.Permission;
import com.cciet.common.bean.PageResponse;
import com.cciet.common.bean.Result;
import com.cciet.common.feign.IPermissionFeign;
import com.cciet.common.interfaces.IPermission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字段翻译DEMO
 *
 * @author huanghui
 * @since 2023/5/9 11:35
 */
@Validated
@RestController
@Tag(name = "字段翻译DEMO")
@RequestMapping("/interpret")
public class InterpretController {

    private User buildUser() {
        String[] codes = {IdUtil.fastSimpleUUID(), IdUtil.fastSimpleUUID()};
        String codeStr = ArrayUtil.join(new String[]{IdUtil.fastSimpleUUID(), IdUtil.fastSimpleUUID()}, ",");
        Long[] roleIds = {IdUtil.getSnowflakeNextId(), IdUtil.getSnowflakeNextId()};
        Group[] groups = {Group.builder().name(RandomUtil.randomString(10)).type(RandomUtil.randomString(10)).build(),
                Group.builder().name(RandomUtil.randomString(10)).type(RandomUtil.randomString(10)).build()};
        List<String> bookIds = new ArrayList<>(Arrays.asList(IdUtil.fastSimpleUUID(), IdUtil.fastSimpleUUID(), IdUtil.fastSimpleUUID()));
        List<Addr> adders = new ArrayList<>(Arrays.asList(Addr.builder().targetId(IdUtil.getSnowflakeNextId()).city(RandomUtil.randomString(10)).build(), Addr.builder().targetId(IdUtil.getSnowflakeNextId()).city(RandomUtil.randomString(10)).build(), Addr.builder().targetId(IdUtil.getSnowflakeNextId()).city(RandomUtil.randomString(10)).build()));

        Org org = Org.builder().userId(IdUtil.getSnowflakeNextId()).dept(new Dept[]{
                        Dept.builder().deptType(RandomUtil.randomString(10)).build(),
                        Dept.builder().deptType(RandomUtil.randomString(10)).build()
                }).treeList(Arrays.asList(
                        Tree.builder().nodeType(NodeType.ROOT).name(RandomUtil.randomString(10)).childNodes(
                                Arrays.asList(
                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).childNodes(
                                                Arrays.asList(
                                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build(),
                                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build(),
                                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build()
                                                )
                                        ).build(),
                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).childNodes(
                                                Arrays.asList(
                                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build(),
                                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build(),
                                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build()
                                                )
                                        ).build(),
                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).childNodes(
                                                Arrays.asList(
                                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build(),
                                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build(),
                                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build()
                                                )
                                        ).build()
                                )
                        ).build(),
                        Tree.builder().nodeType(NodeType.ROOT).name(RandomUtil.randomString(10)).childNodes(
                                Arrays.asList(
                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build(),
                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build(),
                                        Tree.builder().nodeType(NodeType.LEAF).name(RandomUtil.randomString(10)).build()
                                )
                        ).build()

                ))

                .build();

        return User.builder().codes(codes).codeStr(codeStr)
                .roleIds(roleIds)
                .groups(groups)
                .bookIds(bookIds)
                .userId(IdUtil.getSnowflakeNextId())
                .addrs(adders)
                .deptDemo(Dept.builder().deptType(RandomUtil.randomString(10)).build())
                .orgDemo(org)
                .sex(Sex.F).build();
    }

    @Operation(summary = "返回Result<User>对象")
    @GetMapping("/result/user")
    public Result<User> resultUser() {
        return Result.ok(buildUser());
    }

    @Operation(summary = "返回Result<List<User>>对象")
    @GetMapping("/result/list/user")
    public Result<List<User>> resultListUser() {
        List<User> user = new ArrayList<>(Arrays.asList(buildUser(), buildUser(), buildUser(), buildUser()));
        return Result.ok(user);
    }

    @Operation(summary = "返回Result<PageResponse<User>>对象")
    @GetMapping("/result/page/user")
    public Result<PageResponse<User>> resultPageUser() {
        List<User> user = new ArrayList<>(Arrays.asList(buildUser(), buildUser(), buildUser(), buildUser()));
        PageResponse<User> page = PageResponse.<User>builder().records(user).build();
        return Result.ok(page);
    }

    @Operation(summary = "返回PageResponse<User>对象")
    @GetMapping("/one/user")
    public PageResponse<User> pageUser() {
        List<User> user = new ArrayList<>(Arrays.asList(buildUser(), buildUser(), buildUser(), buildUser()));
        return PageResponse.<User>builder().records(user).build();
    }

    @Operation(summary = "返回List<User>对象")
    @GetMapping("/list/user")
    public List<User> listUser() {
        return new ArrayList<>(Arrays.asList(buildUser(), buildUser(), buildUser(), buildUser()));
    }

    @Operation(summary = "返回User[]对象")
    @GetMapping("/array/user")
    public User[] arrayUser() {
        return new User[]{buildUser(), buildUser(), buildUser(), buildUser()};
    }

    @Operation(summary = "返回User对象")
    @GetMapping("/user")
    public User user() {

        System.out.println(SpringUtil.getBean(Permission.class));
//        System.out.println(SpringUtil.getBean(IPermissionFeign.class));

        return buildUser();
    }

}
