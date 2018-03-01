package com.ccclubs.influxdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
@SpringBootApplication
public class InfluxdbApiApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(InfluxdbApiApp.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(InfluxdbApiApp.class, args);
    }
}
