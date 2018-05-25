package com.ccclubs.gateway.gb.utils;

import com.ccclubs.gateway.gb.constant.ChannelAttrKey;
import com.ccclubs.gateway.gb.constant.PackProcessExceptionCode;
import com.ccclubs.gateway.gb.message.track.PacProcessTrack;
import com.ccclubs.gateway.gb.message.track.HandlerPacTrack;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

import java.util.Arrays;

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

    public static String buildCode(int step, PackProcessExceptionCode packProcessExceptionCode) {
        return new StringBuilder()
                .append(step).append("-")
                .append(packProcessExceptionCode.getCode())
                .toString();
    }

}
