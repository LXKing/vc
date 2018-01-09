package com.ccclubs.admin.task.threads;

import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.util.ReportUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Scope("prototype")
public class ReportThread implements Runnable {

    private static final Logger logger= LoggerFactory.getLogger(ReportThread.class);

    private String baseName;
    private Collection list;
    private ReportParam reportParam;
    private String userUuid;


    @Autowired
    ReportUtil reportUtil;

    @Override
    public void run() {
        reportUtil.doReport(baseName,list,reportParam,userUuid);
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public Collection getList() {
        return list;
    }

    public void setList(Collection list) {
        this.list = list;
    }

    public ReportParam getReportParam() {
        return reportParam;
    }

    public void setReportParam(ReportParam reportParam) {
        this.reportParam = reportParam;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }
}
