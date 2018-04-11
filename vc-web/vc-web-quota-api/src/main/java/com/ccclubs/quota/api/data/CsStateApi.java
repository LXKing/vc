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
import com.ccclubs.quota.inf.data.CsStateInf;
import com.ccclubs.quota.orm.model.CsState;
import com.ccclubs.quota.orm.model.CsStateBiz;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.data.CsStateAddInput;
import com.ccclubs.quota.vo.data.CsStateQueryInput;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class CsStateApi {
	@Reference(version = "1.0.0")
	private CsStateInf csStateInf;
	@ApiOperation(value = "车机当前状态管理新增", notes = "车机当前状态管理新增")
	@RequestMapping(path = "/data/csState/add/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> add(CsStateAddInput input) {
		return null;
	}
	@ApiOperation(value = "车机当前状态管理删除", notes = "车机当前状态管理删除")
	@RequestMapping(path = "/data/csState/del/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> del(@RequestParam("ids[]") List<Integer> ids) {
		BaseDeleteInput input = new BaseDeleteInput();
		input.setIds(ids);
		csStateInf.del(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车机当前状态管理修改", notes = "车机当前状态管理修改")
	@RequestMapping(path = "/data/csState/mod/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> mod(CsStateAddInput input) {
		csStateInf.mod(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车机当前状态管理修改", notes = "车机当前状态管理修改")
	@RequestMapping(path = "/data/csState/mod/record/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<CsState> modInfo(@NotNull@RequestParam("cssId")Integer cssId) {
		CsState cm = csStateInf.mod(cssId);
		return new ApiMessage<CsState>(cm);
	}
	@ApiOperation(value = "车机当前状态管理查询", notes = "车机当前状态管理查询")
	@RequestMapping(path = "/data/csState/que/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<PageInfo<CsStateBiz>> que(CsStateQueryInput input) {
		PageInfo<CsStateBiz> pi = csStateInf.que(input);
		return new ApiMessage<PageInfo<CsStateBiz>>(pi);
	}
}
