package com.ccclubs.phoenix.inf;

import com.ccclubs.phoenix.input.HistoryMileageInput;
import com.ccclubs.phoenix.input.HistoryTrackInput;
import com.ccclubs.phoenix.output.HistoryMileageOutput;
import com.ccclubs.phoenix.output.HistoryTrackOutput;

/**
 * 历史数据查询
 *
 * @author jianghaiyang
 * @create 2018-09-26
 **/
public interface CustomHistoryInf {

    /**
     * 时间区间里程数
     *
     * @param input
     *
     * @return
     */
    HistoryMileageOutput getHistoryMileageByTime(HistoryMileageInput input);

    /**
     * 时间区间内行驶轨迹
     *
     * @param input
     *
     * @return
     */
    HistoryTrackOutput getHistoryTrackByTime(HistoryTrackInput input);
}
