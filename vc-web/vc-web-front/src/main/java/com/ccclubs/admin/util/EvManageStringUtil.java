package com.ccclubs.admin.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA 2017.
 * Author: @author FengJun
 * Date: 2017/11/16
 * Time: 19:16
 * Email:fengjun@ccclubs.com
 */
public class EvManageStringUtil {

    public static int findNumberInVinString(String str){
        if (null!=str){
            return Integer.valueOf(str.substring(11));
        }
        return -1;
    }

    public static String findHeadInVinString(String str){
        if (null!=str){
            return str.substring(0,11);
        }
        return null;
    }


    public static boolean isExpression(String str){
        if (null!=str&&str.contains("-")){
            return true;
        }
        return false;
    }

    public static List<String> buildCsVinByExpression(String str){
        List<String> stringList=new ArrayList<>();
        if (isExpression(str)){
            int index=str.indexOf("-");
            String[] strings=str.split("-");
            if (strings[0].length()!=17||strings[1].length()!=17){
                return null;
            }
            if (!findHeadInVinString(strings[0].trim()).equals(findHeadInVinString(strings[1].trim()))){
                return null;
            }
            String head=findHeadInVinString(strings[0].trim());
            int beginInt=findNumberInVinString(strings[0].trim());
            int endInt=findNumberInVinString(strings[1].trim());
            if (beginInt<1||endInt<1){return null;}
            if (beginInt>endInt){
                int tempInt=beginInt;
                beginInt=endInt;
                endInt=tempInt;
            }
            for(int i=beginInt;i<endInt+1;i++){
                stringList.add(buildStringVinWithInt(head,i));
            }

            return stringList;
        }
        return null;
    }
    private static String buildStringVinWithInt(String head,int number){
        String result=null;
        String tempNumberString=String.valueOf(number);
        while (tempNumberString.length()<6){
            tempNumberString=String.valueOf(0)+tempNumberString;
        }
        result=head+tempNumberString;
        return result;
    }

}
