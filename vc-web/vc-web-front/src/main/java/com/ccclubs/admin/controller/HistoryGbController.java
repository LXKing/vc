package com.ccclubs.admin.controller;

import com.ccclubs.protocol.dto.gb.GBMessage;
import java.util.*;

import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.task.threads.ReportThread;
import com.ccclubs.admin.util.EvManageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import com.ccclubs.admin.vo.TableResult;

import com.ccclubs.admin.model.HistoryGb;
import com.ccclubs.admin.service.IHistoryGbService;
import com.ccclubs.admin.query.HistoryGbQuery;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;

/**
 * 车辆国标历史数据Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/electricity/historyState")
public class HistoryGbController {

	Logger logger= LoggerFactory.getLogger(HistoryGbController.class);
	@Autowired
	IHistoryGbService historyGbService;
	@Autowired
	ReportThread reportThread;

	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<HistoryGb> list(HistoryGbQuery query, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer rows,
	@RequestParam(defaultValue = "desc" )String order) {
		if (null==query.getCsVinEquals()){return  new TableResult<HistoryGb>();}
		TableResult<HistoryGb> pageInfo = historyGbService.getPage(query, page, rows,order);
		List<HistoryGb> list = pageInfo.getData();
		for(HistoryGb data : list){
			registResolvers(data);
		}
		return pageInfo;
	}


	/**
	 * 获取分页列表数据
	 */
	@RequestMapping(value = "listGbMessage", method = RequestMethod.GET)
	public TableResult<GBMessage> listGbMessage(HistoryGbQuery query, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer rows,
			@RequestParam(defaultValue = "desc" )String order) {
		if (null==query.getCsVinEquals()){return  new TableResult<>();}
		TableResult<GBMessage> pageInfo = historyGbService.getGbMessagePage(query, page, rows,order);

		return pageInfo;
	}

	
	
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(HistoryGb data){
		if(data!=null){
			data.registResolver(com.ccclubs.admin.resolver.HistoryGbResolver.协议类型.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.HistoryGbResolver.报文类型.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.HistoryGbResolver.校验结果.getResolver());
		}
	}

	/**
	 * 根据文本检索车辆历史状态信息并导出。
	 */
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public VoResult<String> getReport(@RequestBody ReportParam<HistoryGbQuery> reportParam)
	{
		List<HistoryGb> list;
		if (null == reportParam.getQuery().getCsVinEquals()||
				null==reportParam.getQuery().getAddTimeEnd()||
				null==reportParam.getQuery().getAddTimeStart()) {
			//TODO 需要Phoenix支持只使用时间的查询。
			VoResult<String> r = new VoResult<>();
			r.setSuccess(false).setMessage("导出任务需要足够的参数。");
			return r;
		}
		if (reportParam.getAllReport()==1){
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
	
	

	
}
