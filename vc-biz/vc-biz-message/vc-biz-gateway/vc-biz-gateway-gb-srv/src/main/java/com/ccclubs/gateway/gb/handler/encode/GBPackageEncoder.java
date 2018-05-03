package com.ccclubs.gateway.gb.handler.encode;

import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.utils.ValidUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

/**
 * @Author: yeanzi
 * @Date: 2018/3/27
 * @Time: 18:25
 * Email:  yeanzhi@ccclubs.com
 */
public class GBPackageEncoder extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        System.out.println("out: msg\n" + msg);
        if (msg instanceof ByteBuf) {
            out.writeBytes((ByteBuf)msg);
        } else if(msg instanceof GBPackage) {
            GBPackage pac = (GBPackage) msg;

            out.writeBytes(pac.getHeader().getStartSymbol().getBytes(Charset.forName("GBK")))
                    .writeByte(pac.getHeader().getCommandMark().getCode())
                    .writeByte(pac.getHeader().getAckMark().getCode())
                    .writeBytes(pac.getHeader().getUniqueNo().getBytes())
                    .writeByte(pac.getHeader().getEncryptType().getCode())
                    .writeShort(pac.getHeader().getContentLength())

                    .writeBytes(pac.getBody().getContent())
                    .writeByte(pac.getValidCode());
            // 计算并设置校验码
            pac.setValidCode(ValidUtil.caculateValidByteFromBuff(out));

            out.resetReaderIndex();
            out.writerIndex(out.readableBytes() - 1).writeByte(pac.getValidCode());
        }
    }
}
