package com.ccclubs.vehicle.inf.binding.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.common.modify.UpdateVehicleService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.vehicle.dto.UnBindVehicleInput;
import com.ccclubs.vehicle.dto.UnBindVehicleOutput;
import com.ccclubs.vehicle.inf.binding.UnBindVehicleInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 终端车辆解绑
 *
 * @author jianghaiyang
 * @create 2017-07-05
 **/
@Service(version = VehicleServiceVersion.V1)
public class UnBindVehicleImpl implements UnBindVehicleInf {

    @Autowired
    QueryTerminalService queryTerminalService;
    @Autowired
    QueryVehicleService queryVehicleService;
    @Autowired
    UpdateVehicleService updateVehicleService;

    @Override
    @DataAuth
    public UnBindVehicleOutput unBindVehicle(UnBindVehicleInput input) {

        CsVehicle vehicle = queryVehicleService.queryVehicleByVin(input.getVin());
        CsMachine machine = queryTerminalService.queryCsMachineByTeNo(input.getTeNo());

        // 1.校验输入的车辆和终端是否存在
        if (vehicle == null) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }

        if (machine == null) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }

        if (machine.getCsmId().equals(vehicle.getCsvMachine())) {
            //开始解绑
            vehicle.setCsvMachine(null);
            vehicle.setCsvUpdateTime(new Date());
            updateVehicleService.unbindTbox(vehicle);
        } else {
            throw new ApiException(ApiEnum.NO_BINDING_EXISTS, input.getVin(), input.getTeNo());
        }
        return null;
    }
}
