package com.ccclubs.frm.mybatis.sepn;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ReadWriteMapperConfig {
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer cfg = new MapperScannerConfigurer();
		cfg.setBasePackage("com.ccclubs.**.orm.mapper");
		//cfg.setSqlSessionFactoryBeanName("sqlSessionFactory");
		cfg.setSqlSessionTemplateBeanName("ejsSqlSessionTemplate");
		return cfg;
	}
}
