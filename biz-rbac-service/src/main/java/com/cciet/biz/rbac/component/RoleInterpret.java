package com.cciet.biz.rbac.component;

import com.cciet.common.apis.interpret.ROLE;
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
public class RoleInterpret implements ROLE {

    @Override
    public Result<Map<Object, String>> getInterpretTextApi(Set<Object> codes) {
        return null;
    }
}
