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

    /**
     * 语音类型
     * 0x0：追加播放
     * 0x1：覆盖播放 (实际值应该为128=0x80)
     * */
    @NotNull(message = "语音类型不能为空")
    @InArray(range = {0,1},message = "0:追加播放,1:覆盖播放")
    private Integer voiceType;

    public Integer getVoiceType() {

        if (voiceType==1){
            return 128;
        }
        return voiceType;

    }

    public void setVoiceType(Integer voiceType) {
        this.voiceType = voiceType;
    }

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
