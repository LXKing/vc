package com.ccclubs.common.query;

import com.ccclubs.pub.orm.mapper.CsVehicleMapper;
import com.ccclubs.pub.orm.model.CsMachine;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.pub.orm.model.CsVehicleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 车辆查询
 *
 * @author jianghaiyang
 * @create 2017-07-11
 **/
@Component
public class QueryVehicleService {

    @Autowired
    CsVehicleMapper dao;

    /**
     * 查询车辆
     *
     * @param vin 车辆VIN码
     * @return 车辆CsVehicle
     */
    //@Cacheable(cacheNames = "vehicles", key = "#vin")
    public CsVehicle queryVehicleByVin(String vin) {
        CsVehicleExample example = new CsVehicleExample();
        CsVehicleExample.Criteria criteria = example.createCriteria();
        criteria.andCsvVinEqualTo(vin);
        List<CsVehicle> list = dao.selectByExample(example);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public CsVehicle queryVehicleByMachine(Integer machine) {
        CsVehicleExample example = new CsVehicleExample();
        CsVehicleExample.Criteria criteria = example.createCriteria();
        criteria.andCsvMachineEqualTo(machine);
        List<CsVehicle> list = dao.selectByExample(example);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public CsVehicle queryVehicleById(Integer id){
        CsVehicle vehicle= dao.selectByPrimaryKey(id);
        return vehicle;
    }
}
