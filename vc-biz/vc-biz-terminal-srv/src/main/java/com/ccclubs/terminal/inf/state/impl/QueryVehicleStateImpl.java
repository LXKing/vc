package com.ccclubs.terminal.inf.state.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.mapper.CsMachineMapper;
import com.ccclubs.pub.orm.mapper.CsStateMapper;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.*;
import com.ccclubs.terminal.dto.VehicleStateQryOutput;
import com.ccclubs.terminal.dto.VehicleStateQryInput;
import com.ccclubs.terminal.inf.state.QueryVehicleStateInf;
import com.ccclubs.terminal.version.TerminalServiceVersion;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 车辆状态数据查询实现
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
@Service(version = TerminalServiceVersion.V1)
public class QueryVehicleStateImpl implements QueryVehicleStateInf{

    @Autowired
    private CsVehicleMapper vdao;

    @Autowired
    private CsMachineMapper mdao;

    @Autowired
    private CsStateMapper sdao;

    @Override
    @DataAuth
    public VehicleStateQryOutput getRealTimeCarState(VehicleStateQryInput input) {

        //Step1.查询车辆
        CsVehicleExample vehicleExample = new CsVehicleExample();
        CsVehicleExample.Criteria vehicleExampleCriteria = vehicleExample.createCriteria();
        vehicleExampleCriteria.andCsvVinEqualTo(input.getVin());
        List<CsVehicle> vehicleList = vdao.selectByExample(vehicleExample);

        // 未查询到车辆
        if (vehicleList.size() != 1) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }

        CsVehicle csVehicle = vehicleList.get(0);

        //Step2.查询终端
        // 未查询到终端
        if(null == csVehicle.getCsvMachine()||0==csVehicle.getCsvMachine()){
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }

        //Step3.查询状态
        CsMachine csMachine = mdao.selectByPrimaryKey(csVehicle.getCsvMachine());
        CsStateExample stateExample = new CsStateExample();
        CsStateExample.Criteria stateExampleCriteria = stateExample.createCriteria();
        stateExampleCriteria.andCssNumberEqualTo(csMachine.getCsmNumber());
        List<CsState> stateList = sdao.selectByExample(stateExample);

        // 未查询到车辆实时状态
        if (stateList.size() != 1) {
            throw new ApiException(ApiEnum.VEHICLE_STATE_NOT_FOUND);
        }
        CsState csState = stateList.get(0);
        VehicleStateQryOutput output = new VehicleStateQryOutput();
        BeanUtils.copyProperties(csState,output);
        return output;
    }
}
