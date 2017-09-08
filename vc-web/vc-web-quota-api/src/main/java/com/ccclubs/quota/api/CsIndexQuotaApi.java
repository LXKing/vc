package com.ccclubs.quota.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.quota.inf.CsIndexQuotaInf;
import com.ccclubs.quota.orm.model.CsIndexReport;
import com.ccclubs.quota.vo.CsIndexReportInput;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RefreshScope
@RestController
public class CsIndexQuotaApi {

    @Value("${csIndexReport.templateReportPath}")
    private String  templateReportPath;

    @Value("${csIndexReport.conditionReportPath}")
    private String  conditionReportPath;

    @Value("${csIndexReport.generateReportPath}")
    private String  generateReportPath;


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
     * 多文件上传
     * @param files
     */
    @RequestMapping("/file/uploads")
    public void upload(@RequestParam("files[]") MultipartFile[] files) {
        try{
            File conditionFile=new File(conditionReportPath);
            if (!conditionFile.exists()){
                conditionFile.mkdirs();
            }


            File generateFile=new File(generateReportPath.substring(0,generateReportPath.lastIndexOf("/")));
            if (!generateFile.exists()){
                generateFile.mkdirs();
            }

            String conditionPath=null;
            for(MultipartFile uploadedFile : files) {
                File file = new File(conditionReportPath +"//"+ uploadedFile.getOriginalFilename());
                uploadedFile.transferTo(file);
                conditionPath=conditionReportPath+File.separator+ uploadedFile.getOriginalFilename();
                break;
            }
            csIndexQuotaInf.reportExport(conditionPath,generateReportPath);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * excel 模板下载
     * @param res
     */
    @RequestMapping(value = "/csIndex/downloadFile", method = RequestMethod.GET)
    public void downloadTemplateFile(HttpServletResponse res) {
        String fileName = templateReportPath.substring(templateReportPath.lastIndexOf("/"));
        getFileContent(fileName,templateReportPath,res);
    }

    /**
     *报表产生
     * @param res
     */
    @RequestMapping(value = "/csIndex/getReport", method = RequestMethod.GET)
    public void getReport(HttpServletResponse res) {
        String fileName = generateReportPath.substring(generateReportPath.lastIndexOf("/"));
        getFileContent(fileName,generateReportPath,res);
    }



    public static void getFileContent(String fileName,String path,HttpServletResponse res){

        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            res.setHeader("content-type", "application/octet-stream");
            res.setContentType("application/octet-stream");
            res.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
            byte[] buff = new byte[1024];
            os = res.getOutputStream();
            //文件路径
            bis = new BufferedInputStream(new FileInputStream(new File( path)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if(os!=null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
