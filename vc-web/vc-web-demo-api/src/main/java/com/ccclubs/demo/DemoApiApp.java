package com.ccclubs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.ccclubs.frm.redis.RedisAutoConfiguration;
import com.ccclubs.frm.swagger.Swagger2Config;
 
@SpringBootApplication
@ImportAutoConfiguration({RedisAutoConfiguration.class, Swagger2Config.class})
public class DemoApiApp extends SpringBootServletInitializer {

    /** war打包用，相当于web.xml配置 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApiApp.class);
    }
    
    

    public static void main(String[] args) {
    	
        SpringApplication.run(DemoApiApp.class, args);
    }

}
