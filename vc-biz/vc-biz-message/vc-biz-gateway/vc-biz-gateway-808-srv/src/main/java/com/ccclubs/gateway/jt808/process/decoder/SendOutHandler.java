package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 14:50
 * Email:  yeanzhi@ccclubs.com
 * 对外发送处理器
 *      用于将消息（或者自己封装好的消息）发送到外部：
 *          kafka消息
 *          ons消息
 */
public class SendOutHandler extends CCClubChannelInboundHandler<Package808> {
    @Override
    protected boolean handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {
        return false;
    }
}
