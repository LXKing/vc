package com.ccclubs.frm.dubbox;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.alibaba.dubbo.config.spring.AnnotationBean;

public class DubboInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		Environment env = applicationContext.getEnvironment();
		String scan = env.getProperty("dubbo.scan.annotationPackage");
		if (scan != null) {
			AnnotationBean scanner = BeanUtils.instantiate(AnnotationBean.class);
			scanner.setPackage(scan);
			scanner.setApplicationContext(applicationContext);
			applicationContext.addBeanFactoryPostProcessor(scanner);
			applicationContext.getBeanFactory().addBeanPostProcessor(scanner);
			applicationContext.getBeanFactory().registerSingleton("dubboxAnnotationBean", scanner);
		}
	}

}
