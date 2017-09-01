package com.ccclubs.frm.druid.sepn;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.ccclubs.frm.druid.DruidSecurityPasswordCallback;
@Configuration
public class ReadJdbcConfig {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//
	@Value("${druid.driver}")
	String driverClass;
	//读
	@Value("${druid.reader.url}")
	String readerJdbcUrl;
	@Value("${druid.reader.username}")
	String readerUsername;
	@Value("${druid.reader.password}")
	String readerPassword;
	 
	//
	@Value("${druid.initialSize}")
	int initialSize;//初始化连接大小
	@Value("${druid.maxActive}")
	int maxActive;//连接池最大数量
	@Value("${druid.minIdle}")
	int minIdle;//连接池最小空闲
	@Value("${druid.maxWait}")
	int maxWait;//获取连接最大等待时间
	@Value("${druid.minEvictableIdleTimeMillis}")
	long minEvictableIdleTimeMillis;
	@Value("${druid.timeBetweenEvictionRunsMillis}")
	long timeBetweenEvictionRunsMillis;
	@Value("${druid.druid.filters}")
	String druidFilters;

	@Bean(name="readerDataSource",destroyMethod="close", initMethod="init")
	public DataSource readerDataSource(){
		List<Filter> filters = new ArrayList<Filter>();
		StatFilter sf = new StatFilter();
		sf.setLogSlowSql(true);
		sf.setMergeSql(true);
		filters.add(sf);
		
		DruidDataSource dds = new DruidDataSource();
		dds.setName("readerDataSource");
		dds.setDriverClassName(driverClass);
		dds.setUrl(readerJdbcUrl);
		dds.setUsername(readerUsername);
		dds.setPassword(readerPassword);
		dds.setInitialSize(initialSize);
		dds.setMaxActive(maxActive);
		dds.setMinIdle(minIdle);
		dds.setMaxWait(maxWait);
		dds.setProxyFilters(filters);
		try {
			dds.setFilters(druidFilters);
		} catch (SQLException e) {
			logger.error("readerDataSource", e);
		}
		dds.setConnectionProperties("password="+readerPassword);
		DruidSecurityPasswordCallback passwordCallback = new DruidSecurityPasswordCallback();
		dds.setPasswordCallback(passwordCallback);
		dds.setTestWhileIdle(true);
		dds.setTestOnBorrow(false);
		dds.setTestOnReturn(false);
		dds.setValidationQuery("SELECT 'x' from dual");
		dds.setTimeBetweenLogStatsMillis(60000);
		//配置一个连接在池中最小生存的时间，单位是毫秒
		dds.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		//配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		dds.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		return dds;
	}
}
