package com.ccclubs.engine.rule.inf.dto.stream;

import java.io.Serializable;
import java.util.Date;

/**
 * 电池跳变
 *
 * @author jianghaiyang
 * @create 2018-05-08
 **/
public class SocJumpEvent implements Serializable {
    /**
     * 授权系统
     */

    private Integer access;
    /**
     * [vin]VIN码
     */

    private String vin;

    /**
     * [te_number]车机号
     */

    private String teNumber;

    /**
     * [before_soc]跳变前电量
     */

    private Integer beforeSoc;

    /**
     * [before_time]跳变前时间
     */
    private Date beforeTime;

    /**
     * [after_soc]跳变后电量
     */

    private Integer afterSoc;

    /**
     * [after_time]跳变后时间
     */
    private Date afterTime;

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public Integer getBeforeSoc() {
        return beforeSoc;
    }

    public void setBeforeSoc(Integer beforeSoc) {
        this.beforeSoc = beforeSoc;
    }

    public Date getBeforeTime() {
        return beforeTime;
    }

    public void setBeforeTime(Date beforeTime) {
        this.beforeTime = beforeTime;
    }

    public Integer getAfterSoc() {
        return afterSoc;
    }

    public void setAfterSoc(Integer afterSoc) {
        this.afterSoc = afterSoc;
    }

    public Date getAfterTime() {
        return afterTime;
    }

    public void setAfterTime(Date afterTime) {
        this.afterTime = afterTime;
    }
}
