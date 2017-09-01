package com.ccclubs.terminal.inf.state;

import com.ccclubs.terminal.dto.TerminalQryInput;
import com.ccclubs.terminal.dto.TerminalQryOutput;
import com.ccclubs.terminal.dto.VersionQryInput;
import com.ccclubs.terminal.dto.VersionQryOutput;

/**
 * 终端自身配置信息
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
public interface QueryTerminalInfoInf {
    Byte TL_TYPE = 3;//通领终端类型
    VersionQryOutput isLatestVersion(VersionQryInput input);
    TerminalQryOutput getTerminalInfo(TerminalQryInput input);
}
