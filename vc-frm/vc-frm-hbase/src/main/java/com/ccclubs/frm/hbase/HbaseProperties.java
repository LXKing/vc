package com.ccclubs.frm.hbase;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
@ConfigurationProperties(prefix = "hbase")
public class HbaseProperties {
    //zookeeper主机名列表
    private String zookeeper_hosts;

    //zookeeper连接端口号
    private String port;

    public String getZookeeper_hosts() {
        return zookeeper_hosts;
    }

    public void setZookeeper_hosts(String zookeeper_hosts) {
        this.zookeeper_hosts = zookeeper_hosts;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
