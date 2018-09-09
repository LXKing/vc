package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.track.PacProcessTrack;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/3/25
 * @Time: 21:41
 * Email:  yeanzhi@ccclubs.com
 */
@Component
@ChannelHandler.Sharable
public class MsgDeliverHandler extends CCClubChannelInboundHandler<GBPackage> {

    private static final Logger LOG = LoggerFactory.getLogger(MsgDeliverHandler.class);

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, GBPackage pac) {

        // 事件下发
        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }
}
