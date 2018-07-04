package com.ccclubs.gateway.common.bean.track;

import com.ccclubs.gateway.common.constant.ChannelLiveStatus;

/**
 * @Author: yeanzi
 * @Date: 2018/7/4
 * @Time: 10:16
 * Email:  yeanzhi@ccclubs.com
 * 连接生命周期轨迹
 */
public class ChannelLifeCycleTrack {

    private ChannelLiveStatus liveStatus;


    public ChannelLiveStatus getLiveStatus() {
        return liveStatus;
    }

    public ChannelLifeCycleTrack setLiveStatus(ChannelLiveStatus liveStatus) {
        this.liveStatus = liveStatus;
        return this;
    }
}
