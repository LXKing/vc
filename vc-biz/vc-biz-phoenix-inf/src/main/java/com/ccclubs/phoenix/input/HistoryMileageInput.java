package com.ccclubs.phoenix.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 里程查询入参
 *
 * @author jianghaiyang
 * @create 2018-09-26
 **/
public class HistoryMileageInput implements Serializable {
    /**
     * 车架号
     */
    @NotNull(message = "车辆Vin码必填")
    private String vin;

    /**
     * 查询开始时间
     */
    @NotNull(message = "查询开始时间(yyyy-MM-dd HH:mm:ss)必填")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date startTime;

    /**
     * 查询结束时间
     */
    @NotNull(message = "查询结束时间(yyyy-MM-dd HH:mm:ss)必填")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date endTime;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
