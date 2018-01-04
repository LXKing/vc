package com.ccclubs.admin.model;


import java.io.Serializable;
import java.util.List;

public class ReportParamList implements Serializable {
    private static final long serialVersionUID = 7024708906444842724L;

    private List<ReportModel> clms;

    public List<ReportModel> getClms() {
        return clms;
    }

    public void setClms(List<ReportModel> clms) {
        this.clms = clms;
    }
}
