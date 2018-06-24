package com.ccclubs.admin.controller.mqtt;

import com.ccclubs.admin.model.HistoryState;
import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.query.HistoryStateQuery;
import com.ccclubs.admin.resolver.HistoryStateResolver;
import com.ccclubs.admin.service.IHistoryStateService;
import com.ccclubs.admin.task.threads.ReportThread;
import com.ccclubs.admin.util.EvManageContext;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 车辆状态历史数据Controller
 *
 * @author
 * @category generated by NovaV1.0
 * @since V1.0
 */
@RestController
@RequestMapping("/monitor/historyState")
public class HistoryStateController {
    private static Logger logger = LoggerFactory.getLogger(HistoryStateController.class);

    @Autowired
    IHistoryStateService historyStateService;

    @Autowired
    ReportThread reportThread;

    /**
     * 获取分页列表数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public TableResult<HistoryState> list(HistoryStateQuery query,
                                          @RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer rows,
                                          @RequestParam(defaultValue = "desc") String order,
                                          @RequestParam(defaultValue = "true") Boolean isResolve) {

        if (null == query.getCsVinEquals()) {
            //TODO 需要Phoenix支持只使用时间的查询。
            return new TableResult<HistoryState>();
        }
        TableResult<HistoryState> pageInfo = historyStateService.getPage(query, page, rows, order);
        List<HistoryState> list = pageInfo.getData();
        if (null != list && list.size() > 0) {
            for (HistoryState data : list) {
                registResolvers(data, isResolve);
            }
        }

        return pageInfo;
    }


    /**
     * 获取分页列表数据
     */
    @RequestMapping(value = "/listJt808", method = RequestMethod.GET)
    public TableResult<HistoryState> listJt808(HistoryStateQuery query,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer rows,
        @RequestParam(defaultValue = "desc") String order,
        @RequestParam(defaultValue = "true") Boolean isResolve) {

        if (null == query.getCsVinEquals()) {
            //TODO 需要Phoenix支持只使用时间的查询。
            return new TableResult<>();
        }
        TableResult<HistoryState> pageInfo = historyStateService.getJt808PositionPage(query, page, rows, order);
        List<HistoryState> list = pageInfo.getData();
        if (null != list && list.size() > 0) {
            for (HistoryState data : list) {
                registResolvers(data, isResolve);
            }
        }

        return pageInfo;
    }


    /**
     * 注册属性内容解析器
     */
    void registResolvers(HistoryState data, Boolean isResolve) {
        if (data != null && isResolve) {
            data.registResolver(HistoryStateResolver.接入商.getResolver());
            data.registResolver(HistoryStateResolver.下位机时间.getResolver());
            data.registResolver(HistoryStateResolver.添加时间.getResolver());
            data.registResolver(HistoryStateResolver.充电状态.getResolver());
            data.registResolver(HistoryStateResolver.gps有效性.getResolver());
            data.registResolver(HistoryStateResolver.循环模式.getResolver());
            data.registResolver(HistoryStateResolver.PTC启停.getResolver());
            data.registResolver(HistoryStateResolver.压缩机状态.getResolver());
            data.registResolver(HistoryStateResolver.档风量.getResolver());
            data.registResolver(HistoryStateResolver.省电模式.getResolver());
            data.registResolver(HistoryStateResolver.发动机.getResolver());
            data.registResolver(HistoryStateResolver.网络类型.getResolver());
            data.registResolver(HistoryStateResolver.档位.getResolver());
        }
    }

    /**
     * 根据文本检索车辆历史状态信息并导出。
     */
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public VoResult<String> getReport(@RequestBody ReportParam<HistoryStateQuery> reportParam) {
        reportParam.setAllReport(1);//强行修改状态数据导出为全部导出。
        List<HistoryState> list;
        if (null == reportParam.getQuery().getCsVinEquals() ||
                null == reportParam.getQuery().getCurrentTimeStart() ||
                null == reportParam.getQuery().getCurrentTimeEnd()) {
            //TODO 需要Phoenix支持只使用时间的查询。
            VoResult<String> r = new VoResult<>();
            r.setSuccess(false).setMessage("导出任务需要足够的参数。");
            return r;
        }
        TableResult<HistoryState> pageInfo = historyStateService.getPage(
                reportParam.getQuery(),
                -1,//reportParam.getPage(),
                reportParam.getRows(),
                reportParam.getOrder());
        list = pageInfo.getData();


        for (HistoryState data : list) {
            registResolvers(data, reportParam.getResolve());
        }

        String uuid = UUID.randomUUID().toString();
        reportThread.setBaseName("History_State");
        reportThread.setList(list);
        reportThread.setUserUuid(uuid);
        reportThread.setReportParam(reportParam);
        logger.info("start running report History_State thread.");
        EvManageContext.getThreadPool().execute(reportThread);

        VoResult<String> r = new VoResult<>();
        r.setSuccess(true).setMessage("导出任务已经开始执行，请稍候。");
        r.setValue(uuid);
        return r;

    }


}
