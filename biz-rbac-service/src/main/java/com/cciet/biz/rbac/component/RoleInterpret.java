package com.cciet.biz.rbac.component;

import com.cciet.common.interpret.type.ROLE;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author huanghui
 * @since 2023/5/10 18:08
 */
@Component
public class RoleInterpret implements ROLE {

    @Override
    public Map<Object, String> getInterpretText(Set<Object> codes) {
        return Collections.emptyMap();
    }
}
