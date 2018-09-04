package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.common.bean.track.ChannelLifeCycleTrack;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.constant.InnerMsgType;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.util.ChannelAttrbuteUtil;
import com.ccclubs.gateway.jt808.constant.PacProcessing;
import com.ccclubs.gateway.jt808.exception.ClientMappingException;
import com.ccclubs.gateway.jt808.exception.OfflineException;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.util.BufReleaseUtil;
import com.ccclubs.gateway.jt808.util.PacUtil;
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

import java.io.IOException;
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
                BufReleaseUtil.releaseByLoop(pac.getSourceBuff());
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
                SocketChannel channel = (SocketChannel) ctx.channel();

                ChannelLifeCycleTrack channelLife = ChannelAttrbuteUtil.getLifeTrack(channel);
                channelLife.setLiveStatus( ChannelLiveStatus.OFFLINE_IDLE);
                String uniqueNo = channelLife.getUniqueNo();
                if (Objects.isNull(uniqueNo)) {
                    LOG.error("cannot mapping to uniqueNo when deal idle event");
                    uniqueNo = ChannelAttrbuteUtil.getPacTracker(channel).getUniqueNo();
                }
                LOG.error("连接(sim={})长时间空闲，将关闭该连接", PacUtil.getUniqueNoOrHost(uniqueNo, channel));

                /**
                 * 区别于正常的断开连接
                 */

                ctx.pipeline().fireChannelInactive();
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
        SocketChannel channel = (SocketChannel) context.channel();
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
        PacProcessTrack pacProcessTrack = ChannelAttrbuteUtil.getPacTracker(channel);
        // (重要)*如果buf未释放则：释放buf*
        BufReleaseUtil.releaseByLoop(pacProcessTrack.getPacBuf());

        PacProcessing pacProcessing = PacProcessing.getByCode(pacProcessTrack.getStep());
        String uniqueNo = pacProcessTrack.getUniqueNo();
        uniqueNo = PacUtil.getUniqueNoOrHost(uniqueNo, channel);
        /**
         * 导致异常的异常原始报文
         */
        String exceptionPacHex = pacProcessTrack.getSourceHex();

        if (Objects.nonNull(pacProcessing)) {
            LOG.error("terminal ({})- [{}] step occured exception sourceHex = [{}], for reason：{}",
                    uniqueNo, pacProcessing.getDes(), exceptionPacHex, cause);
            if (pacProcessTrack.getCurrentHandlerTracker().isErrorOccur()) {
                // 自定义抛出的处理异常
            } else {
                // 其他非自定义的异常
                setOtherException(uniqueNo, pacProcessTrack, cause);
            }
        } else {
            LOG.error("terminal ({})- occured exception when handle sourceHex = [{}], exception throwed but step invalid: step={}, for reason: {}",
                    uniqueNo, exceptionPacHex, pacProcessTrack.getStep(), cause);
            // 其他非自定义的异常
            setOtherException(uniqueNo, pacProcessTrack, cause);
        }

        // 其他非自定义异常如果获取不到vin码则不发送到kafka
        if (StringUtils.isEmpty(pacProcessTrack.getUniqueNo())) {
            needSendKafka = false;
        }

        // json序列化之后发送到kafka对应Topic
        if (needSendKafka) {
            KafkaTask task = new KafkaTask(KafkaSendTopicType.ERROR, uniqueNo, pacProcessTrack.getExpMessageDTO().toJson());
            context.pipeline().fireChannelRead(new AbstractChannelInnerMsg().setInnerMsgType(InnerMsgType.TASK_KAFKA).setMsg(task));
        }

        // 帧长度异常，未免影响下一次发送结果，主动断开与客户端的连接
        if (cause instanceof TooLongFrameException) {
            LOG.error("检测到车机[" + uniqueNo +"]发送帧长度异常，服务端将主动断开连接");
            needCloseConn = true;
        } else if (cause instanceof OfflineException) {
            // 断开连接异常，服务端将强制断开. 这里已经找不到uniqueNo了，所以也发送不了下线事件给 redis
            LOG.error("({}) 断开连接异常，服务端将强制断开", uniqueNo);

            context.channel().unsafe().closeForcibly();
        } else if (cause instanceof IOException) {
            // Connection reset by peer
            LOG.error("({}) 连接重置[{}]，服务端将关闭该连接", uniqueNo, cause.getMessage());
            needCloseConn = true;
        } else if (cause instanceof ClientMappingException) {
            LOG.error("client ({}) cannot find mapping: cause={}", uniqueNo, cause);
            needCloseConn = true;
        }

        if (needCloseConn) {
            ChannelAttrbuteUtil.setChannelLiveStatus(channel, ChannelLiveStatus.OFFLINE_SERVER_CUT);
            // 关闭链接
            context.pipeline().fireChannelInactive();
        }

        // 最后释放可能存在的缓存
        ReferenceCountUtil.release(cause);

        /**
         * TODO 这里需要考虑，如果发生异常，是否有必要拿到buffer对象并且释放？
         */
    }

    private void setOtherException(String uniqueNo, PacProcessTrack pacProcessTrack, Throwable cause) {
        ExpMessageDTO expMessageDTO = pacProcessTrack.getExpMessageDTO();
        expMessageDTO.setMsgTime(System.currentTimeMillis());
        expMessageDTO.setCode(pacProcessTrack.getStep() + "")
                .setGatewayType(GatewayType.GATEWAY_808.getDes())
                .setSourceHex(pacProcessTrack.getSourceHex())
                .setReason(cause.getMessage())
                .setMobile(uniqueNo);
    }
}
