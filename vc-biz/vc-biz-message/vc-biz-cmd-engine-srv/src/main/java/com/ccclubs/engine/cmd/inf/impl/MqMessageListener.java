package com.ccclubs.engine.cmd.inf.impl;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.ccclubs.protocol.inf.IMqMessageProcessService;
import com.ccclubs.protocol.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理网关指令结果ONS消息
 */
public class MqMessageListener implements MessageListener {

    //日志对象
    private static Logger logger = LoggerFactory.getLogger(MqMessageListener.class);

    //set方式注入
    private IMqMessageProcessService mqMessageProcessService;

    /**
     * 消费网关指令结果ONS消息
     * @param message
     * @param context
     * @return
     */
    @Override
    public Action consume(Message message, ConsumeContext context) {
        try {
            //从ons消息中获取报文
            final String hexString = Tools.ToHexString(message.getBody());

            /**
             * 调用消息处理服务
             */
            getMqMessageProcessService()
                    .processAliMqMsg(message.getTag(), message.getUserProperties("topic"), message.getBody(),
                            hexString);
            //消费完成，提交
            return Action.CommitMessage;
        } catch (Exception e) {
            //消费失败
            logger.error(e.getMessage(), e);
            return Action.ReconsumeLater;
        }
    }

    /**
     * 获取消息处理服务
     * @return
     */
    public IMqMessageProcessService getMqMessageProcessService() {
        return mqMessageProcessService;
    }

    /**
     * 设置mqMessageProcessService
     * @param mqMessageProcessService
     */
    public void setMqMessageProcessService(IMqMessageProcessService mqMessageProcessService) {
        this.mqMessageProcessService = mqMessageProcessService;
    }

}
