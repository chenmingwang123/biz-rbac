package com.cciet.biz.rbac.bean.interpret;

import com.cciet.common.interpret.Interpret;
import lombok.*;

import java.util.List;

/**
 *
 * @author huanghui
 * @since 2023/5/10 16:32
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tree {

    String name;

    String parentId;

    @Interpret
    NodeType nodeType;

    List<Tree> childNodes;
}
