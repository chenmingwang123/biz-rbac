package com.cciet.biz.rbac.config;

import com.cciet.web.util.OpenApiUtil;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SpringDocConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return OpenApiUtil.groupByPath("RBAC模块","/rbac/**").build();
    }

}