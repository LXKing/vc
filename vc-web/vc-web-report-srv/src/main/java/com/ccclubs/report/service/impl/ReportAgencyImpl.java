package com.ccclubs.report.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccclubs.report.netty.client.NettyClient;
import com.ccclubs.report.service.ReportAgency;
import com.ccclubs.report.service.ReportInf;

@Service
public class ReportAgencyImpl implements ReportAgency {
    @Autowired
    private NettyClient nc;

    @Override
    public void loginIn(ReportInf bInf) {
        nc.sendLoginIn(bInf);
    }

    @Override
    public void loginOut(ReportInf bInf) {
        nc.sendLoginOut(bInf);
    }

    @Override
    public void send(ReportInf bInf, Object msg) {
        // TODO Auto-generated method stub
        nc.send(bInf, msg);
    }


}
