package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.beans.DecodeExceptionDTO;
import com.ccclubs.gateway.gb.constant.AckType;
import com.ccclubs.gateway.gb.constant.CommandType;
import com.ccclubs.gateway.gb.constant.EncryType;
import com.ccclubs.gateway.gb.constant.PackagePart;
import com.ccclubs.gateway.gb.exception.PackageDecodeException;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.PacHeader;
import com.ccclubs.gateway.gb.message.track.PacProcessTrack;
import com.ccclubs.gateway.gb.utils.ChannelPacTrackUtil;
import com.ccclubs.gateway.gb.utils.DecodeUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.TooLongFrameException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: yeanzi
 * @Date: 2018/3/25
 * @Time: 22:05
 * Email:  yeanzhi@ccclubs.com
 */
public class GBLengthFieldFrameDecoder extends LengthFieldBasedFrameDecoder {
    private static Logger LOG = LoggerFactory.getLogger(GBLengthFieldFrameDecoder.class);

    // 记录当前渠道粘包处理状态
    private boolean isComplete = false;

    private Integer specifiedMaxFrameLength = 4096;

    public GBLengthFieldFrameDecoder() {
        this(4096, 22, 2);
    }

    public GBLengthFieldFrameDecoder(
            int maxFrameLength,
            int lengthFieldOffset, int lengthFieldLength) {
        //   2K                  22                 2                       1
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, 1, 0);
    }

    private boolean reorganizedPac(ChannelHandlerContext ctx, ByteBuf in) {
        // 超长报文处理：防止超长报文导致的内存爆炸
//        int frameLength = in.readableBytes();
//        if (frameLength > specifiedMaxFrameLength) {
//            // TODO 单次发送长度超长则直接丢弃
//            in.skipBytes(frameLength);throw new TooLongFrameException("Frame too big!");
//        }
        int startMarkIndex = DecodeUtil.indexOfStartMark(in);
        if (-1 == startMarkIndex) {
            return false;
        }
        if (0 == startMarkIndex) {
            isComplete = true;
        } else {
            if (isComplete) {

            } else {
                in.readerIndex(startMarkIndex);
                in.discardReadBytes();
                isComplete = true;
            }
        }

        if (isComplete) {

        } else {
            in.discardReadBytes();
            return false;
        }
        return true;
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        boolean reorganized = reorganizedPac(ctx, in);
        if (!reorganized) {
            return null;
        }
        // 过滤报文段[232307fe010000f8]
        DecodeUtil.filterEmptyVinMsgPart(in);

        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
        // 过滤半包
        if (null == frame) {
            isComplete = true;
            return null;
        } else {
            isComplete = false;
        }

        /**
         * 处理链处理新消息前，先清除上一个消息的轨迹信息
         */
        ChannelPacTrackUtil.refreshPacTrackForNewMsg(ctx.channel());

        // 生成和初始化消息包装类
        GBPackage pac = GBPackage.valueOfEmpty();
        pac.setSourceBuff(frame);
        // 标记为当前处理步骤
        PacProcessTrack pacProcessTrack = ChannelPacTrackUtil.getPacTracker(ctx.channel()).next();
        pacProcessTrack.setSourceHex(pac.getSourceHexStr());

        // 消息组装
        composeMsgPac(pac, pacProcessTrack);

        return pac;
    }

    /**
     * 将ByteBuf包装为GBPackage
     * @param pac
     */
    private GBPackage composeMsgPac(GBPackage pac, PacProcessTrack pacProcessTrack) {
        // 记录解析报文用时
        Long startTime = System.nanoTime();

        ByteBuf frame = pac.getSourceBuff();
        // 初始化解析异常dto，记录异常详细信息
        DecodeExceptionDTO decodeExceptionInfo = new DecodeExceptionDTO(pac.getSourceHexStr());
        PacHeader pacHeader = pac.getHeader();

        /**
         * 分别拼装消息的各个部分，最细粒度地定位错误报文异常位置
         */
        // 先获取vin码
        frame.readerIndex(PackagePart.UNIQUENO.getStartIndex());
        String vinNo = DecodeUtil.byte2Str(frame, PackagePart.UNIQUENO.getLen());
        if (StringUtils.isNotEmpty(vinNo) && vinNo.length() == PackagePart.UNIQUENO.getLen()) {
            decodeExceptionInfo.setVin(vinNo).next();
            pacHeader.setUniqueNo(vinNo);

            pacProcessTrack.setVin(vinNo);
            // 重置回读指针
            frame.resetReaderIndex();
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal(vinNo)
                    .setExpectedVal("非空的17个字符");
            throwWhenDecodeError(decodeExceptionInfo, pacProcessTrack);
        }

        // 起始符
        String startSymbol = DecodeUtil.byte2Str(frame, PackagePart.START_SYMBOL.getLen());
        if ("##".equals(startSymbol)) {
            decodeExceptionInfo.next();
            pacHeader.setStartSymbol(startSymbol);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal(startSymbol)
                    .setExpectedVal("##");
            throwWhenDecodeError(decodeExceptionInfo, pacProcessTrack);
        }

        // 命令标识
        Short commandVal = frame.readUnsignedByte();
        CommandType commandType = CommandType.getByCode(commandVal);
        if (null != commandType) {
            decodeExceptionInfo.next();
            pacHeader.setCommandMark(commandType);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal("" + commandVal)
                    .setExpectedVal(CommandType.expectedVals());
            throwWhenDecodeError(decodeExceptionInfo, pacProcessTrack);
        }

        // 应答标志
        Short ackVal = frame.readUnsignedByte();
        AckType ackType = AckType.getByCode(ackVal);
        if (null != ackType) {
            decodeExceptionInfo.next();
            pacHeader.setAckMark(ackType);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal("" + ackVal)
                    .setExpectedVal(AckType.expectedVals());
            throwWhenDecodeError(decodeExceptionInfo, pacProcessTrack);
        }

        // vin码在第一部分已经读取了，这里只需要跳过vin码部分
        frame.readerIndex(frame.readerIndex() + PackagePart.UNIQUENO.getLen());

        // 加密方式
        Short encryVal = frame.readUnsignedByte();
        EncryType encryType = EncryType.getByCode(encryVal);
        if (null != encryType) {
            decodeExceptionInfo.next();
            pacHeader.setEncryptType(encryType);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal("" + encryVal)
                    .setExpectedVal(EncryType.expectedVals());
            throwWhenDecodeError(decodeExceptionInfo, pacProcessTrack);
        }

        // 包体长度
        int contentLength = frame.readUnsignedShort();
        if (contentLength >= 0) {
            decodeExceptionInfo.next();
            pacHeader.setContentLength(contentLength);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal("" + contentLength)
                    .setExpectedVal("大于或者等于0");
            throwWhenDecodeError(decodeExceptionInfo, pacProcessTrack);
        }

        // 包体
        ByteBuf body = frame.readSlice(pac.getHeader().getContentLength());
        if (null != body && body.readableBytes() >= 0) {
            decodeExceptionInfo.next();
            pac.getBody().setContent(body);
        } else {
            decodeExceptionInfo.fail()
                    .setExceptionVal("空")
                    .setExpectedVal("消息体中可读字节不能为负数");
            throwWhenDecodeError(decodeExceptionInfo, pacProcessTrack);
        }

        // 校验码
        if(frame.readableBytes() == 1) {
            pac.setValidCode(frame.readByte());
        } else {
            byte valideByte= frame.readByte();
            decodeExceptionInfo.fail()
                    .setExceptionVal("" + valideByte).setReason("包长度超长，实际长度为：" + frame.readableBytes() + 1)
                    .setExpectedVal("字节长度等于1");
            throwWhenDecodeError(decodeExceptionInfo, pacProcessTrack);
        }

        // 初始化异常信息
        pacProcessTrack.getExpMessageDTO()
                .setSourceHex(pac.getSourceHexStr())
                .setVin(pacProcessTrack.getVin());
        Long endTime = System.nanoTime();
        pacProcessTrack.getCurrentHandlerTracker().setUsedTime(endTime - startTime);
        return pac;
    }

    public void throwWhenDecodeError(DecodeExceptionDTO decodeExceptionInfo, PacProcessTrack pacProcessTrack) {
        pacProcessTrack.getCurrentHandlerTracker().setErrorOccur(true);
        pacProcessTrack.getExpMessageDTO()
                .setMsgTime(System.currentTimeMillis());
        pacProcessTrack.getExpMessageDTO()
                .setSourceHex(decodeExceptionInfo.getSource())
                .setVin(decodeExceptionInfo.getVin())
                .setIndex(decodeExceptionInfo.getDecodeMarkIndex())
                .setReason(decodeExceptionInfo.toLogString())
                .setCode(pacProcessTrack.getStep() + "");
        throw new PackageDecodeException(decodeExceptionInfo.toLogString());
    }
}
