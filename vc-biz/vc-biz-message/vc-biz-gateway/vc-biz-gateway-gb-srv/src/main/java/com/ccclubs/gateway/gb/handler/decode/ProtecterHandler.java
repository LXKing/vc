package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.exception.*;
import com.ccclubs.gateway.gb.handler.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.reflect.ClientCache;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: yeanzi
 * @Date: 2018/3/24
 * @Time: 21:41
 * Email:  yeanzhi@ccclubs.com
 *      守卫在最后底线的处理器
 */
public class ProtecterHandler extends CCClubChannelInboundHandler<GBPackage> {
    private static final Logger LOG = LoggerFactory.getLogger(ProtecterHandler.class);

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
    }

    @Override
    public void channelInactive(ChannelHandlerContext context) {
        LOG.info("连接被释放");
        ClientCache.closeWhenInactive((SocketChannel) context.channel());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent) {
            // 连接长时间空闲事件
            IdleStateEvent e = (IdleStateEvent) evt;
            if (IdleState.READER_IDLE == e.state()) {
                // 读空闲
                LOG.info("连接长时间空闲，将关闭该连接");
                ClientCache.closeWhenInactive((SocketChannel) ctx.channel());
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
        } else if (cause instanceof PacValidateException) {
            // 校验过程异常
            LOG.error("校验过程异常：msg={}", cause.getMessage());
        } else if (cause instanceof ConnStatisticsException) {
            // 连接数据统计过程异常
            LOG.error("连接数据统计过程异常：msg={}", cause.getMessage());
        } else if (cause instanceof DeleverPacException) {
            // 业务处理器异常
            LOG.error("业务处理过程异常：msg={}", cause.getMessage());
        } else if (cause instanceof TooLongFrameException) {
            // 数据包超长异常
            LOG.error("消息处理链出现数据包超长异常：msg={}", cause.getMessage());
            needCloseConn = true;
        } else if (cause instanceof ChannelDisconnException) {
            // 未连接异常
            LOG.error("消息处理链出现未连接异常：msg={}", cause.getMessage());
            needCloseConn = true;
        } else {
            // 其他异常
            LOG.error("消息处理链出现其他异常：msg={}", cause.getMessage());
        }
//        cause.printStackTrace();

        if (needCloseConn) {
            // 关闭链接
            LOG.info("抛出重要异常，服务端主动断开连接");
            ClientCache.closeWhenInactive((SocketChannel) context.channel());
        }
    }

}
