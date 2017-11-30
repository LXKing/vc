package com.ccclubs.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 开启严格匹配模式，至匹配/add，不匹配add.html
 * @author qsxiaogang
 * @create 2017-11-28
 **/
@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {

//  @Override
//  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/error").setViewName("404.html");
//    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    super.configurePathMatch(configurer);
    configurer.setUseSuffixPatternMatch(false);
  }
}
