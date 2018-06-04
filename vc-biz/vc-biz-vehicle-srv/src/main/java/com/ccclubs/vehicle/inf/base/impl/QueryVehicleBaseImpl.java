package com.ccclubs.vehicle.inf.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.aop.DataAuth;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.common.validate.AuthValidateHelper;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.CsVehicleExample;
import com.ccclubs.vehicle.dto.VehicleBaseInput;
import com.ccclubs.vehicle.dto.VehicleBaseOutput;
import com.ccclubs.vehicle.inf.base.QueryVehicleBaseInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * 车辆基础信息查询实现
 *
 * @author jianghaiyang
 * @create 2017-06-28
 **/
@Service(version = VehicleServiceVersion.V1)
public class QueryVehicleBaseImpl implements QueryVehicleBaseInf {

    @Autowired
    QueryVehicleService queryVehicleService;

    @Autowired
    private VehicleProp prop;
    @Resource
    AuthValidateHelper authValidateHelper;
    @Override
    public VehicleBaseOutput getProdDateAndCarColor(VehicleBaseInput input) {

        //Step1.查询车辆
        CsVehicle csVehicle = queryVehicleService.queryVehicleByVin(input.getVin());
        // 未查询到车辆
        if (null == csVehicle) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }

        VehicleBaseOutput result = new VehicleBaseOutput();
        result.setColor(csVehicle.getCsvColorCode() == null ? null : prop.getColorMap().get(csVehicle.getCsvColorCode().toString()));
        result.setProdDate(csVehicle.getCsvProdDate() == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(csVehicle.getCsvProdDate()));

        return result;
    }
}
