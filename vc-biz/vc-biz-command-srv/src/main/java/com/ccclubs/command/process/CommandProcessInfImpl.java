package com.ccclubs.command.process;

import com.ccclubs.command.util.CommandMessageFactory;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.frm.mqtt.inf.IMqClient;
import com.ccclubs.frm.mqtt.util.MqttConstants;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.dao.CsRemoteDao;
import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.protocol.dto.jt808.T808Message;
import com.ccclubs.protocol.dto.mqtt.MqMessage;
import com.ccclubs.protocol.util.CmdUtils;
import com.ccclubs.protocol.util.ProtocolTools;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.protocol.util.Tools;
import com.ccclubs.pub.orm.model.CsMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CommandProcessInfImpl implements CommandProcessInf {

    /**
     * 通领，中导终端下发指令
     */
    @Resource(name = "aliyunMqttClient")
    private IMqClient mqttClient;
    /**
     * 富士康终端下发指令
     */
    @Resource(name = "ownMqttClient")
    private IMqClient customMqttClient;

    @Autowired
    CsRemoteDao rdao;

    @Autowired
    QueryTerminalService queryTerminalService;

    @Autowired
    CommandMessageFactory commandMessageFactory;

    private static Logger logger = LoggerFactory.getLogger(CommandProcessInfImpl.class);

    /**
     * 处理中岛http升级指令
     * @param csMachine
     * @param srcArray
     */
    @Override
    public void dealZdHttpUpdateCommand(CsMachine csMachine, byte[] srcArray) {
        String downTopic = commandMessageFactory.getP2pTopic(csMachine);
        if (StringUtils.empty(downTopic)) {
            return;
        }
        downTopic = downTopic + "update/";

        sendFinalMessage(csMachine, downTopic, srcArray, true);
    }

    /**
     * 处理远程指令
     * @param csMachine 待下发指令的终端
     * @param srcArray  待下发的指令字节数组
     * @param isUpdate  是升级指令
     */
    @Override
    public void dealRemoteCommand(CsMachine csMachine, byte[] srcArray, boolean isUpdate) {
        if (isUpdate) {
            String downTopic = commandMessageFactory.getP2pTopic(csMachine);
            if (StringUtils.empty(downTopic)) {
                return;
            }

            sendFinalMessage(csMachine, downTopic, srcArray, true);
        } else {
            sendMessage(csMachine, Tools.ToHexString(srcArray), srcArray);
        }
    }

    /**
     * 处理远程指令
     * @param remote
     * @param array
     */
    @Override
    public void dealRemoteCommand(CsRemote remote, Object[] array) {
        try {
            String resultCode = CmdUtils
                    .getSimpleMQTTRemoteCommend(remote.getCsrId(), remote.getCsrNumber(), array);

            if (!StringUtils.empty(resultCode)) {
                sendMessage(remote, resultCode);
            }

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            throw new ApiException(ApiEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 下发指令
     * @param csRemote
     * @param message
     */
    private void sendMessage(CsRemote csRemote, String message) {
        // 查询车机
        CsMachine machine = queryTerminalService.queryCsMachineByCarNumber(csRemote.getCsrNumber());
        if (null == machine) {
            throw new ApiException(ApiEnum.COMMAND_REQUIRED_TERMINAL_MISSING);
        }
        sendMessage(machine, message, Tools.HexString2Bytes(message));
    }

    /**
     * 对指定的内容发送
     * @param csMachine
     * @param message
     * @param srcArray
     */
    private void sendMessage(CsMachine csMachine, String message, byte[] srcArray) {
        MqMessage mqMessage = commandMessageFactory.getP2pMessage(csMachine, message, srcArray);
        if (mqMessage == null) {
            throw new ApiException(ApiEnum.TERMINAL_PROTOCOL_NOT_SUPPORT);
        }
        if (StringUtils.empty(mqMessage.getDownTopic())) {
            throw new ApiException(ApiEnum.TERMINAL_TOPIC_NOT_SET);
        }

        sendFinalMessage(csMachine, mqMessage.getDownTopic(), srcArray, false);
    }


    /**
     * 最终发送
     * @param csMachine     命令下发的车机
     * @param topic         主题
     * @param srcArray      指令字节数组
     * @param isT808Message 是否是808消息下发
     */
    private void sendFinalMessage(CsMachine csMachine, String topic, byte[] srcArray,
                                  boolean isT808Message) {
        // 富士康终端下发指令
        if (csMachine.getCsmProtocol() == 1L) {
            customMqttClient.send(topic, srcArray);
            return;
        }
        // 通领，中导车机下发指令
        if (isT808Message) {
            mqttClient.send(topic, srcArray);
        } else {
            T808Message ts = ProtocolTools.package2T808Message(csMachine.getCsmMobile().trim(), srcArray);
            mqttClient.send(topic, ts.WriteToBytes(), MqttConstants.QOS_1);
        }
    }

}
