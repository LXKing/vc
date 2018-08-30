package com.ccclubs.terminal.inf.state.impl;

import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_ONLINE;
import static com.ccclubs.frm.spring.constant.RedisConst.REDIS_KEY_RT_STATES;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.query.QueryStateService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.frm.spring.util.BeanMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsState;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.terminal.dto.VehicleOnlineInput;
import com.ccclubs.terminal.dto.VehicleOnlineOutput;
import com.ccclubs.terminal.dto.VehicleStateQryInput;
import com.ccclubs.terminal.dto.VehicleStateQryOutput;
import com.ccclubs.terminal.dto.VehicleStatesQryInput;
import com.ccclubs.terminal.dto.VehicleStatesQryOutput;
import com.ccclubs.terminal.inf.state.QueryVehicleStateInf;
import com.ccclubs.terminal.version.TerminalServiceVersion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 车辆状态数据查询实现
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
@Service(version = TerminalServiceVersion.V1)
public class QueryVehicleStateImpl implements QueryVehicleStateInf {

    @Autowired
    QueryVehicleService queryVehicleService;

    @Autowired
    QueryTerminalService queryTerminalService;

    @Autowired
    private QueryStateService queryStateService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    AuthValidateHelper authValidateHelper;

    @Override
    public VehicleStateQryOutput getRealTimeCarState(VehicleStateQryInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper
                .validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }

        //Step1.查询车辆
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVinFromCache(input.getVin());
        // 未查询到车辆
        if (null == csVehicle) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }

        //Step2.查询终端
        // 未查询到终端
        if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }
        CsMachine csMachine = queryTerminalService.queryCsMachineByIdFromCache(csVehicle.getCsvMachine());
        if (null == csMachine) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }

        //Step3.查询状态
        /*CsState csState = (CsState) redisTemplate.opsForHash()
                .get(REDIS_KEY_RT_STATES, csMachine.getCsmNumber());
        if (null == csState) {
            CsState csState = queryStateService.queryStateByVehicleId(csVehicle.getCsvId());
        }*/
        CsState csState = queryStateService.queryStateByVehicleId(csVehicle.getCsvId());
        if (null == csState) {
            throw new ApiException(ApiEnum.VEHICLE_STATE_NOT_FOUND);
        }
        VehicleStateQryOutput output = BeanMapper.map(csState, VehicleStateQryOutput.class);
        return output;
    }

    @Override
    public VehicleStatesQryOutput getRealTimeCarStates(VehicleStatesQryInput input) {
        VehicleStatesQryOutput output = new VehicleStatesQryOutput();
        List<VehicleStateQryOutput> vehicleStateQryOutputList = new ArrayList<>();
        String[] vins = input.getVins();
        for (String vin : vins) {
            //根据vin码获取车辆信息
            CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(vin);
            // 未查询到车辆
            if (null == csVehicle) {
                continue;
            }

            //Step2.查询终端
            // 未查询到终端
            if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
                continue;
            }

            //Step3.查询状态
            CsState csState = queryStateService.queryStateByVehicleId(csVehicle.getCsvId());
            if (null == csState) {
                continue;
            }
            VehicleStateQryOutput vehicleStateQryOutput = new VehicleStateQryOutput();
            BeanUtils.copyProperties(csState, vehicleStateQryOutput);
            vehicleStateQryOutput.setCssVin(vin);
            vehicleStateQryOutputList.add(vehicleStateQryOutput);
        }
        output.setVehicleStateQryOutputList(vehicleStateQryOutputList);
        return output;
    }

    /**
     * 车辆在线状态判断
     */
    @Override
    public VehicleOnlineOutput isOnline(VehicleOnlineInput input) {
        //根据vin码获取车辆信息
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVinFromCache(input.getVin());
        // 未查询到车辆
        if (null == csVehicle) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }

        // 未查询到终端
        if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }
        //根据id获取车机信息
        CsMachine csMachine = queryTerminalService.queryCsMachineById(csVehicle.getCsvMachine());
        if (null == csMachine) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }
        int protocol =
                null == csMachine.getCsmProtocol() ? -1 : csMachine.getCsmProtocol().intValue();
        boolean isOnline = true;
        switch (protocol) {
            // MQTT协议使用车机号 -> MqttMessageProcessService.java
            case 1:
                isOnline = (null != redisTemplate.opsForValue()
                        .get(REDIS_KEY_ONLINE + csMachine.getCsmNumber()));
                break;
            // JT808协议使用手机卡号 -> JT808ServerHandler.java
            case 2:
                isOnline = (null != redisTemplate.opsForValue()
                        .get(REDIS_KEY_ONLINE + csMachine.getCsmMobile()));
                break;
            default:
                break;
        }
        VehicleOnlineOutput output = new VehicleOnlineOutput();
        output.setOnline(isOnline);
        return output;
    }

}
