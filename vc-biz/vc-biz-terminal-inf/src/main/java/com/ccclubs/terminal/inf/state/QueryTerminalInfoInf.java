package com.ccclubs.terminal.inf.state;

import com.ccclubs.terminal.dto.TerminalListQryInput;
import com.ccclubs.terminal.dto.TerminalQryInput;
import com.ccclubs.terminal.dto.TerminalQryOutput;
import com.ccclubs.terminal.dto.VersionQryInput;
import com.ccclubs.terminal.dto.VersionQryOutput;
import java.util.List;

/**
 * 终端自身配置信息
 *
 * @author jianghaiyang
 * @create 2017-06-29
 **/
public interface QueryTerminalInfoInf {
    Byte TL_TYPE = 3;//通领终端类型

    //判断是否最新版本
    VersionQryOutput isLatestVersion(VersionQryInput input);

    //状态信息的实时读取
    TerminalQryOutput getTerminalInfo(TerminalQryInput input);

    //通过序列号获取终端信息
    List<TerminalQryOutput> searchTerminalInfo(TerminalListQryInput input);
}
