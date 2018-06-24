package com.ccclubs.engine.rule.inf.consumer.handle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.ccclubs.common.query.QueryAppInfoService;
import com.ccclubs.engine.core.util.MessageFactory;
import com.ccclubs.engine.rule.inf.consumer.StreamEventConsumer;
import com.ccclubs.engine.rule.inf.dto.stream.SocJumpEvent;
import com.ccclubs.frm.spring.constant.OnsConst;
import com.ccclubs.frm.spring.util.EnvironmentUtils;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.SrvHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 电池电量跳变
 *
 * @author jianghaiyang
 * @create 2018-06-06
 **/
@Component
public class SocJumpEventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamEventConsumer.class);
    @Resource
    MessageFactory messageFactory;

    @Resource
    QueryAppInfoService queryHostInfoService;

    @Resource
    EnvironmentUtils environmentUtils;

    @Resource(name = "producer")
    private Producer client;

    public void handleSocJumpEvent(String event) {
        SocJumpEvent jumpEventObject = JSONObject.parseObject(event, SocJumpEvent.class);
        SrvHost srvHost = queryHostInfoService.queryHostByIdFromCache(jumpEventObject.getAccess());
        String message = JSON.toJSONString(jumpEventObject);
        Message mqMessage = messageFactory
                .getMessage(srvHost.getShTopic().trim(),
                        OnsConst.ONS_TAG_PREFIX_SOC_JUMP + jumpEventObject.getAccess(),
                        message.getBytes());
        if (mqMessage != null) {
            mqMessage
                    .setKey(
                            jumpEventObject.getVin() + "_" + StringUtils
                                    .date(new Date(), ConstantUtils.TIME_FORMAT));
            if (environmentUtils.isProdEnvironment()) {
                client.sendOneway(mqMessage);
            } else {
                LOGGER.debug(JSON.toJSONString(event));
            }
        } else {
            LOGGER.error(jumpEventObject.getVin() + " 未授权给应用");
        }
    }
}
