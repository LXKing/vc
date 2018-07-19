package com.ccclubs.command.inf.time;

import com.ccclubs.command.dto.TimeSyncInput;
import com.ccclubs.command.dto.TimeSyncOutput;

/**
 * 终端校时指令
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public interface TimeSyncCmdInf {
    /**
     * 时间同步
     */
    TimeSyncOutput timeSynchronization(TimeSyncInput input);
}
