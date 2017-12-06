package com.ccclubs.hbase.phoenix.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/27 0027
 */
@ConfigurationProperties(prefix = "phoenix")
public class PhoenixProperties {
    private String zk_url;

    private List<String> entityList;

    public String getZk_url() {
        return zk_url;
    }

    public void setZk_url(String zk_url) {
        this.zk_url = zk_url;
    }

    public List<String> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<String> entityList) {
        this.entityList = entityList;
    }
}
