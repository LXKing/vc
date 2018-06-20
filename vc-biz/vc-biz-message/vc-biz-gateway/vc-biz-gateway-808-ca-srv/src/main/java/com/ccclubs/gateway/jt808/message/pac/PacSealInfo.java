package com.ccclubs.gateway.jt808.message.pac;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 11:12
 * Email:  yeanzhi@ccclubs.com
 * 消息封装项
 */
public class PacSealInfo {

    /**
     * 消息总包数
     */
    private Integer totalPacCount;

    /**
     * 消息包序号
     */
    private Integer pacNo;

    public Integer getTotalPacCount() {
        return totalPacCount;
    }

    public PacSealInfo setTotalPacCount(Integer totalPacCount) {
        this.totalPacCount = totalPacCount;
        return this;
    }

    public Integer getPacNo() {
        return pacNo;
    }

    public PacSealInfo setPacNo(Integer pacNo) {
        this.pacNo = pacNo;
        return this;
    }
}
