package com.ccclubs.phoenix.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.phoenix.inf.CustomHistoryInf;
import com.ccclubs.phoenix.input.HistoryMileageInput;
import com.ccclubs.phoenix.input.HistoryTrackInput;
import com.ccclubs.phoenix.output.HistoryMileageOutput;
import com.ccclubs.phoenix.output.HistoryTrackOutput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 历史数据查询API
 *
 * @author jianghaiyang
 * @create 2018-09-26
 **/
@RestController
@RequestMapping("history")
public class CustomHistoryApi {

    @Reference(version = "1.0.0")
    CustomHistoryInf customHistoryInf;

    @PostMapping(value = "getHistoryMileageByTime")
    public ApiMessage<HistoryMileageOutput> getHistoryMileageByTime(@RequestBody HistoryMileageInput input) {
        return new ApiMessage<>(customHistoryInf.getHistoryMileageByTime(input));
    }

    @PostMapping(value = "getHistoryTrackByTime")
    public ApiMessage<HistoryTrackOutput> getHistoryTrackByTime(@RequestBody HistoryTrackInput input) {
        return new ApiMessage<>(customHistoryInf.getHistoryTrackByTime(input));
    }
}
