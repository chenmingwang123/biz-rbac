package com.cciet.biz.rbac.feign;

import com.cciet.common.bean.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * 翻译接口支持
 *
 * @author huanghui
 * @since 2023/5/10 17:57
 */
@Validated
@RestController
@Tag(name = "字段翻译DEMO")
@RequestMapping("/interpret")
public class InterpretFeignRbacController {

    @RequestMapping("/user/text")
    public Result<Map<Object, String>> getUserInterpretTextApi(Set<Object> codes) {
        return null;
    }

    @RequestMapping("/org/text")
    public Result<Map<Object, String>> getOrgInterpretTextApi(Set<Object> codes) {
        return null;
    }

    @RequestMapping("/role/text")
    public Result<Map<Object, String>> getRoleInterpretTextApi(Set<Object> codes) {
        return null;
    }

}
