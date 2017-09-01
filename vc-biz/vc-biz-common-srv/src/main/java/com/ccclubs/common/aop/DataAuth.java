package com.ccclubs.common.aop;

import java.lang.annotation.*;

/**
 * 数据权限校验
 * 校验应用(appId)是否有数据资源(resource)的权限(perms)
 * @author jianghaiyang
 * @create 2017-07-17
 * */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataAuth {

    /**
     * 数据权限
     * TODO 结合权限框架实现
     */
    String[] perms() default {};
}
