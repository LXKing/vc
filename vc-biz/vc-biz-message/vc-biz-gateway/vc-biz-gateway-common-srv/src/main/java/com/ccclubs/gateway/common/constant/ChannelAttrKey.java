package com.ccclubs.gateway.common.constant;

import com.ccclubs.gateway.common.bean.track.ChannelLifeCycleTrack;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import io.netty.util.AttributeKey;

/**
 * @Author: yeanzi
 * @Date: 2018/5/4
 * @Time: 15:33
 * Email:  yeanzhi@ccclubs.com
 * Channel中共享变量单元的key常量
 */
public class ChannelAttrKey {

    //***********************************************************************************
    //  AttributeKey
    //***********************************************************************************

    /**
     * 报文轨迹信息
     */
    public static AttributeKey<PacProcessTrack> PACKAGE_TRACK = AttributeKey.newInstance("channel.attr.pac.track");

    /**
     * channel生命周期轨迹
     */
    public static AttributeKey<ChannelLifeCycleTrack> CHANNEL_LIFE_CYCLE_TRACK = AttributeKey.newInstance("channel.life.cycle.track");



}
