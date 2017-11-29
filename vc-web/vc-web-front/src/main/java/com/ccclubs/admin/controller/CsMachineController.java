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

import com.ccclubs.admin.entity.CsMachineCrieria;
import com.ccclubs.admin.model.CsMachine;
import com.ccclubs.admin.service.ICsMachineService;
import com.ccclubs.admin.query.CsMachineQuery;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;

/**
 * T-box信息管理Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/admin/machine")
public class CsMachineController {

	@Autowired
	ICsMachineService csMachineService;

	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<CsMachine> list(CsMachineQuery query, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		PageInfo<CsMachine> pageInfo = csMachineService.getPage(query.getCrieria(), page, rows);
		List<CsMachine> list = pageInfo.getList();
		for(CsMachine data : list){
			registResolvers(data);
		}
		
		TableResult<CsMachine> r = new TableResult<>(pageInfo);
		return r;
	}

	/**
	 * 创建保存T-box信息管理
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public VoResult<?> add(CsMachine data){
		csMachineService.insert(data);
		return VoResult.success();
	}
	
	/**
	 * 更新T-box信息管理
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public VoResult<?> update(CsMachine data){
		csMachineService.updateByPrimaryKeySelective(data);
		return VoResult.success();
	}
	
	/**
	 * 删除T-box信息管理
	 * @return
	 */
	@RequestMapping(value="delete", method = RequestMethod.DELETE)
	public VoResult<?> delete(@RequestParam(required=true)final Long[] ids){
		csMachineService.batchDelete(ids);
		return VoResult.success();
	}
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(CsMachine data){
		if(data!=null){
			data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.接入商.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.终端类型.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.协议类型.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.适配车型.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.CsMachineResolver.状态.getResolver());
		}
	}
	
	/**
	 * 获取单条T-box信息管理信息
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, CsMachine>> detail(@PathVariable(required = true) Long id){
		CsMachine data = csMachineService.selectByPrimaryKey( id.intValue());
		Map<String, CsMachine> map = new HashMap<String, CsMachine>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}
	
	
	/**
	 * 根据文本检索T-box信息管理信息
	 */
	@RequestMapping(value="/query", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , CsMachine queryRecord){
		CsMachineCrieria query = new CsMachineCrieria();
		CsMachineCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			String val = String.valueOf(text);
			c.andcsmTeNoLike(val);
		}
		if(!StringUtils.isEmpty(where)){
			Integer val = Integer.valueOf(where);
			c.andcsmIdEqualTo(val);
		}
//		List<CsMachine> list = csMachineService.selectByExample(query);
		PageInfo<CsMachine> pageInfo = csMachineService.getPage(query, 0, 10);
		List<CsMachine> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (CsMachine data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getCsmId());
			map.put("text", data.getCsmTeNo());
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}
	
}
