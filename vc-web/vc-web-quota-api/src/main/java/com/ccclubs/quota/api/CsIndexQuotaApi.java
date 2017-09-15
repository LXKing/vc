package com.ccclubs.quota.api;

import com.ccclubs.quota.api.util.CsIndexReportUtil;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.CsIndexQuotaInf;
import com.ccclubs.quota.orm.model.CsIndexReport;
import com.ccclubs.quota.vo.CsIndexReportInput;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     *报表产生
     * @param res
     */
    @RequestMapping(value = "/csIndex/getReport", method = RequestMethod.GET)
    public void getReport(String token,HttpServletResponse res) {
        OutputStream os = null;
        try {
            res.setHeader("content-type", "application/vnd.ms-excel");
            res.setContentType("application/vnd.ms-excel");
            res.setHeader("Content-Disposition", "attachment; filename=" + new String("zhong_tai_report.xls".getBytes("UTF-8"),"ISO8859-1"));
            os = res.getOutputStream();
            //文件路径
            ByteArrayOutputStream  bytes=null;
            if(CsIndexReportUtil.excelBinaryMap.containsKey(token)){
                bytes =CsIndexReportUtil.excelBinaryMap.get(token);
                os.write(bytes.toByteArray());
                os.flush();
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(os!=null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 多文件上传

     */
    @RequestMapping("/file/uploads")
    public Map<String,Object> upload(@RequestParam("files[]") MultipartFile[] files, HttpServletRequest request) {

        try{
            List<CsIndexReport> vinList= CsIndexReportUtil.getConditionVinList(files);
            //
            Map<String,List<CsIndexReport>> dateMap=new HashMap<>();
            if (vinList!=null&&vinList.size()>0){
                dateMap= csIndexQuotaInf.ztReportExport(vinList);
            }
            //
            String token= request.getSession().getId()+System.currentTimeMillis();
            ByteArrayOutputStream buff=  CsIndexReportUtil.outToExcel(dateMap,vinList);
            CsIndexReportUtil.excelBinaryMap.put(token,buff);
            Map<String,Object> map=new HashMap<>();
            map.put("token",token);
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}













