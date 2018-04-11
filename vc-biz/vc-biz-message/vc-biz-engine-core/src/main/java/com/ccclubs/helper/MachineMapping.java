package com.ccclubs.helper;

import java.io.Serializable;

/**
 * 缓存车机映射关系
 *
 * @author jianghaiyang
 * @create 2017-08-07
 **/
public class MachineMapping implements Serializable{
    private static final long serialVersionUID = 1L;
    String number;
    String mobile;
    String teno;
    String vin;
    Long machine;
    Long access;
    Long host;
    Long car;
    Long can;
    Long state;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTeno() {
        return teno;
    }

    public void setTeno(String teno) {
        this.teno = teno;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getMachine() {
        return machine;
    }

    public void setMachine(Long machine) {
        this.machine = machine;
    }

    public Long getAccess() {
        return access;
    }

    public void setAccess(Long access) {
        this.access = access;
    }

    public Long getHost() {
        return host;
    }

    public void setHost(Long host) {
        this.host = host;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public Long getCan() {
        return can;
    }

    public void setCan(Long can) {
        this.can = can;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }
}
