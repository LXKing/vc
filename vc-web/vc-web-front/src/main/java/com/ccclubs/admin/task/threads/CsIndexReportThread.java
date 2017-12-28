package com.ccclubs.admin.task.threads;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.ccclubs.admin.AppContext;
import com.ccclubs.admin.controller.CsIndexReportController;
import com.ccclubs.admin.resolver.CsIndexReportResolver;
import com.ccclubs.admin.service.IReportService;
import com.ccclubs.quota.inf.CsIndexQuotaInf;
import com.ccclubs.quota.orm.model.CsIndexReport;
import com.ccclubs.quota.vo.CsIndexReportInput;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")//非单例调用
public class CsIndexReportThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(CsIndexReportThread.class);

    private CsIndexReportInput csIndexReportInput;


    @Autowired
    OSSClient ossClient;

    private boolean isAllReport = false;

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    private String userUuid=null;


    @Reference(version = "1.0.0")
    private CsIndexQuotaInf csIndexQuotaInf;
    @Autowired
    IReportService reportService;

    public CsIndexReportThread() {

    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        PageInfo<CsIndexReport> pageInfoFromQuota = null;
        List<CsIndexReport> csIndexReportFromQuotaList = null;
        if (!isAllReport) {
            pageInfoFromQuota = csIndexQuotaInf.bizQuota(csIndexReportInput);
            csIndexReportFromQuotaList = pageInfoFromQuota.getList();
        } else {
            csIndexReportFromQuotaList = csIndexQuotaInf.bizQuotaAll(csIndexReportInput);
        }

        //PageInfo<CsIndexReport> pageInfo =new PageInfo<>();
        //copyPageInfo(pageInfo,pageInfoFromQuota);

        List<com.ccclubs.admin.model.CsIndexReport> list = new ArrayList<>();//pageInfo.getList();
        if (null != csIndexReportFromQuotaList && csIndexReportFromQuotaList.size() > 0) {
            for (int i = 0; i < csIndexReportFromQuotaList.size(); i++) {
                com.ccclubs.admin.model.CsIndexReport csIndexReport = new com.ccclubs.admin.model.CsIndexReport();
                CsIndexReportController.dealCsIndexReportFromQuotaToThis(csIndexReport, csIndexReportFromQuotaList.get(i));
                list.add(csIndexReport);
            }
        }
        //pageInfo.setList(list);
        for (com.ccclubs.admin.model.CsIndexReport data : list) {
            CsIndexReportController.registResolvers(data);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(System.currentTimeMillis());
        /**
         * 命名规则是 表意义+“——”+页号+“——”+页面大小+“——”+日期
         * */
        String fileName = null;
        if (isAllReport) {
            fileName = "IndexReport_All_Data" + dateNowStr + ".xls";
        } else {
            fileName = "IndexReport_" + csIndexReportInput.getPageNum() + "_" + csIndexReportInput.getPageSize() + "_" + dateNowStr + ".xls";
        }
        //文件路径
        ByteArrayOutputStream bytes;
        bytes = reportService.reportIndexReport(list);
        long midTime=System.currentTimeMillis();
        logger.info("处理但不存储耗时ms：" + (midTime - startTime));
        ossClient.putObject("oss-vc", fileName, new ByteArrayInputStream(bytes.toByteArray()));
        CsIndexReportController.ossFileMap.put(userUuid,fileName);

        long endTime = System.currentTimeMillis();
        logger.info("导出完整耗时ms：" + (endTime - startTime));
        logger.info("report a file to oss done:" + fileName);
        //TODO 提醒前端，计算完成。
    }

    public void setCsIndexReportInput(CsIndexReportInput csIndexReportInput) {
        this.csIndexReportInput = csIndexReportInput;
    }


    public void setAllReport(boolean allReport) {
        isAllReport = allReport;
    }

    public static CsIndexReportThread getFromApplication() {
        return AppContext.CTX.getBean(CsIndexReportThread.class);
    }

}
