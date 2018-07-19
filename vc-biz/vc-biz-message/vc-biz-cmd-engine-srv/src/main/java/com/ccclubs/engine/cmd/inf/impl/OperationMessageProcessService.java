package com.ccclubs.engine.cmd.inf.impl;


import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.inf.IMqMessageProcessService;
import com.ccclubs.protocol.inf.IParseDataService;
import com.ccclubs.protocol.util.MqTagUtils;
import com.ccclubs.protocol.util.StringUtils;

/**
 * 处理远程控制
 */
public class OperationMessageProcessService implements IMqMessageProcessService {

    //注入parseDataService
    private IParseDataService parseDataService;

    /**
     * 处理消息
     * @param tag 区分是哪种协议
     * @param upTopic mqtt主题
     * @param srcByteArray 原始字节数组
     * @param hexString 原始字节十六进制字符串
     */
    @Override
    public void processAliMqMsg(String tag, String upTopic, final byte[] srcByteArray,
                                final String hexString) {
        // 不处理tag为空的消息
        if (StringUtils.empty(tag)) {
            return;
        }

        // MQTT 分时租赁 协议
        if (tag.startsWith(MqTagUtils.PROTOCOL_MQTT)) {
            MqMessage mqMessage = new MqMessage();
            // 字节数组转消息对象
            mqMessage.ReadFromBytes(srcByteArray);
            // 从消息中取出基本属性赋值消息对象
            if (mqMessage != null && StringUtils.notEmpty(mqMessage.getCarNumber())) {
                //topic
                mqMessage.setUpTopic(upTopic);
                //原始报文
                mqMessage.setHexString(hexString);
                // 设置时间有效性，暂时设置为 60*1000 ，主要用于流转
                mqMessage.setTimeStamp(System.currentTimeMillis());
                // 消息入库
                getParseDataService().processMessage(mqMessage);
            }
        }
    }

    /**
     * getParseDataService
     * @return
     */
    public IParseDataService getParseDataService() {
        return parseDataService;
    }

    /**
     * setParseDataService
     * @param parseDataService
     */
    public void setParseDataService(IParseDataService parseDataService) {
        this.parseDataService = parseDataService;
    }
}
