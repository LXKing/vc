package com.ccclubs.phoenix.inf;

import com.ccclubs.phoenix.input.HistoryDeleteParam;
import com.ccclubs.phoenix.output.HistoryNoQueryOutput;

import java.util.List;

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
    HistoryNoQueryOutput deleteCarCanHistory(HistoryDeleteParam param);
    /**
     * 删除历史状态数据
     * */
    HistoryNoQueryOutput deleteCarStateHistory(HistoryDeleteParam param);

    /**
     * 批量删除历史状态数据
     * */
    HistoryNoQueryOutput deleteCarStateHistory(List<HistoryDeleteParam> paramList);

    /**
     * 删除历史国标数据
     * */
    HistoryNoQueryOutput deleteCarGbHistory(HistoryDeleteParam param);

}
