package com.ccclubs.quota.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.olap.orm.model.ZhiFABean;
import com.ccclubs.quota.api.util.CsIndexReportUtil;
import com.ccclubs.quota.api.util.ZhiFaReportUtil;
import com.ccclubs.quota.vo.WeekBeanOutput;
import com.ccclubs.quota.inf.ZhiFaMilesBasicInf;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/19 0019.
 */

@RefreshScope
@RestController
public class ZhiFaMilesBasicApi {

    @Reference(version="1.0.0")
    private ZhiFaMilesBasicInf zhiFaMilesBasicInf;

    @RequestMapping(value="/zhifa/queryweek", method={RequestMethod.POST, RequestMethod.GET})
    public List<WeekBeanOutput> getWeekCount(){
        List<WeekBeanOutput> weekList= zhiFaMilesBasicInf.getWeekCount();
      return   weekList;
    }

    /**
     * 执法_数据项导出项选择
     */
    @RequestMapping(value="/zhifa/generatereport", method={RequestMethod.POST, RequestMethod.GET})
    public Map<String,Object> zhiFaGenerateReport(@RequestParam("rangetime") String rangetime, HttpServletRequest request) {
        Map<String,Object> map=new HashMap<>();
        try{
            String[] range=null;
            if(rangetime!=null&&rangetime.length()>0){
                range= rangetime.split("~");
            }
            String startTime=range[0];//开始时间
            String endTime=range[1];//结束时间
            //
            Map<String,List<ZhiFABean>> mapDate= zhiFaMilesBasicInf.queryZhiFaData(startTime,endTime);
            String token= request.getSession().getId()+System.currentTimeMillis();
            ByteArrayOutputStream buff=  ZhiFaReportUtil.getZhiFaReport(mapDate);
            CsIndexReportUtil.excelBinaryMap.put(token,buff);
            //
            map.put("token",token);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     *执法报表导出
     * @param res
     */
    @RequestMapping(value = "/zhifa/getReport", method = RequestMethod.GET)
    public void getReport(String token,HttpServletResponse res) {
        OutputStream os = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(System.currentTimeMillis());
        String fileName="zf_report_"+dateNowStr+".xls";
        try {
            res.setHeader("content-type", "application/vnd.ms-excel");
            res.setContentType("application/vnd.ms-excel");
            res.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
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

}
