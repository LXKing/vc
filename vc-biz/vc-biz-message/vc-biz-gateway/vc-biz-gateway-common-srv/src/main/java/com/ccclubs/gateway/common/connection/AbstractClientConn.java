package com.ccclubs.gateway.common.connection;

import com.ccclubs.gateway.common.inf.MsgSender;
import com.ccclubs.gateway.common.inf.GatewayPackage;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 11:15
 * Email:  yeanzhi@ccclubs.com
 * 客户端连接
 */
public abstract class AbstractClientConn implements MsgSender {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractClientConn.class);

    /**
     * 客户端对应的socke连接
     */
    private SocketChannel socketChannel;

    /**
     * 终端唯一标识
     */
    private String uniqueNo;

    /**
     *  车牌号
     */
    private String plateNo;

    /**
     * 连接创建的时间
     */
    private LocalDateTime createTime;

    /**
     * 最新在线时间
     */
    private LocalDateTime onlineDateTime;

    /**
     * 收到的包的数量
     */
    private Integer packageNum;

    /**
     * 定位包数量
     */
    private Integer positionPackageNum;

    /**
     * 断开次数
     */
    private Integer disconnectTimes;

    /**
     * 异常包数量
     */
    private Integer errorPacketNum;

    /**
     * 是否已连接
     */
    private Boolean connected;

    // --------------------------------------------------------------------------
    public AbstractClientConn closeWhenDisconnect() {
         this.closeChannelAndPipline()
                 .markChannelClosed();
        return this;
    }

    public AbstractClientConn closeChannelAndPipline() {
        if (this.socketChannel.isOpen()) {
            this.socketChannel.pipeline().close();
            this.socketChannel.close();
        }
        return this;
    }

    public AbstractClientConn markChannelClosed() {
        this.connected = false;
        if(this.disconnectTimes == Integer.MAX_VALUE) {
            this.disconnectTimes = 0;
        } else {
            ++ this.disconnectTimes;
        }
        return this;
    }

    public AbstractClientConn replace(SocketChannel channel) {
        closeChannelAndPipline();
        this.socketChannel = channel;
        this.onlineDateTime = LocalDateTime.now();
        return this;
    }

    @Override
    public boolean send(GatewayPackage pac) {
        if (!isOnline()) {
            LOG.warn("机车[{}]未在线，发送消息失败", uniqueNo);
            return false;
        }
        // 消息编码测试
        this.socketChannel.writeAndFlush(pac);
        return true;
    }

    public boolean isOnline() {
        if (!connected) {
            return false;
        }
        if (Objects.isNull(this.socketChannel) || !this.socketChannel.isOpen()) {
            LOG.error("机车连接缓存存在，但连接未打开.");
            this.connected = false;
            return false;
        }
        return true;
    }

    public AbstractClientConn increPackageNum() {
        if(this.packageNum == Integer.MAX_VALUE) {
            this.packageNum = 0;
        } else {
            ++ this.packageNum;
        }
        return this;
    }

    public AbstractClientConn increPositionPackageNum() {
        if(this.positionPackageNum == Integer.MAX_VALUE) {
            this.positionPackageNum = 0;
        } else {
            ++ this.positionPackageNum;
        }
        return this;
    }

    public AbstractClientConn increErrorPacketNum() {
        if(this.errorPacketNum == Integer.MAX_VALUE) {
            this.errorPacketNum = 0;
        } else {
            ++ this.errorPacketNum;
        }
        return this;
    }

    // ------------------------------------------------------------------


    public SocketChannel getSocketChannel() {
        return socketChannel;
    }

    public AbstractClientConn setSocketChannel(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
        return this;
    }

    public String getUniqueNo() {
        return uniqueNo;
    }

    public AbstractClientConn setUniqueNo(String uniqueNo) {
        this.uniqueNo = uniqueNo;
        return this;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public AbstractClientConn setPlateNo(String plateNo) {
        this.plateNo = plateNo;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public AbstractClientConn setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getOnlineDateTime() {
        return onlineDateTime;
    }

    public AbstractClientConn setOnlineDateTime(LocalDateTime onlineDateTime) {
        this.onlineDateTime = onlineDateTime;
        return this;
    }

    public Integer getPackageNum() {
        return packageNum;
    }

    public AbstractClientConn setPackageNum(Integer packageNum) {
        this.packageNum = packageNum;
        return this;
    }

    public Integer getPositionPackageNum() {
        return positionPackageNum;
    }

    public AbstractClientConn setPositionPackageNum(Integer positionPackageNum) {
        this.positionPackageNum = positionPackageNum;
        return this;
    }

    public Integer getDisconnectTimes() {
        return disconnectTimes;
    }

    public AbstractClientConn setDisconnectTimes(Integer disconnectTimes) {
        this.disconnectTimes = disconnectTimes;
        return this;
    }

    public Integer getErrorPacketNum() {
        return errorPacketNum;
    }

    public AbstractClientConn setErrorPacketNum(Integer errorPacketNum) {
        this.errorPacketNum = errorPacketNum;
        return this;
    }

    public Boolean getConnected() {
        return connected;
    }

    public AbstractClientConn setConnected(Boolean connected) {
        this.connected = connected;
        return this;
    }
}
