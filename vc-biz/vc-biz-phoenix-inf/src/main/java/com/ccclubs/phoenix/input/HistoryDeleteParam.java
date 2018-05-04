package com.ccclubs.phoenix.input;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/3
 * @Time: 10:17
 * @Description: 大数据删除数据的输入参数！
 */

public class HistoryDeleteParam implements Serializable {
    private static final long serialVersionUID = -6467675661852380739L;

    /**
     * key为车机号或者车架号
     * 国标为车架号，can数据和历史状态数据为车机号
     */
    private String deleteKey;
    /**
     * 要删除的数据的时间点
     */
    private String timePoint;

    public String getDeleteKey() {
        return deleteKey;
    }

    public void setDeleteKey(String deleteKey) {
        this.deleteKey = deleteKey;
    }

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }


}
