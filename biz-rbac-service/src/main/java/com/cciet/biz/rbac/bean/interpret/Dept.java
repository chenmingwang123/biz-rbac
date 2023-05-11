package com.cciet.biz.rbac.bean.interpret;

import com.cciet.common.interpret.Interpret;
import lombok.*;

/**
 *
 * @author huanghui
 * @since 2023/5/9 11:14
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    @Interpret
    String deptType;

}
