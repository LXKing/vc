package com.ccclubs.phoenix.inf;

import com.ccclubs.phoenix.input.HistoryDeleteParam;
import com.ccclubs.phoenix.output.HistoryDeleteOutput;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/3
 * @Time: 11:05
 * @Description: 删除历史数据接口！
 */
public interface CarHistoryDeleteInf {

    /**
     * 删除历史can数据
     * */
    HistoryDeleteOutput deleteCarCanHistory(HistoryDeleteParam param);
    /**
     * 删除历史状态数据
     * */
    HistoryDeleteOutput deleteCarStateHistory(HistoryDeleteParam param);
    /**
     * 删除历史国标数据
     * */
    HistoryDeleteOutput deleteCarGbHistory(HistoryDeleteParam param);

}
