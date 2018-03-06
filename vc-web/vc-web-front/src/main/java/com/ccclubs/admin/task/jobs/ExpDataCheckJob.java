package com.ccclubs.admin.task.jobs;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.admin.constants.AttachmentConst;
import com.ccclubs.admin.model.SrvUser;
import com.ccclubs.admin.model.VcJobTriggerInfo;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.admin.service.ISrvUserService;
import com.ccclubs.admin.service.IVcJobTriggerInfoService;
import com.ccclubs.admin.task.param.ExpDataCheckJobParam;
import com.ccclubs.admin.util.MailConfig;
import com.ccclubs.admin.util.SendMailService;
import com.ccclubs.admin.util.SendMailUtil;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.mongo.orm.model.history.CsVehicleExp;
import com.ccclubs.pub.orm.page.PageInput;
import com.ccclubs.pub.orm.vo.VehicleMachineVo;
import com.github.pagehelper.PageInfo;
import com.mongodb.BasicDBList;
import com.mongodb.CommandResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

/**
 * 异常车辆巡检任务
 *
 * @author jianghaiyang
 * @create 2018-02-28
 **/
@Service
public class ExpDataCheckJob implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ExpDataCheckJob.class);

    @Autowired
    IVcJobTriggerInfoService jobTriggerInfoService;

    @Resource
    ICsVehicleService vehicleService;

    @Resource
    ISrvUserService srvUserService;

    @Resource
    SendMailService sendMailService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource(name = "historyMongoTemplate")
    MongoTemplate historyMongoTemplate;

    @Value("${filedisk.path}")
    private String filePath;     //文件保存目录

    @Override
    public void run() {
        logger.info("车辆数据开始巡检..");
        // 查询job信息
        VcJobTriggerInfo jobTriggerInfo = new VcJobTriggerInfo();
        jobTriggerInfo.setJobCode(this.getClass().getSimpleName());
        jobTriggerInfo = jobTriggerInfoService.selectOne(jobTriggerInfo);
        // 提取job参数
        ExpDataCheckJobParam jobParam = JSONObject.parseObject(jobTriggerInfo.getJobParam(), ExpDataCheckJobParam.class);
        // 清空mongo异常数据
        historyMongoTemplate.dropCollection(CsVehicleExp.class);
        SrvUser user = new SrvUser();
        user.setSuUsername(jobParam.getUsername());
        user = srvUserService.selectOne(user);
        if (null == user) {
            return;
        }
        VehicleMachineVo queryVo = new VehicleMachineVo();
        queryVo.setUserId(user.getSuId());
        PageInfo<VehicleMachineVo> ownData = vehicleService.queryVehicleMachineByPage(queryVo, new PageInput(1, 500));
        // 分页处理
        for (int i = 1; i <= ownData.getPages(); i++) {
            PageInfo<VehicleMachineVo> pageData = vehicleService.queryVehicleMachineByPage(queryVo, new PageInput(i, 500));
            List<CsVehicleExp> invalidData = new ArrayList<>();
            CsVehicleExp vehicleExp;
            for (VehicleMachineVo vo : pageData.getList()) {
                // 检验数据完整性
                if (StringUtils.isEmpty(vo.getCsvVin()) || StringUtils.isEmpty(vo.getCsmTeNo()) || StringUtils.isEmpty(vo.getCsmIccid())
                        || StringUtils.isEmpty(vo.getCsvEngineNo()) || StringUtils.isEmpty(vo.getCsvBataccuCode())
                        || StringUtils.isEmpty(vo.getCsvModelCodeSimple())) {
                    vehicleExp = new CsVehicleExp();
                    BeanUtils.copyProperties(vo, vehicleExp);
                    invalidData.add(vehicleExp);
                }
            }
            logger.info("正在分页处理[第" + i + "页].");
            //批量写入mongo
            if (invalidData.size() > 0) {
                historyMongoTemplate.insert(invalidData, CsVehicleExp.class);
            }

        }
        Query query = new Query();
        long count = historyMongoTemplate.count(query, CsVehicleExp.class);

        if (count > 0) {
            logger.info("检测到 " + count + " 条数据异常的车辆，开始导出异常数据并发送邮件.");
            // todo 导出Excel 发邮件
            List<CsVehicleExp> list = historyMongoTemplate.findAll(CsVehicleExp.class);
            Date start = new Date();
            ExportParams params = new ExportParams("车辆异常数据", "异常车辆");
            Workbook workbook = ExcelExportUtil.exportExcel(params, CsVehicleExp.class, list);
            logger.info("数据导出花费时间：" + (new Date().getTime() - start.getTime()));
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
                        "检测到 " + count + " 条数据异常的车辆，请及时处理！", attachmentProp);
            } catch (EmailException e) {
                throw new ApiException(ApiEnum.FAIL.code(), "邮件发送失败！");
            } catch (MalformedURLException e) {
                throw new ApiException(ApiEnum.FAIL.code(), "邮件发送失败！");
            }
        }
    }
}
