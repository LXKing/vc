package com.ccclubs.engine.rule.inf.impl;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.engine.core.util.MachineMapping;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.core.util.RedisHelper;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.rule.inf.util.*;
import com.ccclubs.engine.rule.inf.IMqAckService;
import com.ccclubs.engine.rule.inf.IParseGbDataService;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.dto.jt808.*;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.inf.IMqMessageProcessService;
import com.ccclubs.protocol.inf.IParseDataService;
import com.ccclubs.protocol.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;

public class MqMessageProcessService implements IMqMessageProcessService {

    private static Logger logger = LoggerFactory.getLogger(MqMessageProcessService.class);

    private IMqAckService mqAckService;
    private IParseDataService parseDataService;
    private IParseGbDataService parseGbDataService;

    @Resource(name = "producer")
    private Producer client;

    @Value("${" + ConstantUtils.MQ_TOPIC + "}")
    String topic;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    MessageFactory messageFactory;

    @Resource
    LogicHelperJt808 logicHelperJt808;

    @Resource
    RedisHelper redisHelper;

    /**
     * 通过 TAG 区分是哪种协议
     *
     * @param tag          区分是哪种协议
     * @param upTopic      mqtt主题
     * @param srcByteArray 原始字节数组
     * @param hexString    原始字节十六进制字符串
     */
    @Override
    public void processAliMqMsg(String tag, String upTopic, final byte[] srcByteArray,
                                final String hexString) {
        if (StringUtils.empty(tag)) {
            tag = MqTagUtils.PROTOCOL_MQTT;
        }

        HashOperations ops = redisTemplate.opsForHash();
        // 808协议
        if (tag.startsWith(MqTagUtils.PROTOCOL_JT808)) {
            T808Message msgFromTerminal = new T808Message();
            msgFromTerminal.ReadFromBytes(srcByteArray);
            // 消息类型
            int headerType = msgFromTerminal.getHeader().getMessageType();

            MachineMapping mapping = (MachineMapping) ops.get(RuleEngineConstant.REDIS_KEY_SIMNO, msgFromTerminal.getSimNo());
            if (mapping == null || mapping.getMachine() == null || StringUtils.empty(mapping.getNumber())) {
                redisHelper.setNotExist(msgFromTerminal.getSimNo(), msgFromTerminal.getSimNo());
            }
            // 0x0200,0x0201,0x0704,0x0900
            if (headerType == 0x0200 || headerType == 0x0201) {
                // 定位补报，需要将补报的定位信息批量入库
                JT_0200 jvi;
                if (headerType == 0x0200) {
                    jvi = (JT_0200) msgFromTerminal.getMessageContents();
                } else {
                    JT_0201 jt = (JT_0201) msgFromTerminal.getMessageContents();
                    jvi = jt.getPositionReport();
                }
                if (jvi == null) {
                    return;
                }
                logicHelperJt808.saveStatusData(msgFromTerminal, jvi);
            } else if (headerType == 0x0704) {
                // 定位补报，需要将补报的定位信息批量入库
                JT_0704 rd = (JT_0704) msgFromTerminal.getMessageContents();
                List<JT_0200> packetList = rd.getPositionReportList();
                for (JT_0200 jvi : packetList) {
                    logicHelperJt808.saveStatusData(msgFromTerminal, jvi);
                }
            } else if (headerType == 0x0900) {
                // 终端对平台的上行透传
                JT_0900 ack = (JT_0900) msgFromTerminal.getMessageContents();
                if (ack == null) {
                    return;
                }

                int msgType = ack.getMessageType();
                // 0x01 can透传信息；0xFD can 补传信息
                if (msgType == 0x01 || (msgType & 0xFF) == 0xFD) {
                    byte[] msgContent = ack.getMessageContent();
                    JT_0900_can canData = new JT_0900_can();
                    canData.ReadFromBytes(msgContent);
                    if (msgType == 0x01) {
                        transferToMq(msgFromTerminal, MqTagProperty.MQ_TERMINAL_CAN);
                        logicHelperJt808.saveCanData(msgFromTerminal, canData);
                    } else {
                        transferToMq(msgFromTerminal, MqTagProperty.MQ_TERMINAL_CAN_FD);
                        logicHelperJt808.saveCanData(msgFromTerminal, canData, ConstantUtils.NOTIFY_FD);
                    }
                }
            }
            return;
        }

        // 国标协议
        if (tag.startsWith(MqTagUtils.PROTOCOL_GB)) {
            GBMessage gbMessage = new GBMessage();
            gbMessage.ReadFromBytes(srcByteArray);

            if (gbMessage == null || gbMessage.getHeader() == null) {
                return;
            }

            MachineMapping mapping = (MachineMapping) ops.get(RuleEngineConstant.REDIS_KEY_VIN,gbMessage.getVin());
            if (mapping == null || mapping.getCar() == null) {
                redisHelper.setNotExist(gbMessage.getVin(), gbMessage.getVin());
            }

            getParseGbDataService().processMessage(gbMessage, srcByteArray);
            return;
        }

        // MQTT 分时租赁 协议
        if (tag.startsWith(MqTagUtils.PROTOCOL_MQTT)) {
            MqMessage mqMessage = new MqMessage();
            mqMessage.ReadFromBytes(srcByteArray);

            MachineMapping mapping = (MachineMapping) ops.get(RuleEngineConstant.REDIS_KEY_CARNUM,mqMessage.getCarNumber());

            if (mapping == null || mapping.getMachine() == null || StringUtils.empty(mapping.getNumber())) {
                redisHelper.setNotExist(mqMessage.getCarNumber(), mqMessage.getCarNumber());
            }

            if (mqMessage != null && !StringUtils.empty(mqMessage.getCarNumber())) {
                mqMessage.setUpTopic(upTopic);
                mqMessage.setHexString(hexString);
                // 设置时间有效性，暂时设置为 60*1000 ，主要用于流转
                mqMessage.setTimeStamp(System.currentTimeMillis());

                // 消息入库
                getParseDataService().processMessage(mqMessage);

                // 启动应答服务
                getMqAckService().beginAck(mqMessage);
            }
            return;
        }
    }

    /**
     * 转发到MQ，topic：terminal，tag
     */
    private void transferToMq(T808Message message, String tag) {
        try {
            Message mqMessage = messageFactory
                    .getMessage(topic, tag, message);

            if (mqMessage != null) {
                client.send(mqMessage);
            } else {
                logger.error(message.getSimNo() + " 未授权给应用");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
    }

    public Producer getClient() {
        return client;
    }

    public void setClient(Producer client) {
        this.client = client;
    }

    public IMqAckService getMqAckService() {
        return mqAckService;
    }

    public void setMqAckService(IMqAckService mqAckService) {
        this.mqAckService = mqAckService;
    }

    public IParseDataService getParseDataService() {
        return parseDataService;
    }

    public void setParseDataService(IParseDataService parseDataService) {
        this.parseDataService = parseDataService;
    }

    public IParseGbDataService getParseGbDataService() {
        return parseGbDataService;
    }

    public void setParseGbDataService(IParseGbDataService parseGbDataService) {
        this.parseGbDataService = parseGbDataService;
    }
}
