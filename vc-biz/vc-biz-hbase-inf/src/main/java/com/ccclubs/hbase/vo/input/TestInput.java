package com.ccclubs.hbase.vo.input;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class TestInput implements Serializable {
    private String startRowKey;

    private String stopRowKey;

    private int pageSize;

    //(-1:上一页  0:当前页  1:下一页)
    private int page_direction;

    //当前页首行记录rowkey
    private String page_first_rowkey;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage_direction() {
        return page_direction;
    }

    public void setPage_direction(int page_direction) {
        this.page_direction = page_direction;
    }

    public String getStartRowKey() {
        return startRowKey;
    }

    public void setStartRowKey(String startRowKey) {
        this.startRowKey = startRowKey;
    }

    public String getStopRowKey() {
        return stopRowKey;
    }

    public void setStopRowKey(String stopRowKey) {
        this.stopRowKey = stopRowKey;
    }

    public String getPage_first_rowkey() {
        return page_first_rowkey;
    }

    public void setPage_first_rowkey(String page_first_rowkey) {
        this.page_first_rowkey = page_first_rowkey;
    }
}
