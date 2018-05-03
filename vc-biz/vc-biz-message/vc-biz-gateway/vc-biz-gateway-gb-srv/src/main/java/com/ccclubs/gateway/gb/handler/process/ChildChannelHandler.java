package com.ccclubs.gateway.gb.handler.process;

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
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Autowired
    private GBLengthFieldFrameDecoder gbLengthFieldFrameDecoder;

    @Autowired
    private PackageValidateHandler packageValidateHandler;

    @Autowired
    private ConnStatisticsHandler connStatisticsHandler;

    @Autowired
    private MsgDeliverHandler msgDeliverHandler;

    @Autowired
    private ProtecterHandler protecterHandler;

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline()
                /*inbound*/
                // 空闲处理
                .addLast("idleHandler", new IdleStateHandler(300,0,0))
                // 解码
                .addLast("gbDecoder", gbLengthFieldFrameDecoder)
                // 数据包校验
                .addLast("validateHandler", packageValidateHandler)
                // 连接数据统计
                .addLast("connStatisticsHandler", connStatisticsHandler)
                // 业务处理
                .addLast("deliverHandler", msgDeliverHandler)
                // 过程保障
                .addLast("protectorHandler", protecterHandler)

                /*outbound*/
                // 编码器
                .addLast("GBEncoder", new GBPackageEncoder());

        /**
         * 可以在运行时动态的编排handler顺序和增删新旧handler达到一些控流等功能
         *      如：1.可以依据消息头部，动态的给多种协议的报文组装处理流水线，而不仅仅处理GB协议报文
         *          2.依据流量情况，动态的在处理链中增加业务功能。
         */
    }
}
