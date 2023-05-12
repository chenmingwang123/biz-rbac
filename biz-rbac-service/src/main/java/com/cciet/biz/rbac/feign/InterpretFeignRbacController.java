package com.cciet.biz.rbac.feign;

import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * 翻译接口支持
 *
 * @author huanghui
 * @since 2023/5/10 17:57
 */
@Slf4j
@Hidden
@Validated
@RestController
@RequestMapping("/interpret")
public class InterpretFeignRbacController {

    @RequestMapping("/user/text")
    public Result<Map<Object, String>> getUserInterpretTextApi(Set<Object> codes) {
        log.debug("getUserInterpretTextApi:{}",codes);
        return Result.ok( Collections.emptyMap());
    }

    @RequestMapping("/org/text")
    public Result<Map<Object, String>> getOrgInterpretTextApi(Set<Object> codes) {
        log.debug("getOrgInterpretTextApi:{}",codes);
        return Result.ok( Collections.emptyMap());
    }

    @RequestMapping("/role/text")
    public Result<Map<Object, String>> getRoleInterpretTextApi(Set<Object> codes) {
        log.debug("getRoleInterpretTextApi:{}",codes);
        return Result.ok( Collections.emptyMap());
    }

}
