package com.ccclubs.report.netty.handler;

import static com.ccclubs.report.constant.LoginType.LOGIN_IN;
import static com.ccclubs.report.constant.LoginType.LOGIN_IN_FAIL;
import static com.ccclubs.report.constant.LoginType.LOGIN_IN_SUCCESS;
import static com.ccclubs.report.constant.LoginType.LOGIN_OUT;
import static com.ccclubs.report.constant.LoginType.LOGIN_OUT_FAIL;
import static com.ccclubs.report.constant.LoginType.LOGIN_OUT_SUCCESS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccclubs.report.service.ReportInf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

public class NettyChannelHandler extends ChannelInboundHandlerAdapter {
    private Logger log = LoggerFactory.getLogger(getClass());
    private ReportInf bInf;

    public NettyChannelHandler(ReportInf bInf) {
        this.bInf = bInf;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (null != bInf) {
            switch (bInf.loginType()) {
                case LOGIN_IN:
                    bInf.setLoginType(LOGIN_IN_SUCCESS);
                    bInf.loginInReceived(msg);
                    break;
                case LOGIN_OUT:
                    bInf.setLoginType(LOGIN_OUT_SUCCESS);
                    bInf.loginOutReceived(msg);
                    break;
                default:
                    bInf.receivedSuccess(msg);
                    break;
            }

        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (null != bInf) {
            switch (bInf.loginType()) {
                case LOGIN_IN:
                    bInf.setLoginType(LOGIN_IN_FAIL);
                    bInf.loginInFail(cause);
                    break;
                case LOGIN_OUT:
                    bInf.setLoginType(LOGIN_OUT_FAIL);
                    bInf.loginOutFail(cause);
                    break;
                default:
                    bInf.receivedError(cause);
                    break;
            }
        } else {
            super.exceptionCaught(ctx, cause);
        }
    }

    // Return a unreleasable view on the given ByteBuf
    // which will just ignore release and retain calls.
    private static final ByteBuf HEARTBEAT_SEQUENCE =
            Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Heartbeat", CharsetUtil.UTF_8));

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String type = "";
            if (event.state() == IdleState.READER_IDLE) {
                type = "read idle";
            } else if (event.state() == IdleState.WRITER_IDLE) {
                type = "write idle";
            } else if (event.state() == IdleState.ALL_IDLE) {
                type = "all idle";
            }

            ctx.writeAndFlush(HEARTBEAT_SEQUENCE.duplicate())
                    .addListener(ChannelFutureListener.CLOSE_ON_FAILURE);

            log.debug(ctx.channel().remoteAddress() + "超时类型：" + type);
        } else {
            log.debug("NettyChannelHandler haaaaaaaa!");
            super.userEventTriggered(ctx, evt);
        }
    }
}
