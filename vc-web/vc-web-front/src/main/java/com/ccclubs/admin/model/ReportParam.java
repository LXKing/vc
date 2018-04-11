package com.ccclubs.admin.model;


import java.io.Serializable;
import java.util.List;

public class ReportParam<T> implements Serializable {
    private static final long serialVersionUID = 7024708906444842724L;

    private T query;
    private List<ReportModel> clms;
    private Integer page=0;
    private Integer rows=10;
    private Integer allReport =0;
    private String order="desc";
    private Boolean isResolve=true;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Boolean getResolve() {
        return isResolve;
    }

    public void setResolve(Boolean resolve) {
        isResolve = resolve;
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

    public Integer getAllReport() {
        return allReport;
    }

    public void setAllReport(Integer allReport) {
        this.allReport = allReport;
    }

    public List<ReportModel> getClms() {
        return clms;
    }

    public void setClms(List<ReportModel> clms) {
        this.clms = clms;
    }

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }
}
