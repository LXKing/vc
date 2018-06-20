package com.ccclubs.gateway.jt808.service;

import com.ccclubs.frm.mqtt.inf.IMessageProcessService;
import com.ccclubs.gateway.common.connection.ClientConnCollection;
import com.ccclubs.gateway.jt808.constant.MsgTopicCon;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.constant.PackagePart;
import com.ccclubs.gateway.jt808.process.conn.JTClientConn;
import com.ccclubs.gateway.jt808.util.PacTranslateUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/6/8
 * @Time: 14:54
 * Email:  yeanzhi@ccclubs.com
 * MQTT消息监听服务（只收不发）
 */
public class MqttMessageProcessService  implements IMessageProcessService {
    public static final Logger LOG = LoggerFactory.getLogger(MqttMessageProcessService.class);

    @Override
    public void processMsg(String upTopic, MqttMessage msg, String hexString) {
        // 如果是中岛升级指令
        if (upTopic.contains(MsgTopicCon.MQTT_UPGRADE)) {
            ByteBuf payloadBuf = Unpooled.wrappedBuffer(msg.getPayload());
            // 前11位为手机号字节
            byte[] uniqueNoBytes = new byte[11];
            payloadBuf.readBytes(uniqueNoBytes);
            // 终端手机号
            String uniqueNo = new String(uniqueNoBytes);
            // 终端对应连接
            JTClientConn conn = (JTClientConn) ClientConnCollection.getByUniqueNo(uniqueNo);
            if (Objects.nonNull(conn) && conn.isOnline()) {
                // 终端在线
                conn.send(payloadBuf.copy());
                // 便于ELK日志分析
                LOG.info("DOWN >> 7E000000010{}{}7E", uniqueNo, hexString);
            }
        } else {
            // 自定义完整的808消息数据(7E打头，7E结尾)，透传
            if (hexString.startsWith(PackageCons.PAC_START_SYMBOL_HEX) &&
                    hexString.endsWith(PackageCons.PAC_START_SYMBOL_HEX)) {

                ByteBuf sourceBuf = Unpooled.buffer();
                sourceBuf.writeBytes(msg.getPayload());

                // 测试代码：
//                    sourceBuf.writeBytes(ByteBufUtil.decodeHexDump("7E890000160646215611440001F154363731303337390000000007D01A9251061012FF00817E"));

                // 消息转义: 还原消息
                PacTranslateUtil.translateUpPac(sourceBuf);

                // 读取终端手机号
                int mobileByteIndex = PackagePart.PAC_ID.getLen() + PackagePart.PAC_SERIAL_NO.getLen();
                // "1" 是： 跳过7E头部
                sourceBuf.readerIndex(1 + mobileByteIndex);
                ByteBuf mobileBuf = sourceBuf.readSlice(PackagePart.TER_MOBILE.getLen());
                String mobile = ByteBufUtil.hexDump(mobileBuf);

                // 终端对应连接
                JTClientConn conn = (JTClientConn) ClientConnCollection.getByUniqueNo(mobile);
                if (Objects.nonNull(conn) && conn.isOnline()) {
                    // 便于ELK日志分析
                    LOG.info("DOWN >> {}", ByteBufUtil.hexDump(sourceBuf.resetReaderIndex()));
                    // 终端在线
                    conn.send(sourceBuf.copy());
                }
            }
        }
    }
}
