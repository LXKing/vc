package com.ccclubs.admin.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author: GFA
 * @Project: vc
 * @Package: com.ccclubs.admin.query
 * @Date: 2018/08/20  14:30
 * @Description:
 */
public class TBoxLogQuery {

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date addTimeStart;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date addTimeEnd;

    private String csVinEquals;

    private String csNumberEquals;

    private Long orderNoEquals;

    private String sidx;
    private String sord;


    public Date getAddTimeStart() {
        return this.addTimeStart;
    }

    public TBoxLogQuery setAddTimeStart(Date addTimeStart) {
        this.addTimeStart = addTimeStart;
        return this;
    }

    public Date getAddTimeEnd() {
        return this.addTimeEnd;
    }

    public TBoxLogQuery setAddTimeEnd(Date addTimeEnd) {
        this.addTimeEnd = addTimeEnd;
        return this;
    }

    public String getCsVinEquals() {
        return this.csVinEquals;
    }

    public TBoxLogQuery setCsVinEquals(String csVinEquals) {
        this.csVinEquals = csVinEquals;
        return this;
    }

    public String getCsNumberEquals() {
        return this.csNumberEquals;
    }

    public TBoxLogQuery setCsNumberEquals(String csNumberEquals) {
        this.csNumberEquals = csNumberEquals;
        return this;
    }

    public Long getOrderNoEquals() {
        return this.orderNoEquals;
    }

    public TBoxLogQuery setOrderNoEquals(Long orderNoEquals) {
        this.orderNoEquals = orderNoEquals;
        return this;
    }

    public String getSidx() {
        if(this.sidx == null){
            return "";
        }
        else if(this.sidx.equals("teNumber")){
            return "te_number";
        }
        else if(this.sidx.equals("vin")){
            return "vin";
        }
        else if(this.sidx.equals("orderNo")){
            return "order_no";
        }
        else if(this.sidx.equals("logInfo")){
            return "log_info";
        }
        else if(this.sidx.equals("sourceHex")){
            return "source_hex";
        }
        else if(this.sidx.equals("addTime")){
            return "add_time";
        }
        return this.sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return this.sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
