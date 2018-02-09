package com.ccclubs.job.executor.jobhandler;

import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.job.core.biz.model.ReturnT;
import com.ccclubs.job.core.handler.IJobHandler;
import com.ccclubs.job.core.handler.annotation.JobHandler;
import com.ccclubs.job.core.log.XxlJobLogger;
import com.ccclubs.job.executor.service.SendMailService;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.SrvUser;
import com.ccclubs.pub.orm.page.PageInput;
import com.ccclubs.pub.orm.vo.VehicleMachineVo;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 车辆异常数据巡检
 *
 * @author jianghaiyang
 * @create 2018-02-07
 **/
@JobHandler(value = "checkExpVehicleJobHandler")
@Component
public class CheckExpVehicleJobHandler extends IJobHandler {

    private static Logger logger = LoggerFactory.getLogger(CheckExpVehicleJobHandler.class);

    @Resource
    QueryVehicleService vehicleService;

    @Resource
    SendMailService sendMailService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource(name = "historyMongoTemplate")
    MongoTemplate historyMongoTemplate;

    @Value("${email.to_email}")
    private String TO_EMAIL; //收件人用户名

    /**
     * execute handler, invoked when executor receives a scheduling request
     * 每天0点执行：0 0 0 1/1 * ?
     * @param param 用户登录名
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("车辆数据开始巡检..");
        //清空mongo异常数据
        historyMongoTemplate.dropCollection(VehicleMachineVo.class);
        SrvUser user = vehicleService.querySrvUserByUsername(param);
        if (null == user) {
            return FAIL;
        }
        VehicleMachineVo queryVo = new VehicleMachineVo();
        queryVo.setUserId(user.getSuId());
        PageInfo<VehicleMachineVo> ownData = vehicleService.queryVehicleMachineByPage(queryVo, new PageInput(1, 100));
        for (int i = 1; i <= ownData.getPages(); i++) {
            PageInfo<VehicleMachineVo> pageData = vehicleService.queryVehicleMachineByPage(queryVo, new PageInput(i, 100));
            List<VehicleMachineVo> invalidData = new ArrayList<>();
            for (VehicleMachineVo vo : pageData.getList()) {
                // 检验数据完整性
                if (StringUtils.isEmpty(vo.getCsvVin()) || StringUtils.isEmpty(vo.getCsmTeNo()) || StringUtils.isEmpty(vo.getCsmIccid())
                        || StringUtils.isEmpty(vo.getCsvEngineNo()) || StringUtils.isEmpty(vo.getCsvBataccuCode())
                        || StringUtils.isEmpty(vo.getCsvModelCodeSimple())) {
                    invalidData.add(vo);
                }
            }
            XxlJobLogger.log("正在分页处理[第" + i + "页].");
            //写入mongo
            historyMongoTemplate.insertAll(invalidData);
        }
        List<VehicleMachineVo> listToExport = historyMongoTemplate.findAll(VehicleMachineVo.class);
        if (listToExport.size() > 0) {
            XxlJobLogger.log("检测到 "+listToExport.size()+" 条数据异常的车辆，开始导出异常数据并发送邮件.");
            // todo 导出Excel 发邮件
            // sendMailService.sendMultiPartEmail
        }
        return SUCCESS;
    }
}
