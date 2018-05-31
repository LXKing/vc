package com.ccclubs.gateway.jt808.constant.msg;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 15:17
 * Email:  yeanzhi@ccclubs.com
 * 下行报文类型
 */
public enum DownPacType {
    /**
     * 平台通用应答
     */
    ACK_NORMAL(0X8001, "平台通用应答"),

    /**
     * 补传分包请求
     */
    SUPPLE(0X8003, "补传分包请求"),

    /**
     * 终端注册应答
     */
    ACK_REGISTER(0X8100, "终端注册应答"),

    /**
     * 设置终端参数
     */
    SET_PARAM(0X8103, "设置终端参数"),

    /**
     * 查询终端参数
     */
    QUERY_PARAM(0X8104, "查询终端参数"),

    /**
     * 终端控制
     */
    CONTROL(0X8105, "终端控制"),

    /**
     * 查询指定终端参数
     */
    QUERY_SPECIFY_PARAM(0X8106, "查询指定终端参数"),

    /**
     * 查询终端属性
     */
    QUERY_ATTR(0X8107, "查询终端属性"),

    /**
     * 下发终端升级包
     */
    SEND_UPGRADE(0X8108, "下发终端升级包"),

    /**
     * 位置信息查询
     */
    QUERY_POSITION(0X8201, "位置信息查询"),

    /**
     * 临时位置跟踪控制
     */
    TRACK_POSITION(0X8202, "临时位置跟踪控制"),

    /**
     * 人工确认报警消息
     */
    ALARM_MANUAL(0X8203, "人工确认报警消息"),

    /**
     * 文本消息下发
     */
    SEND_TEXT(0X8300, "文本消息下发"),

    /**
     * 事件设置
     */
    EVENT_SET(0X8301, "事件设置"),

    /**
     * 提问下发
     */
    SEND_QUESTION(0X8302, "提问下发");

    private int code;
    private String des;
    DownPacType(int code, String des) {
        this.code = code;
        this.des = des;
    }

    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    public static DownPacType getByCode(int code) {
        for (DownPacType e :
                DownPacType.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

}
