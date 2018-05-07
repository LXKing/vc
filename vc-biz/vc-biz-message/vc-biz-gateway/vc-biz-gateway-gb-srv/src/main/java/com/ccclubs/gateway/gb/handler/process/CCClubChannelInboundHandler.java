package com.ccclubs.gateway.gb.handler.process;

import com.ccclubs.gateway.gb.inf.IExceptionDtoJsonParse;
import com.ccclubs.gateway.gb.message.track.PacProcessTrack;
import com.ccclubs.gateway.gb.message.track.HandlerPacTrack;
import com.ccclubs.gateway.gb.utils.ChannelPacTrackUtil;
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

    protected PacProcessTrack beforeProcess(ChannelHandlerContext ctx, IExceptionDtoJsonParse exceptionDtoJsonParse) {
        // 数据包处理轨迹
        PacProcessTrack pacProcessTrack = ChannelPacTrackUtil.getPacTracker(ctx.channel()).next();
        // 数据包在当前处理器中的轨迹信息
        HandlerPacTrack currentHandlerTracker = pacProcessTrack.getCurrentHandlerTracker()
                .setStartTime(System.nanoTime());

        currentHandlerTracker.setExceptionDtoJsonParse(exceptionDtoJsonParse);
        return pacProcessTrack;
    }

    private void afterProcesss() {

    }

    protected abstract void channelRead0(ChannelHandlerContext ctx, T msg) throws Exception;

}
