package com.ccclubs.gateway.gb.message.common;

import com.ccclubs.gateway.gb.constant.AckType;
import com.ccclubs.gateway.gb.utils.ValidUtil;
import io.netty.buffer.ByteBuf;

/**
 * @Author: yeanzi
 * @Date: 2018/3/27
 * @Time: 16:48
 * Email:  yeanzhi@ccclubs.com
 */
public class AckMsgBuilder {

    public static ByteBuf ofSuccess(ByteBuf sourceBuff) {
        // 当服务端发送应答时，只需要变更应答标志、应答报文时间，并重新计算校验位即可，其余报文内容与主动发送报文一致
//        int readIndex = sourceBuff.readerIndex();
//        int writeIndex = sourceBuff.writerIndex();
        return changeMarkAndValidByte(sourceBuff, AckType.ACK_SUCCESS);
    }

    public static ByteBuf ofFail(ByteBuf sourceBuff) {
        // 当服务端发送应答时，只需要变更应答标志、应答报文时间，并重新计算校验位即可，其余报文内容与主动发送报文一致
        return changeMarkAndValidByte(sourceBuff, AckType.ACK_FAIL);
    }

    /**
     * 将该消息 变更应答标记和重新计算校验位
     * @param sourceBuff
     * @param ackType
     * @return
     */
    private static ByteBuf changeMarkAndValidByte(ByteBuf sourceBuff, AckType ackType) {
        sourceBuff.resetReaderIndex();
        int readableBytes = sourceBuff.readableBytes();
        sourceBuff.resetWriterIndex();

        // 变更应答标记
        sourceBuff.writerIndex(3)
                .writeByte(ackType.getCode())
                .writerIndex(readableBytes - 1);
        byte newValidByte = ValidUtil.caculateValidByteFromBuff(sourceBuff);
        // 调整指针指向末端
        sourceBuff.writeByte(newValidByte);

        sourceBuff.resetReaderIndex();
        return sourceBuff;
    }

}
