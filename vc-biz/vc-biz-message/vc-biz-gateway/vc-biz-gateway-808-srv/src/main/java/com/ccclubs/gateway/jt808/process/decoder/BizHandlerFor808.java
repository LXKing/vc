package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.jt808.message.pac.Package808;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 11:26
 * Email:  yeanzhi@ccclubs.com
 * 808业务操作处理器
 */
public class BizHandlerFor808 extends SimpleChannelInboundHandler<Package808> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

        System.out.println("出现异常：" + cause.getMessage());
        cause.printStackTrace();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Package808 msg) throws Exception {
        System.out.println(msg.getSourceHexStr());

        ReferenceCountUtil.release(msg.getSourceBuff());
    }
}
