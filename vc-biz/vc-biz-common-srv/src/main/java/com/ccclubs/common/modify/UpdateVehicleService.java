package com.ccclubs.common.modify;

import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 修改车辆信息
 *
 * @author jianghaiyang
 * @create 2017-07-24
 **/
@Component
public class UpdateVehicleService {

    @Autowired
    CsVehicleMapper dao;

    //@CachePut(cacheNames = "vehicles", key = "#vehicle.csvVin")
    public CsVehicle update(CsVehicle vehicle) {

        if (vehicle.getCsvId() == null) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }
        dao.updateByPrimaryKeySelective(vehicle);
        return vehicle;
    }
}
