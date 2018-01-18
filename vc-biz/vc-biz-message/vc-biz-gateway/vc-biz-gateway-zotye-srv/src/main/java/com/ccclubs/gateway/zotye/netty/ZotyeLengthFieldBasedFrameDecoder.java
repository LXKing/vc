package com.ccclubs.gateway.zotye.netty;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.nio.ByteOrder;

/**
 * \* Created with IntelliJ IDEA2017.
 * \* User: Alban
 * \* Date: 2018/1/17
 * \* Time: 15:28
 * \* Description:
 * \
 */
public class ZotyeLengthFieldBasedFrameDecoder extends LengthFieldBasedFrameDecoder {

    public ZotyeLengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }


    public ZotyeLengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }

    public ZotyeLengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }


    public ZotyeLengthFieldBasedFrameDecoder(ByteOrder byteOrder, int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }


    @Override
    protected long getUnadjustedFrameLength(ByteBuf buf, int offset, int length, ByteOrder order) {
        buf = buf.order(order);
        long frameLength;
        switch (length) {
            case 1:
                frameLength = buf.getUnsignedByte(offset)+1;
                break;
            case 2:
                frameLength = buf.getUnsignedShort(offset)+1;
                break;
            case 3:
                frameLength = buf.getUnsignedMedium(offset)+1;
                break;
            case 4:
                frameLength = buf.getUnsignedInt(offset)+1;
                break;
            case 8:
                frameLength = buf.getLong(offset)+1;
                break;
            default:
                throw new DecoderException(
                        "unsupported lengthFieldLength: " + length + " (expected: 1, 2, 3, 4, or 8)");
        }
        return frameLength;
    }


}
