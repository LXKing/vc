package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.beans.DecodeExceptionDTO;
import com.ccclubs.gateway.gb.constant.AckType;
import com.ccclubs.gateway.gb.constant.CommandType;
import com.ccclubs.gateway.gb.constant.EncryType;
import com.ccclubs.gateway.gb.constant.PackagePart;
import com.ccclubs.gateway.gb.exception.PackageDecodeException;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.PacHeader;
import com.ccclubs.gateway.gb.utils.DecodeUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/3/25
 * @Time: 22:05
 * Email:  yeanzhi@ccclubs.com
 */
@Component
@Scope("prototype")
public class GBLengthFieldFrameDecoder extends LengthFieldBasedFrameDecoder {
    private static Logger LOG = LoggerFactory.getLogger(GBLengthFieldFrameDecoder.class);

    public GBLengthFieldFrameDecoder() {
        this(4024, 22, 2);
    }

    public GBLengthFieldFrameDecoder(
            int maxFrameLength,
            int lengthFieldOffset, int lengthFieldLength) {
        //   2M                  22                 2                       1
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, 1, 0);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
//        long startTime = System.currentTimeMillis();

        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
        // 过滤半包
        if (null == frame) {
            return null;
        }
        // 消息组装
        GBPackage pac = composeMsgPac(frame);

//        long endTime = System.currentTimeMillis();
//        LOG.info("数据包解析用时：" + (endTime - startTime) + "毫秒");
        return pac;
    }

    /**
     * 将ByteBuf包装为GBPackage
     * @param frame
     */
    private GBPackage composeMsgPac(ByteBuf frame) throws PackageDecodeException {
        DecodeExceptionDTO decodeExceptionInfo = new DecodeExceptionDTO(frame);
        try {
            GBPackage pac = GBPackage.valueOfEmpty();
            PacHeader pacHeader = pac.getHeader();
            pac.setSourceBuff(frame);

            /**
             * 分别拼装消息的各个部分，最细粒度地定位错误报文异常位置
             */
            // 起始符
            String startSymbol = DecodeUtil.byte2Str(frame, PackagePart.START_SYMBOL.getLen());
            if ("##".equals(startSymbol)) {
                decodeExceptionInfo.next();
                pacHeader.setStartSymbol(startSymbol);
            } else {
                decodeExceptionInfo.fail()
                        .setExceptionVal(startSymbol)
                        .setExpectedVal("##");
                throwWhenDecodeError(decodeExceptionInfo);
            }

            // 命令标识
            Short commandVal = frame.readUnsignedByte();
            CommandType commandType = CommandType.getByCode(commandVal);
            if (decodeExceptionInfo.isDecodeNotFinished() && null != commandType) {
                decodeExceptionInfo.next();
                pacHeader.setCommandMark(commandType);
            } else {
                decodeExceptionInfo.fail()
                        .setExceptionVal("" + commandVal)
                        .setExpectedVal(CommandType.expectedVals());
                throwWhenDecodeError(decodeExceptionInfo);
            }

            // 应答标志
            Short ackVal = frame.readUnsignedByte();
            AckType ackType = AckType.getByCode(ackVal);
            if (decodeExceptionInfo.isDecodeNotFinished() && null != ackType) {
                decodeExceptionInfo.next();
                pacHeader.setAckMark(ackType);
            } else {
                decodeExceptionInfo.fail()
                        .setExceptionVal("" + ackVal)
                        .setExpectedVal(AckType.expectedVals());
                throwWhenDecodeError(decodeExceptionInfo);
            }

            // vin码
            String vinNo = DecodeUtil.byte2Str(frame, PackagePart.UNIQUENO.getLen());
            if (decodeExceptionInfo.isDecodeNotFinished() &&
                    StringUtils.isNotEmpty(vinNo) &&
                    vinNo.length() == PackagePart.UNIQUENO.getLen()) {
                decodeExceptionInfo.next();
                pacHeader.setUniqueNo(vinNo);
            } else {
                decodeExceptionInfo.fail()
                        .setExceptionVal(vinNo)
                        .setExpectedVal("非空的17个字符");
                throwWhenDecodeError(decodeExceptionInfo);
            }

            // 加密方式
            Short encryVal = frame.readUnsignedByte();
            EncryType encryType = EncryType.getByCode(encryVal);
            if (decodeExceptionInfo.isDecodeNotFinished() && null != encryType) {
                decodeExceptionInfo.next();
                pacHeader.setEncryptType(encryType);
            } else {
                decodeExceptionInfo.fail()
                        .setExceptionVal("" + encryVal)
                        .setExpectedVal(EncryType.expectedVals());
                throwWhenDecodeError(decodeExceptionInfo);
            }

            // 包体长度
            int contentLength = frame.readUnsignedShort();
            if (decodeExceptionInfo.isDecodeNotFinished() && contentLength >= 0) {
                decodeExceptionInfo.next();
                pacHeader.setContentLength(contentLength);
            } else {
                decodeExceptionInfo.fail()
                        .setExceptionVal("" + contentLength)
                        .setExpectedVal("大于或者等于0");
                throwWhenDecodeError(decodeExceptionInfo);
            }

            // 包体
            ByteBuf body = frame.readSlice(pac.getHeader().getContentLength());
            if (decodeExceptionInfo.isDecodeNotFinished() && null != body && body.readableBytes() >= 0) {
                decodeExceptionInfo.next();
                pac.getBody().setContent(body);
            } else {
                decodeExceptionInfo.fail()
                        .setExceptionVal("空")
                        .setExpectedVal("可为空");
                throwWhenDecodeError(decodeExceptionInfo);
            }

            // 校验码
            if (decodeExceptionInfo.isDecodeNotFinished()) {
                if(frame.readableBytes() == 1) {
                    pac.setValidCode(frame.readByte());
                } else {
                    byte valideByte= frame.readByte();
                    decodeExceptionInfo.fail()
                            .setExceptionVal("" + valideByte).setReason("包长度超长，实际长度为：" + frame.readableBytes() + 1)
                            .setExpectedVal("字节长度等于1");
                    throwWhenDecodeError(decodeExceptionInfo);
                }
            }
            return pac;
        } catch (Throwable throwable) {
            // 抛出异常后不要忘了释放缓存
            ReferenceCountUtil.release(frame);
            // 根据解析步骤，提示不同的异常信息
            throw new PackageDecodeException(decodeExceptionInfo.toLogString());
        }

    }

    public void throwWhenDecodeError(DecodeExceptionDTO decodeExceptionInfo) {
        throw new PackageDecodeException(decodeExceptionInfo.toLogString());
    }
}
