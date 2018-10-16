package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.attr.ChannelStatusAttr;
import com.ccclubs.gateway.common.bean.attr.PackageTraceAttr;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.constant.InnerMsgType;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.exception.ClientMappingException;
import com.ccclubs.gateway.common.exception.OfflineException;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.common.util.ChannelUtils;
import com.ccclubs.gateway.jt808.constant.PacProcessing;
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
                // 更新渠道状态
                ChannelStatusAttr channelStatusAttr = ChannelAttributeUtil.getStatus(channel);
                channelStatusAttr.setCurrentStatus(ChannelLiveStatus.OFFLINE_IDLE);

                String uniqueNo = channelStatusAttr.getUniqueNo();
                if (Objects.isNull(uniqueNo)) {
                    LOG.error("cannot mapping to uniqueNo when deal idle event");
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
        PackageTraceAttr packageTraceAttr = ChannelAttributeUtil.getTrace(channel);
        // (重要)*如果buf未释放则：释放buf*
        BufReleaseUtil.releaseByLoop(packageTraceAttr.getPacBuf());
        // 打印异常日志
        PacProcessing pacProcessing = PacProcessing.getByCode(packageTraceAttr.getStep());
        LOG.error("[{}]发生异常，异常原因：", pacProcessing.getDes(), cause);

        // 获取唯一标识
        String uniqueNo = packageTraceAttr.getUniqueNo();
        if (Objects.isNull(uniqueNo)) {
            // 若在获取到手机号之前发生异常，该异常信息不记录并且直接断开该连接
            LOG.error("cannot find uniqueNo when a exception was caughted, the server will close the connection.");
            ChannelUtils.closeChannelForcibly(channel);
            return;
        }
        if (!packageTraceAttr.isErrorOccured()) {
            // 其他非自定义的异常, 填补异常原因
            packageTraceAttr.getExpMessageDTO()
                    .setCode(String.valueOf(packageTraceAttr.getStep()))
                    .setReason(cause.getMessage());
        }

        // json序列化之后发送到kafka对应Topic
        if (needSendKafka) {
            KafkaTask task = new KafkaTask(KafkaSendTopicType.ERROR, uniqueNo, packageTraceAttr.getExpMessageDTO().toJson());
            context.pipeline().fireChannelRead(new AbstractChannelInnerMsg().setInnerMsgType(InnerMsgType.TASK_KAFKA).setMsg(task));
        }

        // 部分异常可能需要服务端主动释放连接
        if (isCutOffClientWhenException(cause, ChannelUtils.getUniqueNoOrHost(packageTraceAttr.getUniqueNo(), channel))) {
            ChannelAttributeUtil.getStatus(channel)
                    .setCurrentStatus(ChannelLiveStatus.OFFLINE_SERVER_CUT);
            // 关闭链接
            context.pipeline().fireChannelInactive();
        }

        // 处理主动断开与客户端的连接的异常
        dealCloseClientForciblyException(cause, packageTraceAttr.getUniqueNo(), channel);

        // 最后释放可能存在的缓存
        ReferenceCountUtil.release(cause);

        /**
         * TODO 这里需要考虑，如果发生异常，是否有必要拿到buffer对象并且释放？
         */
    }

    /**
     * 根据异常类型，判断服务端是否需要主动断开客户端连接
     * @param cause
     * @param uniqueNo
     * @return
     */
    private boolean isCutOffClientWhenException(Throwable cause, String uniqueNo) {
        // 帧长度异常，未免影响下一次发送结果，主动断开与客户端的连接
        if (cause instanceof TooLongFrameException) {
            LOG.error("client({}) send frame too long, the server will cutoff the connection.", uniqueNo);
        } else if (cause instanceof IOException) {
            // Connection reset by peer
            LOG.error("client ({}) cause a io-exception: cause={}, the server will cutoff the connection.", uniqueNo, cause.getMessage());
        } else if (cause instanceof ClientMappingException) {
            LOG.error("client ({}) cannot find mapping: cause={}", uniqueNo, cause);
        } else {
            // 其他情况不断开连接
            return false;
        }
        // 命中的异常，断开连接
        return true;
    }

    /**
     * 处理强制关闭终端连接的异常
     *      当某些异常发生时，不能通过正常下线操作使终端下线，只有强制终端下线
     * @param cause
     * @param uniqueNo
     * @param channel
     */
    private void dealCloseClientForciblyException(Throwable cause, String uniqueNo, SocketChannel channel) {
        if (cause instanceof OfflineException) {
            LOG.error("检测到终端[{}]下线异常，服务端将主动断开连接.", ChannelUtils.getUniqueNoOrHost(uniqueNo, channel));
            ChannelUtils.closeChannelForcibly(channel);
            return;
        }
    }
}
