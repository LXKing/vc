package com.ccclubs.terminal.inf.upgrade;

import com.ccclubs.terminal.dto.AbleUpgradeInput;
import com.ccclubs.terminal.dto.AbleUpgradeOutput;
import com.ccclubs.terminal.dto.TboxVersionInput;
import com.ccclubs.terminal.dto.TboxVersionOutput;

import java.util.List;

/**
 * 终端升级相关接口
 *
 * @author jianghaiyang
 * @create 2018-07-24
 **/
public interface UpgradeInf {
    /**
     * 获取终端可升级的版本列表
     *
     * @param input
     * @return
     */
    List<AbleUpgradeOutput> getAbleUpgradeList(AbleUpgradeInput input);

    /**
     * 获取终端版本升级进度
     *
     * @param input
     * @return
     */
    TboxVersionOutput getTboxVersionInfo(TboxVersionInput input);
}
