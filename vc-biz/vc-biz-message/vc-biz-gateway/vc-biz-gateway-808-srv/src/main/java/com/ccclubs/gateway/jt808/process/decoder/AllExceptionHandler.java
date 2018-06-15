package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.InnerMsgType;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.util.ChannelPacTrackUtil;
import com.ccclubs.gateway.jt808.constant.PacProcessing;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 14:52
 * Email:  yeanzhi@ccclubs.com
 * 异常处理器
 */
@Component
@ChannelHandler.Sharable
public class AllExceptionHandler extends ChannelInboundHandlerAdapter {
    public static final Logger LOG = LoggerFactory.getLogger(AllExceptionHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Package808 pac = (Package808) msg;

        /*
         * 只清理引用计数
         */
        if (pac.getSourceBuff().refCnt() > 0) {
            ReferenceCountUtil.release(pac.getSourceBuff());
            if (pac.getSourceBuff().refCnt() > 0) {
                LOG.error("buf 引用计数 release后发现计数仍大于0 refCng={}", pac.getSourceBuff().refCnt());
                while (ReferenceCountUtil.release(pac.getSourceBuff())) {}
            }
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent) {
            // 连接长时间空闲事件
            IdleStateEvent e = (IdleStateEvent) evt;
            if (IdleState.READER_IDLE == e.state()) {
                // 读空闲
                LOG.warn("连接长时间空闲，将关闭该连接");
                ctx.close();
                // 事件触发后，最终会触发ChannelInActive方法

            } else if (IdleState.WRITER_IDLE == e.state()) {
                // 写空闲
            } else if (IdleState.ALL_IDLE == e.state()) {
                // 读写都异常
            }
        } else {

        }
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) throws Exception {
        // 部分异常可能需要服务端主动释放连接
        boolean needCloseConn = false;
        // 是否发送至kafka
        boolean needSendKafka = true;

        /**
         * 处理链路出现异常后
         *  1.获取异常链路中的轨迹信息
         *  2.按照异常轨迹判断
         *      如果是链路上主动抛出的异常：获取对应的异常dto信息
         *      如果是链路上非主动抛出：组装其他异常dto
         *  3.发送至kafka
         */
        PacProcessTrack pacProcessTrack = ChannelPacTrackUtil.getPacTracker(context.channel());
        PacProcessing pacProcessing = PacProcessing.getByCode(pacProcessTrack.getStep());

        if (Objects.nonNull(pacProcessing)) {
            LOG.error("[{}]发生异常，异常原因：{}", pacProcessing.getDes(), cause.getMessage());
            if (pacProcessTrack.getCurrentHandlerTracker().isErrorOccur()) {
                // 自定义抛出的处理异常
            } else {
                // 其他非自定义的异常
                ExpMessageDTO expMessageDTO = pacProcessTrack.getExpMessageDTO();
                expMessageDTO.setMsgTime(System.currentTimeMillis());
                expMessageDTO.setCode(pacProcessTrack.getStep() + "")
                        .setVin(pacProcessTrack.getUniqueNo())
                        .setSourceHex(pacProcessTrack.getSourceHex())
                        .setReason(cause.getMessage());
            }
        } else {
            LOG.error("exception throwed but step invalid step={}", pacProcessTrack.getStep());

            // 其他非自定义的异常
            ExpMessageDTO expMessageDTO = pacProcessTrack.getExpMessageDTO();
            expMessageDTO.setMsgTime(System.currentTimeMillis());
            expMessageDTO.setCode(pacProcessTrack.getStep() + "")
                    .setVin(pacProcessTrack.getUniqueNo())
                    .setSourceHex(pacProcessTrack.getSourceHex())
                    .setReason(cause.getMessage());
        }

        // 其他非自定义异常如果获取不到vin码则不发送到kafka
        if (StringUtils.isEmpty(pacProcessTrack.getUniqueNo())) {
            needSendKafka = false;
        }

        // json序列化之后发送到kafka对应Topic
        if (needSendKafka) {
            KafkaTask task = new KafkaTask(KafkaSendTopicType.ERROR, pacProcessTrack.getUniqueNo(), pacProcessTrack.getExpMessageDTO().toJson());
            context.pipeline().fireChannelRead(new AbstractChannelInnerMsg().setInnerMsgType(InnerMsgType.TASK_KAFKA).setMsg(task));
        }

        // 帧长度异常，未免影响下一次发送结果，主动断开与客户端的连接
        if (cause instanceof TooLongFrameException) {
            StringBuilder tooLongSb = new StringBuilder("检测到车机");
            if (StringUtils.isNotEmpty(pacProcessTrack.getUniqueNo())) {
                tooLongSb.append("[").append(pacProcessTrack.getUniqueNo()).append("]");
            } else {
                SocketChannel channel = (SocketChannel) context.channel();
                tooLongSb.append("[ip=").append(channel.remoteAddress().getHostString())
                        .append(", port=").append(channel.remoteAddress().getPort()).append("]");
            }
            tooLongSb.append("发送帧长度异常，服务端将主动断开连接");
            LOG.error(tooLongSb.toString());
            needCloseConn = true;
        }

        // 打印异常链
        cause.printStackTrace();
//        if (cause.getCause() != null) {
//            cause.printStackTrace();
//        }

        if (needCloseConn) {
            // 关闭链接
            context.channel().close();
        }
    }
}
