package com.ccclubs.quota.api.data;

import java.util.List;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.data.SrvHostInf;
import com.ccclubs.quota.orm.model.SrvHost;
import com.ccclubs.quota.vo.data.CsStateQueryInput;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class SrvHostApi {
	@Reference(version = "1.0.0")
	private SrvHostInf srvHostInf;
	@ApiOperation(value = "授权系统管理查询", notes = "授权系统管理查询")
	@RequestMapping(path = "/basis/srvHost/select/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<List<SrvHost>> que(CsStateQueryInput input) {
		List<SrvHost> pi = srvHostInf.select();
		return new ApiMessage<List<SrvHost>>(pi);
	}
}
