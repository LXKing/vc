package com.ccclubs.vehicle.inf.modify.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.common.modify.UpdateVehicleService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.vehicle.dto.ModifyVehicleInput;
import com.ccclubs.vehicle.dto.ModifyVehicleOutput;
import com.ccclubs.vehicle.inf.modify.ModifyVehicleInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 车辆信息修改
 *
 * @author jianghaiyang
 * @create 2017-07-31
 **/
@Service(version = VehicleServiceVersion.V1)
public class ModifyVehicleImpl implements ModifyVehicleInf {

    @Autowired
    UpdateVehicleService updateVehicleService;

    @Autowired
    QueryVehicleService queryVehicleService;
    @Resource
    AuthValidateHelper authValidateHelper;
    @Override
    public ModifyVehicleOutput vehicleModify(ModifyVehicleInput input) {
        //数据权限校验
        boolean validateResult = authValidateHelper.validateAuth(input.getAppId(), input.getVin(), "");
        if (!validateResult) {
            throw new ApiException(ApiEnum.DATA_ACCESS_CHECK_FAILED);
        }
        //根据vin码获取车辆信息
        CsVehicle vehicle = queryVehicleService.queryVehicleByVin(input.getVin());
        if (null==vehicle){
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }
        //TODO：需要校验车牌号，发动机号唯一性
        BeanUtils.copyProperties(input, vehicle);
        vehicle.setCsvVin(input.getVin());
        try {
            vehicle.setCsvProdDate(new SimpleDateFormat("yyyy-MM-dd").parse(input.getCsvProdDate()));
        } catch (ParseException e) {
            throw new ApiException(ApiEnum.DATE_FORMAT_ERROR);
        }
        vehicle.setCsvUpdateTime(new Date());
        //更新车辆信息
        updateVehicleService.update(vehicle);
        return null;
    }
}
