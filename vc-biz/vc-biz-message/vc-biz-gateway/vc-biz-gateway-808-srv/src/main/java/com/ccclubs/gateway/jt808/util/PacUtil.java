package com.ccclubs.gateway.jt808.util;

import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.constant.PackagePart;
import com.ccclubs.gateway.jt808.constant.msg.DownPacType;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.PacHeader;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 18:14
 * Email:  yeanzhi@ccclubs.com
 * 包工具
 */
public final class PacUtil {
    public static final Logger LOG = LoggerFactory.getLogger(PacUtil.class);

    public static Integer getContentLen(Short contentAttr) {
        // 0x03FF = 0000 0011 1111 1111
        return contentAttr & 0x03FF;
    }

    /**
     * 判断加密方式：
     *  目前只判断是否加密了
     * @param contentAttr
     * @return
     */
    public static boolean isEncrypted(Short contentAttr) {

        // 获取第10、11、12位的bit位
        int encryptPart = (contentAttr >>> 10);
        Boolean b10 = checkLastBit(encryptPart);
        encryptPart = encryptPart >>> 1;
        Boolean b11 = checkLastBit(encryptPart);
        encryptPart = encryptPart >>> 1;
        Boolean b12 = checkLastBit(encryptPart);

        if (!b10 && !b11 && !b12) {
            return false;
        } else if (b10) {
            return true;
        }
        // 其他为其他加密方式
        return true;
    }

    /**
     * 从消息体属性字段中解析出该消息是否为分包数据
     * @param contentAttr
     * @return
     */
    public static boolean isMultiPac(Short contentAttr) {
        int attr = contentAttr >>> 13;
        return (attr & 0x0001) == 1;
    }

    public static ByteBuf mobile2Buf(String mobile) {
        StringBuilder mobileSb = new StringBuilder(mobile);
        while (mobileSb.length() < 12) {
            // 大陆首位加0；港澳台根据区号补充
            mobileSb.insert(0, "0");
        }
        return Unpooled.wrappedBuffer(ByteBufUtil.decodeHexDump(mobileSb.toString()));
    }

    public static boolean needNormalAck(Integer pacId) {
        DownPacType downPacType = getAckPacType(pacId);
        if (Objects.nonNull(downPacType)) {
            return false;
        }
        return true;
    }

    public static DownPacType getAckPacType(Integer pacId) {
        UpPacType upPacType = UpPacType.getByCode(pacId);
        Objects.requireNonNull(upPacType);
        int downPacId = upPacType.getCode() | PackageCons.ACK_PRIFIX_HIGH;
        return DownPacType.getByCode(downPacId);
    }

    /**
     * 给当前报文加上808报文标识7E
     *      (即 在sourceHex的收尾加上7E)
     * @param sourceHex
     * @return
     */
    public static String packWithPacSymbol(String sourceHex) {
        StringBuilder sb = new StringBuilder(PackageCons.PAC_START_SYMBOL_HEX);
        return sb.append(sourceHex).append(PackageCons.PAC_START_SYMBOL_HEX).toString().toUpperCase();
    }

    /**
     * 从终端通用应答中获取应答的消息ID
     * @param pac
     * @return
     */
    public static int getAckPacIdFromNormalAck(Package808 pac) {
        if (UpPacType.ACK.getCode() != pac.getHeader().getPacId()) {
            throw new IllegalArgumentException("该消息不是[终端通用应答]，不能获取应答ID");
        }
        return pac.getBody().getContent().resetReaderIndex().skipBytes(2).readUnsignedShort();
    }


    /**
     * 从上行透传消息中获取消息类型
     * @param pac
     * @return
     */
    public static int getMsgTypeFromPenetrateUpMsg(Package808 pac) {
        if (UpPacType.PENETRATE_UP.getCode() != pac.getHeader().getPacId()) {
            throw new IllegalArgumentException("该消息不是[终端上行透传消息]，不能获取消息类型");
        }
        return pac.getBody().getContent().resetReaderIndex()
                // 读取消息类型
                .readByte() & 0xFF;
    }

    /**
     * 从上行透传消息中获取功能码
     * @param pac
     * @return
     */
    public static int getFuncCodeFromPenetrateUpMsg(Package808 pac) {
        if (UpPacType.PENETRATE_UP.getCode() != pac.getHeader().getPacId()) {
            throw new IllegalArgumentException("该消息不是[终端上行透传消息]，不能获取功能码");
        }

        if (pac.getBody().getContent().resetReaderIndex().readableBytes() < 17) {
            LOG.error("该上行透传消息体的长度少于17个字节");
            return -1;
        }
        return pac.getBody().getContent().resetReaderIndex()
                // 跳过功能码字节
                .skipBytes(1)
                // 跳过分时租赁协议的车机号（8）和流水号（8）
                .skipBytes(16)
                // 读取功能码
                .readByte() & 0xFF;
    }

    /**
     * 获取维护的消息序列号
     * @return
     */
    public static short getAndIncreaseSerialNo() {

        return PackageCons.ACK_SERINALNO.getAndUpdate(PacSerialNo::increase).getValue();
    }

    public static String getMobileFromByteBuf(ByteBuf completeSourceBuf) {
        ByteBuf sourceBuf = Unpooled.buffer();
        sourceBuf.writeBytes(completeSourceBuf.resetReaderIndex());
        // 消息转义: 还原消息
        PacTranslateUtil.translateUpPac(sourceBuf);

        // 读取终端手机号
        int mobileByteIndex = PackagePart.PAC_ID.getLen() + PackagePart.PAC_SERIAL_NO.getLen();
        // "1" 是： 跳过7E头部
        sourceBuf.readerIndex(1 + mobileByteIndex);
        ByteBuf mobileBuf = sourceBuf.readSlice(PackagePart.TER_MOBILE.getLen());

        completeSourceBuf.resetReaderIndex();
        return ByteBufUtil.hexDump(mobileBuf);
    }

    /**
     * 检查数值的最后一字节位是否为1
     *  true:  1
     *  false: 0
     * @param number
     * @return
     */
    private static boolean checkLastBit(int number) {
        return (number & 0x0001) == 1;
    }

    public static void main(String[] args) {
        Short contentAttr = 0x1803;
        int contentLen = getContentLen(contentAttr);
        boolean isEncrypt = isEncrypted(contentAttr);
        boolean isMultiPac = isMultiPac(contentAttr);
        System.out.println(new StringBuilder()
                .append("contentLen: ").append(contentLen).append("\n")
                .append("isEncrypt: ").append(isEncrypt).append("\n")
                .append("isMultiPac: ").append(isMultiPac).append("\n")
        .toString());

        System.out.println(needNormalAck(0x0100));
    }

}
