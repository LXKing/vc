package com.ccclubs.gateway.gb.handler.decode;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.gateway.gb.beans.KafkaTask;
import com.ccclubs.gateway.gb.constant.KafkaSendTopicType;
import com.ccclubs.gateway.gb.handler.process.ChildChannelHandler;
import com.ccclubs.gateway.gb.service.KafkaService;
import com.ccclubs.gateway.gb.service.VehicleService;
import com.ccclubs.gateway.gb.utils.DecodeUtil;
import com.ccclubs.gateway.gb.config.KafkaProperties;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/5/16
 * @Time: 10:11
 * Email:  yeanzhi@ccclubs.com
 * 前置处理处理器
 */
@Component
@ChannelHandler.Sharable
public class PreProcessHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(PreProcessHandler.class);

    @Autowired
    private KafkaService kafkaService;
    @Autowired
    private VehicleService vehicleService;

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
            if (vehicleService.getAll().contains(vin)) {
                JSONObject json = new JSONObject();
                json.put("createTime", System.currentTimeMillis());
                json.put("sourceHex", sourceHex);
                json.put("usedTime", allEndTime - allStartTime);
                kafkaService.send(new KafkaTask(KafkaSendTopicType.OVERSEE,
                        vin,
                        json.toJSONString()));
            }
        }

        LOG.debug("报文[{}]处理时间为：{}", sourceHex, allEndTime - allStartTime);
    }
}
