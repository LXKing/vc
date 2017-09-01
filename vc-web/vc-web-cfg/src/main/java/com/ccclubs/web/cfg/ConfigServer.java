package com.ccclubs.web.cfg;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.support.ResourcePropertySource;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer {
	private static final Logger logger = LoggerFactory.getLogger(ConfigServer.class);
	/**
	 * 启动服务
	 *
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx = SpringApplication.run(ConfigServer.class, args);
		ctx.getEnvironment().getPropertySources().addFirst(new ResourcePropertySource("classpath:filtered.properties"));
		String[] profiles = ctx.getEnvironment().getActiveProfiles();
		for(String p : profiles){
			logger.info("Env profile:{}", p);
		}
	}

}