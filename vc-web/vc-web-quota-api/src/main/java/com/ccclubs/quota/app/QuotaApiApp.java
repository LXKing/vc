package com.ccclubs.quota.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.ccclubs.frm.swagger.Swagger2Config;
 
@SpringBootApplication
@ImportAutoConfiguration({Swagger2Config.class})
public class QuotaApiApp extends SpringBootServletInitializer {

    /** war打包用，相当于web.xml配置 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(QuotaApiApp.class);
    }
    
    

    public static void main(String[] args) {
    	
        SpringApplication.run(QuotaApiApp.class, args);
    }

}
