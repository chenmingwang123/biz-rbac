package com.cciet.biz.rbac.bean.interpret;

import com.cciet.common.interpret.Interpret;
import lombok.*;

import java.util.List;

/**
 * @author huanghui
 * @since 2023/5/9 11:12
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Interpret
    Sex sex;

    @Interpret
    Long userId;

    @Interpret
    Long[] roleIds;

    @Interpret
    String[] codes;

    @Interpret(isSplit = true)
    String codeStr;

    @Interpret
    List<String> bookIds;

    List<Addr> addrs;

    Group[] groups;

    Dept deptDemo;

    Org orgDemo;



}
