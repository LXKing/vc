package com.ccclubs.hbase.phoenix.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/27 0027
 */
@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties(PhoenixProperties.class)
public class PhoenixAutoConfiguration {
    @Autowired
    private PhoenixProperties phoenixProperties;

    @Bean(name="phoenixDataSource")
    public DruidDataSource initBasicDataSource(){
        String zk_url=phoenixProperties.getZk_url();
        String phoenix_url="jdbc:phoenix:"+zk_url;
        DruidDataSource basicDataSource = new DruidDataSource();
        basicDataSource.setDriverClassName("org.apache.phoenix.jdbc.PhoenixDriver");
        basicDataSource.setUrl(phoenix_url);
        basicDataSource.setUsername("");
        basicDataSource.setPassword("");
        basicDataSource.setInitialSize(20);
        basicDataSource.setMaxActive(30);
        basicDataSource.setMinIdle(10);
        basicDataSource.setValidationQuery("select now() ");
        basicDataSource.setTestOnBorrow(true);
        basicDataSource.setDefaultAutoCommit(false);
        return basicDataSource;
    }

    @Bean(name="phoenixDataSourceWrite")
    public DruidDataSource initBasicDataSourceWrite(){
        String zk_url=phoenixProperties.getZk_url();
        String phoenix_url="jdbc:phoenix:"+zk_url;
        DruidDataSource basicDataSource = new DruidDataSource();
        basicDataSource.setDriverClassName("org.apache.phoenix.jdbc.PhoenixDriver");
        basicDataSource.setUrl(phoenix_url);
        basicDataSource.setUsername("");
        basicDataSource.setPassword("");
        basicDataSource.setInitialSize(10);
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxActive(15);
        basicDataSource.setValidationQuery("select now() ");
        basicDataSource.setTestOnBorrow(true);
        basicDataSource.setDefaultAutoCommit(false);
        return basicDataSource;
    }

    @Bean(name="phoenixJdbcTemplate")
    public JdbcTemplate initJdbcTemplate(@Qualifier("phoenixDataSource")DruidDataSource phoenixDataSource){
        JdbcTemplate phoenixJdbcTemplate = new JdbcTemplate();
        phoenixJdbcTemplate.setDataSource(phoenixDataSource);
        return phoenixJdbcTemplate;
    }

    @Bean(name="phoenixHelper",initMethod = "start",destroyMethod = "stop")
    public PhoenixHelper initPhoenixHelper(@Qualifier("phoenixDataSourceWrite")DruidDataSource phoenixDataSource){
        PhoenixHelper phoenixHelper = new PhoenixHelper(phoenixDataSource);
        return phoenixHelper;
    }
}
