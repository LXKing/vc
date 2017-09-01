package com.ccclubs.usr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
 
@SpringBootApplication
@ImportAutoConfiguration({})
public class UsrAppApp extends SpringBootServletInitializer {

    /** war打包用，相当于web.xml配置 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UsrAppApp.class);
    }
    
    

    public static void main(String[] args) {
    	
        SpringApplication.run(UsrAppApp.class, args);
    }

}
