package com.ccclubs.gateway.jt808.process;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.common.bean.track.HandlerPacTrack;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.constant.ChannelAttrKey;
import com.ccclubs.gateway.common.inf.ChildChannelHandler;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.process.decoder.BizHandlerFor808;
import com.ccclubs.gateway.jt808.process.decoder.Package808BaseDecoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.Attribute;
import org.springframework.stereotype.Component;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 15:52
 * Email:  yeanzhi@ccclubs.com
 * 808初始化ChildChannelHandler
 */
@Component
public class ChildChannelHandler808Impl extends ChannelInitializer<SocketChannel> implements ChildChannelHandler {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        // 组装处理链路
        channel.pipeline()
                /*inbound*/
                // 空闲处理
                .addLast("idleHandler", new IdleStateHandler(300,0,0))
                // 记录监视的车辆报文
//                .addLast("preHandler", preProcessHandler)
                // 解码
                .addLast("808Decoder", new Package808BaseDecoder(14,4096, PackageCons.PAC_DECODE_DELIMITER))
                // 数据包校验
//                .addLast("validateHandler", packageValidateHandler)
                // 连接数据统计
//                .addLast("connStatisticsHandler", new ConnStatisticsHandler(kafkaService))
                // 业务处理
                .addLast("bizHandler", new BizHandlerFor808());
                // 过程保障
//                .addLast("protectorHandler", protecterHandler)

                /*outbound*/
                // 编码器
//                .addLast("GBEncoder", gbPackageEncoder);

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
