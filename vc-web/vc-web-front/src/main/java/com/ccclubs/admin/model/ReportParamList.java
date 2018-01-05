package com.ccclubs.admin.model;


import java.io.Serializable;
import java.util.List;

public class ReportParamList implements Serializable {
    private static final long serialVersionUID = 7024708906444842724L;

    private List<ReportModel> clms;
    private Integer page=0;
    private Integer rows=10;
    private Integer isAllReport=0;

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
        return isAllReport;
    }

    public void setAllReport(Integer allReport) {
        isAllReport = allReport;
    }

    public List<ReportModel> getClms() {
        return clms;
    }

    public void setClms(List<ReportModel> clms) {
        this.clms = clms;
    }
}
