package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.common.bean.event.ConnLiveEvent;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.connection.ClientSocketCollection;
import com.ccclubs.gateway.common.constant.*;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.dto.event.ConnOnlineStatusEvent;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.ChannelAttrbuteUtil;
import com.ccclubs.gateway.common.util.ClientEventFactory;
import com.ccclubs.gateway.jt808.constant.RedisConnCons;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.service.RedisConnService;
import com.ccclubs.gateway.jt808.service.TerminalConnService;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;
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
    private TerminalConnService terminalConnService;

    @Autowired
    private ClientSocketCollection clientSocketCollection;

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {

        String uniqueNo = pac.getHeader().getTerMobile();
        SocketChannel channel = (SocketChannel) ctx.channel();

        /**
         * TODO 需要一个本地缓存连接信息的措施,以免一直在并发Map下查询
         */
        boolean isExistedInSocketMap = clientSocketCollection.existed(uniqueNo);
        if (!isExistedInSocketMap) {
            boolean isClientExistedFromRedis = redisConnService.isExisted(uniqueNo, GatewayType.GATEWAY_808);
            if (!isClientExistedFromRedis) {
                LOG.info("数据统计时发现终端({})首次连入系统", uniqueNo);
                dealClientFirstConnect(ctx, pac);
            }
            boolean isClientOnlineFromRedis = redisConnService.isOnline(uniqueNo, GatewayType.GATEWAY_808);
            if (!isClientOnlineFromRedis) {
                // 重连
                LOG.info("数据统计时发现终端({})重新连入系统", uniqueNo);

                ChannelAttrbuteUtil.setChannelLiveStatus(channel, ChannelLiveStatus.ONLINE_RECONNECT);
                terminalConnService.online(uniqueNo, channel, GatewayType.GATEWAY_808);
            }
        }

        redisConnService.updatePac(uniqueNo, RedisConnCons.REDIS_KEY_CONN_UPDATE_TOTAL_PAC, 1, GatewayType.GATEWAY_808);
        // 统计错误报文
        if (pac.getErrorPac()) {
            redisConnService.updatePac(uniqueNo, RedisConnCons.REDIS_KEY_CONN_UPDATE_ERROR_PAC, 1, GatewayType.GATEWAY_808);
            releaseErrorPac(pac.getSourceBuff());

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

    @Deprecated
    private void dealClientFirstConnect(ChannelHandlerContext ctx, Package808 pac) {

        /**
         * 从消息中判断出的新的连接
         * TODO 为了方便调试，等认证处理器完善后删除
         */
        String uniqueNo = pac.getHeader().getTerMobile();
        SocketChannel channel = (SocketChannel) ctx.channel();

        ChannelAttrbuteUtil.setChannelLiveStatus(channel, ChannelLiveStatus.ONLINE_REGISTER);
        terminalConnService.register(uniqueNo, channel, GatewayType.GATEWAY_808);
        // 发送上线通知
        ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOnline(uniqueNo, channel, GatewayType.GATEWAY_808);
        KafkaTask task = new KafkaTask(KafkaSendTopicType.CONN, uniqueNo, connOnlineStatusEvent.toJson());
        // 发送至kafka
        fireChannelInnerMsg(ctx, InnerMsgType.TASK_KAFKA, task);

        // 5. 发送上线轨迹事件
        ConnLiveEvent onlineEvent = new ConnLiveEvent()
                .uniqueNo(uniqueNo)
                .channel(channel)
                .online(true)
                .gatewayType(GatewayType.GATEWAY_808)
                .build();
        redisConnService.addTcpStatusTraceEvent(uniqueNo, GatewayType.GATEWAY_808, onlineEvent);
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }

    /**
     * 销毁错误报文缓存，终止消息传递
     * @param erroPacBuf
     */
    private void releaseErrorPac(ByteBuf erroPacBuf) {

        ReferenceCountUtil.release(erroPacBuf);
    }

}
