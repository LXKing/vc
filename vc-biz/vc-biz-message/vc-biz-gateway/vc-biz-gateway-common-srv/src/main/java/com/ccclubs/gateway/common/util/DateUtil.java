package com.ccclubs.gateway.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 11:22
 * Email:  yeanzhi@ccclubs.com
 * 日期工具
 */
public final class DateUtil {
    private static final DateTimeFormatter FORMATTER_YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");

    public static String getNowStr() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return FORMATTER_YYYYMMDDHHMMSS.format(localDateTime);
    }

    public static void main(String[] args) {
        System.out.println(getNowStr());
    }

}
