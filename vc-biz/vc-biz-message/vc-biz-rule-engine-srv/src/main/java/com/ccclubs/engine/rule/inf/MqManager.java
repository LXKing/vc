package com.ccclubs.engine.rule.inf;

import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.frm.mqtt.inf.IMqClient;
import com.ccclubs.frm.mqtt.util.MqttConstants;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MqManager {

    private static Logger logger = LoggerFactory.getLogger(MqManager.class);

    private IMqClient mqClient;
    private IMqClient mqttClient;

    /**
     * 应答服务
     */
    private IMqAckService mqAckService;

    @Resource
    QueryTerminalService queryTerminalService;

    @Resource
    MessageFactory messageFactory;

    @Value("${"+ConstantUtils.LOG_SHOW_SOURCE+"}")
    String showAllLog;

    /**
     * 发送数据
     * 默认为p2p，点对点消息
     */
    public void Send(MqMessage msg) {
        CsMachine csMachine = queryTerminalService.queryCsMachineByCarNumber(msg.getCarNumber());
        if (csMachine == null || msg == null) {
            return;
        }
        String downTopic = messageFactory.getP2pTopic(csMachine);

        if (StringUtils.empty(downTopic)) {
            return;
        }

        if (csMachine.getCsmProtocol() == 1L) {
            getMqttClient().send(downTopic, msg.WriteToBytes());
            return;
        }

        T808Message ts = ProtocolTools
                .package2T808Message(csMachine.getCsmMobile().trim(), msg.WriteToBytes());
        getMqClient().send(downTopic, ts.WriteToBytes(), MqttConstants.QOS_1);
    }

    /**
     * 启动Client服务
     */
    public boolean startServer() {
        GlobalConfig.setShowSoure(Boolean.valueOf(showAllLog));
        // 应答服务，调用Client，发送应答数据包
        mqAckService.setMessageSender(new IMqMessageSender() {
            @Override
            public void sendMqMessage(MqMessage tm) {
                Send(tm);
            }
        });
        return true;
    }

    /**
     * 停止服务
     */
    public void stopServer() {
        try {
            getMqClient().stop();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public IMqAckService getMqAckService() {
        return mqAckService;
    }

    public void setMqAckService(IMqAckService mqAckService) {
        this.mqAckService = mqAckService;
    }

    public IMqClient getMqClient() {
        return mqClient;
    }

    public void setMqClient(IMqClient mqClient) {
        this.mqClient = mqClient;
    }

    public IMqClient getMqttClient() {
        return mqttClient;
    }

    public void setMqttClient(IMqClient mqttClient) {
        this.mqttClient = mqttClient;
    }
}
