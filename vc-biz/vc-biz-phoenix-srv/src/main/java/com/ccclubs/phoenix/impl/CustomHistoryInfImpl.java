package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.phoenix.inf.CustomHistoryInf;
import com.ccclubs.phoenix.inf.MqttStateHistoryInf;
import com.ccclubs.phoenix.input.HistoryMileageInput;
import com.ccclubs.phoenix.input.HistoryTrackInput;
import com.ccclubs.phoenix.input.MqttStateParam;
import com.ccclubs.phoenix.orm.dto.MqttStateDto;
import com.ccclubs.phoenix.output.HistoryMileageOutput;
import com.ccclubs.phoenix.output.HistoryTrackOutput;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 查询接口
 *
 * @author jianghaiyang
 * @create 2018-09-26
 **/
@Service(version = "1.0.0")
public class CustomHistoryInfImpl implements CustomHistoryInf {

    private static final Logger LOG = LoggerFactory.getLogger(CustomHistoryInfImpl.class);

    @Resource
    MqttStateHistoryInf mqttStateHistoryInf;

    /**
     * 时间区间里程数
     *
     * @param input
     *
     * @return
     */
    @Override
    public HistoryMileageOutput getHistoryMileageByTime(HistoryMileageInput input) {
        HistoryMileageOutput output = new HistoryMileageOutput();
        DateTime startTime = new DateTime(input.getStartTime());
        DateTime endTime = new DateTime(input.getEndTime());
        Period p = new Period(startTime, endTime, PeriodType.days());
        int days = p.getDays();
        if (days > 1) {
            throw new ApiException(ApiEnum.FAIL.code(), "时间区间不能大于一天");
        }
        float startMile;
        float endMile;
        MqttStateParam query = new MqttStateParam();
        query.setVin(input.getVin());
        query.setStartTime(startTime.toString("yyyy-MM-dd HH:mm:ss"));
        query.setEndTime(endTime.toString("yyyy-MM-dd HH:mm:ss"));
        query.setQueryFields("current_time,obd_miles");
        query.setOrderBy("order by current_time asc");
        query.setPageSize(1);
        List<MqttStateDto> startData = mqttStateHistoryInf.queryMqttStateDtoList(query);
        if (startData.isEmpty()) {
            throw new ApiException(ApiEnum.FAIL.code(), "未查询到历史数据");
        } else {
            startMile = startData.get(0).getObdMiles();
        }
        query.setOrderBy("order by current_time desc");
        List<MqttStateDto> endData = mqttStateHistoryInf.queryMqttStateDtoList(query);
        if (endData.isEmpty()) {
            throw new ApiException(ApiEnum.FAIL.code(), "未查询到历史数据");
        } else {
            endMile = endData.get(0).getObdMiles();
        }
        if ((endMile - startMile) < 0) {
            LOG.warn("[查询时间区间内里程数][数据异常,计算出里程为负]");
            throw new ApiException(ApiEnum.FAIL.code(), "未查询到历史数据");
        }
        BigDecimal totalMileage = new BigDecimal(endMile - startMile)
                .setScale(1, BigDecimal.ROUND_UP);
        output.setTotalMileage(totalMileage);
        return output;
    }

    /**
     * 时间区间内行驶轨迹
     *
     * @param input
     *
     * @return
     */
    @Override
    public HistoryTrackOutput getHistoryTrackByTime(HistoryTrackInput input) {
        /**
         * 校验查询时间范围
         */
        HistoryTrackOutput output = new HistoryTrackOutput();
        DateTime startTime = new DateTime(input.getStartTime());
        DateTime endTime = new DateTime(input.getEndTime());
        Period p = new Period(startTime, endTime, PeriodType.days());
        int days = p.getDays();
        if (days > 1) {
            throw new ApiException(ApiEnum.FAIL.code(), "时间区间不能大于一天");
        }
        MqttStateParam query = new MqttStateParam();
        query.setVin(input.getVin());
        query.setStartTime(startTime.toString("yyyy-MM-dd HH:mm:ss"));
        query.setEndTime(endTime.toString("yyyy-MM-dd HH:mm:ss"));
        query.setQueryFields("longitude,latitude");
        query.setOrderBy("order by current_time asc");
        List<MqttStateDto> trackData = mqttStateHistoryInf.queryMqttStateDtoList(query);
        if (trackData.isEmpty()) {
            throw new ApiException(ApiEnum.FAIL.code(), "未查询到历史轨迹");
        } else {
            output.setVin(input.getVin());
            output.setTracks(trackData);
        }
        return output;
    }
}
