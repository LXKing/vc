package com.ccclubs.phoenix;

import com.ccclubs.frm.swagger.Swagger2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@ImportAutoConfiguration({Swagger2Config.class})
public class PhoenixApiApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PhoenixApiApp.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(PhoenixApiApp.class, args);
    }

}
