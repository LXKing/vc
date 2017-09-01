package com.ccclubs.quota.api.basis;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.basis.CsTerminalInf;
import com.ccclubs.quota.orm.model.CsTerminal;
import com.ccclubs.quota.vo.basis.CsTerminalAddInput;
import com.ccclubs.quota.vo.basis.CsTerminalDelInput;
import com.ccclubs.quota.vo.basis.CsTerminalQueryInput;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class CsTerminalApi {
	@Reference(version = "1.0.0")
	private CsTerminalInf csTerminalInf;
	@ApiOperation(value = "车载终端注册信息管理新增", notes = "车载终端注册信息管理新增")
	@RequestMapping(path = "/basis/csTerminal/add/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> add(CsTerminalAddInput input) {
		csTerminalInf.add(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车载终端注册信息管理删除", notes = "车载终端注册信息管理删除")
	@RequestMapping(path = "/basis/csTerminal/del/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> del(@RequestParam("ids[]") List<Long> ids) {
		CsTerminalDelInput input = new CsTerminalDelInput();
		input.setIds(ids);
		csTerminalInf.del(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车载终端注册信息管理修改", notes = "车载终端注册信息管理修改")
	@RequestMapping(path = "/basis/csTerminal/mod/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> mod(CsTerminalAddInput input) {
		csTerminalInf.mod(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车载终端注册信息管理修改", notes = "车载终端注册信息管理修改")
	@RequestMapping(path = "/basis/csTerminal/mod/record/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<CsTerminal> modInfo(@NotNull@RequestParam("cstId")Long cstId) {
		CsTerminal cm = csTerminalInf.mod(cstId);
		return new ApiMessage<CsTerminal>(cm);
	}
	@ApiOperation(value = "车载终端注册信息管理查询", notes = "车载终端注册信息管理查询")
	@RequestMapping(path = "/basis/csTerminal/que/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<PageInfo<CsTerminal>> que(CsTerminalQueryInput input) {
		PageInfo<CsTerminal> pi = csTerminalInf.que(input);
		return new ApiMessage<PageInfo<CsTerminal>>(pi);
	}
}
