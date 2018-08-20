package com.ccclubs.admin.controller.base;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.model.TBoxLog;
import com.ccclubs.admin.query.TBoxLogQuery;
import com.ccclubs.admin.service.ICsMachineService;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.admin.vo.Page;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.mongo.orm.model.history.CsLogger;
import com.ccclubs.mongo.orm.query.CsLoggerQuery;
import com.ccclubs.mongo.service.impl.CsLoggerService;
import com.ccclubs.phoenix.inf.TBoxLogInf;
import com.ccclubs.phoenix.input.TBoxLogParam;
import com.ccclubs.phoenix.orm.dto.TBoxLogDto;
import com.ccclubs.phoenix.output.TBoxLogOutput;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CsLogger
 *
 * @author jianghaiyang
 * @create 2018-01-10
 **/
@SuppressWarnings("unused")
@RestController
@RequestMapping("monitor/historyLogger")
public class CsLoggerController {

    Logger logger = LoggerFactory.getLogger(CsLoggerController.class);

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    CsLoggerService csLoggerService;
    @Autowired
    ICsVehicleService csVehicleService;
    @Autowired
    ICsMachineService csMachineService;

    @Reference
    TBoxLogInf tBoxLogInf;

    /**
     * 获取分页列表数据
     *
     * @param query
     * @param page
     * @param rows
     * @return
     */
    @ApiOperation(value = "获取日志分页记录", notes = "获取日志分页记录")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public TableResult<CsLogger> list(CsLoggerQuery query,
                                      @RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "10") Integer rows,
                                      @RequestParam(defaultValue = "cslAddTime") String order) {
        PageInfo<CsLogger> pageResult = csLoggerService.getPage(query, new PageRequest(page, rows, new Sort(Sort.Direction.DESC, order)));
        List<CsLogger> list = pageResult.getList();
        for (CsLogger data : list) {
            registResolvers(data);
        }
        TableResult<CsLogger> tableResult = new TableResult<>(page, rows, pageResult);
        return tableResult;
    }

    @ApiOperation(value = "获得日志分页记录（增加车辆绑定信息判断）", notes = "获取日志分页记录")
    @RequestMapping(value = "getlist", method = RequestMethod.GET)
    public TableResult<TBoxLog> getlist (TBoxLogQuery query,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer rows,
            @RequestParam(defaultValue = "addTime") String sidx,
            @RequestParam(defaultValue = "desc") String sord) {

        TableResult<TBoxLog> tableResult = new TableResult<>();

        //初始化参数
        TBoxLogParam param = new TBoxLogParam();
        //组装参数值
        String startTime = DateTimeUtil.getDateTimeByUnixFormat(
                query.getAddTimeStart().getTime());
        String endTime = DateTimeUtil.getDateTimeByUnixFormat(
                query.getAddTimeEnd().getTime());

        param.setVin(query.getCsVinEquals());
        param.setTeNumber(query.getCsNumberEquals());
        param.setStartTime(startTime);
        param.setEndTime(endTime);
        param.setPageNum(page);
        param.setPageSize(rows);
//        param.setOrderBy(query.getSidx() + " " + query.getSord());
        param.setQueryFields("*");

        //Check Param
        if (null == param.getVin() || null == endTime || null == startTime) {
            return tableResult;
        }
        if (param.getVin().isEmpty() || endTime.isEmpty() || startTime.isEmpty()) {
            return tableResult;
        }

        //是否车机与车辆绑定
        Boolean isBanded;
        String vin = StringUtils.isNotEmpty(query.getCsVinEquals()) ?
                query.getCsVinEquals() : null;
        String number = StringUtils.isNotEmpty(query.getCsNumberEquals()) ?
                query.getCsNumberEquals() : null;

        isBanded = checkVehicleBand(vin, number);

        TBoxLogOutput tBoxLogOutput =
                tBoxLogInf.queryListByParam(param, isBanded);

        List<TBoxLog> historyGbList = new ArrayList<>();

        //设置页面展示数据
        TBoxLog tBoxLog;
        for (TBoxLogDto dto : tBoxLogOutput.getList()) {
            tBoxLog = new TBoxLog();
            tBoxLog.setAddTime(new Date(dto.getAddTime()));
            tBoxLog.setVin(dto.getVin());
            tBoxLog.setTeNumber(dto.getTeNumber());
            tBoxLog.setOrderNo(dto.getOrderNo());

            tBoxLog.setLogInfo(dto.getLogInfo());
            tBoxLog.setSourceHex(dto.getSourceHex());
            historyGbList.add(tBoxLog);
        }

        Page pageInfo = new Page(page, rows, tBoxLogOutput.getTotal());

        tableResult.setData(historyGbList);
        tableResult.setPage(pageInfo);
        return tableResult;
    }

    /**
     * 删除数据
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete/{ids}", method = RequestMethod.DELETE)
    public int list(@PathVariable("ids") String ids) {
        return csLoggerService.delete(ids);
    }

    /**
     * 注册属性内容解析器
     */
    void registResolvers(CsLogger data) {
        if (data != null) {
            data.registResolver(com.ccclubs.admin.resolver.CsLoggerResolver.状态.getResolver());
        }
    }

    /**
     * 判断车架vin码 与 车机号是否绑定
     * @param vin
     * @param number
     * @return
     */
    Boolean checkVehicleBand(String vin, String number) {

        CsVehicle csVehicle = new CsVehicle();
        if(vin != null) {
            csVehicle = csVehicleService.getVehicleInfo(vin, null);
        }
        if(number != null) {
            Integer machineId = csMachineService.getIdByNumber(number);
            csVehicle = csVehicleService.getVehicleInfo(vin, machineId);
        }

        if (csVehicle.getCsvMachine() != null) {
            return true;
        }
        return false;
    }
}
