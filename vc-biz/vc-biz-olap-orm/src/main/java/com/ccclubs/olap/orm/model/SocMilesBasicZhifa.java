package com.ccclubs.olap.orm.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class SocMilesBasicZhifa implements Serializable {


    private String csNumber;

    private int rowNo;

    private int startSoc;

    private int endSoc;

    private int changedSoc;

    private String startTime;

    private String endTime;

    private long paceTimemills;

    //
    private  int chargeCount;

    private static final long serialVersionUID = 1L;


    public String getCsNumber() {
        return csNumber;
    }

    public void setCsNumber(String csNumber) {
        this.csNumber = csNumber;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public int getStartSoc() {
        return startSoc;
    }

    public void setStartSoc(int startSoc) {
        this.startSoc = startSoc;
    }

    public int getEndSoc() {
        return endSoc;
    }

    public void setEndSoc(int endSoc) {
        this.endSoc = endSoc;
    }

    public int getChangedSoc() {
        return changedSoc;
    }

    public void setChangedSoc(int changedSoc) {
        this.changedSoc = changedSoc;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getPaceTimemills() {
        return paceTimemills;
    }

    public void setPaceTimemills(long paceTimemills) {
        this.paceTimemills = paceTimemills;
    }

    public int getChargeCount() {
        return chargeCount;
    }

    public void setChargeCount(int chargeCount) {
        this.chargeCount = chargeCount;
    }
}