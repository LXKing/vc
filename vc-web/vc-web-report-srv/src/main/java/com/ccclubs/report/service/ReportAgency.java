package com.ccclubs.report.service;

public interface ReportAgency {
    void loginIn(ReportInf bInf);
    void loginOut(ReportInf bInf);
    void send(ReportInf bInf, Object msg);
}
