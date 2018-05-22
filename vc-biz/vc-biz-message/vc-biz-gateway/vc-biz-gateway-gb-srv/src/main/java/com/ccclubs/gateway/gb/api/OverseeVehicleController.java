package com.ccclubs.gateway.gb.api;

import com.ccclubs.gateway.gb.service.VehicleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yeanzi
 * @Date: 2018/5/22
 * @Time: 14:50
 * Email:  yeanzhi@ccclubs.com
 * 车辆监视对外api
 */
@RestController
public class OverseeVehicleController {
    public static final Logger LOG = LoggerFactory.getLogger(OverseeVehicleController.class);

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicle/add/{vin}")
    public boolean addVin(@PathVariable("vin") String vin) {
        if (StringUtils.isNotEmpty(vin)) {
            return vehicleService.put(vin);
        } else {
            return false;
        }
    }

    @GetMapping("/vehicle/remove/{vin}")
    public boolean removeVin(@PathVariable("vin") String vin) {
        if (StringUtils.isNotEmpty(vin)) {
            vehicleService.remove(vin);
            return true;
        } else {
            return false;
        }
    }

}
