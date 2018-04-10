package com.ccclubs.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.ev.base.model.EvAlarmRecord;
import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.task.threads.ReportThread;
import com.ccclubs.admin.util.EvManageContext;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.ccclubs.ev.base.query.EvAlarmRecordQuery;
import com.ccclubs.ev.base.service.open.AlarmRecordBaseInf;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * GB报警数据
 *
 * @author jianghaiyang
 * @create 2018-04-08
 **/
@RestController
@RequestMapping("electricity/alarm")
public class GbAlarmController {

    @Reference(version = "1.0")
    AlarmRecordBaseInf alarmRecordBaseInf;

    /**
     * 获取分页列表数据
     *
     * @param query
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public TableResult<EvAlarmRecord> list(EvAlarmRecordQuery query, @RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "15") Integer rows) {
       PageInfo<EvAlarmRecord> pageInfo = alarmRecordBaseInf.getAlarmRecordPage(query, page, rows);
        return new TableResult<>(pageInfo);
    }

    @RequestMapping(value = "confirm", method = RequestMethod.POST)
    public VoResult<?> confirm(EvAlarmRecord record) {
        record.setComfirmTime(new Date());
        alarmRecordBaseInf.confirmAlarmState(record);
        return VoResult.success();
    }

    @Autowired
    ReportThread reportThread;

    /**
     * 根据文本检索车辆历史状态信息并导出。
     */
    @RequestMapping(value = "report", method = RequestMethod.POST)
    public VoResult<String> getReport(@RequestBody ReportParam<EvAlarmRecordQuery> reportParam) {
        List<EvAlarmRecord> result = alarmRecordBaseInf.getAllAlarmRecord(reportParam.getQuery());

        String uuid = UUID.randomUUID().toString();
        reportThread.setBaseName("Vehicle_Alarm");
        reportThread.setList(result);
        reportThread.setUserUuid(uuid);
        reportThread.setReportParam(reportParam);
        EvManageContext.getThreadPool().execute(reportThread);

        VoResult<String> r = new VoResult<>();
        r.setSuccess(true).setMessage("导出任务已经开始执行，请稍候。");
        r.setValue(uuid);
        return r;
    }
}
