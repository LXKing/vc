package com.ccclubs.command.inf.update;

import com.ccclubs.command.dto.ReturnCheckInput;
import com.ccclubs.command.dto.ReturnCheckOutput;

/**
 * 设置还车充电检查
 * 0：还车时，终端不校验车辆充电；
 * 1：还车时，终端需要校验车辆充电，不充电不允许还车。
 *
 * @author jianghaiyang
 * @create 2017-08-01
 **/
public interface ReturnCheckInf {
    ReturnCheckOutput setReturn(ReturnCheckInput input);
}
