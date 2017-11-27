package com.ccclubs.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 后台页面
 *
 * @author jianghaiyang
 * @create 2017-09-15
 **/
@SpringBootApplication
public class AdminFrontApp extends SpringBootServletInitializer {
    /**
     * war打包用，相当于web.xml配置
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminFrontApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminFrontApp.class, args);
    }
}