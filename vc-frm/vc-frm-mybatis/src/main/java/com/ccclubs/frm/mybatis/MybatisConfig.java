package com.ccclubs.frm.mybatis;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ccclubs.frm.druid.DruidJdbcConfig;

@Configuration
@Import({DruidJdbcConfig.class, MybatisFactoryConfig.class, MybatisMapperConfig.class})
public class MybatisConfig {

}
