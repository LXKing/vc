package com.ccclubs.frm.influxdb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by kevin on 16/11/28.
 *
 * 需要做lnfluxdb的tag属性的字段需要加上此注解
 *
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InfluxTag {
    public String name() default "";
}
