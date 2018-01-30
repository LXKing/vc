package com.ccclubs.command.inf.cmd808;

import com.ccclubs.command.dto.Send808CmdInput;
import com.ccclubs.command.dto.Send808CmdOutput;

/**
 * 808指令
 *
 * @author jianghaiyang
 * @create 2018-01-24
 **/
public interface Cmd808Inf {
    Send808CmdOutput send808CmdInf(Send808CmdInput input);
}
