package com.ccclubs.gateway.zotye.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;


/**
 * \* Created with IntelliJ IDEA2017.
 * \* User: Alban
 * \* Date: 2018/1/17
 * \* Time: 17:36
 * \* Description:
 * \
 */
public class ZotyeTboxProtocolHandler extends ChannelInboundHandlerAdapter {
    private SocketChannel socketChannel;

    public ZotyeTboxProtocolHandler(SocketChannel socketChannel) {
        super();
        this.socketChannel = socketChannel;

    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx){
        //todo 这里有个判断存储此链接。用以保存和车机的channel，如果没注册就应该有个超时时间，已经注册并且登录则要放入map中。
    }




}
