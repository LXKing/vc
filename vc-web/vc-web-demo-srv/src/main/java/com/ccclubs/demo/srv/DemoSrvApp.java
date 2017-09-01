package com.ccclubs.demo.srv;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.ResourcePropertySource;

import com.ccclubs.frm.mybatis.MybatisConfig;
 
@SpringBootApplication
@Import({MybatisConfig.class})
public class DemoSrvApp extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(DemoSrvApp.class);
    /** war打包用，相当于web.xml配置 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoSrvApp.class);
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
    	ConfigurableApplicationContext ctx = SpringApplication.run(DemoSrvApp.class, args);
        ctx.getEnvironment().getPropertySources().addFirst(new ResourcePropertySource("classpath:filtered.properties"));
		String[] profiles = ctx.getEnvironment().getActiveProfiles();
		for(String p : profiles){
			logger.info("Env profile:{}", p);
		}
		
		//Thread.sleep(100000000000000000L);
    }

}