package com.ccclubs.frm.spring.entity;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/18
 * @Time: 16:24
 * @Description: 处理String处理常见问题！
 */

public class StringTool {

    /**
     * 将驼峰命名的字段名变换为下划线分隔的命名的字段名
     * */
    public static String camelToUnderline(String column)
    {
        char arr[] = column.toCharArray();
        StringBuffer buf = new StringBuffer();
        for(char ch:arr)
        {
            if(Character.isUpperCase(ch))
            {
                buf.append('_');
                buf.append(Character.toLowerCase(ch));
            }
            else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }

    /**
     * 将下划线分隔的命名的字段名变换为驼峰命名的字段名
     *
     * */
    public static String underlineToCamel(String column) {
        String arr[] = column.split("_");
        StringBuffer buf = new StringBuffer();
        boolean first = true;
        for (String subColumn : arr) {
            if (first) {
                first = false;
                buf.append(subColumn);
            } else {
                buf.append(subColumn.replaceFirst(subColumn.substring(0, 1), subColumn.substring(0, 1).toUpperCase()));
            }
        }
        return buf.toString();
    }

}
