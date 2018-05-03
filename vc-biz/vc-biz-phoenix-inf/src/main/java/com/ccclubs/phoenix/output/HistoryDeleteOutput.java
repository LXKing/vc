package com.ccclubs.phoenix.output;

import com.ccclubs.phoenix.input.HistoryDeleteParam;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/3
 * @Time: 10:20
 * @Description: 删除历史数据成功和失败的条数！
 */

public class HistoryDeleteOutput implements Serializable {
    private static final long serialVersionUID = -7643219290033330764L;

    /**
     * 成功删除的数量
     */
    private Integer successCount;

    private List<HistoryDeleteParam> fialdsKey;

    private Integer failureCount;

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(Integer failureCount) {
        this.failureCount = failureCount;
    }

    public List<HistoryDeleteParam> getFialdsKey() {
        return fialdsKey;
    }

    public void setFialdsKey(List<HistoryDeleteParam> fialdsKey) {
        this.fialdsKey = fialdsKey;
    }
}
