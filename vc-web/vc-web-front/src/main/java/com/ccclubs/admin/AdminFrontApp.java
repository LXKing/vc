package com.ccclubs.admin;

import com.ccclubs.frm.oss.OssAutoConfiguration;
import com.ccclubs.frm.redis.RedisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * 后台页面
 *
 * @author jianghaiyang
 * @create 2017-09-15
 **/
@SpringBootApplication(scanBasePackages = "com.ccclubs")
@Import({RedisAutoConfiguration.class, OssAutoConfiguration.class})
public class AdminFrontApp extends SpringBootServletInitializer {

    /**
     * war打包用，相当于web.xml配置
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminFrontApp.class);
    }

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(AdminFrontApp.class);
        springApplication.addListeners(new AppContext());
        springApplication.run(args);

    }

}