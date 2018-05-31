package com.ccclubs.gateway.jt808.constant.msg;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 15:13
 * Email:  yeanzhi@ccclubs.com
 * 上行报文类型
 */
public enum UpPacType {
    /**
     * 终端通用应答
     */
    ACK(0X0001, "终端通用应答"),

    /**
     * 终端心跳
     */
    HEART(0X0002, "终端心跳"),

    /**
     * 终端注销
     */
    LOGOUT(0X0003, "终端注销"),

    /**
     * 终端注册
     */
    REGISTER(0X0100, "终端注册"),

    /**
     * 终端鉴权
     */
    AUTH(0X0102, "终端鉴权"),

    /**
     * 查询终端属性应答
     */
    ACK_QUERY_ATTR(0X0107, "查询终端属性应答"),

    /**
     * 终端升级结果通知
     */
    ACK_UPGRADE(0X0108, "终端升级结果通知"),

    /**
     * 位置信息汇报
     */
    POSITION_REPORT(0X0200, "位置信息汇报"),

    /**
     * 位置信息查询应答
     */
    ACK_QUERY_POSITION(0X0201, "位置信息查询应答"),

    /**
     * 事件报告
     */
    EVENT_REPORT(0X0301, "事件报告");

    private int code;
    private String des;
    UpPacType(int code, String des) {
        this.code = code;
        this.des = des;
    }

    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    public static UpPacType getByCode(int code) {
        for (UpPacType e :
                UpPacType.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }
}
