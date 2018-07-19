package com.ccclubs.command.inf.power;

import com.ccclubs.command.dto.PowerModeInput;
import com.ccclubs.command.dto.PowerModeOutput;

/**
 * 省电模式切换
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public interface PowerModeSwitchInf {
    /**
     * 省电模式开关
     * @param input
     * @return
     */
    PowerModeOutput powerModeSwitch(PowerModeInput input);
}
