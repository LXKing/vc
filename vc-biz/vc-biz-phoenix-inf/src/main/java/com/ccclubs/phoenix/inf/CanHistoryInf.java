package com.ccclubs.phoenix.inf;

import com.ccclubs.phoenix.input.CanParam;
import com.ccclubs.phoenix.input.CanStateParam;
import com.ccclubs.phoenix.orm.dto.CanDto;
import com.ccclubs.phoenix.orm.dto.CanStateDto;
import com.ccclubs.phoenix.output.CanHistoryOutput;

import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/15
 * @Time: 16:02
 * @Description: CAN数据历史数据查询接口！
 */
public interface CanHistoryInf {
    //查询车辆状态信息
    List<CanDto> queryCanDtoList(CanParam param);

    //查询车辆状态信息记录总数
    Long queryListCount(CanParam param);

    //查询车辆状态信息(封装)
    CanHistoryOutput queryListByParam(CanParam param);

    /**
     * 2018/9/17
     * queryCanStateDto 查询车辆状态信息详情
     *
     * @param param
     * @return com.ccclubs.phoenix.orm.dto.CanStateDto
     * @author machuanpeng
     */
    CanStateDto queryCanStateDto(CanStateParam param);
}
