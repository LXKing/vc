package com.ccclubs.gateway.gb.handler.decode;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.gateway.gb.handler.process.ChildChannelHandler;
import com.ccclubs.gateway.gb.utils.DecodeUtil;
import com.ccclubs.gateway.gb.utils.KafkaProperties;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @Author: yeanzi
 * @Date: 2018/5/16
 * @Time: 10:11
 * Email:  yeanzhi@ccclubs.com
 * 前置处理处理器
 */
public class PreProcessHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(PreProcessHandler.class);

    private KafkaTemplate kafkaTemplate;

    private KafkaProperties kafkaProperties;

    public PreProcessHandler(KafkaTemplate kafkaTemplate, KafkaProperties kafkaProperties) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaProperties = kafkaProperties;
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf sourceBuf = (ByteBuf) msg;
        // 获取包中的vin码
        String vin = DecodeUtil.getVinFromByteBuf(sourceBuf);
        // 原始报文(包括粘包的整包数据)
        String sourceHex = ByteBufUtil.hexDump(sourceBuf);

        long allStartTime = System.nanoTime();
        // 开始处理
        super.channelRead(ctx, msg);
        long allEndTime = System.nanoTime();



        // 记录监控车辆的数据
        if (StringUtils.isNotEmpty(vin)) {
            if (ChildChannelHandler.vins.contains(vin)) {
                JSONObject json = new JSONObject();
                json.put("sourceHex", sourceHex);
                json.put("usedTime", allEndTime - allStartTime);
                kafkaTemplate.send(kafkaProperties.getTest(),
                        vin,
                        json.toJSONString());
            }
        }

        LOG.debug("报文[{}]处理时间为：{}", sourceHex, allEndTime - allStartTime);
    }
}
