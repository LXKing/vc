package com.ccclubs.report.main;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.ccclubs.report.main.config.KafkaConsumerConfig;
import com.ccclubs.report.main.config.NettyConfig;
import com.ccclubs.report.main.config.TaskConfig;
import com.ccclubs.report.spring.WebConfiguration;

@SpringBootApplication
@ComponentScan("com.ccclubs.report.api,com.ccclubs.report.service")
@Import({WebConfiguration.class, NettyConfig.class, TaskConfig.class, KafkaConsumerConfig.class})
public class ProtocolSrv extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(ProtocolSrv.class);

    /** war打包用，相当于web.xml配置 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProtocolSrv.class);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProtocolSrv.class, args);
        // ctx.getEnvironment().getPropertySources().addFirst(new
        // ResourcePropertySource("classpath:filtered.properties"));
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        for (String p : profiles) {
            logger.info("Env profile:{}", p);
        }

    }
}
