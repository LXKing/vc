package com.ccclubs.phoenix;

import com.ccclubs.common.BatchProperties;
import com.ccclubs.frm.mybatis.MybatisConfig;
import com.ccclubs.frm.redis.RedisAutoConfiguration;
import com.ccclubs.hbase.phoenix.config.PhoenixAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

@SpringBootApplication
@Import({PhoenixAutoConfiguration.class,MybatisConfig.class,BatchProperties.class,RedisAutoConfiguration.class})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.ccclubs"})
public class PhoenixSrvApp extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(PhoenixSrvApp.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PhoenixSrvApp.class);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(PhoenixSrvApp.class, args);

        ctx.getEnvironment().getPropertySources().addFirst(new ResourcePropertySource("classpath:filtered.properties"));
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        for(String p : profiles){
            logger.info("Env profile:{}", p);
        }
        //初步决定在此处判断运行环境，来判断是否可以存储hbase
    }



}
