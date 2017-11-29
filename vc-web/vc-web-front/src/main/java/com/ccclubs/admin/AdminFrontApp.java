package com.ccclubs.admin;

import com.ccclubs.admin.config.MvcConfigurer;
import com.ccclubs.frm.mybatis.MybatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * 后台页面
 *
 * @author jianghaiyang
 * @create 2017-09-15
 **/
@SpringBootApplication
@Import({MybatisConfig.class,MvcConfigurer.class})
public class AdminFrontApp extends SpringBootServletInitializer {

  /**
   * war打包用，相当于web.xml配置
   */
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(AdminFrontApp.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(AdminFrontApp.class, args);
  }
}