package com.ccclubs.phoenix.tesks.processor;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @auther FengJun
 * Date: 2017/9/29
 * Time: 14:45
 * Email:fengjun@ccclubs.com
 */
public abstract class ConvertUtils {
    static Long convertToLong(Short param){
        Long result=null;
        try {
            result=param.longValue();
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }
    static Long convertToLong(Integer param){
        Long result=null;
        try {
            result=param.longValue();
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }
    static String convertToString(Integer param){
        String result=null;
        try {
            result=String.valueOf(param);
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }
    static String convertToString(Double param){
        String result=null;
        try {
            result=String.valueOf(param);
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }
    static String convertToString(Float param){
        String result=null;
        try {
            result=String.valueOf(param);
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }
    static String convertToString(Long param){
        String result=null;
        try {
            result=String.valueOf(param);
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }
    static String convertToString(Byte param){
        String result=null;
        try {
            result=String.valueOf(param);
        }catch (NullPointerException e){
            //e.getMessage();
        }
        catch (Exception e){

        }
        return result;
    }

    static Integer convertToInterger(Short param){
        Integer result=null;
        try {
            result=param.intValue();
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }

    static Integer convertToInterger(Byte param){
        Integer result=null;
        try {
            result=param.intValue();
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }
    static Integer convertToInterger(String param){
        Integer result=null;
        try {
            result=Integer.valueOf(param);
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }

    static Float convertToFloat(Byte param){
        Float result=null;
        try {
            result=param.floatValue();
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }
    static Float convertToFloat(Integer param){
        Float result=null;
        try {
            result=param.floatValue();
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }

    static Float convertToFloat(String param){
        Float result=null;
        try {
            result=Float.valueOf(param);
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }


    static Float convertToFloat(Short param){
        Float result=null;
        try {
            result=param.floatValue();
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }


    static Double convertToDouble(BigDecimal param){
        Double result=null;
        try {
            result=param.doubleValue();
        }catch (NullPointerException e){
            //e.getMessage();
        }catch (Exception e){

        }
        return result;
    }

}
