package com.ccclubs.command.inf.tamper;

import com.ccclubs.command.dto.TamperInput;
import com.ccclubs.command.dto.TamperOutput;


/**
 * 防拆控制服务
 * @auther Vincent
 * @wechat luxiaotao1123
 * @data 2018/8/21
 */
public interface TamperCmdInf {

    TamperOutput tamperCommandComply(TamperInput input);
}
