package com.ccclubs.gateway.common.inf;

import io.netty.channel.socket.SocketChannel;

/**
 * @Author: yeanzi
 * @Date: 2018/6/19
 * @Time: 15:29
 * Email:  yeanzhi@ccclubs.com
 */
public interface LocalStoreConnService {
    void login(String uniqueNo, SocketChannel channel);

    void logout(String uniqueNo, SocketChannel channel);
}
