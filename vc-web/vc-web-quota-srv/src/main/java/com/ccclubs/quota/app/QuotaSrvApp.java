package com.ccclubs.quota.app;

import java.io.IOException;

import com.ccclubs.frm.mongo.config.MultipleMongoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import com.ccclubs.frm.mybatis.MybatisConfig;
import com.ccclubs.frm.redis.RedisAutoConfiguration;

@SpringBootApplication
@Import({RedisAutoConfiguration.class, MybatisConfig.class, MultipleMongoConfig.class})
public class QuotaSrvApp extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(QuotaSrvApp.class);

    /** war打包用，相当于web.xml配置 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(QuotaSrvApp.class);
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
    	ConfigurableApplicationContext ctx = SpringApplication.run(QuotaSrvApp.class, args);
//        ctx.getEnvironment().getPropertySources().addFirst(new ResourcePropertySource("classpath:filtered.properties"));
		String[] profiles = ctx.getEnvironment().getActiveProfiles();
		for(String p : profiles){
			logger.info("Env profile:{}", p);
		}
		
    }
}