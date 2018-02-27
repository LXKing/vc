package com.ccclubs.influxdb.input;

import java.io.Serializable;


public class Page implements Serializable{

    private static final long serialVersionUID = -3124471778034756526L;
    //查询页号
    private Integer page_no=-1;
    //页最大记录数量(默认20)
    private Integer page_size=3;
    //记录总数
    private Long total =-1L;

    public Integer getPage_no() {
        return page_no;
    }

    public void setPage_no(Integer page_no) {
        this.page_no = page_no;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }



}
