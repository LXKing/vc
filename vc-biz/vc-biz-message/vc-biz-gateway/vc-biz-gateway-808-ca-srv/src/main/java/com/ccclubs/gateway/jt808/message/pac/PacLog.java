package com.ccclubs.gateway.jt808.message.pac;

/**
 * @Author: yeanzi
 * @Date: 2018/6/15
 * @Time: 15:54
 * Email:  yeanzhi@ccclubs.com
 * 报文处理日志
 */
public class PacLog {

    private StringBuilder logSb;

    public static PacLog newPacLog() {
        return new PacLog().setLogSb(new StringBuilder("---new_package---"));
    }

    public PacLog append(String name, String content) {
        logSb.append(name).append("--").append(content).append("\n");
        return this;
    }


    public StringBuilder getLogSb() {
        return logSb;
    }

    public PacLog setLogSb(StringBuilder logSb) {
        this.logSb = logSb;
        return this;
    }
}
