package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.dto.MsgDeliverExceptionDTO;
import com.ccclubs.gateway.gb.handler.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.track.PacProcessTrack;
import io.netty.buffer.ByteBuf;
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

        // 过滤不能解析的报文
//        ByteBuf contentBuffer = pac.getSourceBuff();
//        switch (pac.getHeader().getCommandMark()) {
//            case REALTIME_DATA:
//            case REISSUE_DATA:
//                // 实时数据和历史数据检查缺省内容
//
//                break;
//                default:
//                    break;
//        }

        pacProcessTrack.getCurrentHandlerTracker().setEndTime(System.nanoTime());

        // 事件下发
        ctx.fireChannelRead(pac);
    }

}
