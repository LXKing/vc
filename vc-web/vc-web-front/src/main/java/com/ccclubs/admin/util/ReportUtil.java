package com.ccclubs.admin.util;

import com.aliyun.oss.OSSClient;
import com.ccclubs.admin.AppContext;
import com.ccclubs.admin.model.ReportModel;
import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.service.IReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;


/**
 * 此方法用于将查询到的数据进行处理，然后生成表格xls文件，最后存储到oss。
 *
 * @field baseName  此参数是你将要生成的文件的最为主要的一部分，
 * 它反应了你的这个文件来自哪个表。例如：‘CsState’。
 * @field headNameMap 此参数是由前端传过来的用于判断哪些字段需要被导出
 * 以及它们的对应中文名字是什么。
 * 其中，key为field名，value为中文名字。
 * @field list 你通过查询或其他方法得到的数据。
 * @field reportParam 前端传递过来的页面参数。
 * @field userUuid 控制层生成的uuid，用于将生成好的文件url放入redis。
 * 前端用此值来查询是否导出完成。
 */
@Component
public class ReportUtil {

    private static final Logger logger = LoggerFactory.getLogger(ReportUtil.class);

    @Autowired
    OSSClient ossClient;

    @Autowired
    IReportService reportService;

    public <T> void doReport(String baseName,
                             Collection list,
                             ReportParam<T> reportParam,
                             String userUuid) {

        long startTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateNowStr = sdf.format(System.currentTimeMillis());
        /**
         * 命名规则是 表意义+“——”+页号+“——”+页面大小+“——”+日期
         * */
        String fileName = null;
        if (null != reportParam.getAllReport() && 1 == reportParam.getAllReport()) {
            fileName = baseName + "_All_Data" + dateNowStr + ".xls";
        } else {
            fileName =
                    baseName + "_" + reportParam.getPage() + "_" + reportParam.getRows()
                            + "_" + dateNowStr + ".xls";
        }
        //文件路径
        ByteArrayOutputStream bytes;
        logger.info("we start a report process.the file is:" + fileName);

        HashMap<String, String> headMap = new HashMap<>();
        for (ReportModel reportModel : reportParam.getClms()) {
            headMap.put(reportModel.getField(), reportModel.getTitle());
        }
        /*for (int i = 0; i < reportParam.getClms().size(); i++) {

        }*/
        bytes = reportService.reportOutputStream(list, headMap);
        long midTime = System.currentTimeMillis();
        logger.info("report deal data use time(ms):" + (midTime - startTime));
        ossClient.putObject("oss-vc", fileName, new ByteArrayInputStream(bytes.toByteArray()));
        //OSS的Object地址由域名、bucketName、object组成，具体格式为：bucketName.endpoint/object。
        String url = "oss-vc." + "oss-cn-hangzhou.aliyuncs.com" + "/" + fileName;

        reportService.putFileUrlMap(userUuid, url);
        //logger.info("文件路径：" + url);
        long endTime = System.currentTimeMillis();
        logger.info("report use time(ms): " + (endTime - startTime));
        logger.info("report a file to oss done:" + fileName);
    }

    public static ReportUtil getFromApplication() {
        return AppContext.CTX.getBean(ReportUtil.class);
    }
}
