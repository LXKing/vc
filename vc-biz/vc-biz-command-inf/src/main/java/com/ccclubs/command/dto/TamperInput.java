package com.ccclubs.command.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 防拆输入流
 * @auther Vincent
 * @wechat luxiaotao1123
 * @data 2018/8/21
 */
public class TamperInput extends CommonInput implements Serializable {

    /**
     * 车辆Vin码
     */
    @NotNull(message = "车辆Vin码必填")
    private String vin;

    /**
     * 开启：1     /   关闭：0
     */
    @NotNull(message = "控制参数必填")
    private Integer code;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String codeToHexString(){
        String hexStr = null;
        if (code == 1){
            hexStr = "0x01";
        }else if (code == 0){
            hexStr = "0x00";
        }
        return hexStr;
    }
}
