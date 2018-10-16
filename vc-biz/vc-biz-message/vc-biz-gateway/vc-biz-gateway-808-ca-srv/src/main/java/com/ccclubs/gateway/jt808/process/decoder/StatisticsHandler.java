package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.common.bean.attr.DefaultChannelHealthyAttr;
import com.ccclubs.gateway.common.bean.attr.PackageTraceAttr;
import com.ccclubs.gateway.common.constant.*;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.service.EventService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 18:35
 * Email:  yeanzhi@ccclubs.com
 * 数据统计处理器
 */
@Component
@ChannelHandler.Sharable
public class StatisticsHandler extends CCClubChannelInboundHandler<Package808> {
    public static final Logger LOG = LoggerFactory.getLogger(StatisticsHandler.class);

    @Autowired
    private EventService eventService;

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac) throws Exception {
        String uniqueNo = pac.getHeader().getTerMobile();
        final SocketChannel channel = (SocketChannel) ctx.channel();

        // 统计错误报文
        if (pac.getErrorPac()) {
            // 获取健康数据
            DefaultChannelHealthyAttr channelHealthyAttr = ChannelAttributeUtil.getHealthy(channel);
            channelHealthyAttr.setErrorPackageNum(channelHealthyAttr.getErrorPackageNum() + 1);
            // 释放buf
            releasePacBuffer(pac.getSourceBuff());
            // 渠道轨迹信息
            PackageTraceAttr packageTraceAttr = ChannelAttributeUtil.getTrace(channel);
            ExpMessageDTO expMessageDTO = packageTraceAttr.getExpMessageDTO();
            // 发送一个kafkaTask给SendoutHandelr
            // 依据不同的校验异常类型，写入不同的错误码
            switch (pac.getPacErrorType()) {
                case PAC_VALID_ERROR:
                    expMessageDTO.setCode(PackProcessExceptionCode.INVALID_FAIL.getCode())
                            .setGatewayType(GatewayType.GATEWAY_808.getDes());
                    break;
                default:
                    break;
            }
            KafkaTask task = new KafkaTask(KafkaSendTopicType.ERROR,
                    packageTraceAttr.getUniqueNo(),
                    expMessageDTO.toJson());
            fireChannelInnerMsg(ctx, InnerMsgType.TASK_KAFKA, task);
            return HandleStatus.END;
        }
        /**
         * 实时刷新在线online状态
         */
        eventService.realtimeReflushOnline(uniqueNo, channel, GatewayType.GATEWAY_808, pac);
        // 获取健康数据
        DefaultChannelHealthyAttr channelHealthyAttr = ChannelAttributeUtil.getHealthy(channel);
        // 统计总包数
        channelHealthyAttr.setPackageNum(channelHealthyAttr.getPackageNum() + 1);
        // 统计位置报文
        if (UpPacType.POSITION_REPORT.getCode() == pac.getHeader().getPacId()) {
            // 位置包（实时信息包）数
            channelHealthyAttr.setPositionPackageNum(channelHealthyAttr.getPositionPackageNum() + 1);
        }
        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }

}
