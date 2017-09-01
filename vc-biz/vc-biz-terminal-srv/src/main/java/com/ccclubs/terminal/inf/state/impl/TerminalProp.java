package com.ccclubs.terminal.inf.state.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 终端类型最新版本
 *
 * @author jianghaiyang
 * @create 2017-07-01
 **/
@ConfigurationProperties(prefix = "terminal")
public class TerminalProp {
    private Map<String,String> latestVersionMap;

    public Map<String, String> getLatestVersionMap() {
        return latestVersionMap;
    }

    public void setLatestVersionMap(Map<String, String> latestVersionMap) {
        this.latestVersionMap = latestVersionMap;
    }
}
