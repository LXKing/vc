package com.ccclubs.gateway.gb.inf;

/**
 * @Author: yeanzi
 * @Date: 2018/5/3
 * @Time: 18:35
 * Email:  yeanzhi@ccclubs.com
 * 定义将异常dto转化为json字符串接口
 */
public interface IExceptionDtoJsonParse {
    /**
     * 将异常dto序列化成json字符串
     * @return
     */
    String toJson();
}
