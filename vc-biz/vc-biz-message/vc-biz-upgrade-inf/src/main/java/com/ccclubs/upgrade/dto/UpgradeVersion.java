package com.ccclubs.upgrade.dto;

import java.util.List;

/**
 * @Author: yeanzi
 * @Date: 2018/5/18
 * @Time: 16:18
 * Email:  yeanzhi@ccclubs.com
 * 升级版本信息
 *      当前要升级的版本信息
 */
public class UpgradeVersion {

    /**
     * 升级版本ID，唯一区分一次升级
     */
    private int id;

    /**
     * 插件升级文件名
     */
    private String pluginFileName;

    /**
     * 主版本升级文件名
     */
    private String majorFileName;

    /**
     * 蓝牙升级文件名
     */
    private String bluetoothFileName;

    /**
     * 插件版本
     */
    private int pluginVer;

    /**
     * 主版本
     */
    private int majorVer;

    /**
     * 升级文件所在服务器配置
     */
    private FtpServer ftpServer;

    /**
     * can波特率
     */
    private Short canRate;
    /**
     * 过滤表中canID列表
     */
    private List<Integer> canIdList;

    // -----------------------------------

    public int getId() {
        return id;
    }

    public UpgradeVersion setId(int id) {
        this.id = id;
        return this;
    }

    public String getPluginFileName() {
        return pluginFileName;
    }

    public UpgradeVersion setPluginFileName(String pluginFileName) {
        this.pluginFileName = pluginFileName;
        return this;
    }

    public String getMajorFileName() {
        return majorFileName;
    }

    public UpgradeVersion setMajorFileName(String majorFileName) {
        this.majorFileName = majorFileName;
        return this;
    }

    public String getBluetoothFileName() {
        return bluetoothFileName;
    }

    public UpgradeVersion setBluetoothFileName(String bluetoothFileName) {
        this.bluetoothFileName = bluetoothFileName;
        return this;
    }

    public int getPluginVer() {
        return pluginVer;
    }

    public UpgradeVersion setPluginVer(int pluginVer) {
        this.pluginVer = pluginVer;
        return this;
    }

    public int getMajorVer() {
        return majorVer;
    }

    public UpgradeVersion setMajorVer(int majorVer) {
        this.majorVer = majorVer;
        return this;
    }

    public FtpServer getFtpServer() {
        return ftpServer;
    }

    public UpgradeVersion setFtpServer(FtpServer ftpServer) {
        this.ftpServer = ftpServer;
        return this;
    }

    public Short getCanRate() {
        return canRate;
    }

    public UpgradeVersion setCanRate(Short canRate) {
        this.canRate = canRate;
        return this;
    }

    public List<Integer> getCanIdList() {
        return canIdList;
    }

    public UpgradeVersion setCanIdList(List<Integer> canIdList) {
        this.canIdList = canIdList;
        return this;
    }
}
