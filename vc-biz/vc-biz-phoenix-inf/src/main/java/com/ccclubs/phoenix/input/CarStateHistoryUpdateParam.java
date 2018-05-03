package com.ccclubs.phoenix.input;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/3
 * @Time: 19:51
 * @Description: 国补数据更新接口输入类！
 */

public class CarStateHistoryUpdateParam  implements Serializable{

    private static final long serialVersionUID = -4936863126654154736L;

    /**
     * key为车机号或者车架号
     * 国标为车架号，can数据和历史状态数据为车机号
     */
    private String updateKey;
    /**
     * 要删除的数据的时间点
     */
    private String timePoint;

    private Float obdMiles;

    public String getUpdateKey() {
        return updateKey;
    }

    public void setUpdateKey(String updateKey) {
        this.updateKey = updateKey;
    }

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }

    public Float getObdMiles() {
        return obdMiles;
    }

    public void setObdMiles(Float obdMiles) {
        this.obdMiles = obdMiles;
    }

}
