package com.ccclubs.vehicle.inf.binding.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.common.modify.UpdateTboxBindHisService;
import com.ccclubs.common.modify.UpdateVehicleService;
import com.ccclubs.common.query.QueryTboxBindHisService;
import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsTboxBindHis;
import com.ccclubs.pub.orm.model.CsTboxBindHisExample;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.vehicle.dto.UnBindVehicleInput;
import com.ccclubs.vehicle.dto.UnBindVehicleOutput;
import com.ccclubs.vehicle.inf.binding.UnBindVehicleInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import org.springframework.beans.factory.annotation.Autowired;
import sun.util.resources.ga.LocaleNames_ga;

import java.util.Date;
import java.util.List;

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

    @Autowired
    UpdateTboxBindHisService updateTboxBindHisService;

    @Autowired
    QueryTboxBindHisService queryTboxBindHisService;

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
            //记录tobxd的解绑关系
            CsTboxBindHis record=new CsTboxBindHis();
            record.setCstbEndTime(new Date());
            record.setCstbModTime(new Date());
            //
            CsTboxBindHisExample example=new CsTboxBindHisExample();
            CsTboxBindHisExample.Criteria criteria=example.createCriteria();
            criteria.andcstbVehicleIdEqualTo((long)vehicle.getCsvId());
            criteria.andcstbMachineIdEqualTo((long)machine.getCsmId());
            criteria.andcstbEndTimeIsNull();
            List<CsTboxBindHis> list=queryTboxBindHisService.selectByExample(example);
            if(list==null||list.isEmpty()){
                record.setCstbVehicleId((long)vehicle.getCsvId());
                record.setCstbMachineId((long)machine.getCsmId());
                record.setCstbStartTime(new Date());
                //状态 1:正常 0:无效
                record.setCstbStatus((short)1);
                record.setCstbAddTime(new Date());
                record.setCstbModTime(new Date());
                record.setCstbEndTime(new Date());
                if(input.getAppId()!=null){
                    record.setCstbOperId(Long.parseLong(input.getAppId()));
                }
                //操作人类型 1:运营商 2:后台用户
                record.setCstbOperType((short)1);
                updateTboxBindHisService.insert(record);
            }else {
                updateTboxBindHisService.updateByExampleSelective(record,example);
            }
        } else {
            throw new ApiException(ApiEnum.NO_BINDING_EXISTS, input.getVin(), input.getTeNo());
        }
        return null;
    }
}
