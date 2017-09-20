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
import com.ccclubs.quota.inf.basis.CsVehicleInf;
import com.ccclubs.quota.orm.model.CsVehicle;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.basis.CsVehicleAddInput;
import com.ccclubs.quota.vo.basis.CsVehicleQueryInput;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class CsVehicleApi {
	@Reference(version = "1.0.0")
	private CsVehicleInf csVehicleInf;
	@ApiOperation(value = "车辆信息管理新增", notes = "车辆信息管理新增")
	@RequestMapping(path = "/basis/csVehicle/add/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> add(CsVehicleAddInput input) {
		csVehicleInf.add(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车辆信息管理删除", notes = "车辆信息管理删除")
	@RequestMapping(path = "/basis/csVehicle/del/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> del(@RequestParam("ids[]") List<Integer> ids) {
		BaseDeleteInput input = new BaseDeleteInput();
		input.setIds(ids);
		csVehicleInf.del(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车辆信息管理修改", notes = "车辆信息管理修改")
	@RequestMapping(path = "/basis/csVehicle/mod/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> mod(CsVehicleAddInput input) {
		csVehicleInf.mod(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车辆信息管理修改", notes = "车辆信息管理修改")
	@RequestMapping(path = "/basis/csVehicle/mod/record/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<CsVehicle> modInfo(@NotNull@RequestParam("csmId")Integer csmId) {
		CsVehicle cm = csVehicleInf.mod(csmId);
		return new ApiMessage<CsVehicle>(cm);
	}
	@ApiOperation(value = "车辆信息管理查询", notes = "车辆信息管理查询")
	@RequestMapping(path = "/basis/csVehicle/que/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<PageInfo<CsVehicle>> que(CsVehicleQueryInput input) {
		PageInfo<CsVehicle> pi = csVehicleInf.que(input);
		return new ApiMessage<PageInfo<CsVehicle>>(pi);
	}
}
