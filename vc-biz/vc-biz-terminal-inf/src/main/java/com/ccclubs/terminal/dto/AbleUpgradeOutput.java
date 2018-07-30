package com.ccclubs.terminal.dto;

import java.io.Serializable;

/**
 * 查询可以升级 的版本包列表
 *
 * @author jianghaiyang
 * @create 2018-07-24
 **/
public class AbleUpgradeOutput implements Serializable {
    /**
     * 升级包ID
     */
    private Integer id;
    /**
     * 升级包版本号
     */
    private String upVerNo;
    /**
     * 升级包描述
     */
    private String des;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUpVerNo() {
        return upVerNo;
    }

    public void setUpVerNo(String upVerNo) {
        this.upVerNo = upVerNo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
