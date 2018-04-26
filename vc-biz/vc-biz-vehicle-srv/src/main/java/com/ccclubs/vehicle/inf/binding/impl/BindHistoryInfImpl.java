package com.ccclubs.vehicle.inf.binding.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.common.query.QueryTboxBindHisService;
import com.ccclubs.common.query.QueryVehicleService;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.pub.orm.model.CsTboxBindHis;
import com.ccclubs.pub.orm.model.CsTboxBindHisExample;
import com.ccclubs.pub.orm.model.CsVehicle;
import com.ccclubs.vehicle.dto.CarLifeInput;
import com.ccclubs.vehicle.dto.CarLifeOutput;
import com.ccclubs.vehicle.inf.binding.BindHistoryInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/25
 * @Time: 15:07
 * @Description: 获取车辆绑定历史记录接口实现！
 */
@Service(version = VehicleServiceVersion.V1)
public class BindHistoryInfImpl implements BindHistoryInf {

    @Autowired
    QueryVehicleService queryVehicleService;
    @Autowired
    QueryTboxBindHisService queryTboxBindHisService;

    @Override
    public List<CarLifeOutput> getBindHistoryByVin(CarLifeInput input) {
        List<CarLifeOutput> carLifeOutputList = null;
        CsVehicle vehicle = queryVehicleService.queryVehicleByVin(input.getVin());
        if (vehicle == null) {
            throw new ApiException(ApiEnum.VEHICLE_NOT_FOUND);
        }
        CsTboxBindHisExample csTboxBindHisExample = new CsTboxBindHisExample();
        CsTboxBindHisExample.Criteria criteria = csTboxBindHisExample.createCriteria();
        criteria.andcstbVinEqualTo(input.getVin());
        List<CsTboxBindHis> csTboxBindHisList = queryTboxBindHisService.selectByExample(csTboxBindHisExample);
        if (null != csTboxBindHisList && csTboxBindHisList.size() > 0) {
            carLifeOutputList = new ArrayList<>();
            for (CsTboxBindHis csTboxBindHis : csTboxBindHisList
                    ) {
                CarLifeOutput carLifeOutput = new CarLifeOutput();
                carLifeOutput.setCsVin(csTboxBindHis.getCstbVin());
                carLifeOutput.setCsNumber(csTboxBindHis.getCstbNumber());
                carLifeOutput.setCsStartTime(csTboxBindHis.getCstbStartTime());
                carLifeOutput.setCsEndTime(csTboxBindHis.getCstbEndTime());
                carLifeOutput.setCsStatus(csTboxBindHis.getCstbStatus());
                carLifeOutputList.add(carLifeOutput);
            }
        }
        return carLifeOutputList;
    }


}
