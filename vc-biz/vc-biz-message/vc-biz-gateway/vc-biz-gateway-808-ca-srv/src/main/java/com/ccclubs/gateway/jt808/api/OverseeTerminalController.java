package com.ccclubs.gateway.jt808.api;

import com.ccclubs.gateway.common.vo.response.Error;
import com.ccclubs.gateway.common.vo.response.OK;
import com.ccclubs.gateway.common.vo.response.R;
import com.ccclubs.gateway.jt808.service.TerOverseeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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
    public R addVin(@PathVariable("sim") String sim) {
        if (StringUtils.isNotEmpty(sim)) {
            boolean result = vehicleService.put(sim);
            return OK.Statu.SUCCESS_WITH_DATA.build().addData("result", result);
        } else {
            return Error.Statu.SIM_NOT_EXIST.build();
        }
    }

    @GetMapping("/remove/{sim}")
    public R removeVin(@PathVariable("sim") String sim) {
        if (StringUtils.isNotEmpty(sim)) {
            vehicleService.remove(sim);
            return OK.Statu.SUCCESS_WITH_DATA.build();
        } else {
            return Error.Statu.SIM_NOT_EXIST.build();
        }
    }

    @GetMapping("/clean/all/{auth}")
    public R removeAllClientCache(@PathVariable("auth")String auth) {
        if ("Andaren".equals(auth)) {
            vehicleService.removeAll();
            return OK.Statu.SUCCESS.build();
        } else {
            return Error.Statu.AUTH_FAILED.build();
        }
    }

    @GetMapping("/show/all")
    public R shwoAllOversee() {
        Set<String> sims = vehicleService.getAll();
        return OK.Statu.SUCCESS_WITH_DATA.build().addData("sims", sims);
    }
}
