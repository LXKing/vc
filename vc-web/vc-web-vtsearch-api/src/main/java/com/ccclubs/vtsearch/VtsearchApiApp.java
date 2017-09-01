package com.ccclubs.vtsearch;

import com.ccclubs.frm.swagger.Swagger2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@ImportAutoConfiguration({Swagger2Config.class})
public class VtsearchApiApp extends SpringBootServletInitializer {

    /** war打包用，相当于web.xml配置 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VtsearchApiApp.class);
    }

    public static void main(String[] args) {
    	
        SpringApplication.run(VtsearchApiApp.class, args);
    }

}
