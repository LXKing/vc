package com.ccclubs.pub.orm.page;

import java.io.Serializable;

/**
 * 分页请求参数
 *
 * @author jianghaiyang
 * @create 2017-09-28
 **/
public class PageInput implements Serializable {
    private Integer page;//页码
    private Integer rows = 10;//每页记录数
    public PageInput() {
        super();
    }
    public PageInput(Integer page, Integer rows) {
        this.page = page;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
