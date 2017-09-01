package com.ccclubs.frm.mybatis;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.pagehelper.PageInterceptor;

/**
 * 注解不要和数据源定义的配置写在一起，否此会导致循环引用初始化bean问题．
 * 类中两个有依赖关系的bean注入方法，不要用set方法形式注入，有可能导致注入循环引用问题．
 * 注意：bean需要拆分开写，否则无法获取依赖bean和value等配置变量
 * 
 * @author ZiYang
 *
 */
@Configuration
public class MybatisFactoryConfig {
	
	@Autowired
	private DataSource druidDataSource;

	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(druidDataSource);
	}

	@Bean(name = "druidSqlSessionFactory")
	public SqlSessionFactory druidSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		// fb.setConfigLocation(mybatisMapperConfig);
		ssfb.setDataSource(druidDataSource);
		PageInterceptor pi = new PageInterceptor();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		pi.setProperties(p);
		ssfb.setPlugins(new Interceptor[] { pi });
	
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		ssfb.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
		// fb.setTypeAliases(new Class<?>[] { IdTypeHandler.class });
		return ssfb.getObject();
	}
}
