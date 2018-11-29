package com.ccclubs.admin.task.jobs;

import com.ccclubs.admin.entity.CsVehicleExpCriteria;
import com.ccclubs.admin.service.ICsVehicleExpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 清理mongo数据
 *
 * @author jianghaiyang
 * @create 2018-03-08
 **/
@Service
public class ExpDataCleanJob implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ExpDataCleanJob.class);

    @Resource
    ICsVehicleExpService csVehicleExpService;

    @Override
    public void run() {
        logger.info("车辆异常数据开始清理...");
        CsVehicleExpCriteria example = new CsVehicleExpCriteria();
        CsVehicleExpCriteria.Criteria criteria = example.createCriteria();
        criteria.andCsveIdIsNotNull();
        csVehicleExpService.deleteByExample(example);
        // 清空mysql异常数据
        logger.info("车辆异常数据清理完成.");
    }
}
