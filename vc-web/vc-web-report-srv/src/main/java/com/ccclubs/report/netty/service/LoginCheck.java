package com.ccclubs.report.netty.service;

import com.ccclubs.report.constant.LoginType;
import com.ccclubs.report.service.ReportAgency;
import com.ccclubs.report.service.ReportInf;

public class LoginCheck implements Runnable {
    private ReportInf bInf;
    private ReportAgency dInf;
    public LoginCheck(ReportInf bInf, ReportAgency dInf) {
        this.bInf = bInf;
        this.dInf = dInf;
    }
    @Override
    public void run() {
        if(!LoginType.LOGIN_IN_SUCCESS.equals(bInf.loginType())){
            dInf.loginIn(bInf);
        }
    }

}
