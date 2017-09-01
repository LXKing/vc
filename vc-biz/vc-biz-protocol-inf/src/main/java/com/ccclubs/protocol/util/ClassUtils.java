package com.ccclubs.protocol.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassUtils {

  private static final Logger logger = LoggerFactory.getLogger(ClassUtils.class);

  /**
   * 通过反射，获取类实例
   */
  public static Object getBean(String className) {
    Class clazz = null;
    try {
      clazz = Class.forName(className);
    } catch (Exception ex) {
      logger.info("找不到指定的类" + className);
    }
    if (clazz != null) {
      try {
        return clazz.newInstance();
      } catch (Exception ex) {
        logger.info("找不到指定的类");
      }
    }
    return null;
  }
}
