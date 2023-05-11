package com.cciet.biz.rbac.bean.interpret;

import com.cciet.common.interpret.Interpret;
import lombok.*;

/**
 *
 * @author huanghui
 * @since 2023/5/9 11:19
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    String name;

    @Interpret
    String type;


}
