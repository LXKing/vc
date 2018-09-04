package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.*;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.jt808.constant.RedisConnCons;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.service.EventService;
import com.ccclubs.gateway.jt808.service.RedisConnService;
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
    private RedisConnService redisConnService;

    @Autowired
    private EventService eventService;

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {
        String uniqueNo = pac.getHeader().getTerMobile();
        SocketChannel channel = (SocketChannel) ctx.channel();

        redisConnService.updatePac(uniqueNo, RedisConnCons.REDIS_KEY_CONN_UPDATE_TOTAL_PAC, 1, GatewayType.GATEWAY_808);
        /**
         * 实时刷新在线online状态
         */
        eventService.realtimeReflushOnline(uniqueNo, channel, GatewayType.GATEWAY_808, pac);
        // 统计错误报文
        if (pac.getErrorPac()) {
            redisConnService.updatePac(uniqueNo, RedisConnCons.REDIS_KEY_CONN_UPDATE_ERROR_PAC, 1, GatewayType.GATEWAY_808);
            releasePacBuffer(pac.getSourceBuff());

            // 发送一个kafkaTask给SendoutHandelr
            ExpMessageDTO expMessageDTO = pacProcessTrack.getExpMessageDTO();
            expMessageDTO.setSourceHex(pac.getSourceHexStr());
            expMessageDTO.setMsgTime(System.currentTimeMillis());
            expMessageDTO.setMobile(pacProcessTrack.getUniqueNo());
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
                    pacProcessTrack.getUniqueNo(),
                    expMessageDTO.toJson());
            fireChannelInnerMsg(ctx, InnerMsgType.TASK_KAFKA, task);
            return HandleStatus.END;
        }

        // 统计位置报文
        if (UpPacType.POSITION_REPORT.getCode() == pac.getHeader().getPacId()) {
            redisConnService.updatePac(uniqueNo, RedisConnCons.REDIS_KEY_CONN_UPDATE_POSITION_PAC, 1, GatewayType.GATEWAY_808);
        }
        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }

}
