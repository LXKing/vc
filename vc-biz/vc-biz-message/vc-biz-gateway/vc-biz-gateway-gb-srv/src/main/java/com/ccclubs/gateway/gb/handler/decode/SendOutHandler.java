package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.service.KafkaService;
import com.ccclubs.gateway.gb.message.GBPackage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yeanzi
 * @Date: 2018/9/11
 * @Time: 11:06
 * Email:  yeanzhi@ccclubs.com
 * 对外发送处理器
 *       用于将消息（或者自己封装好的消息）发送到外部：
 *          kafka消息
 */
@Service
@ChannelHandler.Sharable
public class SendOutHandler extends CCClubChannelInboundHandler<GBPackage> {

    @Autowired
    private KafkaService kafkaService;

    /**
     * 由于该处理器主要处理内部消息，所以对报文不进行任何处理
     * @param ctx
     * @param pac
     * @return
     * @throws Exception
     */
    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, GBPackage pac) throws Exception {
        // Do nothing for package, just send to next handler
        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        switch (innerMsg.getInnerMsgType()) {
            case TASK_KAFKA:
                kafkaService.send((KafkaTask) innerMsg.getMsg());
                break;
            default:
                break;
        }
        return HandleStatus.END;
    }
}
