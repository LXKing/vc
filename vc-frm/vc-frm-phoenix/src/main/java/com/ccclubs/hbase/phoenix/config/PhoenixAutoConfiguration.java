package com.ccclubs.hbase.phoenix.config;

import org.apache.commons.dbcp.BasicDataSource;
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
    public BasicDataSource initBasicDataSource(){
        String zk_url=phoenixProperties.getZk_url();
        String phoenix_url="jdbc:phoenix:"+zk_url;
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.apache.phoenix.jdbc.PhoenixDriver");
        basicDataSource.setUrl(phoenix_url);
        basicDataSource.setUsername("");
        basicDataSource.setPassword("");
        basicDataSource.setInitialSize(20);
        basicDataSource.setMaxActive(0);
        basicDataSource.setDefaultAutoCommit(true);
        return basicDataSource;
    }

    @Bean(name="phoenixJdbcTemplate")
    public JdbcTemplate initJdbcTemplate(@Qualifier("phoenixDataSource")BasicDataSource phoenixDataSource){
        JdbcTemplate phoenixJdbcTemplate = new JdbcTemplate();
        phoenixJdbcTemplate.setDataSource(phoenixDataSource);
        return phoenixJdbcTemplate;
    }



}
