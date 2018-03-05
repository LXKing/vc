package com.ccclubs.job.executor;

import com.ccclubs.frm.oss.OssAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.ccclubs")
@Import({OssAutoConfiguration.class})
public class JobExecutorApp extends SpringBootServletInitializer {

	/** war打包用，相当于web.xml配置 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JobExecutorApp.class);
	}

	public static void main(String[] args) {
        SpringApplication.run(JobExecutorApp.class, args);
	}

}