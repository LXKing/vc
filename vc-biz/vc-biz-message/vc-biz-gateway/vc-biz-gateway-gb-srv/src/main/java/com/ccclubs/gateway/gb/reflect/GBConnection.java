package com.ccclubs.gateway.gb.reflect;

import com.ccclubs.gateway.gb.inf.MsgSender;
import com.ccclubs.gateway.gb.message.GBPackage;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: yeanzi
 * @Date: 2018/4/2
 * @Time: 11:37
 * Email:  yeanzhi@ccclubs.com
 * 客户端（终端）连接信息实体
 */
public class GBConnection implements MsgSender {

    private static final Logger LOG = LoggerFactory.getLogger(GBConnection.class);

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");

    private SocketChannel socketChannel;

    // 终端VIN码
    private String vin;
    // 车牌号
    private String plateNo;
    // 连接时间
    private LocalDateTime createDate;
    // 最新在线时间
    private LocalDateTime onlineDate;
    // 收到的包的数量
    private int packageNum;
    // 定位包数量
    private int positionPackageNum;
    // 断开次数
    private int disconnectTimes;
    // 错误包数
    private int errorPacketNum;
    // 是否已连接
    private boolean connected;
    // 是否定位
    private boolean located;



    public static GBConnection ofNew(String vin, SocketChannel channel) {
        return new GBConnection()
                .setConnected(true)
                .setCreateDate(LocalDateTime.now())
                .setOnlineDate(LocalDateTime.now())
                .setVin(vin)
                .setSocketChannel(channel);
    }

    public GBConnection closeWhenDisconnect() {
        return closeChannelAndPipline().markChannelClosed();
    }

    public GBConnection closeChannelAndPipline() {
        this.socketChannel.pipeline().close();
        this.socketChannel.close();
        return this;
    }

    public GBConnection markChannelClosed() {
        this.connected = false;
        if(this.disconnectTimes == Integer.MAX_VALUE) {
            this.disconnectTimes = 0;
        } else {
            ++ this.disconnectTimes;
        }
        return this;
    }

    public GBConnection replace(SocketChannel channel) {
        closeChannelAndPipline();
        this.socketChannel = channel;
        this.onlineDate = LocalDateTime.now();
        return this;
    }

    @Override
    public boolean send(GBPackage pac) {
        if (!isOnline()) {
            LOG.warn("机车[{}]未在线，发送消息失败", pac.getHeader().getUniqueNo());
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
        if (null == this.socketChannel || !this.socketChannel.isOpen()) {
            LOG.error("机车连接缓存存在，但连接未打开.");
            this.markChannelClosed();
            return false;
        }
        return true;
    }

    public  GBConnection increPackageNum() {
        if(this.packageNum == Integer.MAX_VALUE) {
            this.packageNum = 0;
        } else {
            ++ this.packageNum;
        }
        return this;
    }

    public  GBConnection increPositionPackageNum() {
        if(this.positionPackageNum == Integer.MAX_VALUE) {
            this.positionPackageNum = 0;
        } else {
            ++ this.positionPackageNum;
        }
        return this;
    }

    public  GBConnection increErrorPacketNum() {
        if(this.errorPacketNum == Integer.MAX_VALUE) {
            this.errorPacketNum = 0;
        } else {
            ++ this.errorPacketNum;
        }
        return this;
    }

    public String toLogString() {
        StringBuilder desSb = new StringBuilder("\n------------channel 渠道报告------------");
        desSb
                .append("\n").append("| 创建时间：").append(formatter.format(this.getCreateDate()))
                .append("\n").append("| VIN码：").append(this.getVin())
                .append("\n").append("| 接收总包数：").append(this.getPackageNum())
                .append("\n").append("| 接收异常包数：").append(this.getErrorPacketNum())
                .append("\n").append("| 接收异定位包数：").append(this.getPositionPackageNum())
                .append("\n").append("| 连接断开次数：").append(this.getDisconnectTimes())
                .append("\n---------------------------------------\n");
        return desSb.toString();
    }





    // getter and setter------------------------------------------------------------------
    public SocketChannel getSocketChannel() {
        return socketChannel;
    }

    public GBConnection setSocketChannel(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public GBConnection setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public GBConnection setPlateNo(String plateNo) {
        this.plateNo = plateNo;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public GBConnection setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public LocalDateTime getOnlineDate() {
        return onlineDate;
    }

    public GBConnection setOnlineDate(LocalDateTime onlineDate) {
        this.onlineDate = onlineDate;
        return this;
    }

    public int getPackageNum() {
        return packageNum;
    }

    public GBConnection setPackageNum(int packageNum) {
        this.packageNum = packageNum;
        return this;
    }

    public int getPositionPackageNum() {
        return positionPackageNum;
    }

    public GBConnection setPositionPackageNum(int positionPackageNum) {
        this.positionPackageNum = positionPackageNum;
        return this;
    }

    public int getDisconnectTimes() {
        return disconnectTimes;
    }

    public GBConnection setDisconnectTimes(int disconnectTimes) {
        this.disconnectTimes = disconnectTimes;
        return this;
    }

    public int getErrorPacketNum() {
        return errorPacketNum;
    }

    public GBConnection setErrorPacketNum(int errorPacketNum) {
        this.errorPacketNum = errorPacketNum;
        return this;
    }

    public boolean isConnected() {
        return connected;
    }

    public GBConnection setConnected(boolean connected) {
        this.connected = connected;
        return this;
    }

    public boolean isLocated() {
        return located;
    }

    public GBConnection setLocated(boolean located) {
        this.located = located;
        return this;
    }
}
