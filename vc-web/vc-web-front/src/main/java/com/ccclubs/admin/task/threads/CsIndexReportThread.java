package com.ccclubs.admin.task.threads;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyun.oss.OSSClient;
import com.ccclubs.admin.AppContext;
import com.ccclubs.admin.controller.CsIndexReportController;
import com.ccclubs.admin.service.IReportService;
import com.ccclubs.quota.inf.CsIndexQuotaInf;
import com.ccclubs.quota.orm.model.CsIndexReport;
import com.ccclubs.quota.vo.CsIndexReportInput;
import com.github.pagehelper.PageInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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

  private String userUuid = null;

  public Map<String, String> getHeadMap() {
    return headMap;
  }

  public void setHeadMap(Map<String, String> headMap) {
    this.headMap = headMap;
  }

  private Map<String, String> headMap = null;

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
        CsIndexReportController
            .dealCsIndexReportFromQuotaToThis(csIndexReport, csIndexReportFromQuotaList.get(i));
        list.add(csIndexReport);
      }
    }
    //pageInfo.setList(list);
    for (com.ccclubs.admin.model.CsIndexReport data : list) {
      CsIndexReportController.registResolvers(data);
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String dateNowStr = sdf.format(System.currentTimeMillis());
    /**
     * 命名规则是 表意义+“——”+页号+“——”+页面大小+“——”+日期
     * */
    String fileName = null;
    if (isAllReport) {
      fileName = "IndexReport_All_Data" + dateNowStr + ".xls";
    } else {
      fileName =
          "IndexReport_" + csIndexReportInput.getPageNum() + "_" + csIndexReportInput.getPageSize()
              + "_" + dateNowStr + ".xls";
    }
    //文件路径
    ByteArrayOutputStream bytes;
    bytes = reportService.reportOutputStream(list, headMap);
    long midTime = System.currentTimeMillis();
    logger.info("处理但不存储耗时ms：" + (midTime - startTime));
    ossClient.putObject("oss-vc", fileName, new ByteArrayInputStream(bytes.toByteArray()));
    //OSS的Object地址由域名、bucketName、object组成，具体格式为：bucketName.endpoint/object。
    String url = "oss-vc." + "oss-cn-hangzhou.aliyuncs.com" + "/" + fileName;

    reportService.putFileUrlMap(userUuid, url);
    logger.info("文件路径：" + url);
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
