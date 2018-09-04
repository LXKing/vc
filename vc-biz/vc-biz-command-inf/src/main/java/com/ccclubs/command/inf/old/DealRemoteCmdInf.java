package com.ccclubs.command.inf.old;

import com.ccclubs.command.dto.DealRemoteCmdInput;
import com.ccclubs.command.dto.DealRemoteCmdOutput;

/**
 * 远程下发指令
 *
 * @author jianghaiyang
 * @create 2018-08-16
 **/
public interface DealRemoteCmdInf {

    /**
     * 提供远程指令下发功能
     *
     * @param input
     * @return
     */
    DealRemoteCmdOutput dealRemoteCommand(DealRemoteCmdInput input);
}
