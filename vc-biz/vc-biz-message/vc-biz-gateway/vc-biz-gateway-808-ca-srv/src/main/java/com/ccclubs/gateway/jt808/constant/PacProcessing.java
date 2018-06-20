package com.ccclubs.gateway.jt808.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 18:29
 * Email:  yeanzhi@ccclubs.com
 */
public enum PacProcessing {

    PROCESS_IDEL(0, "空闲连接处理", false),
    PROCESS_DECODR(1, "数据包解码", true),
    PROCESS_VALIDATE(2, "数据包校验", true),
    PROCESS_AUTH(3, "连接身份认证", true),
    PROCESS_ACK(4, "应答处理", true),
    process_statistics(5, "数据统计", true),
    PROCESS_BIZ(6, "业务处理", true),
    PROCESS_OUT_SEND(7, "对外发送处理", true),
    PROCESS_Exception(8, "异常拦截处理", true);


    private int code;
    private String des;
    /**
     * 是否进行轨迹跟踪
     */
    private boolean tracking;

    PacProcessing(int code, String des, boolean tracking) {
        this.code = code;
        this.des = des;
        this.tracking = tracking;
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

    public static int countNeedTrack() {
        int count = 0;
        for (PacProcessing e :
                PacProcessing.values()) {
            if (e.tracking) {
                ++ count;
            }
        }
        return count;
    }

}
