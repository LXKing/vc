package com.ccclubs.engine.cmd.inf.impl;


import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.inf.IMqMessageProcessService;
import com.ccclubs.protocol.inf.IParseDataService;
import com.ccclubs.protocol.util.MqTagUtils;
import com.ccclubs.protocol.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理远程控制
 */
public class OperationMessageProcessService implements IMqMessageProcessService {

    private static Logger logger = LoggerFactory.getLogger(OperationMessageProcessService.class);

    private IParseDataService parseDataService;

    @Override
    public void processAliMqMsg(String tag, String upTopic, final byte[] srcByteArray,
                                final String hexString) {
        if (StringUtils.empty(tag)) {
            return;
        }

        // MQTT 分时租赁 协议
        if (tag.startsWith(MqTagUtils.PROTOCOL_MQTT)) {
            MqMessage mqMessage = new MqMessage();
            mqMessage.ReadFromBytes(srcByteArray);
            if (mqMessage != null && StringUtils.notEmpty(mqMessage.getCarNumber())) {
                mqMessage.setUpTopic(upTopic);
                mqMessage.setHexString(hexString);
                // 设置时间有效性，暂时设置为 60*1000 ，主要用于流转
                mqMessage.setTimeStamp(System.currentTimeMillis());
                // 消息入库
                logger.info("start update csRemote in mongo...");
                getParseDataService().processMessage(mqMessage);
            }
        }
    }

    public IParseDataService getParseDataService() {
        return parseDataService;
    }

    public void setParseDataService(IParseDataService parseDataService) {
        this.parseDataService = parseDataService;
    }
}
