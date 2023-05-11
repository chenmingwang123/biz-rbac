package com.cciet.biz.rbac.bean.interpret;

import com.cciet.common.interpret.Interpret;
import lombok.*;

import java.util.List;

/**
 * @author huanghui
 * @since 2023/5/9 11:14
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Org {

    @Interpret
    Long userId;

    List<Tree> treeList;

    Dept[] dept;


}
