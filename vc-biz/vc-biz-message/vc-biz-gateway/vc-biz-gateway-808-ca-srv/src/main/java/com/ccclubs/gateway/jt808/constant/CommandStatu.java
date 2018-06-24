package com.ccclubs.gateway.jt808.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 17:56
 * Email:  yeanzhi@ccclubs.com
 * 下行命令状态
 */
public enum CommandStatu {
    /**
     * 命令已发送
     */
    send,

    /**
     * 命令已重发
     */
    resend,

    /**
     * 命令已应答
     */
    answerd;
}
