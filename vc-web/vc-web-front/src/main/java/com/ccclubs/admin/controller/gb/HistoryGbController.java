package com.ccclubs.admin.controller.gb;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.admin.model.HistoryGb;
import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.query.HistoryGbQuery;
import com.ccclubs.admin.service.IHistoryGbService;
import com.ccclubs.admin.task.threads.ReportThread;
import com.ccclubs.admin.util.EvManageContext;
import com.ccclubs.admin.vo.Page;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.inf.GbMessageHistoryInf;
import com.ccclubs.phoenix.input.GbMessageParam;
import com.ccclubs.phoenix.orm.dto.GbMessageDto;
import com.ccclubs.phoenix.orm.model.CarGb;
import com.ccclubs.phoenix.output.GbMessageHistoryOutput;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.util.Tools;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 车辆国标历史数据Controller
 *
 * @author
 * @category generated by NovaV1.0
 * @since V1.0
 */
@RestController
@RequestMapping("/electricity/historyState")
public class HistoryGbController {

    Logger logger = LoggerFactory.getLogger(HistoryGbController.class);

    private static final long ONE_MOUTH = 2592000000L;

    @Autowired
    IHistoryGbService historyGbService;
    @Autowired
    ReportThread reportThread;

    @Reference(version = "1.0.0")
    GbMessageHistoryInf gbMessageHistoryInf;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public TableResult<HistoryGb> queryGbMessageList(@RequestParam(defaultValue = "0") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer rows,
                                                     @RequestParam(defaultValue = "desc") String order,
                                                     @RequestBody HistoryGbQuery query) {
        GbMessageParam param = new GbMessageParam();
        String startTime= DateTimeUtil.getDateTimeByUnixFormat(query.getAddTimeStart().getTime());
        String endTime= DateTimeUtil.getDateTimeByUnixFormat(query.getAddTimeEnd().getTime());
        param.setVin(query.getCsVinEquals());
        param.setStartTime(startTime);
        param.setEndTime(endTime);
        TableResult<HistoryGb> tableResult = new TableResult<>();
        if (this.paramTimeCheck(param.getStartTime(), param.getEndTime())) {
            return tableResult;
        }
        if (StringUtils.isEmpty(param.getVin())
                && StringUtils.isEmpty(param.getTeNumber())) {
            return tableResult;
        }
        logger.debug("请求参数：" + param.toString());
        String pointQueryKey;
        if (StringUtils.isEmpty(param.getVin())) {
            pointQueryKey = param.getTeNumber();
        } else {
            pointQueryKey = param.getVin();
        }

        if (!paramCheck(pointQueryKey, param.getStartTime(), param.getEndTime(), param.getPageNum(), param.getPageSize())) {
            return tableResult;
        }

        GbMessageHistoryOutput gbMessageHistoryOutput =
                gbMessageHistoryInf.queryListByParam(param);
        List<HistoryGb> historyGbList = new ArrayList<>();
        HistoryGb historyGb;
        for (GbMessageDto dto : gbMessageHistoryOutput.getList()) {
            historyGb = new HistoryGb();
            historyGb.setAddTime(new Date(dto.getAddTime()));
            historyGb.setCsAccess(dto.getAccess());
            historyGb.setCsVin(dto.getVin());
            historyGb.setCsProtocol(dto.getProtocol());
            historyGb.setCsVerify(dto.getVerify());
            historyGb.setCurrentTime(new Date(dto.getCurrentTime()));
            historyGb.setGbData(dto.getSourceHex());
            historyGb.setGbType(dto.getMessageType());
        }

        for (HistoryGb data : historyGbList) {
            registResolvers(data);
        }
        Page pageInfo = new Page(page, rows, gbMessageHistoryOutput.getTotal());

        tableResult.setData(historyGbList);
        tableResult.setPage(pageInfo);
        return tableResult;
    }

    /**
     * 检查查询的时间，其查询的间隔不能过长。
     */
    private boolean paramTimeCheck(String startTime, String endTime) {
        boolean flag = false;//false为验证通过。
        long startTimeLong = DateTimeUtil.date2UnixFormat(startTime, DateTimeUtil.UNIX_FORMAT);
        long endTimeLong = DateTimeUtil.date2UnixFormat(endTime, DateTimeUtil.UNIX_FORMAT);
        long timeLong = endTimeLong - startTimeLong;
        if (timeLong > ONE_MOUTH) {
            flag = true;
        }
        return flag;
    }

