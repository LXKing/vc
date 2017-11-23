package com.ccclubs.manage;

import com.ccclubs.frm.mybatis.MybatisConfig;
import com.ccclubs.frm.swagger.Swagger2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/23
 * Time: 10:38
 * Email:fengjun@ccclubs.com
 */
@SpringBootApplication
@ImportAutoConfiguration({Swagger2Config.class})
public class ManageApiApp extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManageApiApp.class);
    }



    public static void main(String[] args) {

        SpringApplication.run(ManageApiApp.class, args);
    }
}
