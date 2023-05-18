package com.cciet.biz.rbac;//

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 */
@SpringBootApplication(
    scanBasePackages = {"com.cciet"}
)
public class GlobalApplication {
    public GlobalApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(GlobalApplication.class, args);
    }
}
