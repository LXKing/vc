package com.ccclubs.command.inf.autopilot;

import com.ccclubs.command.dto.SiteIssuedInput;
import com.ccclubs.command.dto.SiteIssuedOutput;
import com.ccclubs.command.dto.VoiceIssuedInput;
import com.ccclubs.command.dto.VoiceIssuedOutput;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/10
 * @Time: 10:36
 * @Description: 自动驾驶语音编号下发和站点下发！
 */
public interface AutopilotInf {

    /**
     * 语音编号下发
     * */
    VoiceIssuedOutput voiceCommandComply(VoiceIssuedInput voiceIssuedInput);

    /**
     * 目标站点下发
     * */
    SiteIssuedOutput siteCommandComply(SiteIssuedInput siteIssuedInput);

}
