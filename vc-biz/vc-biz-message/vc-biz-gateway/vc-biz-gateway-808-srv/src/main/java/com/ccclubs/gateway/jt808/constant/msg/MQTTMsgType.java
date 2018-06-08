package com.ccclubs.gateway.jt808.constant.msg;

/**
 * @Author: yeanzi
 * @Date: 2018/6/7
 * @Time: 16:48
 * Email:  yeanzhi@ccclubs.com
 * MQTT消息功能类型
 */
public enum MQTTMsgType {

    /**
     * CAN数据
     */
    CAN_DATA(0x01, "CAN数据"),

    /**
     * CAN补传
     */
    CAN_DATA_RESEND(0xFD, "CAN补传"),

    /**
     * 包括但不限于，状态数据，指令反馈，车机日志
     */
    OTHER(0xF1, "包括但不限于，状态数据，指令反馈，车机日志");

    private int code;
    private String des;

    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    MQTTMsgType(int code, String des) {
        this.code = code;
        this.des = des;
    }

    public static MQTTMsgType getByCode(int code) {
        for (MQTTMsgType e :
                MQTTMsgType.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }
}
