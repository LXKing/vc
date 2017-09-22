package com.ccclubs.olap.orm.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
public class CsCar implements Serializable{

    private String cscNumber;
    private String cscCarNo;
    private Integer cscModel;
    private String cscCode;


    public String getCscNumber() {
        return cscNumber;
    }

    public void setCscNumber(String cscNumber) {
        this.cscNumber = cscNumber;
    }

    public String getCscCarNo() {
        return cscCarNo;
    }

    public void setCscCarNo(String cscCarNo) {
        this.cscCarNo = cscCarNo;
    }

    public Integer getCscModel() {
        return cscModel;
    }

    public void setCscModel(Integer cscModel) {
        this.cscModel = cscModel;
    }

    public String getCscCode() {
        return cscCode;
    }

    public void setCscCode(String cscCode) {
        this.cscCode = cscCode;
    }

    private static final long serialVersionUID =1L;
}
