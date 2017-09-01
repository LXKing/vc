package com.ccclubs.hbase.app;

import com.ccclubs.frm.swagger.Swagger2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by taosm on 2017/8/30 0030.
 */
@SpringBootApplication
@ImportAutoConfiguration({Swagger2Config.class})
public class HbaseApiApp extends SpringBootServletInitializer {
    /** war打包用，相当于web.xml配置 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HbaseApiApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(HbaseApiApp.class, args);
    }
}
