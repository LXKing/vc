package com.ccclubs.upgrade.dto;

/**
 * @Author: yeanzi
 * @Date: 2018/5/29
 * @Time: 13:35
 * Email:  yeanzhi@ccclubs.com
 * ftp服务器配置信息
 */
public class FtpServer {

    /**
     * 升级文件服务器的远程地址（若http方式升级，则该属性为http请求地址）
     */
    private String serHost;

    /**
     * 升级文件服务器的端口
      */
    private String serPort;

    /**
     * 登陆升级文件服务器的用户名
      */
    private String serUsername;

    /**
     * 登陆升级文件服务器的密码
     */
    private String serPwd;

    public String getSerHost() {
        return serHost;
    }

    public FtpServer setSerHost(String serHost) {
        this.serHost = serHost;
        return this;
    }

    public String getSerPort() {
        return serPort;
    }

    public FtpServer setSerPort(String serPort) {
        this.serPort = serPort;
        return this;
    }

    public String getSerUsername() {
        return serUsername;
    }

    public FtpServer setSerUsername(String serUsername) {
        this.serUsername = serUsername;
        return this;
    }

    public String getSerPwd() {
        return serPwd;
    }

    public FtpServer setSerPwd(String serPwd) {
        this.serPwd = serPwd;
        return this;
    }
}
