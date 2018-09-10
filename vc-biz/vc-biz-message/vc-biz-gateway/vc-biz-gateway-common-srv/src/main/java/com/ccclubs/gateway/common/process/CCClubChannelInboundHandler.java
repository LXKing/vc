package com.ccclubs.gateway.common.process;

import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.constant.InnerMsgType;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.util.ChannelAttrbuteUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 11:50
 * Email:  yeanzhi@ccclubs.com
 * 入站处理器基类
 *      一些入站公共处理可以在此处实现
 *          1. 处理器处理用时统计
 */
public abstract class CCClubChannelInboundHandler<T> extends ChannelInboundHandlerAdapter {
    public static final Logger LOG = LoggerFactory.getLogger(CCClubChannelInboundHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object pac) throws Exception {
        HandleStatus handleStatus = HandleStatus.END;
        // 真正处理消息的方法
        if (Objects.isNull(pac)) {
            // 空消息
            LOG.error("收到一个空消息 channelIdLongText: {}", ctx.channel().id().asLongText());
        } else if (pac instanceof AbstractChannelInnerMsg) {
            AbstractChannelInnerMsg innerMsg = (AbstractChannelInnerMsg) pac;
            handleStatus = handleInnerMsg(innerMsg);
        } else {
            ChannelAttrbuteUtil.getTrace(ctx.channel()).next();

            @SuppressWarnings("unchecked")
            T imsg = (T) pac;
            handleStatus = handlePackage(ctx, imsg);
        }
        switch (handleStatus) {
            // 传递到下一个处理器
            case NEXT:
                ctx.fireChannelRead(pac);
                break;
            case END:
                break;
            case RESP:
                break;
            default:
                break;
        }

    }

    protected abstract HandleStatus handlePackage(ChannelHandlerContext ctx, T pac) throws Exception;

    protected abstract HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg);

    protected void fireChannelInnerMsg(ChannelHandlerContext ctx, InnerMsgType innerMsgType, Object msg) {
        ctx.fireChannelRead(new AbstractChannelInnerMsg().setInnerMsgType(innerMsgType).setMsg(msg));
    }

    /**
     * release buffer
     * @param erroPacBuf
     */
    protected void releasePacBuffer(ByteBuf erroPacBuf) {
        if (Objects.nonNull(erroPacBuf) && erroPacBuf.refCnt() > 0) {
            ReferenceCountUtil.release(erroPacBuf);
        }
    }

}
