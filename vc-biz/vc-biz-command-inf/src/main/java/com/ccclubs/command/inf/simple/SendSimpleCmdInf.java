package com.ccclubs.command.inf.simple;

import com.ccclubs.command.dto.SimpleCmdInput;
import com.ccclubs.command.dto.SimpleCmdOutput;

/**
 * 简单指令下发
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public interface SendSimpleCmdInf {
    /**
     * 下发简单指令
     * @param input
     * @return
     */
    SimpleCmdOutput sendSimpleCmd(SimpleCmdInput input);
}
