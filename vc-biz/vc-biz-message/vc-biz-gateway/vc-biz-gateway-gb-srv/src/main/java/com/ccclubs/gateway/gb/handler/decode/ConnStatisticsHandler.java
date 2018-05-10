package com.ccclubs.gateway.gb.handler.decode;

import com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent;
import com.ccclubs.gateway.gb.constant.CommandType;
import com.ccclubs.gateway.gb.constant.PackProcessExceptionCode;
import com.ccclubs.gateway.gb.dto.ConnStatisticsExceptionDTO;
import com.ccclubs.gateway.gb.dto.PackProcessExceptionDTO;
import com.ccclubs.gateway.gb.handler.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.gb.message.GBPackage;
import com.ccclubs.gateway.gb.message.track.PacProcessTrack;
import com.ccclubs.gateway.gb.reflect.ClientCache;
import com.ccclubs.gateway.gb.reflect.GBConnection;
import com.ccclubs.gateway.gb.utils.KafkaProperties;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/4/27
 * @Time: 9:46
 * Email:  yeanzhi@ccclubs.com
 * 连接数据统计处理器
 *      该类不可与其他渠道共享
 */
public class ConnStatisticsHandler extends CCClubChannelInboundHandler<GBPackage> {
    private static final Logger LOG = LoggerFactory.getLogger(ConnStatisticsHandler.class);

//    @Autowired
    private KafkaTemplate kafkaTemplate;

//    @Autowired
    private KafkaProperties kafkaProperties;

    private GBConnection conn;

    public ConnStatisticsHandler(KafkaTemplate kafkaTemplate, KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GBPackage pac) throws Exception {
        ConnStatisticsExceptionDTO statisticsExceptionDTO = new ConnStatisticsExceptionDTO();
        PacProcessTrack pacProcessTrack = beforeProcess(ctx, statisticsExceptionDTO);

        SocketChannel channel = (SocketChannel)ctx.channel();
        if (pac.isErrorPac()) {
            LOG.error("收到一个校验异常包：{}", pac.toLogString());

            // 目前校验异常dto中为空
            PackProcessExceptionDTO packProcessExceptionDTO = new PackProcessExceptionDTO()
                    .setVin(pac.getHeader().getUniqueNo())
                    .setSourceHex(pac.getSourceHexStr())
                    .setCode(PackProcessExceptionCode.INVALID_FAIL.getCode());

            kafkaTemplate.send(kafkaProperties.getError(),
                    packProcessExceptionDTO.toJson());

            countErrorPac(channel);
            // 错误包不进行下发
            ReferenceCountUtil.release(pac.getSourceBuff());
        } else {
            // 因为错误包的数据不准确，所以不在错误包之前初始化连接
            GBConnection conn = getConn(pac.getHeader().getUniqueNo(), channel);
            // 统计总包数
            conn.increPackageNum();
            // 实时数据包则需要统计位置包数量
            if (pac.getHeader().getCommandMark().equals(CommandType.REALTIME_DATA)) {
                conn.increPositionPackageNum();// 位置包（实时信息包）数
            }

            /**
             * 测试动态添加/删除Handler
             *      当收到包数超过500个少于1000，添加通道数据报告handler，之后每50个包之后报告一次通道数据
             *      当数据包超过1万，删除报告handler
             */
            // -----------------------------------------------------
            int allPacCount = conn.getPackageNum();
            if (allPacCount > 500 && allPacCount < 1000) {
                if (ctx.pipeline().get("singleChannelDatailHandler") == null) {
                    LOG.info(">>> 添加singleChannelDatailHandler <<<");
                    ctx.pipeline().addAfter("connStatisticsHandler", "singleChannelDatailHandler", new SingleChannelDetailHandler());
                }
            }

            // 当收到包大于1万（模拟业务高峰），删除通道数据报告handler，以求效率
            if (conn.getPackageNum() > 10000) {
                if (ctx.pipeline().get("singleChannelDatailHandler") != null) {
                    LOG.info(">>> 删除singleChannelDatailHandler >>>");
                    ctx.pipeline().remove("singleChannelDatailHandler");
                }
            }
            // -----------------------------------------------------

            // 记录处理结束时间
            pacProcessTrack.getCurrentHandlerTracker().setEndTime(System.nanoTime());

            // 事件下发
            ctx.fireChannelRead(pac);
        }
    }

    /**
     * 统计异常包数量
     * @param channel
     */
    private void countErrorPac(SocketChannel channel) {
        GBConnection conn = ClientCache.getByChannelId(channel.id());
        if (Objects.nonNull(conn)) {
            conn.increErrorPacketNum();
        }
        // 如果channel不存在，不需要统计数据
    }

    /**
     * 获取当前渠道对应的连接
     *      如果连接不存在则初始化一个新连接
     * @param vin
     * @param channel
     * @return
     */
    public GBConnection getConn(String vin, SocketChannel channel) {
        if (Objects.isNull(conn)) {
            conn = ClientCache.checkConnection(vin, channel);

            if (!Objects.isNull(conn)) {
                ConnOnlineStatusEvent connOnlineStatusEvent = new ConnOnlineStatusEvent();
                connOnlineStatusEvent.setVin(vin)
                        .setOnline(true)
                        .setTimestamp(System.currentTimeMillis())
                        .setClientIp(channel.remoteAddress().getHostString())
                        .setServerIp(channel.localAddress().getHostString());
                kafkaTemplate.send(kafkaProperties.getConn(), connOnlineStatusEvent.toJson());
            }
        }
        return conn;
    }
}
