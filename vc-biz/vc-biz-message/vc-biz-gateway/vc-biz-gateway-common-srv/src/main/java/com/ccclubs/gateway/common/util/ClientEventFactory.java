package com.ccclubs.gateway.common.util;

import com.ccclubs.gateway.common.dto.event.ConnOnlineStatusEvent;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: yeanzi
 * @Date: 2018/6/7
 * @Time: 14:16
 * Email:  yeanzhi@ccclubs.com
 * 终端事件工厂方法
 */
public final class ClientEventFactory {

    /**
     * 创建一个终端上线事件dto
     * @param uniqueNo
     * @param channel
     * @return
     */
    public static ConnOnlineStatusEvent ofOnline(String uniqueNo, SocketChannel channel) {
        return new ConnOnlineStatusEvent()
                .setSimNo(uniqueNo)
                .setOnline(true)
                .setTimestamp(System.currentTimeMillis())
                .setClientIp(channel.remoteAddress().getHostString())
                .setServerIp(channel.localAddress().getHostString());
    }

    /**
     * 创建一个终端下线dto
     * @param uniqueNo
     * @param channel
     * @return
     */
    public static ConnOnlineStatusEvent ofOffline(String uniqueNo, SocketChannel channel) {
        return new ConnOnlineStatusEvent()
                .setSimNo(uniqueNo)
                .setOnline(false)
                .setTimestamp(System.currentTimeMillis())
                .setClientIp(channel.remoteAddress().getHostString())
                .setServerIp(channel.localAddress().getHostString());
    }

}
