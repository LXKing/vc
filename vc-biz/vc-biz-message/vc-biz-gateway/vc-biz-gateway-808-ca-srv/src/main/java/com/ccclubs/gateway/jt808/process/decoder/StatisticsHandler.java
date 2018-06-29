package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.connection.ChannelMappingCollection;
import com.ccclubs.gateway.common.constant.*;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.dto.event.ConnOnlineStatusEvent;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.ClientEventFactory;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.process.conn.JTClientConn;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

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

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {

        JTClientConn conn = (JTClientConn) ChannelMappingCollection.getByUniqueNo(pac.getHeader().getTerMobile());
        if (Objects.isNull(conn)) {
            conn = dealClientFirstConnect(ctx, pac);
        }
        if (!conn.isOnline()) {
            String uniqueNo = pac.getHeader().getTerMobile();
            // 重连
            LOG.info("数据统计时发现终端({})重新连入系统", uniqueNo);
            ChannelMappingCollection.doReconnecte(uniqueNo, (SocketChannel) ctx.channel());
            ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOnline(PacUtil.trim0InMobile(uniqueNo), (SocketChannel) ctx.channel()).setGatewayType(GatewayType.GATEWAY_808);
            KafkaTask task = new KafkaTask(KafkaSendTopicType.CONN, PacUtil.trim0InMobile(uniqueNo), connOnlineStatusEvent.toJson());
            // 发送至kafka
            fireChannelInnerMsg(ctx, InnerMsgType.TASK_KAFKA, task);
        }

        conn.increPackageNum();
        // 统计错误报文
        if (pac.getErrorPac()) {
            conn.increErrorPacketNum();
            releaseErrorPac(pac.getSourceBuff());

            // 发送一个kafkaTask给SendoutHandelr
            ExpMessageDTO expMessageDTO = pacProcessTrack.getExpMessageDTO();
            expMessageDTO.setSourceHex(pac.getSourceHexStr());
            expMessageDTO.setMsgTime(System.currentTimeMillis());
            expMessageDTO.setMobile(PacUtil.trim0InMobile(pacProcessTrack.getUniqueNo()));
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
                    PacUtil.trim0InMobile(pacProcessTrack.getUniqueNo()),
                    expMessageDTO.toJson());
            fireChannelInnerMsg(ctx, InnerMsgType.TASK_KAFKA, task);
            return HandleStatus.END;
        }

        // 统计位置报文
        if (UpPacType.POSITION_REPORT.getCode() == pac.getHeader().getPacId()) {
            conn.increPositionPackageNum();
        }
        return HandleStatus.NEXT;
    }

    @Deprecated
    private JTClientConn dealClientFirstConnect(ChannelHandlerContext ctx, Package808 pac) {

        /**
         * 从消息中判断出的新的连接
         * TODO 为了方便调试，等认证处理器完善后删除
         */
        String uniqueNo = pac.getHeader().getTerMobile();
        SocketChannel channel = (SocketChannel) ctx.channel();

        // 连接第一次连接进系统
        JTClientConn newConn = JTClientConn.ofNew(uniqueNo);

        // 新建连接，连接存在时断开原连接
        ChannelMappingCollection.addNew(newConn, channel);
        LOG.info("数据统计时发现终端({})首次连入系统", uniqueNo);

        ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOnline(PacUtil.trim0InMobile(uniqueNo), channel).setGatewayType(GatewayType.GATEWAY_808);
        KafkaTask task = new KafkaTask(KafkaSendTopicType.CONN, PacUtil.trim0InMobile(uniqueNo), connOnlineStatusEvent.toJson());
        // 发送至kafka
        fireChannelInnerMsg(ctx, InnerMsgType.TASK_KAFKA, task);
        return newConn;
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
