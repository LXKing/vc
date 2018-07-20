package com.ccclubs.gateway.jt808.api;

import com.ccclubs.gateway.common.config.TcpServerConf;
import com.ccclubs.gateway.common.vo.response.Error;
import com.ccclubs.gateway.common.vo.response.OK;
import com.ccclubs.gateway.common.vo.response.R;
import com.ccclubs.gateway.jt808.service.RedisConnService;
import com.ccclubs.gateway.jt808.service.TerOverseeService;
import com.ccclubs.gateway.jt808.service.TerminalConnService;
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

    /**
     * 默认需要10次以上提交请求才真正执行下线所有客户端操作，防止手误
     */
    private static volatile int ALL_CLIENT_OFFLINE_CMD_COUNT = 0;

    @Autowired
    private TerOverseeService vehicleService;

    @Autowired
    private RedisConnService redisConnService;

    @Autowired
    private TerminalConnService terminalConnService;

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
            redisConnService.cleanChacheForTheFirstTime();
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

    @GetMapping("/log/{status}")
    public R openTcpServerLog(@PathVariable("status") String status) {
        if ("open".equals(status)) {
            TcpServerConf.GATEWAY_PRINT_LOG = true;
        } else if ("close".equals(status)) {
            TcpServerConf.GATEWAY_PRINT_LOG = false;
        }
        StringBuilder sharkLog = new StringBuilder();
        sharkLog.append("\n*---------------------------------------------------------------\n")
                .append("*      gateway log status:  ").append(status)
                .append("\n*---------------------------------------------------------------\n");
        LOG.info(sharkLog.toString());
        return OK.Statu.SUCCESS.build();
    }

    @GetMapping("/all/offline/{admin}/{password}")
    @Deprecated
    public R offlineAllClientByApi(@PathVariable("admin") String admin,
                                   @PathVariable("password") String password) {

        if ("Andaren".equals(admin) && "YAz20111183067".equals(password)) {
            StringBuilder cmdCountSb = new StringBuilder();
            cmdCountSb.append("\n*---------------------------------------------------------------\n")
                    .append("*      offline all client command count:  ").append(++ ALL_CLIENT_OFFLINE_CMD_COUNT)
                    .append("\n*---------------------------------------------------------------\n");
            LOG.info(cmdCountSb.toString());
            if (10 == ALL_CLIENT_OFFLINE_CMD_COUNT) {
                terminalConnService.offlineOfAll();
                LOG.warn("truely executed cmd: offline all client");
                ALL_CLIENT_OFFLINE_CMD_COUNT = 0;
                return OK.Statu.SUCCESS_WITH_DATA.build().addData("result", true);
            } else {
                return OK.Statu.SUCCESS_WITH_DATA.build().addData("count", ALL_CLIENT_OFFLINE_CMD_COUNT);
            }
        } else {
            return Error.Statu.AUTH_FAILED.build();
        }
    }

}
