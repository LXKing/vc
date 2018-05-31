package com.ccclubs.gateway.jt808.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 18:29
 * Email:  yeanzhi@ccclubs.com
 */
public enum PacProcessing {

    PROCESS_IDEL(0, "空闲连接处理"),
    PROCESS_DECODR(1, "数据包解码"),
    PROCESS_VALIDATE(2, "数据包校验"),
    PROCESS_AUTH(3, "连接身份认证"),
    process_statistics(4, "数据统计"),
    PROCESS_BIZ(5, "业务处理"),
    PROCESS_OUT_SEND(6, "对外发送处理"),
    PROCESS_Exception(7, "异常拦截处理");


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
