package com.ccclubs.gateway.common.bean.attr;

import com.ccclubs.gateway.common.inf.ChannelAttr;

/**
 * describe: 渠道健康数据
 * author  : Andaren
 * email   : 603822061@qq.com
 * date    : 2018/8/9
 * time    : 下午11:17
 * version : v1.0
 * update_log:
 * date[更新日期] time[更新时间] updater[更新人]     for[原因]
 *
 **/
public abstract class AbstractChannelHealthyAttr extends AbstractChannelAttr implements ChannelAttr {
    /**
     * 当前客户端IP端口信息
     */
    private String currentClientAddress;

    /**
     * 当前服务器IP端口信息
     */
    private String currentServerAddress;

    /**
     * 上次报文间隔时长（秒）
     */
    private int lastPackageDuration;

    public String getCurrentClientAddress() {
        return currentClientAddress;
    }

    public AbstractChannelHealthyAttr setCurrentClientAddress(String currentClientAddress) {
        this.currentClientAddress = currentClientAddress;
        return this;
    }

    public String getCurrentServerAddress() {
        return currentServerAddress;
    }

    public AbstractChannelHealthyAttr setCurrentServerAddress(String currentServerAddress) {
        this.currentServerAddress = currentServerAddress;
        return this;
    }

    public int getLastPackageDuration() {
        return lastPackageDuration;
    }

    public AbstractChannelHealthyAttr setLastPackageDuration(int lastPackageDuration) {
        this.lastPackageDuration = lastPackageDuration;
        return this;
    }


}
