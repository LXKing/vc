package com.ccclubs.frm.spring.validation.constraintvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ccclubs.frm.spring.validation.constraints.ApiValid;

public class ApiValidDef implements ConstraintValidator<ApiValid, Object> {

	@Override
	public void initialize(ApiValid constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
