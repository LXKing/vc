package com.ccclubs.gateway.common.util;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.ChannelAttrKey;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @Author: yeanzi
 * @Date: 2018/5/4
 * @Time: 16:27
 * Email:  yeanzhi@ccclubs.com
 * 消息处理跟踪工具类
 */
public class ChannelPacTrackUtil {

    public static void refreshPacTrackForNewMsg(Channel channel) {
        PacProcessTrack pacProcessTrack = getPacTracker(channel);
        pacProcessTrack.reset();
    }

    public static PacProcessTrack getPacTracker(Channel channel) {
        Attribute<PacProcessTrack> pacProcessTrackAttribute = channel.attr(ChannelAttrKey.PACTRACK_KEY);
        PacProcessTrack pacProcessTrack = pacProcessTrackAttribute.get();
        return pacProcessTrack;
    }

}
