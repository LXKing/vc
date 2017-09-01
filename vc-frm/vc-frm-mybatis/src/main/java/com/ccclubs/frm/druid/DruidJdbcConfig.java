package com.ccclubs.frm.druid;

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
@Configuration
public class DruidJdbcConfig {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//
	@Value("${druid.driver}")
	String driverClass;
	//写
	@Value("${druid.jdbc.url}")
	String writerJdbcUrl;
	@Value("${druid.jdbc.username}")
	String writerUsername;
	@Value("${druid.jdbc.password}")
	String writerPassword;
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
	//@Value("${druid.druid.filters}")
	//String druidFilters;

	@Bean(name="druidDataSource",destroyMethod="close", initMethod="init")
	public DataSource druidDataSource(){
		logger.debug("init druid config");
		List<Filter> filters = new ArrayList<Filter>();
		StatFilter sf = new StatFilter();
		sf.setLogSlowSql(true);
		sf.setMergeSql(true);
		filters.add(sf);
		
		DruidDataSource dds = new DruidDataSource();
		dds.setName("druidDataSource");
		dds.setDriverClassName(driverClass);
		dds.setUrl(writerJdbcUrl);
		dds.setUsername(writerUsername);
		dds.setPassword(writerPassword);
		dds.setInitialSize(initialSize);
		dds.setMaxActive(maxActive);
		dds.setMinIdle(minIdle);
		dds.setMaxWait(maxWait);
		dds.setProxyFilters(filters);
		/*try {
			dds.setFilters(druidFilters);
		} catch (SQLException e) {
			logger.error("druidDataSource", e);
		}*/
		dds.setConnectionProperties("password="+writerPassword);
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
