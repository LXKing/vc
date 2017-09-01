package com.ccclubs.terminal.dto;

/**
 * 终端版本信息
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
public class VersionQryOutput implements java.io.Serializable{

    //是否最新版true：是false:否
    private Boolean isLatest;

    //终端类型0:车厘子,1:中导,2:慧翰,3:通领
    private Byte terminalType;

    //当前版本
    private String currentV;

    //最新版本
    private String latestV;

    private String filename;

    public Boolean getLatest() {
        return isLatest;
    }

    public void setLatest(Boolean latest) {
        isLatest = latest;
    }

    public Byte getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(Byte terminalType) {
        this.terminalType = terminalType;
    }

    public String getCurrentV() {
        return currentV;
    }

    public void setCurrentV(String currentV) {
        this.currentV = currentV;
    }

    public String getLatestV() {
        return latestV;
    }

    public void setLatestV(String latestV) {
        this.latestV = latestV;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "VersionQryOutput{" +
                "isLatest=" + isLatest +
                ", terminalType=" + terminalType +
                ", currentV='" + currentV + '\'' +
                ", latestV='" + latestV + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
