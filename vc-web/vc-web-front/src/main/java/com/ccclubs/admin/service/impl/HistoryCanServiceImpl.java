package com.ccclubs.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.admin.model.HistoryCan;
import com.ccclubs.admin.model.HistoryState;
import com.ccclubs.admin.query.HistoryCanQuery;
import com.ccclubs.admin.service.IHistoryCanService;
import com.ccclubs.admin.vo.Page;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.inf.CanHistoryInf;
import com.ccclubs.phoenix.input.CanParam;
import com.ccclubs.phoenix.input.CanStateParam;
import com.ccclubs.phoenix.orm.dto.CanDto;
import com.ccclubs.phoenix.orm.dto.CanStateDto;
import com.ccclubs.phoenix.output.CanHistoryOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 车辆CAN历史数据的Service实现
 *
 * @author Joel
 */
@Service
public class HistoryCanServiceImpl implements IHistoryCanService {

    Logger logger = LoggerFactory.getLogger(HistoryCanServiceImpl.class);

    @Reference(version = "1.0.0")
    CanHistoryInf canHistoryService;

    @Override
    public CanStateDto getHistoryStateDetail(String carNumber, Long canTime) {
        CanStateParam param = new CanStateParam();
        param.setCanTime(canTime);
        param.setTeNumber(carNumber);
        CanStateDto canStateDto = canHistoryService.queryCanStateDto(param);
        return canStateDto;
    }

    @Override
    public TableResult<HistoryCan> getPage(HistoryCanQuery query, Integer pageNo, Integer pageSize, String order) {
        ApiMessage<CanHistoryOutput> apiMessage;
        TableResult<HistoryCan> result = new TableResult<>();
        Page page = new Page(0, pageSize, 0);
        result.setData(new ArrayList<>());
        result.setPage(page);

        String startTime = DateTimeUtil.getDateTimeByUnixFormat(query.getCurrentTimeStart().getTime());
        String endTime = DateTimeUtil.getDateTimeByUnixFormat(query.getCurrentTimeEnd().getTime());
        try {
            apiMessage = this.queryCanDtoListFromHbase(query.getCsVinEquals(),
                    startTime, endTime,
                    pageNo, pageSize, order);
            if (apiMessage != null && apiMessage.getCode() == ApiEnum.SUCCESS.code()) {
                if (apiMessage.getData() != null) {
                    if (null != apiMessage.getData().getTotal()
                            && apiMessage.getData().getTotal() > 0) {
                        List<CanDto> canDtoList = apiMessage.getData().getList();
                        page = new Page(pageNo, pageSize, apiMessage.getData().getTotal());
                        result.setData(dealCanDtoToHistoryCanAll(canDtoList));
                        result.setPage(page);
                    }
                    //这里是查询全部的数据的处理流程，用于导出全部数据。
                    else if (null != apiMessage.getData().getList()
                            && apiMessage.getData().getList().size() > 0) {
                        List<CanDto> canDtoList = apiMessage.getData().getList();
                        page = new Page(pageNo, pageSize, apiMessage.getData().getList().size());
                        result.setData(dealCanDtoToHistoryCanAll(canDtoList));
                        result.setPage(page);
                    } else {
                        //没有查询到数据
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static HistoryCan dealCanDtoToHistoryCan(CanDto canDto) {
        if (null != canDto) {
            HistoryCan historyCan = new HistoryCan();
            historyCan.setAddTime(new Date(canDto.getAddTime()));
            historyCan.setCanData(canDto.getSourceHex());
            historyCan.setCsNumber(canDto.getTeNumber());
            historyCan.setCurrentTime(new Date(canDto.getCurrentTime()));
            return historyCan;
        } else {
            return null;
        }
    }

    private static List<HistoryCan> dealCanDtoToHistoryCanAll(List<CanDto> canDtoList) {
        if (null != canDtoList && canDtoList.size() > 0) {
            List<HistoryCan> historyCanList = new ArrayList<>();
            for (CanDto canDto : canDtoList) {
                historyCanList.add(dealCanDtoToHistoryCan(canDto));
            }
            return historyCanList;
        } else {
            return null;
        }

    }

    private ApiMessage<CanHistoryOutput> queryCanDtoListFromHbase(String vin, String startTime,
                                                                  String endTime, Integer pageNo,
                                                                  Integer pageSize, String order) throws Exception {
        CanParam param = new CanParam();
        param.setQueryFields("*");
        param.setVin(vin);
        param.setStartTime(startTime);
        param.setEndTime(endTime);
        param.setPageNum(pageNo);
        param.setPageSize(pageSize);
        param.setOrder(order);
        return new ApiMessage<>(canHistoryService.queryListByParam(param));

    }

}