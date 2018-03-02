package com.ccclubs.influxdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.io.IOException;

/**
 * Created by Administrator on 2018/1/30 0030.
 */
@SpringBootApplication
public class InfluxdbSrvApp extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(InfluxdbSrvApp.class);

    /** war打包用，相当于web.xml配置 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(InfluxdbSrvApp.class);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(InfluxdbSrvApp.class, args);
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        for(String p : profiles){
            logger.info("Env profile:{}", p);
        }

    }
}
