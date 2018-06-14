package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.connection.ClientConnCollection;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.constant.HandleStatus;
import com.ccclubs.gateway.common.constant.InnerMsgType;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.dto.AbstractChannelInnerMsg;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.dto.event.ConnOnlineStatusEvent;
import com.ccclubs.gateway.common.process.CCClubChannelInboundHandler;
import com.ccclubs.gateway.common.util.ClientEventFactory;
import com.ccclubs.gateway.common.util.DecodeUtil;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.process.conn.JTClientConn;
import com.ccclubs.protocol.util.StringUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 14:47
 * Email:  yeanzhi@ccclubs.com
 * 连接身份认证处理器
 */
@Component
@ChannelHandler.Sharable
public class AuthConnectionHandler extends CCClubChannelInboundHandler<Package808> {
    public static final Logger LOG = LoggerFactory.getLogger(AuthConnectionHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        if (LOG.isDebugEnabled()) {
            LOG.debug("终端建立连接: ip={}, port={}",
                    channel.remoteAddress().getHostString(),
                    channel.remoteAddress().getPort());
        }
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        JTClientConn conn = (JTClientConn)ClientConnCollection.getByChannelId(channel.id());
        if (LOG.isDebugEnabled()) {
            LOG.debug("终端({}) 连接关闭: ip={}, port={}",
                    Objects.isNull(conn)?"连接无缓存":conn.getUniqueNo(),
                    channel.remoteAddress().getHostString(),
                    channel.remoteAddress().getPort());
        }
        // 关闭终端的连接，但是不删除终端在内存中的数据
        if (Objects.isNull(conn)) {
            LOG.error("关闭终端(channelId={})连接时发现连接为空:", channel.id());
        } else {
            if (StringUtils.notEmpty(conn.getUniqueNo())) {

                ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOffline(conn.getUniqueNo(), channel).setGatewayType(GatewayType.GATEWAY_808);
                KafkaTask task = new KafkaTask(KafkaSendTopicType.CONN, conn.getUniqueNo(), connOnlineStatusEvent.toJson());

                fireChannelInnerMsg(ctx, InnerMsgType.TASK_KAFKA, task);
            }
        }

        ClientConnCollection.doDisconnected(channel);
    }

    @Override
    protected HandleStatus handlePackage(ChannelHandlerContext ctx, Package808 pac, PacProcessTrack pacProcessTrack) throws Exception {
        UpPacType upPacType = UpPacType.getByCode(pac.getHeader().getPacId());
        String uniqueNo = pac.getHeader().getTerMobile();
        // 处理认证类型消息
        switch(upPacType) {
                // 终端注册
            case REGISTER:
                doRegister(uniqueNo, ctx);
                break;
                // 终端注销
            case LOGOUT:
                doLogout(uniqueNo, ctx);
                break;
                // 终端鉴权
            case AUTH:
                doAuth(pac, ctx);
                break;
            default:
                break;
        }

        LOG.debug("auth complete");
        return HandleStatus.NEXT;
    }

    @Override
    protected HandleStatus handleInnerMsg(AbstractChannelInnerMsg innerMsg) {
        return HandleStatus.NEXT;
    }

    private void doRegister(String uniqueNo, ChannelHandlerContext ctx) {
        SocketChannel newChannel = (SocketChannel) ctx.channel();
        JTClientConn newConn = JTClientConn.ofNew(uniqueNo);

        // 新建连接，连接存在时断开原连接
        ClientConnCollection.addNew(newConn, newChannel);
        LOG.info("终端({})注册成功", uniqueNo);

        // TODO 终端注册成功后，应该发送一段包含 终端ID、手机号、终端IP信息的数据给规则引擎
    }

    /**
     * 终端注销
     *      注销时：
     *          删除终端在内存中的所有统计数据和终端连接
     * @param uniqueNo
     * @param ctx
     */
    private void doLogout(String uniqueNo, ChannelHandlerContext ctx) {
        SocketChannel channel = (SocketChannel) ctx.channel();
        ClientConnCollection.logout(uniqueNo, channel);
        LOG.info("终端({})注销成功", uniqueNo);
    }

    /**
     * 鉴权处理
     *      鉴权成功：应答鉴权成功
     *      鉴权失败：应答鉴权失败
     * @param pac
     */
    private void doAuth(Package808 pac, ChannelHandlerContext ctx) {
        SocketChannel channel = (SocketChannel) ctx.channel();
        String uniqueNo = pac.getHeader().getTerMobile();
        boolean authSuccess = true;
        if (Objects.isNull(pac.getBody().getContent()) || 0 == pac.getBody().getContent().readableBytes()) {
            // 无鉴权码
            LOG.error("终端({})鉴权时发现无鉴权码, 原始报文[{}]", uniqueNo, pac.getSourceHexStr());
            authSuccess = false;
        } else {
            String authCode = DecodeUtil.byte2Str(pac.getBody().getContent(), pac.getBody().getContent().readableBytes());
            // TODO 目前鉴权码就是sim号码
            if (!PackageCons.GLOBAL_AUTH_CODE.equals(authCode)) {
                authSuccess = false;
            }
        }
        // 鉴权失败: 断开连接
        if (!authSuccess) {
            pac.setErrorPac(true);
            LOG.error("重连的终端({})鉴权失败, 原始报文[{}]", uniqueNo, pac.getSourceHexStr());
        } else {
            Optional connOptional = ClientConnCollection.getIfExist(uniqueNo);
            if (connOptional.isPresent()) {
                ClientConnCollection.doReconnecte(uniqueNo, channel);
                LOG.debug("重连的终端({})鉴权成功", uniqueNo);
            } else {
                // 连接第一次连接进系统
                JTClientConn newConn = JTClientConn.ofNew(uniqueNo);

                // 新建连接，连接存在时断开原连接
                ClientConnCollection.addNew(newConn, channel);
                LOG.info("认证时发现终端({})首次连入系统", uniqueNo);
            }

            ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOnline(uniqueNo, channel).setGatewayType(GatewayType.GATEWAY_808);
            KafkaTask task = new KafkaTask(KafkaSendTopicType.CONN, uniqueNo, connOnlineStatusEvent.toJson());
            // 发送至kafka
            fireChannelInnerMsg(ctx, InnerMsgType.TASK_KAFKA, task);
        }
    }
}
