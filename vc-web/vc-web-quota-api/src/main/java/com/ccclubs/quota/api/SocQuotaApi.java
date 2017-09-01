package com.ccclubs.quota.api;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.SocMilesQuotaInf;
import com.ccclubs.quota.orm.model.SocMilesBasicZt;
import com.ccclubs.quota.orm.model.SocMilesBizQuota;
import com.ccclubs.quota.orm.model.SocMilesQuota;
import com.ccclubs.quota.vo.SocMilesBasicZtInput;
import com.ccclubs.quota.vo.SocMilesBizQuotaInput;
import com.ccclubs.quota.vo.SocMilesQuotaInput;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class SocQuotaApi {
	@Reference(version="1.0.0")
    private SocMilesQuotaInf socMilesQuotaInf;
	 
    @ApiOperation(value="充电指标", notes="中间表查询充电指标")
    @RequestMapping(path="/soc/quota/v2", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<PageInfo<SocMilesBizQuota>> socQuota(SocMilesBizQuotaInput input){
    	PageInfo<SocMilesBizQuota> pi = socMilesQuotaInf.bizQuota(input);
		return new ApiMessage<PageInfo<SocMilesBizQuota>>(pi);
    }
    
    @ApiOperation(value="充电指标", notes="实时计算充电指标")
    @RequestMapping(path="/soc/quota/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<PageInfo<SocMilesQuota>> socQuota(SocMilesQuotaInput input){
    	PageInfo<SocMilesQuota> pi = socMilesQuotaInf.calcQuota(input);
    	return new ApiMessage<PageInfo<SocMilesQuota>>(pi);
    }
    
    @ApiOperation(value="充电指标详情", notes="查询充电指标详情")
    @RequestMapping(path="/soc/detail/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<PageInfo<SocMilesBasicZt>> socQuotaDetail(SocMilesBasicZtInput input){
    	PageInfo<SocMilesBasicZt> pi = socMilesQuotaInf.bizQuotaDetail(input);
    	return new ApiMessage<PageInfo<SocMilesBasicZt>>(pi);
    }
    @ApiOperation(value="充电指标表生成", notes="充电指标表生成")
    @RequestMapping(path="/soc/build/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<String> quotaBuilder(){
    	socMilesQuotaInf.quotaBuilder();
    	return new ApiMessage<String>("");
    }
}
