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
public class Doc2Config {
    @Bean("loginOpenApi")
    public GroupedOpenApi init() {
        return OpenApiUtil.getGroupedOpenApiBuilder("用户授权","/login/**").build();
    }
}