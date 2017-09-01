package com.ccclubs.frm.mybatis.sepn;

import java.util.HashMap;
import java.util.Map;
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
public class ReadWriteMybatisConfig {
	/*
	 * @Value("classpath:mapper/*.xml") Resource mybatisMapperConfig;
	 */
	@Autowired
	private DataSource writeDataSource;
	
	@Autowired
	private DataSource readerDataSource;


	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(writeDataSource);
	}
	
	@Bean("ejsSqlSessionTemplate")
	public ReadWriteSqlSessionTemplate ejsSqlSessionTemplate() throws Exception {
		ReadWriteSqlSessionTemplate esst = new ReadWriteSqlSessionTemplate(writeSqlSessionFactory());
		Map<Object, SqlSessionFactory> targetSqlSessionFactory = new HashMap<Object, SqlSessionFactory>();
		targetSqlSessionFactory.put("reader", readerSqlSessionFactory());
		targetSqlSessionFactory.put("write", writeSqlSessionFactory());
		esst.setTargetSqlSessionFactory(targetSqlSessionFactory);
		return esst;
	}

	@Bean(name = "readerSqlSessionFactory")
	public SqlSessionFactory readerSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		// fb.setConfigLocation(mybatisMapperConfig);
		ssfb.setDataSource(readerDataSource);
		PageInterceptor pi = new PageInterceptor();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		pi.setProperties(p);
		ssfb.setPlugins(new Interceptor[] { pi });
		/*
		 * Resource[] mapperLocations = new Resource[] { new
		 * ClassPathResource("mapper/*.xml") };
		 * ssfb.setMapperLocations(mapperLocations);
		 */
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		ssfb.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
		// fb.setTypeAliases(new Class<?>[] { IdTypeHandler.class });
		return ssfb.getObject();
	}
	
	@Bean(name = "writeSqlSessionFactory")
	public SqlSessionFactory writeSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		// fb.setConfigLocation(mybatisMapperConfig);
		ssfb.setDataSource(writeDataSource);
		PageInterceptor pi = new PageInterceptor();
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		pi.setProperties(p);
		ssfb.setPlugins(new Interceptor[] { pi });
		/*
		 * Resource[] mapperLocations = new Resource[] { new
		 * ClassPathResource("mapper/*.xml") };
		 * ssfb.setMapperLocations(mapperLocations);
		 */
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		ssfb.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
		// fb.setTypeAliases(new Class<?>[] { IdTypeHandler.class });
		return ssfb.getObject();
	}
}
