package com.ccclubs.frm.dubbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.alibaba.dubbo.config.spring.AnnotationBean;

@Configuration
@Import({ DubboxAutoConfiguration.class })
public class DubboxConfig {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Bean
	public AnnotationBean dubboAnnotationBean() {
		String scan = "com.ccclubs.demo.cache,com.ccclubs.demo.com.ccclubs.hbase.inf,com.ccclubs.demo.com.ccclubs.hbase.inf.impl,com.ccclubs.demo.api,com.ccclubs.demo.mono";
		logger.debug("dubbo.scan.package:{}", scan);
		// String scan = "com.ccclubs.demo.api";
		AnnotationBean scanner = new AnnotationBean();
		scanner.setPackage(scan);
		return scanner;
	}
}
