package com.ccclubs.gateway.common.process;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.util.ChannelPacTrackUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 11:50
 * Email:  yeanzhi@ccclubs.com
 * 入站处理器基类
 *      一些入站公共处理可以在此处实现
 *          1. 处理器处理用时统计
 */
public abstract class CCClubChannelInboundHandler<T> extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object pac) throws Exception {

        @SuppressWarnings("unchecked")
        T imsg = (T) pac;
        PacProcessTrack pacProcessTrack = ChannelPacTrackUtil.getPacTracker(ctx.channel()).next();
        // 统计处理器处理用时
        long startTime = System.nanoTime();
        // 真正处理消息的方法
        boolean fireNextChannel = handlePackage(ctx, imsg, pacProcessTrack);

        long endTime = System.nanoTime();
        pacProcessTrack.getCurrentHandlerTracker().setUsedTime(endTime - startTime);

        if (fireNextChannel) {
            ctx.fireChannelRead(imsg);
        }
    }

    protected abstract boolean handlePackage(ChannelHandlerContext ctx, T pac, PacProcessTrack pacProcessTrack) throws Exception;

}
