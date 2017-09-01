package com.ccclubs.quota.api;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.MapInf;
import com.ccclubs.quota.vo.MapInput;
import com.ccclubs.quota.vo.MapOutput;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class MapApi {
	@Reference(version = "1.0.0")
	private MapInf mapinf;
	
	@ApiOperation(value = "行政区域显示", notes = "行政区域显示")
	@RequestMapping(path = "/map/show/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<MapOutput> map(MapInput input) {
		MapOutput out = mapinf.map(input);
		return new ApiMessage<MapOutput>(out);
	}
	@ApiOperation(value = "省显示", notes = "省显示")
	@RequestMapping(path = "/map/province/v1", method = { RequestMethod.POST, RequestMethod.GET })
	ApiMessage<MapOutput> districtId(MapInput input) {
		MapOutput out = mapinf.district(input);
		return new ApiMessage<MapOutput>(out);
	}
}
