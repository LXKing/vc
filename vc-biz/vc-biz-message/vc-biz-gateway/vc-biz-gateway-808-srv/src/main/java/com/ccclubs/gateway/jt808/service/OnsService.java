package com.ccclubs.gateway.jt808.service;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.gateway.common.config.TcpServerConf;
import com.ccclubs.gateway.common.dto.OnsTask;
import com.ccclubs.protocol.util.ConstantUtils;
import io.netty.buffer.ByteBufUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: yeanzi
 * @Date: 2018/6/5
 * @Time: 14:01
 * Email:  yeanzhi@ccclubs.com
 * 阿里云消息队列服务
 */
@Service
public class OnsService {
    private static final Logger LOG = LoggerFactory.getLogger(OnsService.class);

    @Value("${" + ConstantUtils.MQ_TOPIC + "}")
    String topic;
    @Resource(name = "onsPublishClient")
    private Producer client;

    /**
     * 将jt808协议数据转发到消息中间件MQ，topic：ser，tag：jt808
     */
    public void sendOneway(OnsTask task) {
        // TODO 参数校验

        Message mqMessage = new Message(
                topic,
                task.getTag(),
                ByteBufUtil.decodeHexDump(task.getSourceHex())
        );

        // 如果打印开启则为测试环境，不需要真实发送到ons
        if (TcpServerConf.GATEWAY_PRINT_LOG) {
            LOG.info("发送ons消息完成, msg={}", JSON.toJSONString(task));
        } else {
            client.sendOneway(mqMessage);
        }
    }

}
