package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.constant.AckType;
import com.ccclubs.gateway.gb.constant.CommandType;
import com.ccclubs.gateway.gb.dto.MsgValidateExceptionDTO;
import com.ccclubs.gateway.gb.handler.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.common.AckMsgBuilder;
import com.ccclubs.gateway.gb.message.track.PacProcessTrack;
import com.ccclubs.gateway.gb.utils.ValidUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 9:54
 * Email:  yeanzhi@ccclubs.com
 * 数据包验证处理器
 */
@ChannelHandler.Sharable
public class PackageValidateHandler extends CCClubChannelInboundHandler<GBPackage> {
    private static final Logger LOG = LoggerFactory.getLogger(PackageValidateHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GBPackage pac) throws Exception {
        ByteBuf frame = pac.getSourceBuff();
        // 开始处理消息前，获取消息轨迹信息，步进轨迹
//        Long startTime = System.nanoTime();
        MsgValidateExceptionDTO validateExceptionDTO = new MsgValidateExceptionDTO();
        PacProcessTrack pacProcessTrack = beforeProcess(ctx, validateExceptionDTO);


        if(!ValidUtil.validePac(frame)) {
            // 标记为错误包
            pac.setErrorPac(true);
            // 根据消息类型的不同，做不同的应答处理
            processFailAckByMsgType(ctx, pac);
        } else {
            // TODO 校验成功：发送成功应答
            processSuccessAck(ctx, pac);
        }

        // 空消息时，预警
        if (pac.getHeader().getContentLength() == 0 &&
                CommandType.HEARTBEAT != pac.getHeader().getCommandMark()) {
            LOG.warn("收到一个包体为空的数据包：{}", pac.toLogString());
        }

        // 统计处理时间
        pacProcessTrack.getCurrentHandlerTracker().setEndTime(System.nanoTime());

//        Long endTime = System.nanoTime();
//        System.out.println("--valid--：" + (endTime -startTime));
        // 事件下发
        ctx.fireChannelRead(pac);
    }

    /**
     * 处理包校验失败后返回 校验失败应答
     * @param ctx
     * @param pac
     */
    private void processFailAckByMsgType(ChannelHandlerContext ctx, GBPackage pac) {
        CommandType msgType = pac.getHeader().getCommandMark();

        switch (msgType) {
            case TIME_CHECK:
            case REALTIME_DATA:
                // TODO 心跳校验失败不知道是否应答失败(理论上不用回复)
//            case HEARTBEAT:
                ByteBuf destBuf = AckMsgBuilder.ofFail(pac.getSourceBuff().copy());
                LOG.info("服务器下发异常错误应答>>>" + ByteBufUtil.hexDump(destBuf));
                ctx.writeAndFlush(destBuf);
                break;
            // 其他类型的消息不做应答
            default:
                break;
        }
    }

    private void processSuccessAck(ChannelHandlerContext ctx, GBPackage pac) {
        AckType ackType = pac.getHeader().getAckMark();
        if (AckType.ACK_COMMAND.equals(ackType)) {
            // 需要应答

            ByteBuf destBuf = AckMsgBuilder.ofSuccess(pac.getSourceBuff().copy());
            LOG.info("服务器下发成功应答>>>" + ByteBufUtil.hexDump(destBuf));
            ctx.writeAndFlush(destBuf.resetReaderIndex());
        }
    }
}
