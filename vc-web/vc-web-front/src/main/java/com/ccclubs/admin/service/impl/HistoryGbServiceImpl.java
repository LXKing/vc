package com.ccclubs.admin.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ccclubs.admin.model.HistoryGb;
import com.ccclubs.admin.query.HistoryGbQuery;
import com.ccclubs.admin.service.IHistoryGbService;
import com.ccclubs.admin.vo.Page;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.phoenix.orm.model.CarGb;
import com.ccclubs.phoenix.output.CarGbHistoryOutput;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.util.Tools;
import javax.tools.Tool;
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
 * 车辆国标历史数据的Service实现
 * @author Joel
 */
@Service
public class HistoryGbServiceImpl implements IHistoryGbService{

    Logger logger= LoggerFactory.getLogger(HistoryGbServiceImpl.class);

    @Value("${hbaseSrv.host:101.37.178.63}")
    private String host;
    @Value("${hbaseSrv.urlPathGb:/history/gbs}")
    private String urlPath;
    @Override
    public TableResult<HistoryGb> getPage(HistoryGbQuery query, Integer pageNo, Integer pageSize, String order) {
        ApiMessage<CarGbHistoryOutput> apiMessage;
        TableResult<HistoryGb> result=new TableResult<>();
        Page page=new Page(0,pageSize,0);
        result.setData(new ArrayList<>());
        result.setPage(page);

        String startTime= DateTimeUtil.getDateTimeByUnixFormat(query.getAddTimeStart().getTime());
        String endTime= DateTimeUtil.getDateTimeByUnixFormat(query.getAddTimeEnd().getTime());
        try {
            apiMessage=this.queryCarGbListFromHbase(query.getCsVinEquals(),
                    startTime,endTime,
                    pageNo,pageSize,order);
            if(apiMessage!=null&&apiMessage.getCode()== ApiEnum.SUCCESS.code()){
                if (apiMessage.getData()!=null){
                    if (null!=apiMessage.getData().getTotal()
                            &&apiMessage.getData().getTotal()>0){
                        List<CarGb> carGbList=apiMessage.getData().getList();
                        page=new Page(pageNo,pageSize,apiMessage.getData().getTotal());
                        result.setData(dealCarGbToHistoryGbAll(carGbList));
                        result.setPage(page);
                    }
                    else if (null!=apiMessage.getData().getList()
                            &&apiMessage.getData().getList().size()>0){
                        List<CarGb> carGbList=apiMessage.getData().getList();
                        page=new Page(pageNo,pageSize,apiMessage.getData().getList().size());
                        result.setData(dealCarGbToHistoryGbAll(carGbList));
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


    @Override
    public TableResult<GBMessage> getGbMessagePage(HistoryGbQuery query, Integer pageNo, Integer pageSize, String order) {
        ApiMessage<CarGbHistoryOutput> apiMessage;
        TableResult<GBMessage> result=new TableResult<>();
        Page page=new Page(0,pageSize,0);
        result.setData(new ArrayList<>());
        result.setPage(page);

        String startTime= DateTimeUtil.getDateTimeByUnixFormat(query.getAddTimeStart().getTime());
        String endTime= DateTimeUtil.getDateTimeByUnixFormat(query.getAddTimeEnd().getTime());
        try {
            apiMessage=this.queryCarGbListFromHbase(query.getCsVinEquals(),
                startTime,endTime,
                pageNo,pageSize,order);
            if(apiMessage!=null&&apiMessage.getCode()== ApiEnum.SUCCESS.code()){
                if (apiMessage.getData()!=null){
                    if (null!=apiMessage.getData().getTotal()
                        && apiMessage.getData().getTotal() > 0 && null!=apiMessage.getData().getList()
                        && apiMessage.getData().getList().size() > 0){
                        List<CarGb> carGbList=apiMessage.getData().getList();
                        page=new Page(pageNo,pageSize,apiMessage.getData().getTotal());
                        result.setData(dealCarGbToGbMessageAll(carGbList));
                        result.setPage(page);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    private static HistoryGb dealCarGbToHistoryGb(CarGb carGb){
        if (null!=carGb){
            HistoryGb historyGb=new HistoryGb();
            historyGb.setAddTime(new Date(carGb.getAdd_time()));
            historyGb.setCsAccess(carGb.getCs_access());
            historyGb.setCsProtocol(carGb.getCs_protocol());
            historyGb.setCsVerify(carGb.getCs_verify());
            historyGb.setCsVin(carGb.getCs_vin());
            if (null!=carGb.getCurrent_time()&&carGb.getCurrent_time()!=0L) {
                historyGb.setCurrentTime(new Date(carGb.getCurrent_time()));
            }
            historyGb.setGbData(carGb.getGb_data());
            historyGb.setGbType(carGb.getGb_type());

            return historyGb;
        }
        else {return null;}
    }

    private static List<GBMessage> dealCarGbToGbMessageAll(List<CarGb> carGbList){
        GBMessage gbMessage = new GBMessage();
        if (null!=carGbList&&carGbList.size() > 0){
            List<GBMessage> historyGbList=new ArrayList<>();
            for (CarGb carGb :carGbList){
                gbMessage.ReadFromBytes(Tools.HexString2Bytes(carGb.getGb_data()));
                historyGbList.add(gbMessage);
            }
            return historyGbList;
        }
        else {
            return null;
        }
    }


    private static List<HistoryGb> dealCarGbToHistoryGbAll(List<CarGb> carGbList){
        if (null!=carGbList&&carGbList.size()>0){
            List<HistoryGb> historyGbList=new ArrayList<>();
            for (CarGb carGb :carGbList){
                historyGbList.add(dealCarGbToHistoryGb(carGb));
            }
            return historyGbList;
        }
        else {
            return null;
        }

    }

    private ApiMessage<CarGbHistoryOutput> queryCarGbListFromHbase(String csVin, String startTime,
                                                                         String endTime, Integer pageNo,
                                                                         Integer pageSize, String order) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpGet httpGet=new HttpGet();
        httpGet.setHeader("Content-Type", "application/json;charset=utf-8");
        String param="?cs_vin="+csVin.trim()
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

    private ApiMessage<CarGbHistoryOutput> checkResponse(CloseableHttpResponse response)
            throws IOException,Exception {
        ApiMessage<CarGbHistoryOutput> apiMessage=null;
        try {
            //System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                String result = IOUtils.toString(entity.getContent(), "UTF-8");
                //System.out.println(result);
                apiMessage= JSON.parseObject(result, new TypeReference<ApiMessage<CarGbHistoryOutput>>() {});
                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
        return apiMessage;
    }
}