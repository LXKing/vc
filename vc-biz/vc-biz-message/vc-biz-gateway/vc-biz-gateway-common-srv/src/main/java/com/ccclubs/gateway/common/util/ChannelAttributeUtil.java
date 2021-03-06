package com.ccclubs.gateway.common.util;

import com.ccclubs.gateway.common.bean.attr.AbstractChannelHealthyAttr;
import com.ccclubs.gateway.common.bean.attr.ChannelStatusAttr;
import com.ccclubs.gateway.common.bean.attr.PackageTraceAttr;
import com.ccclubs.gateway.common.bean.track.ChannelLifeCycleTrack;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.ChannelAttrKey;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.inf.ChannelAttr;
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
public class ChannelAttributeUtil {

    public static PackageTraceAttr getTrace(Channel channel) {
        Objects.requireNonNull(channel);

        Attribute<PackageTraceAttr> pacProcessTrackAttribute = channel.attr(ChannelAttrKey.PACKAGE_TRACE.getAttributeKey());
        return checkNullForAttr(pacProcessTrackAttribute.get());
    }

    public static <T extends AbstractChannelHealthyAttr> T getHealthy (SocketChannel channel) {
        Objects.requireNonNull(channel);

        Attribute<T> healthyInfoAttribute = (Attribute<T>) channel.attr(ChannelAttrKey.CHANNEL_HEALTHY.getAttributeKey());
        return checkNullForAttr(healthyInfoAttribute.get());
    }

    public static ChannelStatusAttr getStatus(SocketChannel channel) {
        Objects.requireNonNull(channel);

        Attribute<ChannelStatusAttr> channelStatusAttrAttribute = channel.attr(ChannelAttrKey.CHANNEL_STATUS.getAttributeKey());
        return checkNullForAttr(channelStatusAttrAttribute.get());
    }

    private static <T extends ChannelAttr> T checkNullForAttr(T attr) {
        if (Objects.isNull(attr)) {
            throw new IllegalStateException("channel attribute values is empty");
        }
        return attr;
    }

}
