package com.ccclubs.command.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * 指令码与指令ID对照表
 * key：指令码 value：指令ID【cs_struct】
 *
 * @author jianghaiyang
 * @create 2017-07-05
 **/
@ConfigurationProperties(prefix = "command")
public class CommandProp {
    private Map<String, Integer> cmdMap;
    private Map<String, Integer> supportVersionMap;

    public Map<String, Integer> getSupportVersionMap() {
        return supportVersionMap;
    }

    public void setSupportVersionMap(Map<String, Integer> supportVersionMap) {
        this.supportVersionMap = supportVersionMap;
    }

    public Map<String, Integer> getCmdMap() {
        return cmdMap;
    }

    public void setCmdMap(Map<String, Integer> cmdMap) {
        this.cmdMap = cmdMap;
    }
}
