package com.ccclubs.quota.api.monitor;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.monitor.CsStructInf;
import com.ccclubs.quota.orm.model.CsStructWithBLOBs;
import com.ccclubs.quota.vo.BaseDeleteKeysInput;
import com.ccclubs.quota.vo.monitor.CsStructAddInput;
import com.ccclubs.quota.vo.monitor.CsStructQueryInput;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 远程控制记录
 */
@RefreshScope
@RestController
public class CsRemoteApi {

  @Reference(version = "1.0.0")
  private CsStructInf csStructInf;

  @ApiOperation(value = "远程控制新增", notes = "车载终端远程控制新增")
  @RequestMapping(path = "/monitor/csRemote/add/v1", method = {RequestMethod.POST,
      RequestMethod.GET})
  ApiMessage<String> add(CsStructAddInput input) {
    csStructInf.add(input);
    return new ApiMessage<String>("");
  }

  @ApiOperation(value = "车载终端远程控制管理修改", notes = "车载终端远程控制管理修改")
  @RequestMapping(path = "/monitor/csRemote/mod/v1", method = {RequestMethod.POST,
      RequestMethod.GET})
  ApiMessage<String> mod(CsStructAddInput input) {
    csStructInf.mod(input);
    return new ApiMessage<String>("");
  }

  @ApiOperation(value = "车载终端远程控制管理修改", notes = "车载终端远程控制管理修改")
  @RequestMapping(path = "/monitor/csRemote/mod/record/v1", method = {RequestMethod.POST,
      RequestMethod.GET})
  ApiMessage<CsStructWithBLOBs> modInfo(@NotNull @RequestParam("cssId") Long cssId) {
    CsStructWithBLOBs cm = csStructInf.mod(cssId);
    return new ApiMessage<CsStructWithBLOBs>(cm);
  }

  @ApiOperation(value = "车载终端远程控制管理查询", notes = "车载终端远程控制管理查询")
  @RequestMapping(path = "/monitor/csRemote/que/v1", method = {RequestMethod.POST,
      RequestMethod.GET})
  ApiMessage<PageInfo<CsStructWithBLOBs>> que(CsStructQueryInput input) {
    PageInfo<CsStructWithBLOBs> pi = csStructInf.que(input);
    return new ApiMessage<PageInfo<CsStructWithBLOBs>>(pi);
  }

}
