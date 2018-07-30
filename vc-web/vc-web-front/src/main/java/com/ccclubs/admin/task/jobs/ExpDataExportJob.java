package com.ccclubs.admin.task.jobs;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.admin.constants.AttachmentConst;
import com.ccclubs.admin.entity.CsVehicleExpCriteria;
import com.ccclubs.admin.model.CsVehicleExp;
import com.ccclubs.admin.model.VcJobTriggerInfo;
import com.ccclubs.admin.service.ICsVehicleExpService;
import com.ccclubs.admin.service.IVcJobTriggerInfoService;
import com.ccclubs.admin.task.param.ExpDataCheckJobParam;
import com.ccclubs.admin.util.SendMailService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import org.apache.commons.mail.EmailException;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆异常数据导出
 *
 * @author jianghaiyang
 * @create 2018-03-08
 **/
@Service
public class ExpDataExportJob implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ExpDataExportJob.class);

    @Autowired
    IVcJobTriggerInfoService jobTriggerInfoService;

    @Resource
    SendMailService sendMailService;

    @Value("${filedisk.path}")
    private String filePath;     //文件保存目录

    @Resource
    ICsVehicleExpService csVehicleExpService;

    @Override
    public void run() {
        // 查询job信息
        VcJobTriggerInfo jobTriggerInfo = new VcJobTriggerInfo();
        jobTriggerInfo.setJobCode(ExpDataCheckJob.class.getSimpleName());
        jobTriggerInfo = jobTriggerInfoService.selectOne(jobTriggerInfo);
        // 提取job参数
        ExpDataCheckJobParam jobParam = JSONObject.parseObject(jobTriggerInfo.getJobParam(), ExpDataCheckJobParam.class);

        long exportStart = System.currentTimeMillis();
        CsVehicleExpCriteria example = new CsVehicleExpCriteria();
        CsVehicleExpCriteria.Criteria criteria = example.createCriteria();
        criteria.andCsveIdIsNotNull();
        long count = csVehicleExpService.selectCountByExample(example);

        if (count > 0) {
            logger.info("近 " + jobParam.getDateRange() + " 天检测到 " + count + " 条数据异常的车辆，开始导出异常数据并发送邮件.");
            example.setOrderByClause("createTime desc");
            List<CsVehicleExp> list = csVehicleExpService.selectAll();

            ExportParams params = new ExportParams("车辆异常数据", "异常车辆");
            Workbook workbook = ExcelExportUtil.exportExcel(params, CsVehicleExp.class, list);
            logger.info("数据导出花费时间：" + (System.currentTimeMillis() - exportStart));
            File savefile = new File(filePath);
            if (!savefile.exists()) {
                savefile.mkdirs();
            }
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(filePath + "Vehicle_Exp_All_Data.xls");
                workbook.write(fos);
                fos.close();
            } catch (FileNotFoundException e) {
                throw new ApiException(ApiEnum.FAIL.code(), "未找到导出的文件路径！");
            } catch (IOException e) {
                throw new ApiException(ApiEnum.FAIL.code(), "导出文件时发生错误！");
            }

            Map<String, String> attachmentProp = new HashMap<>();
            attachmentProp.put(AttachmentConst.IS_REMOTE, "false");
            attachmentProp.put(AttachmentConst.LOCAL_FILE_PATH, filePath + "Vehicle_Exp_All_Data.xls");
            attachmentProp.put(AttachmentConst.DESCRIPTION, "异常车辆数据");
            attachmentProp.put(AttachmentConst.FILE_NAME, "异常车辆数据.xls");
            try {
                logger.info("开始发送通知邮件");
                sendMailService.sslSend(jobParam.getToEmail(), jobParam.getCcEmail(), jobParam.getSubject(),
                        "近 " + jobParam.getDateRange() + " 天检测到 " + count + " 条数据异常的车辆，请及时处理！", attachmentProp);
            } catch (EmailException e) {
                throw new ApiException(ApiEnum.FAIL.code(), "邮件发送失败！");
            } catch (MalformedURLException e) {
                throw new ApiException(ApiEnum.FAIL.code(), "邮件发送失败！");
            }
        }

    }
}