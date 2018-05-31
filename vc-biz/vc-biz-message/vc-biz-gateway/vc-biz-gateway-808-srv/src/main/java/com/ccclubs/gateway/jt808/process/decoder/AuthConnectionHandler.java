package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 14:47
 * Email:  yeanzhi@ccclubs.com
 * 连接身份认证处理器
 */
public class AuthConnectionHandler extends CCClubChannelInboundHandler<Package808> {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object pac) throws Exception {
        super.channelRead(ctx, pac);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    protected boolean handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {
        return false;
    }
}
