package com.ccclubs.command.util;

import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 校验服务，校验参数 VIN:车辆Vin码，teNo:终端序列号
 * <p>
 * 1.车辆是否存在 2.车辆关联的终端是否存在 3.车辆是否关联有终端 4.终端是否存在 5.终端是否关联有车辆 6.机车绑定关系是否正常
 *
 * @author jianghaiyang
 * @create 2017-07-05
 **/
@Component
public class ValidateHelper {

    @Autowired
    QueryVehicleService queryVehicleService;

    @Autowired
    QueryTerminalService queryTerminalService;

    public boolean isVehicleExists(String vin) {

        CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(vin);
        // 未查询到车辆
        if (null == csVehicle) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }

        return true;
    }

    public boolean isMachineExists(String teNo) {

        CsMachine machine = queryTerminalService.queryCsMachineByTeNo(teNo);
        // 未查询到终端
        if (null == machine) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }

        return true;
    }

    /**
     * 机车绑定关系是否正常,如下查询链路有结果即为正常绑定 vin->CsVehicle->csv_machine->CsMachine
     *
     * @return 正常则返回终端信息，否则抛出异常
     */
    public Map isVehicleAndCsMachineBoundRight(String vin) {
        // 查询到车辆
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(vin);
        // 未查询到车辆
        if (null == csVehicle) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }

        // 未绑定到终端
        if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }
        CsMachine csMachine = queryTerminalService.queryCsMachineById(csVehicle.getCsvMachine());
        // 终端已经不存在了
        if (null == csMachine) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(CommandConstants.MAP_KEY_CSVEHICLE, csVehicle);
        map.put(CommandConstants.MAP_KEY_CSMACHINE, csMachine);
        return map;
    }
}
