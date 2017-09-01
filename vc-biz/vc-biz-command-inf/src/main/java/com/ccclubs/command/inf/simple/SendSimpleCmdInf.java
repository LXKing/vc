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
    SimpleCmdOutput sendSimpleCmd(SimpleCmdInput input);
}
