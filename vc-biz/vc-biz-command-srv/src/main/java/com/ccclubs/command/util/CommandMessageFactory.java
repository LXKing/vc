package com.ccclubs.command.util;

import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsMachine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 指令模块，下行消息构造
 */
@Component
public class CommandMessageFactory {
    /**
     *
     */
    private final static String COMMOND_DOWN_STREAM_TEMPLATE = "car/ser/{0}/rt_0/{1}/pri_3";
    /**
     * 让808协议网关接收到的消息 tag
     */
    public final static String TOPIC_PROTOCOL_TAG = "jt808";
    /**
     * 自有mqtt协议，众车相关应用使用的消息 tag
     */
    public final static String DEFAULT_TOPIC_MQTT_TAG = "jhz";

    /**
     * 终端直连MQ所使用的 topic
     */
    @Value("${mqtt.topic.car}")
    public String topicCar;
    /**
     * 808网关订阅的 topic
     */
    @Value("${mqtt.topic.protocol}")
    public String topicProtocol;
    /**
     * mqtt组
     */
    @Value("${mqtt.topic.gid}")
    public String topicGid;



    /**
     * 针对指定车机，发送消息，点对点发送
     */
    public MqMessage getP2pMessage(CsMachine csMachine, String message,
                                          final byte[] srcByteArray) {
        if (csMachine == null) {
            return null;
        }

        MqMessage mqMessage = new MqMessage();
        mqMessage.ReadFromBytes(srcByteArray);
        mqMessage.setHexString(message);

        mqMessage.setDownTopic(getP2pTopic(csMachine));

        if (StringUtils.empty(mqMessage.getDownTopic())) {
            return null;
        }

        return mqMessage;
    }

    /**
     * 通过车机，发送消息
     */
    public String getP2pTopic(CsMachine csMachine) {
        if (csMachine.getCsmProtocol() == null || StringUtils.empty(csMachine.getCsmNumber())) {
            return null;
        } else if (csMachine.getCsmProtocol() == 3L) {
            // MQTT协议
            return new StringBuilder().append(topicCar).append("/p2p/").append(topicGid).append("@@@").append(csMachine.getCsmNumber()).toString();
        } else if (csMachine.getCsmProtocol() == 2L) {
            // 808协议
            return topicProtocol + "/" + TOPIC_PROTOCOL_TAG + "/";
        } else if (csMachine.getCsmProtocol() == 1L) {
            // MQ
            if (StringUtils.empty(csMachine.getCsmMqttFlag())) {
                return COMMOND_DOWN_STREAM_TEMPLATE.replace("{1}", csMachine.getCsmNumber())
                        .replace("{0}", DEFAULT_TOPIC_MQTT_TAG);
            } else {
                return csMachine.getCsmMqttFlag().trim();
            }
        }
        return null;
    }
}
