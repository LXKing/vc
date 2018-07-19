package com.ccclubs.gateway.jt808.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 17:56
 * Email:  yeanzhi@ccclubs.com
 * 下行命令状态
 */
public enum CommandStatus {
    /**
     * 命令已发送
     */
    SEND,

    /**
     * 命令已重发
     */
    RESEND,

    /**
     * 808已应答
     */
    ANSWERD_808,

    /**
     * MQTT已应答
     */
    ANSWERD_MQTT;
}
