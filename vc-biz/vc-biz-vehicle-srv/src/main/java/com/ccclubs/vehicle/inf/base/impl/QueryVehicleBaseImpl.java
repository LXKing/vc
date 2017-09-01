package com.ccclubs.vehicle.inf.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.aop.DataAuth;
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
    private CsVehicleMapper dao;

    @Autowired
    private VehicleProp prop;

    @Override
//    @DataAuth
    public VehicleBaseOutput getProdDateAndCarColor(VehicleBaseInput input) {

        CsVehicleExample example = new CsVehicleExample();
        CsVehicleExample.Criteria criteria = example.createCriteria();
        criteria.andCsvVinEqualTo(input.getVin());
        List<CsVehicle> list = dao.selectByExample(example);

        // 未查询到车辆
        if (list.size() != 1) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }

        VehicleBaseOutput result = new VehicleBaseOutput();
        CsVehicle csVehicle = list.get(0);

        result.setColor(csVehicle.getCsvColorCode() == null ? null : prop.getColorMap().get(csVehicle.getCsvColorCode().toString()));
        result.setProdDate(csVehicle.getCsvProdDate() == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(csVehicle.getCsvProdDate()));

        return result;
    }
}
