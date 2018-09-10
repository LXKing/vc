package com.ccclubs.gateway.common.bean.attr;

import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.inf.ChannelAttr;

import java.time.LocalDateTime;

/**
 * 渠道状态
 */
public class ChannelStatusAttr implements ChannelAttr {
    /**
     * 渠道唯一标志
     */
    private String uniqueNo;

    /**
     * 渠道生命阶段
     *  相对于当前状态，该值承步进式，默认值为0，即渠道创建，下一阶段为渠道连接
     *  生命周期总览：渠道创建-》连接-》注册-》认证-》关闭
     *  渠道应该遵循该阶段值步进，跳段则服务端应断开与该客户端连接，视为渠道状态异常
     */
    private int channelLiveStage;

    /**
     * 当前渠道状态
     */
    private ChannelLiveStatus currentStatus;

    /**
     * 渠道创建时间
     */
    private LocalDateTime createTime;

    /**
     * 渠道关闭时间
     */
    private LocalDateTime closeTime;

    /**
     * 标记当前渠道状态进入下一个阶段
     * @return
     */
    public ChannelStatusAttr nextStage() {
        ++ this.channelLiveStage;
        return this;
    }

    public String getUniqueNo() {
        return uniqueNo;
    }

    public ChannelStatusAttr setUniqueNo(String uniqueNo) {
        this.uniqueNo = uniqueNo;
        return this;
    }

    public int getChannelLiveStage() {
        return channelLiveStage;
    }

    public ChannelStatusAttr setChannelLiveStage(int channelLiveStage) {
        this.channelLiveStage = channelLiveStage;
        return this;
    }

    public ChannelLiveStatus getCurrentStatus() {
        return currentStatus;
    }

    public ChannelStatusAttr setCurrentStatus(ChannelLiveStatus currentStatus) {
        this.currentStatus = currentStatus;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ChannelStatusAttr setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public ChannelStatusAttr setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
        return this;
    }
}
