package com.ccclubs.gateway.jt808.constant.msg;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 16:06
 * Email:  yeanzhi@ccclubs.com
 * 响应结果类型
 */
public enum AckReaultType {
    /**
     * 成功/确认
     */
    SUCCESS,

    /**
     * 失败
     */
    FAIL,

    /**
     * 消息有误
     */
    ERROR,

    /**
     * 不支持
     */
    NOT_SUPPORT,

    /**
     * 报警处理确认
     */
    ALARM;
}
