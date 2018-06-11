package com.ccclubs.admin.task.jobs;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.admin.model.CsVehicleExp;
import com.ccclubs.admin.model.SrvUser;
import com.ccclubs.admin.model.VcJobTriggerInfo;
import com.ccclubs.admin.service.ICsVehicleExpService;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.admin.service.ISrvUserService;
import com.ccclubs.admin.service.IVcJobTriggerInfoService;
import com.ccclubs.admin.task.param.ExpDataCheckJobParam;
import com.ccclubs.pub.orm.vo.VehicleMachineVo;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
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
    ICsVehicleExpService vehicleExpService;

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

//    /**
//     * 异常数据存入mongo
//     */
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
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        queryVo.setStartDate(sdf.format(DateTime.now().minusDays(jobParam.getDateRange()).toDate()));
//        long writeStart = System.currentTimeMillis();
//        // 统一一次处理
//        List<VehicleMachineVo> pageData = vehicleService.queryVehicleMachineByUser(queryVo);
//        List<CsVehicleExp> invalidData = new ArrayList<>();
//        CsVehicleExp vehicleExp;
//        for (VehicleMachineVo vo : pageData) {
//            // 检验数据完整性
//            if (StringUtils.isEmpty(vo.getCsvVin()) || StringUtils.isEmpty(vo.getCsmTeNo()) || StringUtils.isEmpty(vo.getCsmIccid())
//                    || StringUtils.isEmpty(vo.getCsvEngineNo()) || StringUtils.isEmpty(vo.getCsvBataccuCode())
//                    || StringUtils.isEmpty(vo.getCsvModelCodeSimple())) {
//                vehicleExp = new CsVehicleExp();
//                vehicleExp.setCheckTime(new Date());
//                BeanUtils.copyProperties(vo, vehicleExp);
//                invalidData.add(vehicleExp);
//            }
//        }
//        logger.info("扫描完成. 检测到 {} 辆异常数据", invalidData.size());
//        //批量写入mongo
//        if (invalidData.size() > 0) {
//            historyMongoTemplate.insert(invalidData, CsVehicleExp.class);
//        }
//
//        logger.info("数据写入mongo花费时间：" + (System.currentTimeMillis() - writeStart));
//
//    }


    /**
     * 异常车辆数据存入数据库
     */
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
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        queryVo.setStartDate(sdf.format(DateTime.now().minusDays(jobParam.getDateRange()).toDate()));
        long writeStart = System.currentTimeMillis();
        // 统一一次处理
        List<VehicleMachineVo> pageData = vehicleService.queryVehicleMachineByUser(queryVo);
        List<CsVehicleExp> invalidData = new ArrayList<>();
        CsVehicleExp vehicleExp;
        int i = 0;
        for (VehicleMachineVo vo : pageData) {
            // 检验数据完整性
            if (StringUtils.isEmpty(vo.getCsvVin()) || StringUtils.isEmpty(vo.getCsmTeNo()) || StringUtils.isEmpty(vo.getCsmIccid())
                    || StringUtils.isEmpty(vo.getCsvEngineNo()) || StringUtils.isEmpty(vo.getCsvBataccuCode())
                    || StringUtils.isEmpty(vo.getCsvModelCodeSimple())) {
                vehicleExp = new CsVehicleExp();
                //
                vehicleExp.setCsveVin(vo.getCsvVin());
                vehicleExp.setCsveTeNo(vo.getCsmTeNo());
                vehicleExp.setCsveIccid(vo.getCsmIccid());
                vehicleExp.setCsveEngineNo(vo.getCsvEngineNo());
                vehicleExp.setCsveBataccuCode(vo.getCsvBataccuCode());
                vehicleExp.setCsveModelCodeSimple(vo.getCsvModelCodeSimple());
                vehicleExp.setCsveCarNo(vo.getCsvCarNo());
                vehicleExp.setCsveNumber(vo.getCsmNumber());
                vehicleExp.setCsveProdDate(vo.getCsvProdDate());
                vehicleExp.setCsveAddTime(vo.getCsvAddTime());
                vehicleExp.setCsveTeType(vo.getCsmTeType());
                vehicleExp.setCsveModelCodeFull(vo.getCsvModelCodeFull());
                vehicleExp.setCsveTeModel(vo.getCsmTeModel());
                vehicleExp.setCsveMobile(vo.getCsmMobile());
                invalidData.add(vehicleExp);
                i++;
                if (i > 500) {
                    i = 0;
                    logger.info("扫描部分完成. 检测到 {} 辆异常数据", invalidData.size());
                    vehicleExpService.insertListSelective(invalidData);
                    invalidData.clear();
                }
            }
        }
        //批量写入数据库
        if (invalidData.size() > 0) {
            vehicleExpService.insertListSelective(invalidData);
        }
        logger.info("数据写入mongo花费时间：" + (System.currentTimeMillis() - writeStart));
    }


    public static void main(String[] args) {
        System.err.println(DateTime.now().minusDays(30).toString("yyyy-MM-dd"));

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
