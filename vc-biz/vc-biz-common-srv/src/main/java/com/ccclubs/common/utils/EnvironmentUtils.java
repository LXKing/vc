package com.ccclubs.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author qsxiaogang
 * @create 2017-10-11
 **/
@Component
public class EnvironmentUtils {

  @Autowired
  private Environment env;

  /**
   * 获取当前应用的应用名
   * @return
   */
  public String getApplicationName() {
    return env.getProperty("spring.application.name");
  }

  /**
   * 获取当前应用编译环境，dev，test，prod
   * @return
   */
  public String getApplicationActive() {
    return env.getProperty("spring.profiles.active");
  }

  /**
   * 当前应用是否是test环境
   * @return
   */
  public boolean isTestEnvironment() {
      return "test".equals(getApplicationActive());
  }

  /**
   * 当前应用是否是dev环境
   * @return
   */
  public boolean isDevEnvironment() {
    return "dev".equals(getApplicationActive());
  }

  /**
   * 当前应用是否是prod环境
   * @return
   */
  public boolean isProdEnvironment() {
    return "prod".equals(getApplicationActive());
  }
}
