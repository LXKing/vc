package com.ccclubs.frm.validation.constraints;


import com.ccclubs.frm.validation.constraintvalidation.InArrayDef;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 实现注解校验InArray
 *
 * @author jianghaiyang
 * @create 2017-07-07
 **/
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {InArrayDef.class})
public @interface InArray {
    String message() default "输入值不在约定范围之内";

    int[] range() default {0, 1};//范围

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
