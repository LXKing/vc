package com.ccclubs.manage;

import com.ccclubs.frm.mybatis.MybatisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

/**
 * Created by Alban on 2017/11/23
 */
@SpringBootApplication
@Import({MybatisConfig.class})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ManageSrvApp extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(ManageSrvApp.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManageSrvApp.class);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(ManageSrvApp.class, args);
        ctx.getEnvironment().getPropertySources().addFirst(new ResourcePropertySource("classpath:filtered.properties"));
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        for(String p : profiles){
            logger.info("Env profile:{}", p);
        }
    }
}
