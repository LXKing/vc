package com.ccclubs.gateway.gb.utils;

import io.netty.channel.socket.SocketChannel;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 10:43
 * Email:  yeanzhi@ccclubs.com
 * 通道工具类
 */
public final class ChannelUtils {
    private ChannelUtils(){}

    /**
     * 校验channel是否存在
     * @param channel
     * @return
     */
    public static boolean notConnected(SocketChannel channel) {
        boolean closed = Objects.isNull(channel) ||
                !channel.isOpen();

        // 因为可能存在其他判定条件，所以这里不用最简便的写法
        return closed;
    }

}
