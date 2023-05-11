package com.cciet.biz.rbac.config;

import com.cciet.common.IConstant;
import com.cciet.web.config.OpenApi3Configuration;
import com.cciet.web.util.OpenApiUtil;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SpringDocConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * API文档
 *
 * @author huanghui
 * @since 2023/5/6 12:23
 */
@Configuration
@AutoConfigureBefore(SpringDocConfiguration.class)
public class DocConfig {

    @Bean("rbacOpenApi")
    public GroupedOpenApi init() {
        return OpenApiUtil.getGroupedOpenApiBuilder("RBAC模块","/user/**").build();
    }

}