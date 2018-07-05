package com.ccclubs.gateway.jt808.api;

import com.alibaba.fastjson.JSON;
import com.ccclubs.gateway.jt808.service.TerOverseeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yeanzi
 * @Date: 2018/5/22
 * @Time: 14:50
 * Email:  yeanzhi@ccclubs.com
 * 车辆监视对外api
 */
@RestController
@RequestMapping("/ter")
public class OverseeTerminalController {
    public static final Logger LOG = LoggerFactory.getLogger(OverseeTerminalController.class);

    @Autowired
    private TerOverseeService vehicleService;

    @GetMapping("/add/{sim}")
    public boolean addVin(@PathVariable("sim") String sim) {
        if (StringUtils.isNotEmpty(sim)) {
            return vehicleService.put(sim);
        } else {
            return false;
        }
    }

    @GetMapping("/remove/{sim}")
    public boolean removeVin(@PathVariable("sim") String sim) {
        if (StringUtils.isNotEmpty(sim)) {
            vehicleService.remove(sim);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/clean/all/{auth}")
    public boolean removeAllClientCache(@PathVariable("auth")String auth) {
        if ("Andaren".equals(auth)) {
            vehicleService.removeAll();
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/show/all")
    public String shwoAllOversee() {
        return JSON.toJSONString(vehicleService.getAll());
    }

}
