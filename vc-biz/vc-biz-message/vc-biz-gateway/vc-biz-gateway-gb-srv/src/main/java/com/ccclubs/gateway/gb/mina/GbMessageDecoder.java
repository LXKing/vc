package com.ccclubs.gateway.gb.mina;

import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.dto.gb.GBMessageHeader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GbMessageDecoder extends CumulativeProtocolDecoder {

  private static final Logger logger = LoggerFactory.getLogger(GbMessageDecoder.class);

  private CharsetDecoder decoder;

  public GbMessageDecoder(Charset charset) {
    this.decoder = charset.newDecoder();
  }

  protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
      throws Exception {

    if (in.remaining() < 1) {
      return false;
    }
    in.mark();
    byte[] data = new byte[in.remaining()];
    in.get(data);
//    logger.info("UP >> 原始数据：" + Tools.ToHexString(data));
    // this.logger.warn(Tools.ToHexString(data));
    int pos = 0;
    in.reset();
    while (in.remaining() > 0) {
      in.mark();
      byte tag = in.get();
      // 搜索包的开始位置
      if (tag == 0x23 && in.remaining() > 0) {
        tag = in.get();
        if (tag == 0x23 && in.remaining() > 0) {
          tag = in.get();
          // Tips:连包 -- 寻找包的结束，连续的两个0x23才计为结束
          while (in.remaining() >= 0) {
            if (tag == 0x23 && in.remaining() > 0) {
              byte secondTag = in.get();
              if (secondTag == 0x23) {
                pos = in.position();
                int packetLength = pos - in.markValue() - 2;
                if (packetLength > 1) {
                  byte[] tmp = new byte[packetLength];
                  in.reset();
                  in.get(tmp);
                  // logger.error("原始数据" + ":" + Tools.ToHexString(tmp));
                  GBMessage message = new GBMessage();
                  message.ReadFromBytes(tmp);
                  //					JT808TransferQueue.forward(message.getSimNo(), tmp); // 808转发
                  out.write(message); // 触发接收Message的事件

                  return true;
                } else {
                  // 说明是两个0x23
                  in.reset();
                  in.get(); // 两个0x23说明前面是包尾，后面是包头
                }
              } else {
                tag = secondTag;
                continue;
              }
            }

            // Tips ：整包或者半包，且包含头部
            if (in.remaining() <= 0) {
              pos = in.position();
              int packetLength = pos - in.markValue();
              if (packetLength >= GBMessageHeader.getHeaderSize()) {
                // 判断长度
                int packetWholeHighByte = (data[22] & 0xFF);
                int packetWholeLowByte = (data[23] & 0xFF);
                int unitLength = (packetWholeHighByte << 8) + packetWholeLowByte;
                // 是一个完整的数据包
                if (data.length == unitLength + GBMessageHeader.getHeaderSize() + 1 + 2) {
                  byte[] tmp = new byte[packetLength];
                  in.reset();
                  in.get(tmp);
                  // logger.error("原始数据" + ":" + Tools.ToHexString(tmp));
                  GBMessage message = new GBMessage();
                  message.ReadFromBytes(tmp);
                  //					JT808TransferQueue.forward(message.getSimNo(), tmp); // 808转发
                  out.write(message); // 触发接收Message的事件
                  return true;
                } else {
                  in.reset();
                  return false;
                }
              } else {
                // 继续接收后面的数据包
//                in.get(); // 两个0x23说明前面是包尾，后面是包头
              }
            }
            tag = in.get();
          }
        }
      }
    }
    return false;
  }
}
