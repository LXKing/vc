package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.gateway.gb.constant.PacProcessing;
import com.ccclubs.gateway.gb.dto.ConnOnlineStatusEvent;
import com.ccclubs.gateway.gb.dto.OtherProcessExceptionDTO;
import com.ccclubs.gateway.gb.dto.PackProcessExceptionDTO;
import com.ccclubs.gateway.gb.dto.ProtecterExceptionDTO;
import com.ccclubs.gateway.gb.handler.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.handler.process.ChildChannelHandler;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.track.HandlerPacTrack;
import com.ccclubs.gateway.gb.message.track.PacProcessTrack;
import com.ccclubs.gateway.gb.reflect.ClientCache;
import com.ccclubs.gateway.gb.reflect.GBConnection;
import com.ccclubs.gateway.gb.utils.ChannelPacTrackUtil;
import com.ccclubs.gateway.gb.utils.KafkaProperties;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/3/24
 * @Time: 21:41
 * Email:  yeanzhi@ccclubs.com
 *      守卫在最后底线的处理器
 */
public class ProtecterHandler extends CCClubChannelInboundHandler<GBPackage> {
    private static final Logger LOG = LoggerFactory.getLogger(ProtecterHandler.class);

//    @Autowired
    private KafkaProperties kafkaProperties;

//    @Autowired
    private KafkaTemplate kafkaTemplate;

    public ProtecterHandler(KafkaTemplate kafkaTemplate, KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void channelRead0 (ChannelHandlerContext ctx, GBPackage pac) throws Exception {
        // 输出消息处理轨迹信息
        ProtecterExceptionDTO protecterExceptionDTO = new ProtecterExceptionDTO();
        PacProcessTrack pacProcessTrack = beforeProcess(ctx, protecterExceptionDTO);

        pacProcessTrack.getCurrentHandlerTracker().setEndTime(System.nanoTime());

        // 如果是测试阶段则打印报告日志
        if (ChildChannelHandler.printPacLog) {
            StringBuilder trackSb = new StringBuilder(pac.toLogString());
            trackSb.append("\n")
                    .append("消息处理各个阶段用时：");
            int stepIndex = 0;
            for (HandlerPacTrack ht : pacProcessTrack.getHandlerPacTracks()) {
                trackSb.append("step-").append(PacProcessing.getByCode(stepIndex ++).getDes())
                        .append("[").append(ht.getEndTime() - ht.getStartTime()).append("]");
            }
            LOG.info(trackSb.toString());
        }

        String topic = kafkaProperties.getSuccess();
        PackProcessExceptionDTO packProcessExceptionDTO = new PackProcessExceptionDTO();
        packProcessExceptionDTO.setCode(pac.getHeader().getCommandMark().getCode())
                .setVin(pac.getHeader().getUniqueNo())
                .setSourceHex(pac.getSourceHexStr());
        // 正常的消息发送至kafka
        kafkaTemplate.send(topic, packProcessExceptionDTO.toJson());



        /**
         *  最终处理消息，不需要继续向下传递消息
         *      1.释放字节缓存
         */
        ReferenceCountUtil.release(pac.getSourceBuff());
    }

    @Override
    public void channelActive(ChannelHandlerContext context) {
        LOG.info("新链接建立");
        SocketChannel channel = (SocketChannel)context.channel();
        ClientCache.addByChannelId(channel.id());
    }

    @Override
    public void channelInactive(ChannelHandlerContext context) {
        LOG.info("连接被释放");
        SocketChannel channel = (SocketChannel)context.channel();
        GBConnection conn = ClientCache.getByChannelId(channel.id());
        ConnOnlineStatusEvent connOnlineStatusEvent = new ConnOnlineStatusEvent();
        if (Objects.nonNull(conn) && conn.isConnected()) {
            connOnlineStatusEvent.setVin(conn.getVin())
                    .setOnline(false)
                    .setTimestamp(System.currentTimeMillis())
                    .setClientIp(channel.remoteAddress().getHostString())
                    .setServerIp(channel.localAddress().getHostString());
        }

        boolean connClosedSuccess = ClientCache.closeWhenInactive((SocketChannel) context.channel());
        if (connClosedSuccess) {
            kafkaTemplate.send(kafkaProperties.getConn(), connOnlineStatusEvent.toJson());
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent) {
            // 连接长时间空闲事件
            IdleStateEvent e = (IdleStateEvent) evt;
            if (IdleState.READER_IDLE == e.state()) {
                // 读空闲
                LOG.warn("连接长时间空闲，将关闭该连接");
                ctx.close();
                // 事件触发后，最终会触发ChannelInActive方法

            } else if (IdleState.WRITER_IDLE == e.state()) {
                // 写空闲
            } else if (IdleState.ALL_IDLE == e.state()) {
                // 读写都异常
            }
        } else {

        }

        // 事件下传
//        ctx.fireUserEventTriggered(evt);
    }

    /**
     * 所有调用链中的异常都在这里处理
     * @param context
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) throws Exception {
        // 部分异常可能需要服务端主动释放连接
        boolean needCloseConn = false;

        /**
         * 处理链路出现异常后
         *  1.获取异常链路中的轨迹信息
         *  2.按照异常轨迹判断
         *      如果是链路上主动抛出的异常：获取对应的异常dto信息
         *      如果是链路上非主动抛出：组装其他异常dto
         *  3.发送至kafka
         */
        PacProcessTrack pacProcessTrack = ChannelPacTrackUtil.getPacTracker(context.channel());
        HandlerPacTrack[] handlerPacTracks = pacProcessTrack.getHandlerPacTracks();

        PacProcessing pacProcessing = PacProcessing.getByCode(pacProcessTrack.getStep());
        if (Objects.nonNull(pacProcessing)) {
            LOG.error("[{}]发生异常，异常原因：{}", pacProcessing.getDes(), cause.getMessage());
        } else {
            LOG.error("exception throwed but step invalid step={}", pacProcessTrack.getStep());
        }

        PackProcessExceptionDTO packProcessExceptionDTO = new PackProcessExceptionDTO();
        packProcessExceptionDTO.setCode(pacProcessTrack.getStep())
                .setVin(pacProcessTrack.getVin())
                .setSourceHex(pacProcessTrack.getSourceHex());
        HandlerPacTrack ht = handlerPacTracks[pacProcessTrack.getStep()];

        if (ht.isErrorOccur()) {
            packProcessExceptionDTO.setJson(ht.getExceptionDtoJsonParse());
        } else {
            // 其他非自定义的异常
            OtherProcessExceptionDTO otherProcessExceptionDTO = new OtherProcessExceptionDTO();
            otherProcessExceptionDTO.setCauseMsg(cause.getMessage());
            packProcessExceptionDTO.setJson(otherProcessExceptionDTO);
        }

        // json序列化之后发送到kafka对应Topic
        kafkaTemplate.send(kafkaProperties.getError(),
                packProcessExceptionDTO.toJson());

        // 打印异常链
//        cause.printStackTrace();

        if (needCloseConn) {
            // 关闭链接
            LOG.error("检测到重要异常，服务端将主动断开连接");
            ClientCache.closeWhenInactive((SocketChannel) context.channel());
        }
    }

}
