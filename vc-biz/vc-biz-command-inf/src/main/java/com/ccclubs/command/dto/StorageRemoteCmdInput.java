package com.ccclubs.command.dto;

import java.io.Serializable;

/**
 * @version 1.0.0
 * @time 2018/8/21
 * @auther Alban
 * @email fengjun@ccclubs.com
 * @description 请填写描述！
 */
public class StorageRemoteCmdInput implements Serializable {

    private static final long serialVersionUID = -9175058886070672829L;

    private Long structId;//对应csStructId字段

    private String values;

    private String vin;

    private String teNumber;

    private String remark;

    private  String user;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public Long getStructId() {
        return structId;
    }

    public void setStructId(Long structId) {
        this.structId = structId;
    }
}
