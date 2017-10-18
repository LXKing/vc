package com.ccclubs.common.aop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 方法执行时长切面处理
 *
 * @author jianghaiyang
 * @create 2017-07-17
 **/
@Component
@Aspect
public class TimerLogAspect {

  private static final Logger logger = LoggerFactory.getLogger(TimerLogAspect.class);

  private long start;
  private Class cls;
  private String method;

  @Pointcut("@annotation(com.ccclubs.common.aop.Timer)")
  public void logTime() {
  }

  //在方法执行前执行
  @Before("logTime()")
  public void before() {
    start = System.nanoTime();
  }

  /**
   * 数据权限校验
   *
   * @param joinPoint 连接点
   * @return 方法执行结果
   * @throws Throwable 调用出错
   */
  @Around("logTime()")
  public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

    /**
     * 解析注解
     */
    cls = joinPoint.getTarget().getClass();// 获取被拦截的Class
    method = joinPoint.getSignature().getName(); //获取被拦截的方法

    return joinPoint.proceed();
  }

  //在方法执行后执行
  @After("logTime()")
  public void after() {
    logger.error("{}.{}, use time:{} ms", cls.getName(), method,
        new BigDecimal((System.nanoTime() - start) * 0.000001).setScale(2, RoundingMode.HALF_UP));
  }

}
