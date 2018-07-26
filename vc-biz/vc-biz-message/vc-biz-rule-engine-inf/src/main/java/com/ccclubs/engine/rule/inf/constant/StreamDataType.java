package com.ccclubs.engine.rule.inf.constant;

/**
 * 实时计算-数据类型
 *
 * @author jianghaiyang
 * @create 2018-06-06
 **/
public enum StreamDataType {
    充电阶段("ChargePace"),
    驾驶阶段("DrivePace"),
    启停阶段("LaunchPace"),
    电池跳变("SocJump");

    String type;

    StreamDataType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static StreamDataType getStreamDataType(String type) {
        StreamDataType streamDataType = null;
        switch (type) {
            case "ChargePace":
                streamDataType = StreamDataType.充电阶段;
                break;
            case "DrivePace":
                streamDataType = StreamDataType.驾驶阶段;
                break;
            case "LaunchPace":
                streamDataType = StreamDataType.启停阶段;
                break;
            case "SocJump":
                streamDataType = StreamDataType.电池跳变;
                break;
        }
        return streamDataType;
    }
}
