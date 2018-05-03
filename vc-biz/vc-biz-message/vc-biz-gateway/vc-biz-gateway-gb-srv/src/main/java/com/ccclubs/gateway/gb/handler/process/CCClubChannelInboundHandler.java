package com.ccclubs.gateway.gb.handler.process;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.TypeParameterMatcher;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 11:50
 * Email:  yeanzhi@ccclubs.com
 * 入站处理器基类
 *      一些入站公共处理可以在此处实现
 */
public abstract class CCClubChannelInboundHandler<T> extends ChannelInboundHandlerAdapter {

    private final TypeParameterMatcher matcher;

    protected CCClubChannelInboundHandler() {
        matcher = TypeParameterMatcher.find(this, CCClubChannelInboundHandler.class, "T");
    }

    public boolean acceptInboundMessage(Object msg) throws Exception {
        return matcher.match(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            if (acceptInboundMessage(msg)) {
                @SuppressWarnings("unchecked")
                T imsg = (T) msg;
                channelRead0(ctx, imsg);
            } else {
                ctx.fireChannelRead(msg);
            }
        } finally {
//            System.out.println("release --");
//            ReferenceCountUtil.release(msg);
        }

    }

    protected abstract void channelRead0(ChannelHandlerContext ctx, T msg) throws Exception;

}
