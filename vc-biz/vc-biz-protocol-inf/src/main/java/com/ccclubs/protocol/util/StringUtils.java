package com.ccclubs.protocol.util;

import com.alibaba.fastjson.JSONObject;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qsxiaogang on 2017/7/4.
 */
public class StringUtils {

  /**
   * 补零对齐
   */
  public static String zerofill(Object value, Integer max) {
    if (value == null) {
      return "";
    }
    String strValue = value.toString();
    if (strValue.length() >= max) {
      return strValue;
    }
    String strZero = "";
    for (int i = 0; i < max - strValue.length(); i++) {
      strZero += "0";
    }
    return strZero + strValue;
  }

  /**
   * 是否为空字符串
   */
  public static Boolean empty(String string) {
    if (string == null || "".equals(string.trim())) {
      return true;
    }
    return false;
  }

  public static Boolean notEmpty(String string) {
    if (string == null || "".equals(string.trim())) {
      return false;
    }
    return true;
  }

  /**
   * 获取随机数
   */
  public static int rand(Integer iMax) {
    return Math.abs(new java.util.Random().nextInt() % iMax);
  }

  /**
   * 保留小数位
   */
  public static String digit(Object value, Integer count) {
    if (value == null) {
      value = 0d;
    }
    if (count == null) {
      count = 2;
    }

    String sNum = "";

    int iii = 1;
    for (int i = 0; i < count; i++) {
      iii *= 10;
    }

    String name = value.getClass().getSimpleName().toLowerCase();

    if (name.equals("float")) {
      sNum = "" + new Float(((Float) value + 0.000001f) * iii).longValue();
    } else if (name.equals("double")) {
      sNum = "" + new Double(((Double) value + 0.0000001d) * iii).longValue();
    } else if (name.equals("bigdecimal")) {
      sNum = "" + new BigDecimal(((BigDecimal) value).doubleValue() * iii).longValue();
    } else if (name.equals("long")) {
      sNum = "" + (Long) value * iii;
    } else if (name.indexOf("int") > -1) {
      sNum = "" + new Long((Integer) value) * iii;
    } else {
      sNum = "" + Long.valueOf("" + value) * iii;
    }

    String prefix = "";
    if (sNum.startsWith("-")) {
      sNum = sNum.replace("-", "");
      prefix = "-";
    }

    for (int i = 0; i < (count - sNum.length() + 1); i++) {
      sNum = "0" + sNum;
    }

    sNum = sNum.substring(0, sNum.length() - count) + "." + sNum
        .substring(sNum.length() - count, sNum.length());

    if (sNum.startsWith(".")) {
      sNum = "0" + sNum;
    }

    return prefix + sNum;
  }

  public static String trim(String string) {
    if (string == null || string.trim().equals("")) {
      return "";
    }
    return string.trim();
  }

  public static String json(Object object) {
    return JSONObject.toJSONString(object);
  }

  public static Boolean equals(String v1, String v2) {
    if (v1 == null && v2 == null) {
      return true;
    }
    if (v1 != null && v2 != null && v1.equals(v2)) {
      return true;
    } else {
      return false;
    }
  }

  public static String date(java.util.Date date, String format) {
    String dateStr = "";
    if (date == null) {
      return "";
    }
    try {
      SimpleDateFormat DF = new SimpleDateFormat(format);
      dateStr = DF.format(date);
    } catch (Exception e) {
      e.printStackTrace();

    }
    return dateStr;
  }

  public static Date date(String date, String format) {
    if (date == null || date.equals("")) {
      return null;
    }
    if (format == null || format.equals("")) {
      return null;
    }
    try {
      return new SimpleDateFormat(format).parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static <T> T or(T v1, T v2) {
    if (v1 == null) {
      return v2;
    }
    if (v1.getClass() == String.class && empty((String) v1)) {
      return v2;
    }
    return v1;
  }

  public static String date(Object date, String format) {
    if (date == null || date.equals("")) {
      return null;
    }
    if (format == null || format.equals("")) {
      return null;
    }
    if (date.getClass() == String.class) {
      return (String) date;
    }
    return date((Date) date, format);
  }

  public static String md5(String string) {
    return new MD5().getMD5ofStr(string);
  }

}
