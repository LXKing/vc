package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.constant.PackProcessExceptionCode;
import com.ccclubs.gateway.gb.dto.ConnOnlineStatusEvent;
import com.ccclubs.gateway.gb.dto.MsgDecodeExceptionDTO;
import com.ccclubs.gateway.gb.dto.OtherProcessExceptionDTO;
import com.ccclubs.gateway.gb.dto.PackProcessExceptionDTO;
import com.ccclubs.gateway.gb.exception.*;
import com.ccclubs.gateway.gb.handler.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.reflect.ClientCache;
import com.ccclubs.gateway.gb.reflect.GBConnection;
import com.ccclubs.gateway.gb.utils.KafkaProperties;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/3/24
 * @Time: 21:41
 * Email:  yeanzhi@ccclubs.com
 *      守卫在最后底线的处理器
 */
//@Component
//@Scope("prototype")
public class ProtecterHandler extends CCClubChannelInboundHandler<GBPackage> {
    private static final Logger LOG = LoggerFactory.getLogger(ProtecterHandler.class);

//    @Autowired
    private KafkaProperties kafkaProperties;

//    @Autowired
    private KafkaTemplate kafkaTemplate;

    public ProtecterHandler(KafkaTemplate kafkaTemplate, KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void channelRead0 (ChannelHandlerContext ctx, GBPackage msg) throws Exception {

        /**
         *  一定要将字节对象传递到下一个处理器（tailHandler）
         *  它会释放字节缓存，不要自己处理
         */
        ctx.fireChannelRead(msg.getSourceBuff());
    }

    @Override
    public void channelActive(ChannelHandlerContext context) {
        LOG.info("新链接建立");
        SocketChannel channel = (SocketChannel)context.channel();
        ClientCache.addByChannelId(channel.id());
    }

    @Override
    public void channelInactive(ChannelHandlerContext context) {
        LOG.info("连接被释放");
        SocketChannel channel = (SocketChannel)context.channel();
        GBConnection conn = ClientCache.getByChannelId(channel.id());
        ConnOnlineStatusEvent connOnlineStatusEvent = new ConnOnlineStatusEvent();
        if (Objects.nonNull(conn) && conn.isConnected()) {
            connOnlineStatusEvent.setVin(conn.getVin())
                    .setOnline(false)
                    .setTimestamp(System.currentTimeMillis())
                    .setClientIp(channel.remoteAddress().getHostString())
                    .setServerIp(channel.localAddress().getHostString());
        }

        boolean connClosedSuccess = ClientCache.closeWhenInactive((SocketChannel) context.channel());
        if (connClosedSuccess) {
            kafkaTemplate.send(kafkaProperties.getOnline(), connOnlineStatusEvent.toJson());
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent) {
            // 连接长时间空闲事件
            IdleStateEvent e = (IdleStateEvent) evt;
            if (IdleState.READER_IDLE == e.state()) {
                // 读空闲
                LOG.info("连接长时间空闲，将关闭该连接");
                ctx.close();

                // 事件触发后，最终会触发ChannelInActive方法


            } else if (IdleState.WRITER_IDLE == e.state()) {
                // 写空闲

            } else if (IdleState.ALL_IDLE == e.state()) {
                // 读写都异常

            }
        } else {

        }
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
        // 部分异常可能需要服务端主动释放连接
        boolean needCloseConn = false;
        // 消息处理过程中发生的异常
        if (cause instanceof PackageDecodeException) {
            // 消息解析异常
            LOG.error(cause.getMessage());

            PackProcessExceptionDTO packProcessExceptionDTO = new PackProcessExceptionDTO();
            PackageDecodeException packageDecodeException = (PackageDecodeException) cause;

            packProcessExceptionDTO.setCode(PackProcessExceptionCode.MESSAGE_DECODE_ERROR.getCode())
                    .setJson(packageDecodeException.getMsgDecodeExceptionDTO())
                    .setVin(packageDecodeException.getVin());
            kafkaTemplate.send(kafkaProperties.getDecode(), packProcessExceptionDTO.toJson());

        } else if (cause instanceof PacValidateException) {
            // 校验过程异常
            LOG.error("校验过程异常：msg={}", cause.getMessage());
            PacValidateException pacValidateException = (PacValidateException) cause;
            kafkaTemplate.send(kafkaProperties.getProcess(),
                    pacValidateException.getPackProcessExceptionDTO().toJson());
        } else if (cause instanceof ConnStatisticsException) {
            // 连接数据统计过程异常
            LOG.error("连接数据统计过程异常：msg={}", cause.getMessage());
            ConnStatisticsException connStatisticsException = (ConnStatisticsException) cause;
            kafkaTemplate.send(kafkaProperties.getProcess(),
                    connStatisticsException.getPackProcessExceptionDTO().toJson());
        } else if (cause instanceof DeleverPacException) {
            // 业务处理器异常
            LOG.error("业务处理过程异常：msg={}", cause.getMessage());
            DeleverPacException deleverPacException = (DeleverPacException) cause;
            kafkaTemplate.send(kafkaProperties.getProcess(),
                    deleverPacException.getPackProcessExceptionDTO().toJson());
        } else if (cause instanceof TooLongFrameException) {
            // 数据包超长异常
            LOG.error("消息处理链出现数据包超长异常：msg={}", cause.getMessage());
            // TODO 应该不会进入该条件运行
//            OtherProcessExceptionDTO otherProcessExceptionDTO = new OtherProcessExceptionDTO();
//            otherProcessExceptionDTO.setCauseMsg(cause.getMessage());
//            PackProcessExceptionDTO packProcessExceptionDTO = new PackProcessExceptionDTO();
//            packProcessExceptionDTO.setCode(PackProcessExceptionCode.)
//                    .setJson(otherProcessExceptionDTO);
//            kafkaTemplate.send(KafkaConst.KAFKA_TOPIC_GATEWAY_GB_PROCESS_ERROR,
//                    packProcessExceptionDTO.toJson());
            needCloseConn = true;
        } else if (cause instanceof ChannelDisconnException) {
            // 未连接异常
            LOG.error("消息处理链出现未连接异常：msg={}", cause.getMessage());
            // TODO 应该不会进入该条件运行
//            kafkaTemplate.send(KafkaProducerKey.CHANNEL_DISCONN_EXCEPTION, cause.getMessage());
            needCloseConn = true;
        } else {
            // 其他异常
            LOG.error("消息处理链出现其他异常：msg={}", cause.getMessage());

            OtherProcessExceptionDTO otherProcessExceptionDTO = new OtherProcessExceptionDTO();
            otherProcessExceptionDTO.setCauseMsg(cause.getMessage());
            PackProcessExceptionDTO packProcessExceptionDTO = new PackProcessExceptionDTO();
            packProcessExceptionDTO.setCode(PackProcessExceptionCode.PROCESS_OTHER_EXCEPTION.getCode())
                    .setJson(otherProcessExceptionDTO);

            kafkaTemplate.send(kafkaProperties.getProcess(),
                    packProcessExceptionDTO.toJson());
        }
//        cause.printStackTrace();

        if (needCloseConn) {
            // 关闭链接
            LOG.info("检测到重要异常，服务端将主动断开连接");
            ClientCache.closeWhenInactive((SocketChannel) context.channel());
        }
    }

}
