package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.exception.DeleverPacException;
import com.ccclubs.gateway.gb.handler.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.common.AckMsgBuilder;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/3/25
 * @Time: 21:41
 * Email:  yeanzhi@ccclubs.com
 */
@Component
@Scope("prototype")
public class MsgDeliverHandler extends CCClubChannelInboundHandler<GBPackage> {

    private static final Logger LOG = LoggerFactory.getLogger(MsgDeliverHandler.class);

    public MsgDeliverHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GBPackage pac) throws Exception {
        try {
            LOG.info(pac.toLogString());
            ctx.writeAndFlush(AckMsgBuilder.ofSuccess(pac.getSourceBuff().copy()));
            // 2. 消息分类处理
            switch (pac.getHeader().getCommandMark()) {
                case REALTIME_DATA:
                    break;
                case VEHICLE_LOGIN:
                    break;
                case HEARTBEAT:
//                context.writeAndFlush(AckMsgBuilder.ofSuccess(pac.getSourceBuff()));
                default:
                    break;

            }
            // 事件下发
            ctx.fireChannelRead(pac);
        } catch (Exception e) {
            throw new DeleverPacException(e.getMessage());
        }
    }

}
