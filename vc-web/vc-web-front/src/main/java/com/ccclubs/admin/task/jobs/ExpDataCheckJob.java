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
        SrvUser user = new SrvUser();
        user.setSuUsername(jobParam.getUsername());
        user = srvUserService.selectOne(user);
        if (null == user) {
            return;
        }
        VehicleMachineVo queryVo = new VehicleMachineVo();
        queryVo.setUserId(user.getSuId());
        long writeStart = System.currentTimeMillis();
        // 统一一次处理
        List<VehicleMachineVo> pageData = vehicleService.queryVehicleMachineByUser(queryVo);
        List<CsVehicleExp> invalidData = new ArrayList<>();
        CsVehicleExp vehicleExp;
        for (VehicleMachineVo vo : pageData) {
            // 检验数据完整性
            if (StringUtils.isEmpty(vo.getCsvVin()) || StringUtils.isEmpty(vo.getCsmTeNo()) || StringUtils.isEmpty(vo.getCsmIccid())
                    || StringUtils.isEmpty(vo.getCsvEngineNo()) || StringUtils.isEmpty(vo.getCsvBataccuCode())
                    || StringUtils.isEmpty(vo.getCsvModelCodeSimple())) {
                vehicleExp = new CsVehicleExp();
                vehicleExp.setCheckTime(new Date());
                BeanUtils.copyProperties(vo, vehicleExp);
                invalidData.add(vehicleExp);
            }
        }
        logger.info("扫描完成. 检测到{}辆异常数据", invalidData.size());
        //批量写入mongo
        if (invalidData.size() > 0) {
            historyMongoTemplate.insert(invalidData, CsVehicleExp.class);
        }

        logger.info("数据写入mongo花费时间：" + (System.currentTimeMillis() - writeStart));

    }

//    @Override
//    public void run() {
//        logger.info("车辆数据开始巡检..");
//
//        // 查询job信息
//        VcJobTriggerInfo jobTriggerInfo = new VcJobTriggerInfo();
//        jobTriggerInfo.setJobCode(this.getClass().getSimpleName());
//        jobTriggerInfo = jobTriggerInfoService.selectOne(jobTriggerInfo);
//        // 提取job参数
//        ExpDataCheckJobParam jobParam = JSONObject.parseObject(jobTriggerInfo.getJobParam(), ExpDataCheckJobParam.class);
//        SrvUser user = new SrvUser();
//        user.setSuUsername(jobParam.getUsername());
//        user = srvUserService.selectOne(user);
//        if (null == user) {
//            return;
//        }
//        VehicleMachineVo queryVo = new VehicleMachineVo();
//        queryVo.setUserId(user.getSuId());
//        PageInfo<VehicleMachineVo> ownData = vehicleService.queryVehicleMachineByPage(queryVo, new PageInput(1, 500));
//        long writeStart = System.currentTimeMillis();
//        // 分页处理
//        for (int i = 1; i <= ownData.getPages(); i++) {
//            PageInfo<VehicleMachineVo> pageData = vehicleService.queryVehicleMachineByPage(queryVo, new PageInput(i, 500));
//            List<CsVehicleExp> invalidData = new ArrayList<>();
//            CsVehicleExp vehicleExp;
//            for (VehicleMachineVo vo : pageData.getList()) {
//                // 检验数据完整性
//                if (StringUtils.isEmpty(vo.getCsvVin()) || StringUtils.isEmpty(vo.getCsmTeNo()) || StringUtils.isEmpty(vo.getCsmIccid())
//                        || StringUtils.isEmpty(vo.getCsvEngineNo()) || StringUtils.isEmpty(vo.getCsvBataccuCode())
//                        || StringUtils.isEmpty(vo.getCsvModelCodeSimple())) {
//                    vehicleExp = new CsVehicleExp();
//                    vehicleExp.setCheckTime(new Date());
//                    BeanUtils.copyProperties(vo, vehicleExp);
//                    invalidData.add(vehicleExp);
//                }
//            }
//            logger.info("正在分页处理[第" + i + "页]. 检测到{}辆异常数据", invalidData.size());
//            //批量写入mongo
//            if (invalidData.size() > 0) {
//                historyMongoTemplate.insert(invalidData, CsVehicleExp.class);
//            }
//
//        }
//
//        logger.info("数据写入mongo花费时间：" + (System.currentTimeMillis() - writeStart));
//
//    }
}
