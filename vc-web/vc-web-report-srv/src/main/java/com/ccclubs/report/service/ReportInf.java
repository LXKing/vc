package com.ccclubs.report.service;

import com.ccclubs.report.constant.LoginType;
import com.ccclubs.report.constant.ReportServer;
import com.ccclubs.report.constant.ReportType;

public interface ReportInf {
    ReportType getBizType();

    ReportServer getReportServer();

    LoginType loginType();

    void setLoginType(LoginType loginType);

    void receivedSuccess(Object msg);

    void receivedError(Throwable cause);

    void sendSuccess(Object msg);

    void sendError(Object msg);

    void doBussiness();

    Object loginInMessage();

    void loginInReceived(Object msg);

    void loginInFail(Throwable cause);

    Object loginOutMessage();

    void loginOutReceived(Object msg);

    void loginOutFail(Throwable cause);
}
