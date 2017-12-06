package com.ccclubs.phoenix.impl;

import com.ccclubs.common.query.QueryTerminalService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.phoenix.inf.TransformForBizInf;
import com.ccclubs.pub.orm.model.CsVehicle;
import org.springframework.beans.factory.annotation.Autowired;

public class TransformForBizInfImpl implements TransformForBizInf {

    @Autowired
    private QueryTerminalService queryTerminalService;
    @Autowired
    private QueryVehicleService queryVehicleService;

    @Override
    public String getCsNumberByCsVin(String csVin) {
        if (null!=csVin&&!csVin.isEmpty()){
            CsVehicle csVehicle=queryVehicleService.queryVehicleByVin(csVin);
            if (null!=csVehicle&&null!=csVehicle.getCsvMachine()){
                Integer csMachineId=csVehicle.getCsvMachine();
                return queryTerminalService.queryCsMachineById(csMachineId).getCsmNumber();
            }

        }
        return null;
    }
}
