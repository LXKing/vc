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
import com.ccclubs.quota.inf.basis.TbUpgradeInf;
import com.ccclubs.quota.orm.model.TbUpgrade;
import com.ccclubs.quota.vo.BaseDeleteInput;
import com.ccclubs.quota.vo.basis.TbUpgradeAddInput;
import com.ccclubs.quota.vo.basis.TbUpgradeQueryInput;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class TbUpgradeApi {
	@Reference(version = "1.0.0")
	private TbUpgradeInf tbUpgradeInf;
	
	@ApiOperation(value = "车机升级管理新增", notes = "车机升级管理新增")
	@RequestMapping(path = "/basis/tbUpgrade/add/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> add(TbUpgradeAddInput input) {
		tbUpgradeInf.add(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车机升级管理删除", notes = "车机升级管理删除")
	@RequestMapping(path = "/basis/tbUpgrade/del/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> del(@RequestParam("ids[]") List<Integer> ids) {
		BaseDeleteInput input = new BaseDeleteInput();
		input.setIds(ids);
		tbUpgradeInf.del(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车机升级管理修改", notes = "车机升级管理修改")
	@RequestMapping(path = "/basis/tbUpgrade/mod/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> mod(TbUpgradeAddInput input) {
		tbUpgradeInf.mod(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "车机升级管理修改", notes = "车机升级管理修改")
	@RequestMapping(path = "/basis/tbUpgrade/mod/record/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<TbUpgrade> modInfo(@NotNull@RequestParam("tbuId")Integer tbuId) {
		TbUpgrade cm = tbUpgradeInf.mod(tbuId);
		return new ApiMessage<TbUpgrade>(cm);
	}
	@ApiOperation(value = "车机升级管理查询", notes = "车机升级管理查询")
	@RequestMapping(path = "/basis/tbUpgrade/que/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<PageInfo<TbUpgrade>> que(TbUpgradeQueryInput input) {
		PageInfo<TbUpgrade> pi = tbUpgradeInf.que(input);
		return new ApiMessage<PageInfo<TbUpgrade>>(pi);
	}
}
