package com.ccclubs.command.inf.update;

import com.ccclubs.command.dto.DvdVersionIntput;
import com.ccclubs.command.dto.DvdVersionOutput;

/**
 * 设置DVD车载APP最新版本（仅设置版本号）
 *
 * @author jianghaiyang
 * @create 2017-08-01
 **/
public interface SetDvdVersionInf {
    DvdVersionOutput setDvdVersion(DvdVersionIntput input);
}
