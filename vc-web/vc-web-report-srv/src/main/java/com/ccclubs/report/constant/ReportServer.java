package com.ccclubs.report.constant;

import java.net.InetSocketAddress;

public class ReportServer {
    private String hostname;
    private Integer port;
    private String username;
    private String password;
    private Integer maxConnections;
    private Integer loginCheckPeriod;
    private Integer logPrint;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    public Integer getLoginCheckPeriod() {
        return loginCheckPeriod;
    }

    public void setLoginCheckPeriod(Integer loginCheckPeriod) {
        this.loginCheckPeriod = loginCheckPeriod;
    }

    public Integer getLogPrint() {
        return logPrint;
    }

    public void setLogPrint(Integer logPrint) {
        this.logPrint = logPrint;
    }

    public InetSocketAddress getInetSocketAddress() {
        InetSocketAddress isa = new InetSocketAddress(this.hostname, this.port);
        return isa;
    }

    public boolean isLogPrint() {
        return null != this.logPrint && 1 == this.logPrint;
    }
}
