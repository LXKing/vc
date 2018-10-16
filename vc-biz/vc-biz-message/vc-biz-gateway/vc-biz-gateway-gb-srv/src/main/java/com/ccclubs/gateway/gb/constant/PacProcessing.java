package com.ccclubs.gateway.gb.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/5/6
 * @Time: 13:04
 * Email:  yeanzhi@ccclubs.com
 * 消息处理链路阶段常量
 */
public enum PacProcessing {
    /**
     * 消息处理器编排
     */
    PROCESS_IDEL(0, "空闲连接处理"),
    PROCESS_DECODR(1, "数据包解码"),
    PROCESS_VALIDATE(2, "数据包校验"),
    PROCESS_AUTH(3, "数据权限校验"),
    PROCESS_STATISTIC(4, "连接信息统计"),
    PROCESS_DELIVER(5, "业务处理"),
    PROCESS_SEND_OUT(6, "对外发送处理"),
    PROCESS_PROTECTER(7, "异常拦截处理");

    private int code;
    private String des;

    PacProcessing(int code, String des) {
        this.code = code;
        this.des = des;
    }

    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    public static PacProcessing getByCode(int code) {
        for (PacProcessing e :
                PacProcessing.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

}