package com.ccclubs.gateway.gb.handler.process;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.gb.constant.ChannelAttrKey;
import com.ccclubs.gateway.gb.handler.decode.*;
import com.ccclubs.gateway.gb.handler.encode.GBPackageEncoder;
import com.ccclubs.gateway.gb.message.track.PacProcessTrack;
import com.ccclubs.gateway.gb.message.track.HandlerPacTrack;
import com.ccclubs.gateway.gb.utils.KafkaProperties;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @Author: yeanzi
 * @Date: 2018/4/4
 * @Time: 11:10
 * Email:  yeanzhi@ccclubs.com
 */
@Component
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    // 受监视的车辆的vin码
    public static Set<String> vins = new HashSet<>();

    public static boolean printPacLog;

//    @Autowired
//    private ApplicationContext context;

    @Autowired
    private KafkaProperties kafkaProperties;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 组装处理链路
        channel.pipeline()
                /*inbound*/
                // 空闲处理
                .addLast("idleHandler", new IdleStateHandler(300,0,0))
                // 记录监视的车辆报文
                .addLast("preHandler", new PreProcessHandler(kafkaTemplate, kafkaProperties))
                // 解码
                .addLast("gbDecoder", new GBLengthFieldFrameDecoder())
                // 数据包校验
                .addLast("validateHandler", new PackageValidateHandler())
                // 连接数据统计
                .addLast("connStatisticsHandler", new ConnStatisticsHandler(kafkaTemplate, kafkaProperties))
                // 业务处理
                .addLast("deliverHandler", new MsgDeliverHandler())
                // 过程保障
                .addLast("protectorHandler", new ProtecterHandler(kafkaTemplate, kafkaProperties))

                /*outbound*/
                // 编码器
                .addLast("GBEncoder", new GBPackageEncoder());

        /**
         * 在追踪处理异常时：
         *      初始化全局记录消息中被所有链路handler共享的数据
         */
        initPacTrack(channel);



        /**
         * 可以在运行时动态的编排handler顺序和增删新旧handler达到一些控流等功能
         *      如：1.可以依据消息头部，动态的给多种协议的报文组装处理流水线，而不仅仅处理GB协议报文
         *          2.依据流量情况，动态的在处理链中增加业务功能。
         */
    }

    private void initPacTrack(SocketChannel channel) {
        Attribute<PacProcessTrack> pacProcessTrackAttribute = channel.attr(ChannelAttrKey.PACTRACK_KEY);
        PacProcessTrack newPacProessTrack = new PacProcessTrack();
        newPacProessTrack
                .setErrorOccur(false)
                .setStep(0)
                .setExpMessageDTO(new ExpMessageDTO());
        HandlerPacTrack[] handlerPacTracks = new HandlerPacTrack[6];
        for (int i = 0; i < handlerPacTracks.length; i ++) {
            handlerPacTracks[i] = new HandlerPacTrack();
        }
        newPacProessTrack.setHandlerPacTracks(handlerPacTracks);

        pacProcessTrackAttribute.setIfAbsent(newPacProessTrack);
    }
}
