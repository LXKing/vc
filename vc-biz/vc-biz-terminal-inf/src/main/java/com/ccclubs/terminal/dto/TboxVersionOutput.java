package com.ccclubs.terminal.dto;

import java.io.Serializable;

/**
 * 终端版本信息
 *
 * @author jianghaiyang
 * @create 2018-07-24
 **/
public class TboxVersionOutput implements Serializable {
    /**
     * 是否最新版本
     */
    private Boolean isLatest;
    /**
     * 当前版本
     */
    private String currentV;
    /**
     * 最新版本
     */
    private String latestV;
    /**
     * 版本升级状态
     */
    private Byte status;
    /**
     * 版本升级状态
     */
    private String statusText;
    /**
     * 升级进度百分比
     */
    private Long percent;
    /**
     * 剩余时间
     */
    private Long leftTime;

    public String getLatestV() {
        return latestV;
    }

    public void setLatestV(String latestV) {
        this.latestV = latestV;
    }

    public Boolean getLatest() {
        return isLatest;
    }

    public void setLatest(Boolean latest) {
        isLatest = latest;
    }

    public String getCurrentV() {
        return currentV;
    }

    public void setCurrentV(String currentV) {
        this.currentV = currentV;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Long getPercent() {
        return percent;
    }

    public void setPercent(Long percent) {
        this.percent = percent;
    }

    public Long getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(Long leftTime) {
        this.leftTime = leftTime;
    }
}
