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
 * 车辆服务类
 */
@Service
public class VehicleService {
    private static final Logger LOG = LoggerFactory.getLogger(VehicleService.class);

    private static final Integer MAX_SIZE_VIN = 128;
    // 目标车辆列表
    private static final Set<String> VEHICLE_VINS = new HashSet<String>(32) {{
        add("LJ8E3A5MXGB001117");
        add("LJ8E3C1M5GB008817");
        add("LJ8E3C1M5GB010065");
        add("LJ8E3C1M8GB011016");
        add("LJ8E3C1M1GB008152");
        add("LJ8E3C1M9GB010635");
        add("LJ8E3A1M1FB001074");
        add("LJ8E3C1M8GB008116");
        add("LJ8E3C1MXGB003628");
        add("LJ8E3C1MXGB009476");
        add("LJ8E3C1M4GB008842");
        add("LJ8E3C1M3HD314565");
        add("LJ8E3C1M0HD310845");
        add("LJ8M3A5M5GB002302");
        add("LJ8E3C1M6HD003401");
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
        LOG.info("新增监视车辆：[{}]", newVin);
        return true;
    }

    public void remove(String vin) {
        VEHICLE_VINS.remove(vin);
        LOG.info("移除监视车辆：[{}]", vin);
    }



}
