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

    private static final long ONE_MOUTH = 2592000000L;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    CsLoggerService csLoggerService;
    @Autowired
    ICsVehicleService csVehicleService;
    @Autowired
    ICsMachineService csMachineService;

    @Reference(version = "1.0.0")
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
    public TableResult<TBoxLog> getList (TBoxLogQuery query,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "15") Integer rows) {

        TableResult<TBoxLog> tableResult = new TableResult<>();

        //初始化参数
        TBoxLogParam param = new TBoxLogParam();

        //校验参数
        if(query.getCsVinEquals() == null && query.getCsNumberEquals() == null) {
            return tableResult;
        }
        if(query.getAddTimeStart() == null || query.getAddTimeEnd() == null) {
            return tableResult;
        }
        if (this.paramTimeCheck(query.getAddTimeStart(), query.getAddTimeEnd())) {
            return tableResult;
        }

        param.setStartTime(DateTimeUtil.getDateTimeByUnixFormat(
                query.getAddTimeStart().getTime()));
        param.setEndTime(DateTimeUtil.getDateTimeByUnixFormat(
                query.getAddTimeEnd().getTime()));
        param.setVin(query.getCsVinEquals());
        param.setTeNumber(query.getCsNumberEquals());
        param.setPageNum(page);
        param.setPageSize(rows);
//        param.setOrderBy(query.getSidx() + " " + query.getSord());
        param.setQueryFields("*");

        //是否车机与车辆绑定
        Boolean idBound;
        String vin = query.getCsVinEquals();
        String number = query.getCsNumberEquals();

        idBound = checkVehicleBand(vin, number);

        TBoxLogOutput tBoxLogOutput =
                tBoxLogInf.queryListByParam(param, idBound);

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
        if (csVehicle != null && csVehicle.getCsvMachine() != null) {
            return true;
        }
        return false;
    }

    /**
     * 检查查询的时间，其查询的间隔不能过长。
     */
    private boolean paramTimeCheck(Date startTime, Date endTime) {
        boolean flag = false;//false为验证通过。
        long startTimeLong = startTime.getTime();
        long endTimeLong = endTime.getTime();
        long timeLong = endTimeLong - startTimeLong;
        if (timeLong > ONE_MOUTH) {
            flag = true;
        }
        return flag;
    }
}
