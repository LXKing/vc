package com.ccclubs.gateway.common.util;

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
        Objects.requireNonNull(channel);
        boolean closed = Objects.isNull(channel) ||
                !channel.isOpen();

        // 因为可能存在其他判定条件，所以这里不用最简便的写法
        return closed;
    }

    /**
     * 获取本地服务器的ip地址
     * @param channel
     * @return
     */
    public static String getLocalAddress(SocketChannel channel) {
        Objects.requireNonNull(channel);

        return channel.localAddress().getHostName();
    }

    /**
     * 获取客户端ip地址
     * @param channel
     * @return
     */
    public static String getRemoteAddress(SocketChannel channel) {
        Objects.requireNonNull(channel);

        return channel.remoteAddress().getHostName();
    }

    /**
     * 获取远程客户端的端口
     * @param channel
     * @return
     */
    public static int getRemotePort(SocketChannel channel) {
        Objects.requireNonNull(channel);

        return channel.remoteAddress().getPort();
    }

    /**
     * 获取唯一ID或者IP端口信息
     * @param uniqueNo
     * @param channel
     * @return
     */
    public static String getUniqueNoOrHost(String uniqueNo, SocketChannel channel) {
        if (Objects.nonNull(uniqueNo)) {
            return uniqueNo;
        }
        StringBuilder hostSb = new StringBuilder();
        hostSb.append(channel.remoteAddress().getHostName())
                .append(":")
                .append(channel.remoteAddress().getPort());
        return hostSb.toString();
    }

}
