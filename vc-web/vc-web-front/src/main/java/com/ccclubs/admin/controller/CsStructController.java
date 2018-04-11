package com.ccclubs.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

import com.ccclubs.admin.vo.TableResult;

import com.ccclubs.admin.entity.CsStructCrieria;
import com.ccclubs.admin.model.CsStruct;
import com.ccclubs.admin.service.ICsStructService;
import com.ccclubs.admin.query.CsStructQuery;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;

/**
 * 控制指令管理Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/control/struct")
public class CsStructController {

	@Autowired
	ICsStructService csStructService;

	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<CsStruct> list(CsStructQuery query, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		PageInfo<CsStruct> pageInfo = csStructService.getPage(query.getCrieria(), page, rows);
		List<CsStruct> list = pageInfo.getList();
		for(CsStruct data : list){
			registResolvers(data);
		}
		
		TableResult<CsStruct> r = new TableResult<>(pageInfo);
		return r;
	}

	/**
	 * 创建保存控制指令管理
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public VoResult<?> add(CsStruct data){

		csStructService.insert(data);
		return VoResult.success();
	}
	
	/**
	 * 更新控制指令管理
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public VoResult<?> update(CsStruct data){
		csStructService.updateByPrimaryKeySelective(data);
		return VoResult.success();
	}
	
	/**
	 * 删除控制指令管理
	 * @return
	 */
	@RequestMapping(value="delete", method = RequestMethod.DELETE)
	public VoResult<?> delete(@RequestParam(required=true)final Long[] ids){
		csStructService.batchDelete(ids);
		return VoResult.success();
	}
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(CsStruct data){
		if(data!=null){
			data.registResolver(com.ccclubs.admin.resolver.CsStructResolver.命令类型.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsStructResolver.状态.getResolver());
		}
	}
	
	/**
	 * 获取单条控制指令管理信息
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, CsStruct>> detail(@PathVariable(required = true) Long id){
		CsStruct data = csStructService.selectByPrimaryKey( id );
		Map<String, CsStruct> map = new HashMap<String, CsStruct>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}
	
	
	/**
	 * 根据文本检索控制指令管理信息
	 */
	@RequestMapping(value="/query", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , CsStruct queryRecord){
		CsStructCrieria query = new CsStructCrieria();
		CsStructCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			String val = String.valueOf(text);
			c.andcssNameLike(val);
		}
		if(!StringUtils.isEmpty(where)){
			Long val = Long.valueOf(where);
			c.andcssIdEqualTo(val);
		}
		PageInfo<CsStruct> pageInfo = csStructService.getPage(query, 0, 10);
		List<CsStruct> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (CsStruct data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getCssId());
			map.put("text", data.getCssName());
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}
	
}
