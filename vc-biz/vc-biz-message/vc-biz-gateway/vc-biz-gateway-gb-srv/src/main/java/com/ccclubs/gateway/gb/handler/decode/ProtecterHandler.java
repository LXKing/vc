package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.common.bean.attr.PackageTraceAttr;
import com.ccclubs.gateway.common.config.TcpServerConf;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.exception.ServerCutException;
import com.ccclubs.gateway.common.service.KafkaService;
import com.ccclubs.gateway.common.util.BufReleaseUtil;
import com.ccclubs.gateway.common.util.ChannelAttributeUtil;
import com.ccclubs.gateway.common.util.ChannelUtils;
import com.ccclubs.gateway.gb.constant.PacProcessing;
import com.ccclubs.gateway.gb.dto.PackProcessExceptionDTO;
import com.ccclubs.gateway.gb.message.GBPackage;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/3/24
 * @Time: 21:41
 * Email:  yeanzhi@ccclubs.com
 *      守卫在最后底线的处理器
 */
@Component
@ChannelHandler.Sharable
public class ProtecterHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ProtecterHandler.class);

    @Autowired
    private KafkaService kafkaService;

    @Override
    public void channelRead (ChannelHandlerContext ctx, Object msg) throws Exception {
        GBPackage pac = (GBPackage) msg;
        ChannelAttributeUtil.getTrace(ctx.channel()).next();
        /**
         *  最终处理消息，不需要继续向下传递消息
         *      1.释放字节缓存
         */
        BufReleaseUtil.releaseByLoop(pac.getSourceBuff());
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

        // 事件下传
//        ctx.fireUserEventTriggered(evt);
    }

    /**
     * 所有调用链中的异常都在这里处理
     * @param context
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) throws Exception {
        SocketChannel channel = (SocketChannel) context.channel();
        /**
         * 抛出异常时，先清理buf
         */
        PackageTraceAttr packageTraceAttr = ChannelAttributeUtil.getTrace(channel);
        BufReleaseUtil.releaseByLoop(packageTraceAttr.getPacBuf());

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
        PacProcessing pacProcessing = PacProcessing.getByCode(packageTraceAttr.getStep());
        LOG.error("[{}]发生异常，异常原因：{}", pacProcessing.getDes(), cause);
        if (packageTraceAttr.isErrorOccured()) {
            // 自定义抛出的处理异常
        } else {
            // 其他非自定义的异常
            packageTraceAttr.getExpMessageDTO()
                    .setCode(String.valueOf(packageTraceAttr.getStep()))
                    .setReason(cause.getMessage());
        }

        // 其他非自定义异常如果获取不到vin码则不发送到kafka
        if (StringUtils.isEmpty(packageTraceAttr.getUniqueNo())) {
            needSendKafka = false;
        }

        // json序列化之后发送到kafka对应Topic
        if (needSendKafka) {
            kafkaService.send(new KafkaTask(KafkaSendTopicType.ERROR, packageTraceAttr.getUniqueNo(), packageTraceAttr.getExpMessageDTO().toJson()));
        }

        // 帧长度异常，未免影响下一次发送结果，主动断开与客户端的连接
        if (cause instanceof TooLongFrameException) {
            StringBuilder tooLongSb = new StringBuilder();
            tooLongSb.append("检测到车机")
                    .append(ChannelUtils.getUniqueNoOrHost(packageTraceAttr.getUniqueNo(), channel))
                    .append("发送帧长度异常，服务端将主动断开连接");
            LOG.error(tooLongSb.toString());
            needCloseConn = true;
        } else if (cause instanceof ServerCutException) {
            needCloseConn = true;
        }

        if (needCloseConn) {
            // 关闭链接
            context.channel().close();
        }
    }

}
