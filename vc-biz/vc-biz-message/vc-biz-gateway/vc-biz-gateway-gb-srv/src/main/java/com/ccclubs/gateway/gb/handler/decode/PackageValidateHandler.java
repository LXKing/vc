package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.constant.CommandType;
import com.ccclubs.gateway.gb.exception.PacValidateException;
import com.ccclubs.gateway.gb.handler.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.common.AckMsgBuilder;
import com.ccclubs.gateway.gb.utils.ValidUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 9:54
 * Email:  yeanzhi@ccclubs.com
 * 数据包验证处理器
 */
@Component
@Scope("prototype")
public class PackageValidateHandler extends CCClubChannelInboundHandler<GBPackage> {
    private static final Logger LOG = LoggerFactory.getLogger(PackageValidateHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GBPackage pac) throws Exception {
        try {
            ByteBuf frame = pac.getSourceBuff();
            // 2. 校验消息正确性
            if(!ValidUtil.validePac(frame)) {
                // 标记为错误包
                pac.setErrorPac(true);
                // 根据消息类型的不同，做不同的应答处理
                processFailAckByMsgType(ctx, frame.copy());

                // TODO 错误包发送到errormsg tag上

            }

            // 空消息时，预警
            if (pac.getHeader().getContentLength() == 0 &&
                    CommandType.HEARTBEAT != pac.getHeader().getCommandMark()) {
                LOG.warn("收到一个包体为空的数据包：{}", pac.toLogString());
            }
            // 事件下发
            ctx.fireChannelRead(pac);
        } catch (Exception e) {
            throw new PacValidateException(e.getMessage());
        }
    }

    /**
     * 处理包校验失败后返回 校验失败应答
     * @param ctx
     * @param msg
     */
    private void processFailAckByMsgType(ChannelHandlerContext ctx, ByteBuf msg) {

        int readerIndex = msg.readerIndex();
        CommandType msgType = CommandType.getByCode(msg.readerIndex(2).readByte());
        msg.resetReaderIndex();

        switch (msgType) {
            case TIME_CHECK:
            case REALTIME_DATA:
                // TODO 心跳校验失败不知道是否应答失败(理论上不用回复)
//            case HEARTBEAT:
                LOG.info("服务器下发>>>" + ByteBufUtil.hexDump(msg));
                ctx.writeAndFlush(AckMsgBuilder.ofFail(msg));
                break;
            // 其他类型的消息不做应答
            default:
                break;
        }
    }
}
