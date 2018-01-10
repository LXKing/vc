package com.ccclubs.olap.orm.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class DriveMilesBasicZhifa implements Serializable {

    private String csNumber;

    private Integer rowNo;

    private Double changedMiles;

    private String startTime;

    private String endTime;

    private Long paceTimemills;



    private static final long serialVersionUID =1L;

    public String getCsNumber() {
        return csNumber;
    }

    public void setCsNumber(String csNumber) {
        this.csNumber = csNumber;
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }

    public Double getChangedMiles() {
        return changedMiles;
    }

    public void setChangedMiles(Double changedMiles) {
        this.changedMiles = changedMiles;
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

    public Long getPaceTimemills() {
        return paceTimemills;
    }

    public void setPaceTimemills(Long paceTimemills) {
        this.paceTimemills = paceTimemills;
    }
}
