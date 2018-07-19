package com.ccclubs.vehicle.inf.binding.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.common.modify.UpdateTboxBindHisService;
import com.ccclubs.common.modify.UpdateVehicleService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsTboxBindHis;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.vo.VehicleVo;
import com.ccclubs.vehicle.dto.BindVehicleInput;
import com.ccclubs.vehicle.dto.BindVehicleOutput;
import com.ccclubs.vehicle.inf.binding.BindVehicleInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * 终端绑定车辆
 *
 * @author jianghaiyang
 * @create 2017-07-03
 **/
@Service(version = VehicleServiceVersion.V1)
public class BindVehicleImpl implements BindVehicleInf {

    @Autowired
    CsVehicleMapper vdao;
    @Autowired
    QueryTerminalService queryTerminalService;
    @Autowired
    QueryVehicleService queryVehicleService;
    @Autowired
    UpdateVehicleService updateVehicleService;

    @Autowired
    UpdateTboxBindHisService updateTboxBindHisService;
    @Resource
    AuthValidateHelper authValidateHelper;
    /**
     * 车机绑定
     */
    @Override
    public BindVehicleOutput bindVehicle(BindVehicleInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        //根据vin码获取车辆信息
        CsVehicle vehicle = queryVehicleService.queryVehicleByVin(input.getVin());
        //根据终端编号获取车机信息
        CsMachine machine = queryTerminalService.queryCsMachineByTeNo(input.getTeNo());

        // 1.校验输入的车辆和终端是否存在
        if (vehicle == null) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }
        //检查车机是否存在
        if (machine == null || machine.getCsmId() == null) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }

        // 如果当前车辆所对应的车机正好就是该车机，直接返回
        if (machine.getCsmId().equals(vehicle.getCsvMachine())) {
            BindVehicleOutput output = new BindVehicleOutput();
            output.setTeNo(input.getTeNo());
            return output;
        }

        boolean vAble = isVehicleAbleToBind(vehicle);//车辆可绑定
        boolean mAble = isTerminalAbleToBind(input.getTeNo());//终端可绑定

        // 2.校验通过，终端和车辆可绑定
        if (vAble && mAble) {
            //开始绑定【更新】
            vehicle.setCsvMachine(machine.getCsmId());
            vehicle.setCsvUpdateTime(new Date());
            updateVehicleService.update(vehicle);
            //Tbox的绑定关系
            insertBindTboxLog(vehicle, machine, input.getAppId());
        }
        BindVehicleOutput output = new BindVehicleOutput();
        output.setTeNo(input.getTeNo());
        return output;
    }

    /**
     * 判断终端可否绑定
     */
    private boolean isTerminalAbleToBind(String teNo) {
        VehicleVo queryVo = new VehicleVo();
        queryVo.setTeNo(teNo);
        VehicleVo result = vdao.selectByVinAndTeNo(queryVo);
        if (null == result) {
            return true;
        } else {
            // 终端已经绑定有车辆
            throw new ApiException(ApiEnum.TERMINAL_BINDING_EXISTS, result.getVin());
        }
    }

    //判断车辆可否绑定
    private boolean isVehicleAbleToBind(CsVehicle csVehicle) {
        if (null == csVehicle.getCsvMachine() || 0 == csVehicle.getCsvMachine()) {
            return true;
        } else {
            // 车辆已经绑定有终端
            CsMachine csMachine = queryTerminalService.queryCsMachineById(csVehicle.getCsvMachine());
            // 车辆已绑定的终端信息异常，cs_machine中不存在
            if (null == csMachine) {
                return true;
            } else {
                throw new ApiException(ApiEnum.VEHICLE_BINDING_EXISTS, csVehicle.getCsvMachine());
            }
        }
    }

    /**
     * 记录Tbox绑定时的日志
     */
    public void insertBindTboxLog(CsVehicle csVehicle, CsMachine csMachine, String operateId) {
        CsTboxBindHis csTboxBindHis = new CsTboxBindHis();
        csTboxBindHis.setCstbVehicleId((long) csVehicle.getCsvId());
        csTboxBindHis.setCstbMachineId((long) csMachine.getCsmId());
        csTboxBindHis.setCstbVin(csVehicle.getCsvVin());
        csTboxBindHis.setCstbNumber(csMachine.getCsmNumber());
        csTboxBindHis.setCstbTeNo(csMachine.getCsmTeNo());
        csTboxBindHis.setCstbStartTime(new Date());
        //状态 1:正常 0:无效
        csTboxBindHis.setCstbStatus((short) 1);
        csTboxBindHis.setCstbAddTime(new Date());
        csTboxBindHis.setCstbModTime(new Date());
        if (operateId != null) {
            csTboxBindHis.setCstbBindOperId(Long.parseLong(operateId));
        }
        //操作人类型 1:运营商 2:后台用户
        csTboxBindHis.setCstbOperType((short) 1);
        updateTboxBindHisService.insert(csTboxBindHis);
    }
}
