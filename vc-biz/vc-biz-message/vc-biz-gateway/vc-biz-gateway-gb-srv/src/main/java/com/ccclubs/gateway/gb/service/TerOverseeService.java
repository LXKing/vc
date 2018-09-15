package com.ccclubs.gateway.gb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yeanzi
 * @Date: 2018/5/22
 * @Time: 14:32
 * Email:  yeanzhi@ccclubs.com
 * 终端监控服务类
 */
@Service
public class TerOverseeService {
    private static final Logger LOG = LoggerFactory.getLogger(TerOverseeService.class);

    private static final Integer MAX_SIZE_VIN = 128;
    // 目标车辆列表
    private static final Set<String> VEHICLE_VINS = new HashSet<String>(32) {{
        add("test");
    }};

    public void removeAll() {
        VEHICLE_VINS.clear();
    }

    public Set getAll() {
        return VEHICLE_VINS;
    }

    public boolean put(String newVin) {
        if (MAX_SIZE_VIN < VEHICLE_VINS.size()) {
            LOG.error("监视车辆达到最大值, 不能继续添加");
            return false;
        }
        VEHICLE_VINS.add(newVin);
        LOG.info("新增监视终端：[{}]", newVin);
        return true;
    }

    public void remove(String vin) {
        VEHICLE_VINS.remove(vin);
        LOG.info("移除监视终端：[{}]", vin);
    }



}
