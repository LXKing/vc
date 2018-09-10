package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.common.config.TcpServerConf;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.constant.InnerMsgType;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.beans.KafkaTask;
import com.ccclubs.gateway.gb.constant.KafkaSendTopicType;
import com.ccclubs.gateway.gb.dto.PackProcessExceptionDTO;
import com.ccclubs.gateway.gb.message.GBPackage;
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

        // 如果是测试阶段则打印报告日志
        if (TcpServerConf.GATEWAY_PRINT_LOG) {
            LOG.info(pac.toLogString());
        }

        PackProcessExceptionDTO packProcessExceptionDTO = new PackProcessExceptionDTO();
        packProcessExceptionDTO.setCode(pac.getHeader().getCommandMark().getCode())
                .setVin(pac.getHeader().getUniqueNo())
                .setSourceHex(pac.getSourceHexStr());

        // 正常的消息发送至kafka
        fireChannelInnerMsg(ctx, InnerMsgType.TASK_KAFKA, new KafkaTask(KafkaSendTopicType.SUCCESS,
                pac.getHeader().getUniqueNo(),
                packProcessExceptionDTO.toJson()));
        // 事件下发
        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }
}
