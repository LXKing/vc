package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.constant.InnerMsgType;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.OnsTask;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.jt808.constant.msg.DownPacType;
import com.ccclubs.gateway.jt808.constant.msg.MQTTMsgType;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.util.PacUtil;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.util.MqTagUtils;
import com.ccclubs.protocol.util.StringUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 11:26
 * Email:  yeanzhi@ccclubs.com
 * 808业务操作处理器
 */
@Component
@ChannelHandler.Sharable
public class BizHandler extends CCClubChannelInboundHandler<Package808> {
    public static final Logger LOG = LoggerFactory.getLogger(BizHandler.class);

    // TODO 暂时不处理分包
//    private Map<String, String> multiPartPacMap = new HashMap<>();

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {
        LOG.info(pac.printLog());

        // 如果是半包消息，则加到对应包后面
        if (pac.getHeader().getPacContentAttr().isMultiPac()) {
            // TODO 分包处理
            LOG.info("收到分包消息");

            // TODO 判断半包是否结束
            boolean pacNotCompleted = true;
            if (pacNotCompleted) {
                // 半包时，跳过处理
                return HandleStatus.NEXT;
            }
        }

        // 需要对外发送时
        if (UpPacType.getByCode(pac.getHeader().getPacId()).getNeedSendout()) {
            dealSendOut(ctx, pac);
        }

        return HandleStatus.NEXT;
    }

    /**
     * 处理对外发送
     * @param ctx
     * @param pac
     */
    private void dealSendOut(ChannelHandlerContext ctx, Package808 pac) {
        // 是否需要发送到ons，应答消息和半包消息不发
        boolean needSendOns = true;
        int pacId = pac.getHeader().getPacId();

        // 转发 终端通用应答 非 平台下行透传 的通用应答，0x8900为分时租赁透传ID
        if (UpPacType.ACK.getCode() == pacId) {
            needSendOns = isNotPlatTransparentTransmission(pac);
        }
        // 要发送消息的tag
        String tag = MqTagUtils.getTag(MqTagUtils.PROTOCOL_JT808, pacId);
        // 要发送的消息
        String onsMsg = PacUtil.packWithPacSymbol(pac.getSourceHexStr());

        /**
         * 上行透传的消息，根据功能号不同发送不同的消息
         *     透传的消息类型：01 | FD 发送到 JT_0900_01 | JT_0900_FD 上
         *                   F1时，根据功能号发送到MQTT_功能号 上
         */
        if (UpPacType.PENETRATE_UP.getCode() == pacId) {
            // 透传的消息类型
            int msgTypeCode = PacUtil.getMsgTypeFromPenetrateUpMsg(pac);

            // 私有协议的其他数据
            if (msgTypeCode == MQTTMsgType.OTHER.getCode()) {
                // 消息体的字节数不满足分时租赁协议最小报文字节数则：该消息异常，不需要发送
                if (MqMessage.MESSAGE_MIN_LENGTH > pac.getBody().getContent().resetReaderIndex().readableBytes()) {
                    needSendOns = false;
                } else {
                    // 发送到jt808 的tage上 eg: MQTT_50
                    int functionCode = PacUtil.getFuncCodeFromPenetrateUpMsg(pac);
                    tag = (-1 == functionCode)?null:MqTagUtils.getTag(MqTagUtils.PROTOCOL_MQTT, (byte)functionCode);
                    // 发送ons的消息体
                    ByteBuf onsContentBuf = pac.getBody().getContent()
                            // 跳过消息类型
                            .skipBytes(1);
                    onsMsg = ByteBufUtil.hexDump(onsContentBuf);
                }
            } else if (Objects.nonNull(MQTTMsgType.getByCode(msgTypeCode))) {
                // 发送到MQTT 的tag上 eg: JT_0900_FD
                tag = MqTagUtils.getTag(MqTagUtils.PROTOCOL_JT808, pacId, (byte) msgTypeCode);
            }
        }

        /*
         * TODO 业务处理流程
         *  现在的业务处理只是将消息的原始报文发送到mq里
         */
        if (needSendOns && StringUtils.notEmpty(tag) && StringUtils.notEmpty(onsMsg)) {
            // 正常的消息发送至ons
            OnsTask task = new OnsTask(tag, onsMsg);
            fireChannelInnerMsg(ctx, InnerMsgType.TASK_ONS, task);
        }
    }

    /**
     * 转发 0001 非 0x8900 的通用应答，0x8900为分时租赁透传ID
     * @param pac
     * @return
     */
    private boolean isNotPlatTransparentTransmission(Package808 pac) {
        int ackPacId = PacUtil.getAckPacIdFromNormalAck(pac);

        return DownPacType.SEND_MQTT.getCode() != ackPacId;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }
}
