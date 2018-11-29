package com.ccclubs.vehicle.inf.binding;

import com.ccclubs.vehicle.dto.CarLifeInput;
import com.ccclubs.vehicle.dto.CarLifeOutput;

import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/25
 * @Time: 14:57
 * @Description: 获取车辆绑定历史记录接口！
 */
public interface BindHistoryInf {
    //通过车架号获取车机生命周期信息
    List<CarLifeOutput> getBindHistoryByVin(CarLifeInput input);
}
