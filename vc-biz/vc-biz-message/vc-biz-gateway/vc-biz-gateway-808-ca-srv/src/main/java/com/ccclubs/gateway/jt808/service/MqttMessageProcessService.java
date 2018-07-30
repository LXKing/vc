package com.ccclubs.gateway.jt808.service;

import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.gateway.common.util.DateUtil;
import com.ccclubs.gateway.jt808.constant.CommandStatus;
import com.ccclubs.gateway.jt808.constant.MsgTopicCon;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.constant.PackagePart;
import com.ccclubs.gateway.jt808.util.PacTranslateUtil;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: yeanzi
 * @Date: 2018/6/8
 * @Time: 14:54
 * Email:  yeanzhi@ccclubs.com
 * MQTT消息监听服务（只收不发）
 */
public class MqttMessageProcessService  implements IMessageProcessService {
    public static final Logger LOG = LoggerFactory.getLogger(MqttMessageProcessService.class);

    public MqttMessageProcessService() {

    }

    @Override
    public void processMsg(String upTopic, MqttMessage msg, String hexString) {
        // 如果是中岛升级指令
        if (upTopic.contains(MsgTopicCon.MQTT_UPGRADE)) {
            ByteBuf payloadBuf = Unpooled.wrappedBuffer(msg.getPayload());
            // 前11位为手机号字节
            byte[] uniqueNoBytes = new byte[11];
            payloadBuf.readBytes(uniqueNoBytes);
            // 终端手机号
            String uniqueNo = PacUtil.trim0InMobile(new String(uniqueNoBytes));
            // 终端对应连接
            ClientCache.getByUniqueNo(uniqueNo).ifPresent(client -> {
                if (client.getChannel().isActive()) {
                    client.getChannel().writeAndFlush(payloadBuf.copy());
                    // 便于ELK日志分析
                    LOG.info("({}):DOWN >> 7E000000010{}{}7E", uniqueNo, uniqueNo, hexString);
                } else {
                    LOG.error("client ({}) not active when deal sendout cmd1: {}", uniqueNo, hexString);
                }
            });
        } else {
            // 自定义完整的808消息数据(7E打头，7E结尾)，透传
            if (hexString.startsWith(PackageCons.PAC_START_SYMBOL_HEX) &&
                    hexString.endsWith(PackageCons.PAC_START_SYMBOL_HEX)) {

                ByteBuf sourceBuf = Unpooled.buffer();
                sourceBuf.writeBytes(msg.getPayload());

                // 消息转义: 还原消息
                PacTranslateUtil.translateUpPac(sourceBuf);

                // 读取终端手机号
                int mobileByteIndex = PackagePart.PAC_ID.getLen() + PackagePart.PAC_SERIAL_NO.getLen();
                // "1" 是： 跳过7E头部
                sourceBuf.readerIndex(1 + mobileByteIndex);
                ByteBuf mobileBuf = sourceBuf.readSlice(PackagePart.TER_MOBILE.getLen());
                String mobile = PacUtil.trim0InMobile(ByteBufUtil.hexDump(mobileBuf));

                ClientCache.getByUniqueNo(mobile).ifPresent(client -> {
                    if (client.getChannel().isActive()) {
                        // 终端在线
                        ByteBuf resetedSourceBuf =  sourceBuf.resetReaderIndex();

                        /**
                         * bug fix: 修改 消息下发前的转移还原
                         * 2018-7-30
                         */
                        resetedSourceBuf.readerIndex(resetedSourceBuf.readerIndex() + 1);
                        resetedSourceBuf.writerIndex(resetedSourceBuf.writerIndex() - 1);
                        // 执行去除7E部分后的转义
                        PacTranslateUtil.translateDownPac(resetedSourceBuf);
                        resetedSourceBuf.resetReaderIndex();
                        // 还原-包装7E
                        resetedSourceBuf.writeBytes(PackageCons.PAC_DECODE_DELIMITER);

                        client.getChannel().writeAndFlush(resetedSourceBuf.copy());
                        // 便于ELK日志分析
                        String downCmd = ByteBufUtil.hexDump(resetedSourceBuf);
                        LOG.info("({}): DOWN >> {}", mobile, downCmd);

                        if (CommandCache.isOpen() && CommandCache.isCurrent(mobile)) {
                            short serialNo808 = sourceBuf.getShort(PackagePart.PAC_SERIAL_NO.getStartIndex() + 1);
                            long serialNoMqtt = sourceBuf.getLong(22);
                            CommandCache.addCmd(mobile)
                                    .setSendTime(DateUtil.getNowStr())
                                    .setCommandStatus(CommandStatus.SEND)
                                    .setCmdHex(downCmd)
                                    .setSerialNo808(serialNo808)
                                    .setSerialNoMqtt(serialNoMqtt);
                        }
                    } else {
                        LOG.error("client ({}) not active when deal sendout cmd2: {}", mobile, hexString);
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        String sourceHex = "7e890000120648441648780000f154363739353232310000000000000003067E7E";

        ByteBuf sourceBuf = Unpooled.buffer().writeBytes(ByteBufUtil.decodeHexDump(sourceHex));
        sourceBuf.readerIndex(sourceBuf.readerIndex() + 1);
        sourceBuf.writerIndex(sourceBuf.writerIndex() - 1);
        System.out.println(ByteBufUtil.hexDump(sourceBuf));

        PacTranslateUtil.translateDownPac(sourceBuf);

        sourceBuf.resetReaderIndex();
        sourceBuf.writeBytes(PackageCons.PAC_DECODE_DELIMITER);
        System.out.println(ByteBufUtil.hexDump(sourceBuf));
    }
}
