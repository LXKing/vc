package com.ccclubs.command.dto;

import com.ccclubs.frm.validation.constraints.InArray;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/4/10
 * @Time: 10:55
 * @Description: 语音下发输入类！
 */

public class VoiceIssuedInput extends CommonInput implements Serializable {
    /**
     * 车辆Vin码
     */
    @NotNull(message = "车辆Vin码必填")
    private String vin;
    /**
     * 编号(编号模式下)
     * */
    @NotNull(message = "语音编号不能为空")
    private Integer voiceNum;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getVoiceNum() {
        return voiceNum;
    }

    public void setVoiceNum(Integer voiceNum) {
        this.voiceNum = voiceNum;
    }
}
