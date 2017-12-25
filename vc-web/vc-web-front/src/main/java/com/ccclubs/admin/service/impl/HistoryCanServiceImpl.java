package com.ccclubs.admin.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ccclubs.admin.model.HistoryCan;
import com.ccclubs.admin.query.HistoryCanQuery;
import com.ccclubs.admin.service.IHistoryCanService;
import com.ccclubs.admin.vo.Page;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.orm.model.CarCan;
import com.ccclubs.phoenix.output.CarCanHistoryOutput;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 车辆CAN历史数据的Service实现
 * @author Joel
 */
@Service
public class HistoryCanServiceImpl  implements IHistoryCanService{

    Logger logger= LoggerFactory.getLogger(HistoryCanServiceImpl.class);
    @Value("${hbaseSrv.host:101.37.178.63}")
    private String host;
    @Value("${hbaseSrv.urlPathCan:/history/cans}")
    private String urlPath;
    @Override
    public TableResult<HistoryCan> getPage(HistoryCanQuery query,Integer pageNo, Integer pageSize, String order) {
        ApiMessage<CarCanHistoryOutput> apiMessage;
        TableResult<HistoryCan> result=new TableResult<>();
        Page page=new Page(0,pageSize,0);
        result.setData(new ArrayList<>());
        result.setPage(page);

        String startTime= DateTimeUtil.getDateTimeByUnixFormat(query.getCurrentTimeStart().getTime());
        String endTime= DateTimeUtil.getDateTimeByUnixFormat(query.getCurrentTimeEnd().getTime());
        try {
            apiMessage=this.queryCarCanListFromHbase(query.getCsNumberEquals(),
                    startTime,endTime,
                    pageNo,pageSize,order);
            if(apiMessage!=null&&apiMessage.getCode()== ApiEnum.SUCCESS.code()){
                if (apiMessage.getData()!=null){
                    if (apiMessage.getData().getTotal()>0){
                        List<CarCan> carCanList=apiMessage.getData().getList();
                        page=new Page(pageNo,pageSize,apiMessage.getData().getTotal());
                        result.setData(dealCarCanToHistoryCanAll(carCanList));
                        result.setPage(page);
                    }
                    else {
                        //没有查询到数据
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private static HistoryCan dealCarCanToHistoryCan(CarCan carCan){
        if (null!=carCan){
            HistoryCan historyCan=new HistoryCan();
            historyCan.setAddTime(new Date(carCan.getAdd_time()));
            historyCan.setCanData(carCan.getCan_data());
            historyCan.setCsNumber(carCan.getCs_number());
            historyCan.setCurrentTime(new Date(carCan.getCurrent_time()));


            return historyCan;
        }
        else {return null;}
    }

    private static List<HistoryCan> dealCarCanToHistoryCanAll(List<CarCan> carCanList){
        if (null!=carCanList&&carCanList.size()>0){
            List<HistoryCan> historyCanList=new ArrayList<>();
            for (CarCan carCan :carCanList){
                historyCanList.add(dealCarCanToHistoryCan(carCan));
            }
            return historyCanList;
        }
        else {
            return null;
        }

    }



    private ApiMessage<CarCanHistoryOutput> queryCarCanListFromHbase(String csNumber, String startTime,
                                                                         String endTime, Integer pageNo,
                                                                         Integer pageSize, String order) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpGet httpGet=new HttpGet();
        httpGet.setHeader("Content-Type", "application/json;charset=utf-8");
        String param="?cs_number="+csNumber.trim()
                +"&start_time="+startTime.trim()
                +"&end_time="+endTime.trim()
                +"&query_fields=*"
                +"&order="+order.trim()
                +"&page_no="+pageNo
                +"&page_size="+pageSize;
        param=param.replaceAll(" ","%20");
        String url="http://"+host+urlPath;
        URI uri=URI.create(url+param);
        httpGet.setURI(uri);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        return this.checkResponse(response);

    }

    private ApiMessage<CarCanHistoryOutput> checkResponse(CloseableHttpResponse response)
            throws IOException,Exception {
        ApiMessage<CarCanHistoryOutput> apiMessage=null;
        try {
            //System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                String result = IOUtils.toString(entity.getContent(), "UTF-8");
                //System.out.println(result);
                apiMessage= JSON.parseObject(result, new TypeReference<ApiMessage<CarCanHistoryOutput>>() {});
                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
        return apiMessage;
    }
}