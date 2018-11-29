package com.ccclubs.frm.spring.util;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @Author: yeanzi
 * @Date: 2018/9/26
 * @Time: 17:50
 * Email:  yeanzhi@ccclubs.com
 * 经纬度工具类
 */
public final class LongLatitudeUtil {

    /**
     * 经度校验
     *
     * @param value
     * @return
     */
    public static boolean isLONG(String value) {
        Objects.requireNonNull(value);

        String regExpress = "^(([1-9]\\d?)|(1[0-7]\\d))(\\.\\d{1,6})|180|0(\\.\\d{1,6})?$";
        return Pattern.matches(regExpress, value);
    }

    /**
     * 纬度校验
     *
     * @param value
     * @return
     */
    public static boolean isLA(String value) {
        Objects.requireNonNull(value);

        String regExpress = "^(([1-8]\\d?)|([1-8]\\d))(\\.\\d{1,6})|90|0(\\.\\d{1,6})?$";
        return Pattern.matches(regExpress, value);
    }

    /**
     * 将真实经纬度字符传转化成X10^6之后的int型字符串
     * @param value
     * @return
     */
    public static int Str2Int(String value) {
        Objects.requireNonNull(value);

        return new BigDecimal(value).multiply(new BigDecimal(1000000)).intValue();
    }
}
