package com.ccclubs.frm.validation.constraintvalidation;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * 实现注解校验InArray
 *
 * @author jianghaiyang
 * @create 2017-07-07
 **/
public class InArrayDef implements ConstraintValidator<InArray, Object> {

    private int[] range;

    @Override
    public void initialize(InArray constraintAnnotation) {
        this.range = constraintAnnotation.range();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;    //非空判断由@NotNull完成
        }
        int index = Arrays.binarySearch(range, (Integer.parseInt(value.toString())));
        if (index < 0) {
            return false;
        } else {
            return true;
        }
    }
}
