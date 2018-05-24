package com.ccclubs.frm.influxdb;

        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;

/**
 * Created by kevin on 16/11/28.
 * <p>
 * 需要做lnfluxdb的表名的注解，需要加在类上。
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InfluxTable {
    String name() default "";
}
