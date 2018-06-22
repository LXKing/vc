package com.ccclubs.gateway.common.constant;

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

    /**
     * 轨迹信息
     */
    public static AttributeKey<PacProcessTrack> PACTRACK_KEY = AttributeKey.newInstance(ChannelAttrKey.CHANNEL_ATTR_KEY_PAC_TRACK);

    private static final String CHANNEL_ATTR_KEY_PAC_TRACK = "channel.attr.pac.track";

}
