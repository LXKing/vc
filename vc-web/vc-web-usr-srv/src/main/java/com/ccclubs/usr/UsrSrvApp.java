package com.ccclubs.usr;

import com.ccclubs.frm.mybatis.MybatisConfig;
import com.ccclubs.frm.redis.RedisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MybatisConfig.class})
@ImportAutoConfiguration({RedisAutoConfiguration.class})
public class UsrSrvApp extends SpringBootServletInitializer {

    /** war打包用，相当于web.xml配置 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UsrSrvApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(UsrSrvApp.class, args);
    }

}
