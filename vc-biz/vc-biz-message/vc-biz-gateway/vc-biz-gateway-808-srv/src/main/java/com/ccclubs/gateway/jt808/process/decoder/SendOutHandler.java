package com.ccclubs.gateway.jt808.process.decoder;

import com.alibaba.fastjson.JSON;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.config.TcpServerConf;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.dto.OnsTask;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.service.KafkaService;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.service.OnsService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
@ChannelHandler.Sharable
public class SendOutHandler extends CCClubChannelInboundHandler<Package808> {
    private static final Logger LOG = LoggerFactory.getLogger(SendOutHandler.class);

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private OnsService onsService;

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {

        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        if (TcpServerConf.GATEWAY_PRINT_LOG) {
            LOG.info("收到一个内部消息: {}", JSON.toJSONString(innerMsg));
        }

        switch (innerMsg.getInnerMsgType()) {
            case TASK_KAFKA:
                kafkaService.send((KafkaTask) innerMsg.getMsg());
                break;
            case TASK_ONS:
                onsService.sendOneway((OnsTask) innerMsg.getMsg());
                default:
                    break;
        }
        return HandleStatus.END;
    }
}
