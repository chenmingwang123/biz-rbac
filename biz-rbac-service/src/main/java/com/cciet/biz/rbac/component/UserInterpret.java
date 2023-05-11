package com.cciet.biz.rbac.component;

import com.cciet.common.apis.interpret.USER;
import com.cciet.common.bean.Result;
import com.cciet.common.interfaces.InterpretType;
import org.springframework.stereotype.Component;

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
        return null;
    }

    @Override
    public Result<Map<Object, String>> getInterpretTextApi(Set<Object> codes) {
        return null;
    }
}
