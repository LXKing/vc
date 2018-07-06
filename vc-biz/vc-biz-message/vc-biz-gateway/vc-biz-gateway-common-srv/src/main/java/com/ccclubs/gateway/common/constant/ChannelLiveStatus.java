package com.ccclubs.gateway.common.constant;

/**
 * @Author: yeanzi
 * @Date: 2018/7/4
 * @Time: 10:18
 * Email:  yeanzhi@ccclubs.com
 * channel在线状态
 */
public enum ChannelLiveStatus {

    /**
     * channel创建
     */
    ONLINE_CREATE,

    /**
     * 客户端建立连接
     */
    ONLINE_CONNECT,

    /**
     * 客户端注册
     */
    ONLINE_REGISTER,

    /**
     * 客户端鉴权
     */
    ONLINE_AUTH,

    // 后面的状态都可以获取uniqueNo
    // -----------------------------------------------

    /**
     * 客户端重连
     */
    ONLINE_RECONNECT,

    /**
     * 连接由于读空闲断开
     */
    OFFLINE_IDLE,

    /**
     * 连接被平台主动断开
     */
    OFFLINE_SERVER_CUT,

    /**
     * 客户端主动断开了连接
     */
    OFFLINE_CLIENT_CUT,

    /**
     * 下线完成
     */
    OFFLINE_END;
}
