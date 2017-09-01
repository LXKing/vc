package com.ccclubs.command.inf.air;

import com.ccclubs.command.dto.AirAllInput;
import com.ccclubs.command.dto.AirAllOutput;
import com.ccclubs.command.dto.AirMonoInput;
import com.ccclubs.command.dto.AirMonoOutput;

/**
 * 空调控制指令
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public interface AirConditionerCmdInf {

    AirMonoOutput airConditionerMonoCtrl(AirMonoInput input);

    AirAllOutput airConditionerAllCtrl(AirAllInput input);
}
