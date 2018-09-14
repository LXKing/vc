package com.ccclubs.gateway.gb.handler.process;

import com.ccclubs.gateway.common.config.GatewayProperties;
import com.ccclubs.gateway.common.constant.ChannelAttrKey;
import com.ccclubs.gateway.common.inf.ChildChannelHandler;
import com.ccclubs.gateway.gb.handler.decode.*;
import com.ccclubs.gateway.gb.handler.encode.GBPackageEncoder;
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
public class GbChildChannelHandler extends ChannelInitializer<SocketChannel> implements ChildChannelHandler {

//    @Autowired
//    private ApplicationContext context;

    @Autowired
    private GatewayProperties gatewayProperties;

    /*shared inbound handlers*/
    @Autowired
    private PackageValidateHandler packageValidateHandler;
    @Autowired
    private AuthticationHandler authticationHandler;
    @Autowired
    private ConnStatisticsHandler connStatisticsHandler;
    @Autowired
    private MsgDeliverHandler msgDeliverHandler;
    @Autowired
    private SendOutHandler sendOutHandler;
    @Autowired
    private ProtecterHandler protecterHandler;

    /*shared outbound handlers*/
    @Autowired
    private GBPackageEncoder gbPackageEncoder;



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
                .addLast("connStatisticsHandler", connStatisticsHandler)
                // 业务处理
                .addLast("deliverHandler", msgDeliverHandler)
                // 内部消息发送处理器
                .addLast("sendOutHandler", sendOutHandler)
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