    private boolean paramCheck(String pointQueryKey, String startTime, String endTime, Integer pageNo, Integer pageSize) {
        if (null == pointQueryKey || null == endTime || null == startTime) {
            return false;
        }
        if (pointQueryKey.isEmpty() || endTime.isEmpty() || startTime.isEmpty()) {
            return false;
        }
        //if (pageNo<-1||pageNo==0){return false;}
        //if (pageSize<=0){return false;}
        //if (pageSize>5000){return false;}
        try {
            DateTimeUtil.date2UnixFormat(startTime, DateTimeUtil.UNIX_FORMAT);
            DateTimeUtil.date2UnixFormat(endTime, DateTimeUtil.UNIX_FORMAT);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 获取分页列表数据
     */
    @RequestMapping(value = "listGbMessage", method = RequestMethod.GET)
    public TableResult<GBMessage> listGbMessage(@RequestBody HistoryGbQuery query, @RequestParam(defaultValue = "0") Integer page,
                                                @RequestParam(defaultValue = "10") Integer rows,
                                                @RequestParam(defaultValue = "desc") String order) {
        TableResult<GBMessage> tableResult = new TableResult<>();
        GbMessageParam param = new GbMessageParam();
        String startTime= DateTimeUtil.getDateTimeByUnixFormat(query.getAddTimeStart().getTime());
        String endTime= DateTimeUtil.getDateTimeByUnixFormat(query.getAddTimeEnd().getTime());
        param.setVin(query.getCsVinEquals());
        param.setStartTime(startTime);
        param.setEndTime(endTime);
        if (this.paramTimeCheck(param.getStartTime(), param.getEndTime())) {
            return tableResult;
        }
        if (StringUtils.isEmpty(param.getVin())
                && StringUtils.isEmpty(param.getTeNumber())) {
            return tableResult;
        }
        logger.debug("请求参数：" + param.toString());
        String pointQueryKey;
        if (StringUtils.isEmpty(param.getVin())) {
            pointQueryKey = param.getTeNumber();
        } else {
            pointQueryKey = param.getVin();
        }

        if (!paramCheck(pointQueryKey, param.getStartTime(), param.getEndTime(), param.getPageNum(), param.getPageSize())) {
            return tableResult;
        }

        GbMessageHistoryOutput gbMessageHistoryOutput =
                gbMessageHistoryInf.queryListByParam(param);
        List<GBMessage> gbMessageList = new ArrayList<>();
        GBMessage gbMessage;
        for (GbMessageDto dto : gbMessageHistoryOutput.getList()) {
            gbMessage = new GBMessage();
            gbMessage.ReadFromBytes(Tools.HexString2Bytes(dto.getSourceHex()));
            gbMessageList.add(gbMessage);
        }

        Page pageInfo = new Page(page, rows, gbMessageHistoryOutput.getTotal());

        tableResult.setData(gbMessageList);
        tableResult.setPage(pageInfo);
        return tableResult;
    }

    /**
     * 注册属性内容解析器
     */
    void registResolvers(HistoryGb data) {
        if (data != null) {
            data.registResolver(com.ccclubs.admin.resolver.HistoryGbResolver.协议类型.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.HistoryGbResolver.报文类型.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.HistoryGbResolver.校验结果.getResolver());
        }
    }

    /**
     * 根据文本检索车辆历史状态信息并导出。
     */
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public VoResult<String> getReport(@RequestBody ReportParam<HistoryGbQuery> reportParam) {
        List<HistoryGb> list;
        if (null == reportParam.getQuery().getCsVinEquals() ||
                null == reportParam.getQuery().getAddTimeEnd() ||
                null == reportParam.getQuery().getAddTimeStart()) {
            //TODO 需要Phoenix支持只使用时间的查询。
            VoResult<String> r = new VoResult<>();
            r.setSuccess(false).setMessage("导出任务需要足够的参数。");
            return r;
        }
        if (reportParam.getAllReport() == 1) {
            reportParam.setPage(-1);
        }
        TableResult<HistoryGb> pageInfo = historyGbService.getPage(
                reportParam.getQuery(),
                reportParam.getPage(),
                reportParam.getRows(),
                reportParam.getOrder());
        list = pageInfo.getData();


        for (HistoryGb data : list) {
            registResolvers(data);
        }

        String uuid = UUID.randomUUID().toString();
        reportThread.setBaseName("History_Gb");
        reportThread.setList(list);
        reportThread.setUserUuid(uuid);
        reportThread.setReportParam(reportParam);
        logger.info("start running report History_Gb thread.");
        EvManageContext.getThreadPool().execute(reportThread);

        VoResult<String> r = new VoResult<>();
        r.setSuccess(true).setMessage("导出任务已经开始执行，请稍候。");
        r.setValue(uuid);
        return r;

    }

    private static List<GBMessage> dealCarGbToGbMessageAll(List<CarGb> carGbList) {
        GBMessage gbMessage;
        if (null != carGbList && carGbList.size() > 0) {
            List<GBMessage> historyGbList = new ArrayList<>();
            for (CarGb carGb : carGbList) {
                gbMessage = new GBMessage();
                gbMessage.ReadFromBytes(Tools.HexString2Bytes(carGb.getGb_data()));
                historyGbList.add(gbMessage);
            }
            return historyGbList;
        } else {
            return null;
        }
    }
}
