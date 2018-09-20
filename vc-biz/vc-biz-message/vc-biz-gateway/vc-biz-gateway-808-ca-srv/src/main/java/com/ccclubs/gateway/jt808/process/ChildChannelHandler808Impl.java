package com.ccclubs.gateway.jt808.process;

import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.gateway.common.bean.track.ChannelLifeCycleTrack;
import com.ccclubs.gateway.common.bean.track.HandlerPacTrack;
import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.config.GatewayProperties;
import com.ccclubs.gateway.common.constant.ChannelAttrKey;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.inf.ChildChannelHandler;
import com.ccclubs.gateway.jt808.constant.PacProcessing;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.process.decoder.*;
import com.ccclubs.gateway.jt808.process.encoder.PackageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.Attribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public static final Logger LOG = LoggerFactory.getLogger(ChildChannelHandler808Impl.class);

    /*shared channel handlers*/
    @Autowired
    private ValidatePacHandler validatePacHandler;
    @Autowired
    private AuthConnectionHandler authConnectionHandler;
    @Autowired
    private AckHandler ackHandler;
    @Autowired
    private StatisticsHandler statisticsHandler;
    @Autowired
    private BizHandler bizHandler;
    @Autowired
    private SendOutHandler sendOutHandler;
    @Autowired
    private AllExceptionHandler exceptionHandler;

    /**
     * 用于监控用的处理器
     *      后面将会删除
     */
    @Autowired
    private PreProcessHandler preProcessHandler;

    @Autowired
    private GatewayProperties gatewayProperties;

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        // 组装处理链路
        channel.pipeline()

                /*inbound*/
                // 空闲处理
                .addLast("idleHandler", new IdleStateHandler(gatewayProperties.getIdleSeconds(),0,0))
                // 记录监视的车辆报文
//                .addLast("preHandler", preProcessHandler)
                // 数据包解码
                .addLast("808Decoder", new PackageBaseDecoder(13,4096, PackageCons.PAC_DECODE_DELIMITER))
                // 数据包校验
                .addLast("validateHandler", validatePacHandler)
                // 连接身份认证
                .addLast("AuthHandler", authConnectionHandler)
                // 应答处理
                .addLast("ackHandler", ackHandler)
                // 数据统计
                .addLast("statisticsHandler", statisticsHandler)
                // 业务处理
                .addLast("bizHandler", bizHandler)
                // 对外发送处理
                .addLast("outSendHandler", sendOutHandler)
                // 异常拦截处理
                .addLast("exceptionHandler", exceptionHandler)

                /*outbound*/
                // 编码器
                .addLast("808Encoder", new PackageEncoder());

        /**
         * 初始化全链路共享的channelAttribute
         */
        ChannelAttrKey.initForAll(channel);
    }
}
