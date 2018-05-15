package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.constant.CommandType;
import com.ccclubs.gateway.gb.constant.PacErrorType;
import com.ccclubs.gateway.gb.constant.RealtimeDataType;
import com.ccclubs.gateway.gb.dto.MsgValidateExceptionDTO;
import com.ccclubs.gateway.gb.handler.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.handler.process.ChildChannelHandler;
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

import java.util.Objects;

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
            LOG.error("收到一个校验异常包：{}", pac.toLogString());
            // 标记为错误包
            pac.setErrorPac(true);
            pac.setPacErrorType(PacErrorType.PAC_VALID_ERROR);
            // 根据消息类型的不同，做不同的应答处理
            processFailAckByMsgType(ctx, pac);
        } else {
            // TODO 校验成功：发送成功应答
            processSuccessAck(ctx, pac);

            // ----------------------------------
            // 校验报文长度
            ByteBuf contentBuffer = pac.getBody().getContent().discardReadBytes();
            // 是否发生包长度校验异常
            boolean lengthError = false;
            // 包体内容长度
            int pacContentLength = contentBuffer.readableBytes();
            switch (pac.getHeader().getCommandMark()) {
                case REALTIME_DATA:
                case REISSUE_DATA:
                    // 实时数据和历史数据检查缺省内容
                    if (pacContentLength > 6) {
                        // 标识实时数据的数据类型循环是否结束
                        boolean end = false;
                        // 按照协议的预期消息体长度
                        int expectedLengthIndex = 5;
                        // 当前循环计数
                        int currentloopCount = 1;
                        // 实时数据中缺少字节的数据类型索引
                        int lackBytesIndex = 0;
                        /**
                         * 加try-catch是想处理包体字节数超过协议规定的长度
                         */
                        try {
                            while (!end) {
                                // 最多循环9次
                                if (currentloopCount > 9) {
                                    break;
                                } else {
                                    currentloopCount ++;
                                }
                                // 少字节时break;
                                if (pacContentLength < expectedLengthIndex + 1 + 1) {
                                    break;
                                }
                                int dataType = contentBuffer.getByte(++ expectedLengthIndex);
                                lackBytesIndex = dataType;
                                RealtimeDataType realtimeDataType = RealtimeDataType.getByCode(dataType);
                                switch (realtimeDataType) {
                                    case ALL:// 整车数据
                                        expectedLengthIndex += 20;
                                        break;
                                    case MOTOR:// 驱动电机数据
                                        int moterNum = contentBuffer.getUnsignedByte(++ expectedLengthIndex);
                                        for (int i = 0; i < moterNum; i ++) {
                                            expectedLengthIndex += 12;
                                        }
                                        break;
                                    case FUEL_CELL:// 燃料电池数据
                                        expectedLengthIndex += 6;
                                        // 温度探针个数
                                        int temProbNum = contentBuffer.getUnsignedShort(expectedLengthIndex);
                                        expectedLengthIndex += 2 + temProbNum + 10;
                                        break;
                                    case ENGINE:// 发动电机数据
                                        expectedLengthIndex += 5;
                                        break;
                                    case POSITION:// 车辆位置数据
                                        expectedLengthIndex += 9;
                                        break;
                                    case EXTREMUM:// 极值数据
                                        expectedLengthIndex += 14;
                                        break;
                                    case ALARM:// 报警数据
                                        expectedLengthIndex += 5;
                                        // 可充能装置故障个数
                                        int chargeableBrokenNum = contentBuffer.getUnsignedByte(++ expectedLengthIndex);
                                        expectedLengthIndex += 4 * chargeableBrokenNum;
                                        // 驱动电机故障个数
                                        int motorBrokenNum = contentBuffer.getUnsignedByte(++ expectedLengthIndex);
                                        expectedLengthIndex += 4 * motorBrokenNum;
                                        // 发动机故障个数
                                        int engineBrokenNum = contentBuffer.getUnsignedByte(++ expectedLengthIndex);
                                        expectedLengthIndex += 4 * engineBrokenNum;
                                        // 其他故障
                                        int otherBrokenNum = contentBuffer.getUnsignedByte(++ expectedLengthIndex);
                                        expectedLengthIndex += 4 * otherBrokenNum;

                                        break;
                                    case RECHARGEABLE_ENERGY_STORAGE_DEVICE_VOLTAGE:// 电压
                                        int voltageNum = contentBuffer.getByte(++ expectedLengthIndex);
                                        for (int i = 0; i < voltageNum; i++) {
                                            expectedLengthIndex += 10;
                                            int singleDY = contentBuffer.getByte(expectedLengthIndex);
                                            expectedLengthIndex += singleDY * 2;
                                        }
                                        break;
                                    case RECHARGEABLE_ENERGY_STORAGE_TEMPERATURE:// 温度
                                        int temNum = contentBuffer.getByte(++ expectedLengthIndex);
                                        for (int i = 0; i < temNum; i++) {
                                            expectedLengthIndex += 2;
                                            int singleTem = contentBuffer.getUnsignedShort(expectedLengthIndex);
                                            expectedLengthIndex += 1;
                                            expectedLengthIndex += singleTem;
                                        }
                                        break;
                                    default:
                                        end = true;
                                        break;
                                }
                            }
                            if (pacContentLength != expectedLengthIndex + 1) {
                                lengthError = true;
                                int lackedBytes = (expectedLengthIndex + 1) - pacContentLength;
                                RealtimeDataType realtimeDataType = RealtimeDataType.getByCode(lackBytesIndex);
                                validateExceptionDTO
                                        .setDataType(realtimeDataType.getCode())
                                        .setCauseMsg("[" + realtimeDataType.getDes() + "]缺少[" + lackedBytes + "]字节");
                                LOG.error("车机({})实时数据中[{}]部位缺失[{}]字节, 原始数据[{}]",
                                        pac.getHeader().getUniqueNo(),
                                        realtimeDataType.getDes(),
                                        lackedBytes,
                                        pac.getSourceHexStr());
                            }
                            break;
                        } catch (IndexOutOfBoundsException e) {
                            lengthError = true;
                            validateExceptionDTO
                                    .setDataType(lackBytesIndex)
                                    .setCauseMsg(e.getMessage());
                            LOG.error("车机({})实时数据中[{}]部位读取字节失败, 原始数据[{}]",
                                    pac.getHeader().getUniqueNo(),
                                    lackBytesIndex,
                                    pac.getSourceHexStr());
                        }
                    }
                    break;
                case VEHICLE_LOGIN:
                    if (pacContentLength < 30) {
                        lengthError = true;
                        break;
                    }
                    // 可充能子系统个数
                    int chargeableChildSysNum = contentBuffer.getByte(28);
                    // 可充能系统编码长度
                    int chargeableCodeLen = contentBuffer.getByte(29);
                    if ((chargeableChildSysNum * chargeableCodeLen + 30) != pacContentLength) {
                        lengthError = true;
                        break;
                    }
                    break;
                case VEHICLE_LOGOUT:
                    if (pacContentLength != 8) {
                        lengthError = true;
                        break;
                    }
                    break;
                case TIME_CHECK:
                    if (pacContentLength > 0) {
                        lengthError = true;
                        break;
                    }
                    break;
                case HEARTBEAT:
                    if (pacContentLength > 0) {
                        lengthError = true;
                        break;
                    }
                    break;
                default:
                    break;
            }
            if (lengthError) {
                pac.setErrorPac(true);
                pac.setPacErrorType(PacErrorType.PAC_LENGTH_ERROR);
            }
            // ----------------------------------
        }

        // 空消息时，预警
        if (pac.getHeader().getContentLength() == 0 &&
                CommandType.HEARTBEAT != pac.getHeader().getCommandMark() && // 心跳包体为空
                CommandType.TIME_CHECK != pac.getHeader().getCommandMark()) {// 校时包体为空
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
                if (ChildChannelHandler.printPacLog) {
                    LOG.info("服务器下发异常错误应答>>>" + ByteBufUtil.hexDump(destBuf));
                }
                ctx.writeAndFlush(destBuf);
                break;
            // 其他类型的消息不做应答
            default:
                break;
        }
    }

    private void processSuccessAck(ChannelHandlerContext ctx, GBPackage pac) {
        if (ValidUtil.isNeedAck(pac)) {
            // 需要应答
            ByteBuf destBuf = AckMsgBuilder.ofSuccess(pac.getSourceBuff().copy());
            if (Objects.nonNull(destBuf)) {
                if (ChildChannelHandler.printPacLog) {
                    LOG.info("服务器下发成功应答>>>" + ByteBufUtil.hexDump(destBuf));
                }
                ctx.writeAndFlush(destBuf.resetReaderIndex());
            }
        }
    }
}
