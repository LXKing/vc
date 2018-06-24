package com.ccclubs.gateway.jt808.process.conn;

import com.ccclubs.gateway.common.connection.AbstractClientConn;
import io.netty.channel.socket.SocketChannel;

import java.time.LocalDateTime;

/**
 * @Author: yeanzi
 * @Date: 2018/6/4
 * @Time: 13:48
 * Email:  yeanzhi@ccclubs.com
 * 808终端连接
 */
public class JTClientConn extends AbstractClientConn {

    /**
     * 鉴权码
     *      由终端注册后发放给终端
     *      终端重连时，上报鉴权码
     */
    private String authCode;

    public static JTClientConn ofNew(String uniqueNo) {
        JTClientConn newConn = new JTClientConn();
        LocalDateTime now = LocalDateTime.now();
        newConn.setUniqueNo(uniqueNo)
                .setConnected(true)
                .setCreateTime(now)
                .setOnlineDateTime(now)

                .setPackageNum(1)
                .setSerialNo((short)0)
                .setDisconnectTimes(0)
                .setErrorPacketNum(0)
                .setPositionPackageNum(0);
        return newConn;
    }

    public String getAuthCode() {
        return authCode;
    }

    public JTClientConn setAuthCode(String authCode) {
        this.authCode = authCode;
        return this;
    }
}