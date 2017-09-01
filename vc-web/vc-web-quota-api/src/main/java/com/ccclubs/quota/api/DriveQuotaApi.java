package com.ccclubs.quota.api;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.DriveMilesQuotaInf;
import com.ccclubs.quota.orm.model.DriveMilesBasicZt;
import com.ccclubs.quota.orm.model.DriveMilesBizQuota;
import com.ccclubs.quota.orm.model.DriveMilesQuota;
import com.ccclubs.quota.vo.DriveMilesBasicZtInput;
import com.ccclubs.quota.vo.DriveMilesBizQuotaInput;
import com.ccclubs.quota.vo.DriveMilesQuotaInput;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class DriveQuotaApi {
 
	@Reference(version="1.0.0")
	private DriveMilesQuotaInf driveMilesQuotaInf;
	
    @ApiOperation(value="行驶指标v2", notes="中间表查询行驶指标")
    @RequestMapping(path="/drive/quota/v2", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<PageInfo<DriveMilesBizQuota>> driveQuota(DriveMilesBizQuotaInput input){
    	PageInfo<DriveMilesBizQuota> pi = driveMilesQuotaInf.bizQuota(input);
    	return new ApiMessage<PageInfo<DriveMilesBizQuota>>(pi);
    }
    @ApiOperation(value="行驶指标v1", notes="动态计算行驶指标")
    @RequestMapping(path="/drive/quota/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<PageInfo<DriveMilesQuota>> driveCalcQuota(DriveMilesQuotaInput input){
    	PageInfo<DriveMilesQuota> pi = driveMilesQuotaInf.calcQuota(input);
    	return new ApiMessage<PageInfo<DriveMilesQuota>>(pi);
    }
    
    @ApiOperation(value="行驶指标详情", notes="查询行驶指标详情")
    @RequestMapping(path="/drive/detail/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<PageInfo<DriveMilesBasicZt>> driveQuotaDetail(DriveMilesBasicZtInput input){
    	PageInfo<DriveMilesBasicZt> pi = driveMilesQuotaInf.bizQuotaDetail(input);
    	return new ApiMessage<PageInfo<DriveMilesBasicZt>>(pi);
    }
    
    @ApiOperation(value="行驶指标表生成", notes="行驶指标表生成")
    @RequestMapping(path="/drive/build/v1", method={RequestMethod.POST, RequestMethod.GET})
    ApiMessage<String> quotaBuilder(){
    	driveMilesQuotaInf.quotaBuilder();
    	return new ApiMessage<String>("");
    }
}
