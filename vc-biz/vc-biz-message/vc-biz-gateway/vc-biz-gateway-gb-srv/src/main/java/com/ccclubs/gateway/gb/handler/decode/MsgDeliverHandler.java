package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.dto.MsgDeliverExceptionDTO;
import com.ccclubs.gateway.gb.handler.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.track.PacProcessTrack;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: yeanzi
 * @Date: 2018/3/25
 * @Time: 21:41
 * Email:  yeanzhi@ccclubs.com
 */
@ChannelHandler.Sharable
public class MsgDeliverHandler extends CCClubChannelInboundHandler<GBPackage> {

    private static final Logger LOG = LoggerFactory.getLogger(MsgDeliverHandler.class);

    public MsgDeliverHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GBPackage pac) throws Exception {
        MsgDeliverExceptionDTO msgDeliverExceptionDTO = new MsgDeliverExceptionDTO();
        PacProcessTrack pacProcessTrack = beforeProcess(ctx, msgDeliverExceptionDTO);

        // 业务处理(暂时没有业务处理)
//        LOG.info(pac.toLogString());

        pacProcessTrack.getCurrentHandlerTracker().setEndTime(System.nanoTime());

        // 事件下发
        ctx.fireChannelRead(pac);
    }

}
