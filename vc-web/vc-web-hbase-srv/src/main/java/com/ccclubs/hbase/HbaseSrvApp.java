package com.ccclubs.hbase;

import com.ccclubs.frm.hbase.HbaseAutoConfiguration;
import com.ccclubs.frm.hbase.HbaseProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

/**
 * Created by taosm on 2017/8/29 0029.
 */
@SpringBootApplication
@EnableConfigurationProperties(HbaseProperties.class)
@Import(HbaseAutoConfiguration.class)
public class HbaseSrvApp extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(HbaseSrvApp.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HbaseSrvApp.class);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(HbaseSrvApp.class, args);
        ctx.getEnvironment().getPropertySources().addFirst(new ResourcePropertySource("classpath:filtered.properties"));
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        for(String p : profiles){
            logger.info("Env profile:{}", p);
        }
    }
}
