package com.ccclubs.quota.api;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.CsIndexQuotaInf;
import com.ccclubs.quota.orm.model.CsIndexReport;
import com.ccclubs.quota.vo.CsIndexReportInput;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class CsIndexQuotaApi {
	@Reference(version="1.0.0")
    private CsIndexQuotaInf csIndexQuotaInf;
 
    @ApiOperation(value="指标统计标准", notes="指标统计标准,生成")
    @RequestMapping(path="/csIndex/meta/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<String> metaBuilder(){
    	csIndexQuotaInf.metaBuilder();
		return new ApiMessage<String>("");
    }
    
    @ApiOperation(value="超标统计车辆列表", notes="超标统计车辆列表,生成")
    @RequestMapping(path="/csIndex/outrange/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<String> outrangeListBuilder(){
    	csIndexQuotaInf.outrangeListBuilder();
    	return new ApiMessage<String>("");
    }
    @ApiOperation(value="未纳入指标统计车辆列表", notes="未纳入指标统计车辆列表,生成")
    @RequestMapping(path="/csIndex/except/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<String> exceptListBuilder(){
    	csIndexQuotaInf.exceptListBuilder();
    	return new ApiMessage<String>("");
    }
    
    @ApiOperation(value="指标统计报表", notes="指标统计报表，生成")
    @RequestMapping(path="/csIndex/report/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<String> reportBuilder(){
    	csIndexQuotaInf.reportBuilder();
    	return new ApiMessage<String>("");
    }
    
    @ApiOperation(value="报表指标分页", notes="报表指标分页")
    @RequestMapping(path="/report/page/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<PageInfo<CsIndexReport>> socQuota(CsIndexReportInput input){
    	PageInfo<CsIndexReport> pi = csIndexQuotaInf.bizQuota(input);
		return new ApiMessage<PageInfo<CsIndexReport>>(pi);
    }
     
}
