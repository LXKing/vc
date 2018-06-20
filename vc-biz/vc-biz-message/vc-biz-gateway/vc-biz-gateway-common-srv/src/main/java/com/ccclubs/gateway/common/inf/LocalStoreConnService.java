package com.ccclubs.gateway.common.inf;

import com.ccclubs.gateway.common.connection.AbstractClientConn;
import io.netty.channel.ChannelId;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: yeanzi
 * @Date: 2018/6/19
 * @Time: 15:29
 * Email:  yeanzhi@ccclubs.com
 */
public interface LocalStoreConnService {

    AbstractClientConn getByUniqueNo(String uniqueNo);

    AbstractClientConn getByChannelId(ChannelId id);

    void login(String uniqueNo, SocketChannel channel);

    void logout(String uniqueNo, SocketChannel channel);

    AbstractClientConn reconected(String uniqueNo, SocketChannel channel);
}
