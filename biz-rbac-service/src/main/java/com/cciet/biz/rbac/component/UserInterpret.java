package com.cciet.biz.rbac.component;

import com.cciet.common.interpret.type.USER;
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
public class UserInterpret implements USER {
    @Override
    public Map<Object, String> getInterpretText(Set<Object> codes) {
        return Collections.emptyMap();
    }
}
