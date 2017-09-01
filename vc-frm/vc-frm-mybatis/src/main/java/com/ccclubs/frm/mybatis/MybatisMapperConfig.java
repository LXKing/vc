package com.ccclubs.frm.mybatis;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MybatisMapperConfig {
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer cfg = new MapperScannerConfigurer();
		cfg.setBasePackage("com.ccclubs.**.orm.mapper");
		cfg.setSqlSessionFactoryBeanName("druidSqlSessionFactory");
		return cfg;
	}
}
