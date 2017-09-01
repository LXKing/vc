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
import com.ccclubs.quota.inf.basis.BasicModelInf;
import com.ccclubs.quota.orm.model.CsModel;
import com.ccclubs.quota.vo.basis.BasicModelAddInput;
import com.ccclubs.quota.vo.basis.BasicModelDelInput;
import com.ccclubs.quota.vo.basis.BasicModelQueryInput;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class BasicModelApi {
	@Reference(version = "1.0.0")
	private BasicModelInf basicModelInf;

	@ApiOperation(value = "基础车型管理新增", notes = "基础车型管理新增")
	@RequestMapping(path = "/basis/basicModel/add/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> add(BasicModelAddInput input) {
		basicModelInf.add(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "基础车型管理删除", notes = "基础车型管理删除")
	@RequestMapping(path = "/basis/basicModel/del/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> del(@RequestParam("ids[]") List<Integer> ids) {
		BasicModelDelInput input = new BasicModelDelInput();
		input.setIds(ids);
		basicModelInf.del(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "基础车型管理修改", notes = "基础车型管理修改")
	@RequestMapping(path = "/basis/basicModel/mod/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<String> mod(BasicModelAddInput input) {
		basicModelInf.mod(input);
		return new ApiMessage<String>("");
	}
	@ApiOperation(value = "基础车型管理修改", notes = "基础车型管理修改")
	@RequestMapping(path = "/basis/basicModel/mod/record/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<CsModel> modInfo(@NotNull@RequestParam("csmId")Integer csmId) {
		CsModel cm = basicModelInf.mod(csmId);
		return new ApiMessage<CsModel>(cm);
	}
	@ApiOperation(value = "基础车型管理查询", notes = "基础车型管理查询")
	@RequestMapping(path = "/basis/basicModel/que/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<PageInfo<CsModel>> que(BasicModelQueryInput input) {
		PageInfo<CsModel> pi = basicModelInf.que(input);
		return new ApiMessage<PageInfo<CsModel>>(pi);
	}
}
