package com.ccclubs.gateway.gb.handler.process;

import com.ccclubs.gateway.common.config.GatewayProperties;
import com.ccclubs.gateway.common.constant.ChannelAttrKey;
import com.ccclubs.gateway.gb.handler.decode.*;
import com.ccclubs.gateway.gb.handler.encode.GBPackageEncoder;
import com.ccclubs.gateway.gb.service.KafkaService;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @Author: yeanzi
 * @Date: 2018/4/4
 * @Time: 11:10
 * Email:  yeanzhi@ccclubs.com
 */
@Component
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

//    @Autowired
//    private ApplicationContext context;

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private GatewayProperties gatewayProperties;

    /*shared handlers*/
    @Autowired
    private ProtecterHandler protecterHandler;
    @Autowired
    private MsgDeliverHandler msgDeliverHandler;
    @Autowired
    private PackageValidateHandler packageValidateHandler;

    @Autowired
    private GBPackageEncoder gbPackageEncoder;
    @Autowired
    private AuthticationHandler authticationHandler;

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 组装处理链路
        channel.pipeline()
                /*inbound*/
                // 空闲处理
                .addLast("idleHandler", new IdleStateHandler(gatewayProperties.getIdleSeconds(),0,0))
                // 解码
                .addLast("gbDecoder", new GBLengthFieldFrameDecoder(4096))
                // 数据包校验
                .addLast("validateHandler", packageValidateHandler)
                // 数据权限校验
                .addLast("authticationHandler", authticationHandler)
                // 连接数据统计
                .addLast("connStatisticsHandler", new ConnStatisticsHandler(kafkaService))
                // 业务处理
                .addLast("deliverHandler", msgDeliverHandler)
                // 过程保障
                .addLast("protectorHandler", protecterHandler)

                /*outbound*/
                // 编码器
                .addLast("gbEncoder", gbPackageEncoder);

        /**
         * 初始化全链路共享的channelAttribute
         */
        ChannelAttrKey.initForAll(channel);

    }
}
