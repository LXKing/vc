package com.ccclubs.admin.controller.base;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.admin.model.CsVehicle;
import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.model.TBoxLog;
import com.ccclubs.admin.query.TBoxLogQuery;
import com.ccclubs.admin.service.ICsMachineService;
import com.ccclubs.admin.service.ICsVehicleService;
import com.ccclubs.admin.task.threads.ReportThread;
import com.ccclubs.admin.util.EvManageContext;
import com.ccclubs.admin.vo.Page;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.mongo.orm.model.history.CsLogger;
import com.ccclubs.mongo.orm.query.CsLoggerQuery;
import com.ccclubs.mongo.service.impl.CsLoggerService;
import com.ccclubs.phoenix.inf.TBoxLogInf;
import com.ccclubs.phoenix.input.TBoxLogParam;
import com.ccclubs.phoenix.orm.dto.TBoxLogDto;
import com.ccclubs.phoenix.output.TBoxLogOutput;
import com.ccclubs.pub.orm.dto.TboxLog;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
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

        //设置param值
        param.setStartTime(DateTimeUtil.getDateTimeByUnixFormat(
                query.getAddTimeStart().getTime()));
        param.setEndTime(DateTimeUtil.getDateTimeByUnixFormat(
                query.getAddTimeEnd().getTime()));
        param.setVin(query.getCsVinEquals());
        param.setTeNumber(query.getCsNumberEquals());
        param.setPageNum(page);
        param.setPageSize(rows);
        param.setQueryFields("*");

        // 车机与车辆是否绑定，默认不存在
        // true：车机与车辆存在绑定关系，false：不存在绑定关系
        Boolean isBound = false;

        //存在绑定关系时，只根据Vin码查询
        CsVehicle csVehicle;
        if(query.getCsVinEquals() != null && query.getCsNumberEquals() == null) {
            csVehicle = csVehicleService.getVehicleInfo(query.getCsVinEquals(), null);
            if (csVehicle != null && csVehicle.getCsvMachine() != null) {
                //存在绑定关系，根据Vin码查询
                isBound = true;
            } else {
                //不存在绑定关系,给出提示
                tableResult.setMsg("当前车辆没有绑定车机");
                return tableResult;
            }
        }
        // 当车机号不为空，而Vin码为空时，如果找到了对应的车辆信息，就存在绑定关系。
        // 当Vin码不为空时，如果通过Vin码和车机号，进行查找。如果找到了对应车辆信息，肯定同时符合两者，说明存在绑定关系；
        // 如果没有找到，说明两个不存在绑定关系，应该根据车机号查询并且提示两者没有绑定关系
        if(query.getCsNumberEquals() != null) {
            Integer machineId = csMachineService.getIdByNumber(query.getCsNumberEquals());
            csVehicle = csVehicleService.getVehicleInfo(query.getCsVinEquals(), machineId);
            if (csVehicle != null && csVehicle.getCsvMachine() != null) {
                //存在绑定关系，根据Vin码查询
                //设置param值
                param.setVin(csVehicle.getCsvVin());
                isBound = true;
            }
            if (csVehicle == null && query.getCsVinEquals() != null) {
                //同时输入了车机号和Vin码，并且不存在绑定关系
                //给出两者不存在绑定关系的提示
                tableResult.setMsg("该车机号与该车辆并未绑定");
                return tableResult;
            }
        }

        //进行查询操作
        TBoxLogOutput tBoxLogOutput =
                tBoxLogInf.queryListByParam(param, isBound);

        List<TBoxLog> tBoxLogList = new ArrayList<>();

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
            tBoxLogList.add(tBoxLog);
        }

        Page pageInfo = new Page(page, rows, tBoxLogOutput.getTotal());

        tableResult.setData(tBoxLogList);
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

    @Autowired
    ReportThread reportThread;

    /**
     * 根据文本检索车辆历史状态信息并导出。
     */
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public VoResult<String> getReport(@RequestBody ReportParam<TBoxLogQuery> reportParam) {

        VoResult<String> r = new VoResult<>();
        //校验参数
        if(reportParam.getQuery().getCsVinEquals() == null && reportParam.getQuery().getCsNumberEquals() == null) {
            r.setSuccess(false).setMessage("导出任务需要足够的参数。");
            return r;
        }
        if(reportParam.getQuery().getAddTimeStart() == null || reportParam.getQuery().getAddTimeEnd() == null) {
            r.setSuccess(false).setMessage("导出任务需要足够的参数。");
            return r;
        }
        if (this.paramTimeCheck(reportParam.getQuery().getAddTimeStart(), reportParam.getQuery().getAddTimeEnd())) {
            r.setSuccess(false).setMessage("导出任务需要足够的参数。");
            return r;
        }
        TBoxLogParam param = new TBoxLogParam();
        //设置param值
        param.setStartTime(DateTimeUtil.getDateTimeByUnixFormat(
                reportParam.getQuery().getAddTimeStart().getTime()));
        param.setEndTime(DateTimeUtil.getDateTimeByUnixFormat(
                reportParam.getQuery().getAddTimeEnd().getTime()));
        param.setVin(reportParam.getQuery().getCsVinEquals());
        param.setTeNumber(reportParam.getQuery().getCsNumberEquals());
        param.setPageNum(-1);
        param.setPageSize(reportParam.getRows());
        param.setQueryFields("*");

        // 车机与车辆是否绑定，默认不存在
        // true：车机与车辆存在绑定关系，false：不存在绑定关系
        Boolean isBound = false;

        //存在绑定关系时，只根据Vin码查询
        CsVehicle csVehicle;
        if(reportParam.getQuery().getCsVinEquals() != null && reportParam.getQuery().getCsNumberEquals() == null) {
            csVehicle = csVehicleService.getVehicleInfo(reportParam.getQuery().getCsVinEquals(), null);
            if (csVehicle != null && csVehicle.getCsvMachine() != null) {
                //存在绑定关系，根据Vin码查询
                isBound = true;
            } else {
                //不存在绑定关系,给出提示
                r.setSuccess(false).setMessage("当前车辆没有绑定车机");
                return r;
            }
        }
        // 当车机号不为空，而Vin码为空时，如果找到了对应的车辆信息，就存在绑定关系。
        // 当Vin码不为空时，如果通过Vin码和车机号，进行查找。如果找到了对应车辆信息，肯定同时符合两者，说明存在绑定关系；
        // 如果没有找到，说明两个不存在绑定关系，应该根据车机号查询并且提示两者没有绑定关系
        if(reportParam.getQuery().getCsNumberEquals() != null) {
            Integer machineId = csMachineService.getIdByNumber(reportParam.getQuery().getCsNumberEquals());
            csVehicle = csVehicleService.getVehicleInfo(reportParam.getQuery().getCsVinEquals(), machineId);
            if (csVehicle != null && csVehicle.getCsvMachine() != null) {
                //存在绑定关系，根据Vin码查询
                //设置param值
                param.setVin(csVehicle.getCsvVin());
                isBound = true;
            }
            if (csVehicle == null && reportParam.getQuery().getCsVinEquals() != null) {
                //同时输入了车机号和Vin码，并且不存在绑定关系
                //给出两者不存在绑定关系的提示
                r.setSuccess(false).setMessage("该车机号与该车辆并未绑定");
                return r;
            }
        }

        //进行查询操作
        TBoxLogOutput tBoxLogOutput =
                tBoxLogInf.queryListByParam(param, isBound);

        List<TBoxLog> tBoxLogList = new ArrayList<>();

        TBoxLog tBoxLog;
        for (TBoxLogDto dto : tBoxLogOutput.getList()) {
            tBoxLog = new TBoxLog();
            tBoxLog.setAddTime(new Date(dto.getAddTime()));
            tBoxLog.setVin(dto.getVin());
            tBoxLog.setTeNumber(dto.getTeNumber());
            tBoxLog.setOrderNo(dto.getOrderNo());
            tBoxLog.setLogInfo(dto.getLogInfo());
            tBoxLog.setSourceHex(dto.getSourceHex());
            tBoxLogList.add(tBoxLog);
        }

        String uuid = UUID.randomUUID().toString();
        reportThread.setBaseName("tboxlog");
        reportThread.setList(tBoxLogList);
        reportThread.setUserUuid(uuid);
        reportThread.setReportParam(reportParam);
        logger.info("start running report tboxlog thread.");
        EvManageContext.getThreadPool().execute(reportThread);

        r.setSuccess(true).setMessage("导出任务已经开始执行，请稍候。");
        r.setValue(uuid);
        return r;

    }
}
