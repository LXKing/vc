package com.ccclubs.admin.task.threads;

import com.ccclubs.admin.util.ReportUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
@Scope("prototype")
public class BackgroundReportThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(BackgroundReportThread.class);

    private String baseName;
    private Collection list;
    private HashMap<String, String> headMap;
    private String userUuid;

    @Autowired
    ReportUtil reportUtil;

    @Override
    public void run() {
        reportUtil.doReport(baseName, list, headMap, userUuid);
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

    public HashMap<String, String> getHeadMap() {
        return headMap;
    }

    public void setHeadMap(HashMap<String, String> headMap) {
        this.headMap = headMap;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }
}
