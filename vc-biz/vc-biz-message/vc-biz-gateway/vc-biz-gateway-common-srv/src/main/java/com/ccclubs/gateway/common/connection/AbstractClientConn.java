package com.ccclubs.gateway.common.connection;

import com.ccclubs.gateway.common.inf.MsgSender;
import com.ccclubs.gateway.common.inf.GatewayPackage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

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
     * 终端唯一标识
     */
    private String uniqueNo;

    /**
     * 平台消息序列号
     */
    private short serialNo;

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

    public AbstractClientConn markChannelClosed() {
        this.connected = false;
        if(this.disconnectTimes == Integer.MAX_VALUE) {
            this.disconnectTimes = 0;
        } else {
            ++ this.disconnectTimes;
        }
        return this;
    }

    /**
     * 标记连接活跃
     * @return
     */
    public AbstractClientConn markChannelActive() {
        this.connected = true;
        this.onlineDateTime = LocalDateTime.now();
        return this;
    }

    @Override
    public boolean send(final GatewayPackage pac) {
        checkExistBeforeSend().ifPresent(channel -> channel.pipeline().writeAndFlush(pac));
        return true;
    }

    @Override
    public boolean send(final ByteBuf buf) {
        checkExistBeforeSend().ifPresent(channel -> channel.pipeline().writeAndFlush(buf));
        return true;
    }

    /**
     * 下发消息时，校验是否终端在线
     * @return
     */
    private Optional<SocketChannel> checkExistBeforeSend() {
        if (!isOnline()) {
            LOG.error("机车[{}]未在线，发送消息失败", uniqueNo);
            return Optional.empty();
        }
        // 消息编码测试
        SocketChannel socketChannel = ClientSocketCollection.get(this.uniqueNo);
        if (Objects.isNull(socketChannel)) {
            LOG.error("下发消息时发现：socketChannel为null，uniqueNo={}", uniqueNo);
            return Optional.empty();
        }
        if (ClientSocketCollection.channelInActive(socketChannel)) {
            LOG.error("下发消息时发现：socketChannel为连接状态异常，uniqueNo={}", uniqueNo);
            return Optional.empty();
        }
        return Optional.of(socketChannel);
    }

    /**
     * 终端是否在线
     * @return
     */
    public boolean isOnline() {
        return connected;
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

    public short getAndIncreaseSerialNo() {
        if (this.serialNo == Short.MAX_VALUE) {
            this.serialNo = 0;
        } else {
            this.serialNo ++;
        }
        return this.serialNo;
    }

    // ------------------------------------------------------------------

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

    public short getSerialNo() {
        return serialNo;
    }

    public AbstractClientConn setSerialNo(short serialNo) {
        this.serialNo = serialNo;
        return this;
    }
}
