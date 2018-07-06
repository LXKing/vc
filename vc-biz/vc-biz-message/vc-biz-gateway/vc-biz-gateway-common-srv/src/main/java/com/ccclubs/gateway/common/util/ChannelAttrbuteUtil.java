package com.ccclubs.gateway.common.util;

import com.ccclubs.gateway.common.bean.track.ChannelLifeCycleTrack;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.ChannelAttrKey;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/5/4
 * @Time: 16:27
 * Email:  yeanzhi@ccclubs.com
 * 渠道共享属性工具类
 */
public class ChannelAttrbuteUtil {

    public static void refreshPacTrackForNewMsg(Channel channel) {
        Objects.requireNonNull(channel);

        PacProcessTrack pacProcessTrack = getPacTracker(channel);
        pacProcessTrack.reset();
    }

    public static PacProcessTrack getPacTracker(Channel channel) {
        Objects.requireNonNull(channel);

        Attribute<PacProcessTrack> pacProcessTrackAttribute = channel.attr(ChannelAttrKey.PACKAGE_TRACK);
        PacProcessTrack pacProcessTrack = pacProcessTrackAttribute.get();
        return pacProcessTrack;
    }

    public static ChannelLifeCycleTrack getLifeTrack(Channel channel) {
        Objects.requireNonNull(channel);

        Attribute<ChannelLifeCycleTrack> trackValue = channel.attr(ChannelAttrKey.CHANNEL_LIFE_CYCLE_TRACK);
        ChannelLifeCycleTrack track = trackValue.get();
        return track;
    }

    public static void setChannelLiveStatus(SocketChannel channel, ChannelLiveStatus liveStatus) {
        Objects.requireNonNull(channel);

        getLifeTrack(channel).setLiveStatus(liveStatus);
    }

}
