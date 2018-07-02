package com.ccclubs.gateway.jt808.process.encoder;

import com.ccclubs.gateway.common.config.TcpServerConf;
import com.ccclubs.gateway.common.connection.ChannelMappingCollection;
import com.ccclubs.gateway.common.util.PacValidUtil;
import com.ccclubs.gateway.jt808.constant.EncryptType;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.constant.msg.DownPacType;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.PacHeader;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.util.PacSerialNo;
import com.ccclubs.gateway.jt808.util.PacTranslateUtil;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 16:43
 * Email:  yeanzhi@ccclubs.com
 * 报文编码器（Package808->ByteBuf）
 */
public class PackageEncoder extends MessageToByteEncoder<Package808> {
    private static final Logger LOG = LoggerFactory.getLogger(PackageEncoder.class);

    /**
     * 维护平台下发的流水号
     */
    private PacSerialNo pacSerialNo = new PacSerialNo((short)0);

    public PackageEncoder() {
        super();
    }

    public PackageEncoder(boolean preferDirect) {
        super(preferDirect);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

        LOG.error("消息编码器接收到一个异常：{}", cause.getMessage());
    }

    /**
     * 转码消息：类->ByteBuf
     *      TODO 错误校验
     * @param ctx
     * @param pac
     * @param out
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Package808 pac, ByteBuf out) throws Exception {
        ByteBuf sendoutBuf = Unpooled.buffer();
        // 消息体
        ByteBuf bodyBuf = pac.getBody().getContent();

        // 起始符
        sendoutBuf.writeByte(PackageCons.PAC_START_SYMBOL_BYTE);

        /*
         *消息头部
         */
        PacHeader header = pac.getHeader();
        // 消息ID
        sendoutBuf.writeShort(header.getPacId())
                // 消息体属性
                .writeShort(createAttrFromPac(null==bodyBuf?0:bodyBuf.readableBytes(), EncryptType.NO))
                // 终端手机号
                .writeBytes(PacUtil.mobile2Buf(header.getTerMobile()));

        // 消息流水号
        if (Objects.nonNull(header.getPacSerialNo())) {
            // 消息流水号
            sendoutBuf.writeShort(header.getPacSerialNo());
        } else {
            // 获取连接中的消息序列号
            sendoutBuf.writeShort(pacSerialNo.getAndIncrease());
        }

        // 消息包封装项: 一般下行报文不需要分包发送
        if (Objects.nonNull(header.getPacSealInfo())) {
            // TODO 加入分包的实现
        }

        // 消息体部分
        if (Objects.nonNull(bodyBuf) && bodyBuf.readableBytes() > 0) {
            sendoutBuf.writeBytes(bodyBuf);
        }

        // 校验码
        byte validCode = PacValidUtil.caculateValidByteFromBuff(sendoutBuf, 1, 0);
        sendoutBuf.writeByte(validCode);

        // 消息转义
        PacTranslateUtil.translateDownPac(sendoutBuf);

        // 结束符
        sendoutBuf.writeByte(PackageCons.PAC_START_SYMBOL_BYTE);

        pac.setSourceHexStr(ByteBufUtil.hexDump(sendoutBuf).toUpperCase());
        if (TcpServerConf.GATEWAY_PRINT_LOG) {
            LOG.info(buildDownstreamLog(pac));
        }
        // 最后写入：防止写入退出时造成部分写入
        out.writeBytes(sendoutBuf);
    }

    /**
     * 构建消息体属性
     * @param contentLen
     * @param encryptType
     * @return
     */
    private Short createAttrFromPac(Integer contentLen, EncryptType encryptType) {
        int destInt = 0;
        // 加入长度
        destInt |= contentLen;
        // 加入加密方式
        destInt |= encryptType.getCode();

        return (short) destInt;
    }

    private String buildDownstreamLog(Package808 pac) {
        StringBuilder logSb = new StringBuilder();
        DownPacType downPacType = DownPacType.getByCode(pac.getHeader().getPacId());
        logSb.append("平台对终端(").append(pac.getHeader().getTerMobile()).append(")")
                .append("下发[").append(downPacType==null?Integer.toHexString(pac.getHeader().getPacId()):downPacType.getDes()).append("]消息");
        if (Objects.nonNull(downPacType)) {
            switch (downPacType) {
                case ACK_NORMAL:
                    // 打印出应答的消息流水号.
                    ByteBuf bodyBuf = pac.getBody().getContent().resetReaderIndex();
                    UpPacType upPacType = null;
                    int ackSerialNo = bodyBuf.readShort() & 0xFFFF;
                    int ackPacId = bodyBuf.readShort() & 0xFFFF;
                    byte result = bodyBuf.readByte();
                    logSb.append("[应答流水:").append(ackSerialNo)
                            .append(",应答类型:").append((upPacType=UpPacType.getByCode(ackPacId))==null?Integer.toHexString(ackPacId):upPacType.getDes())
                            .append(",应答结果:").append(result == 0?"成功":"失败/异常")
                            .append("]");
                    break;
                    default:
                        break;
            }
        }
        logSb.append(",原始报文[").append(pac.getSourceHexStr()).append("]");
        return logSb.toString();
    }
}
