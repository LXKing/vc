package com.ccclubs.frm.spring.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.validation.constraintvalidation.ApiValidDef;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ApiValidDef.class})
public @interface ApiValid {
	ApiEnum msg() default ApiEnum.SUCCESS;
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String message();
}
