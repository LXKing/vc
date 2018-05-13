package com.ccclubs.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 开启严格匹配模式，至匹配/add，不匹配add.html
 * @author qsxiaogang
 * @create 2017-11-28
 **/
@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedHeaders("*").allowedMethods("POST,GET").allowedOrigins("*").allowCredentials(true);
  }

//  @Override
//  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/error").setViewName("404.html");
//    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//  }

  @Autowired
  TokenInterceptor tokenInterceptor;
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 多个拦截器组成一个拦截器链
    // addPathPatterns 用于添加拦截规则
    // excludePathPatterns 用户排除拦截
    //此处添加所有的请求路径都要拦截但是登录等的请求除外。
    registry.addInterceptor(tokenInterceptor)
            .addPathPatterns("/**")
            //.excludePathPatterns("/oauth/**")
            .excludePathPatterns("/user/**")
            .excludePathPatterns("/monitor/gbState/set")
            .excludePathPatterns("/monitor/expVehicle/trigger/**")
            .excludePathPatterns("/protocol/**")
            .excludePathPatterns("/monitor/gbState/detail/**")
            .excludePathPatterns("/report/**");

    super.addInterceptors(registry);
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    super.configurePathMatch(configurer);
    configurer.setUseSuffixPatternMatch(false);
  }
}
