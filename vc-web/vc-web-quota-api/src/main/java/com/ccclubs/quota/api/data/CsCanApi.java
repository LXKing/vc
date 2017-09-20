package com.ccclubs.quota.api.data;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.data.CsCanInf;
import com.ccclubs.quota.orm.model.CsCan;
import com.ccclubs.quota.orm.model.CsCanBiz;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.data.CsCanAddInput;
import com.ccclubs.quota.vo.data.CsCanQueryInput;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class CsCanApi {
	@Reference(version = "1.0.0")
	private CsCanInf csCanInf;
	@ApiOperation(value = "车机升级管理新增", notes = "车机升级管理新增")
	@RequestMapping(path = "/basis/csCan/add/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> add(CsCanAddInput input) {
		csCanInf.add(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车机升级管理删除", notes = "车机升级管理删除")
	@RequestMapping(path = "/basis/csCan/del/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> del(@RequestParam("ids[]") List<Integer> ids) {
		BaseDeleteInput input = new BaseDeleteInput();
		input.setIds(ids);
		csCanInf.del(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车机升级管理修改", notes = "车机升级管理修改")
	@RequestMapping(path = "/basis/csCan/mod/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> mod(CsCanAddInput input) {
		csCanInf.mod(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车机升级管理修改", notes = "车机升级管理修改")
	@RequestMapping(path = "/basis/csCan/mod/record/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<CsCan> modInfo(@NotNull@RequestParam("cssId")Integer cssId) {
		CsCan cm = csCanInf.mod(cssId);
		return new ApiMessage<CsCan>(cm);
	}
	@ApiOperation(value = "车机升级管理查询", notes = "车机升级管理查询")
	@RequestMapping(path = "/basis/csCan/que/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<PageInfo<CsCanBiz>> que(CsCanQueryInput input) {
		PageInfo<CsCanBiz> pi = csCanInf.que(input);
		return new ApiMessage<PageInfo<CsCanBiz>>(pi);
	}
}
