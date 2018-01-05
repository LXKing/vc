package com.ccclubs.phoenix.tesks.processor;

import com.ccclubs.phoenix.inf.CarGbHistoryInf;
import com.ccclubs.phoenix.orm.model.CarGb;
import com.ccclubs.pub.orm.dto.CsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryMessageUtils extends ConvertUtils {
    private static Logger logger = LoggerFactory.getLogger(HistoryMessageUtils.class);
    @Resource
    private RedisTemplate redisTemplate;
//    @Reference(version = "1.0.0")
    @Autowired
    private CarGbHistoryInf carGbHistoryService;

    /*@Value("${ccclubs.data.batch.hbaseSrv.host:127.0.0.1}")
    private String ip;
    @Value("${ccclubs.data.batch.hbaseSrv.port:8080}")
    private String port;
    @Value("${ccclubs.data.batch.hbaseSrv.urlRootPath:history}")
    private String urlRootPath;*/


    public void saveHistoryGbDataToHbase(List<CsMessage> csMessageLists){
        logger.info("即将转换国标数据");
        List<CarGb> carGbList=dealCsMessageListToCarGbHistoryLsit(csMessageLists);
        if(null==carGbList||carGbList.size()<1){
            logger.warn("carGbList is null! nothing history gb date saved");
            return ;
        }
        logger.info("即将存储国标数据");
        carGbHistoryService.saveOrUpdate(carGbList);
        logger.info("国标数据存储完成");
        /*String sourceJson = JSON.toJSONString(csMessageLists);
        String objectJson = JSON.toJSONString(carGbList);
        logger.debug("source: {} ,target: {}",sourceJson,objectJson);
        //concurrentLinkedQueue.add(objectJson);
        logger.debug("deal carGb list json done:" + objectJson);
        String url="http://"+ip+":"+port+"/"+urlRootPath+"/gbs";
        HttpClientUtil.doPostJson(url, objectJson);
        logger.debug("send post for csMessageList !");*/


    }


    public void saveHistoryGbDataToHbase(CsMessage csMessage){


        CarGb carGb=dealCsMessageToCarGbHistory(csMessage);
        /*String objectJson = JSON.toJSONString(carGb);
        //concurrentLinkedQueue.add(objectJson);
        logger.debug("deal carGb data json done:" + objectJson);
        String url="http://"+ip+":"+port+"/"+urlRootPath+"/gb";
        HttpClientUtil.doPostJson(url, objectJson);
        logger.debug("send post for carGb !");*/

    }



    public List<CarGb> dealCsMessageListToCarGbHistoryLsit(List<CsMessage> csMessageList){

        if(null==csMessageList||csMessageList.size()<1){
            logger.warn("csMessageList is null!");
            return null;
        }
        List<CarGb> carGbList=new ArrayList<>();
        for (int i=0;i<csMessageList.size();i++){
            carGbList.add(dealCsMessageToCarGbHistory(csMessageList.get(i)));
        }
        return  carGbList;


    }




    public CarGb dealCsMessageToCarGbHistory(CsMessage csMessage){
        if (null==csMessage){return null;}
        CarGb carGb=new CarGb();
        carGb.setAdd_time(null==csMessage.getCsmAddTime()?System.currentTimeMillis():csMessage.getCsmAddTime());
        carGb.setCs_access(csMessage.getCsmAccess());
        carGb.setCs_protocol(convertToInterger(csMessage.getCsmProtocol()));
        carGb.setCs_verify(convertToInterger(csMessage.getCsmVerify()));
        carGb.setCs_vin(csMessage.getCsmVin());
        if (null!=csMessage.getCsmMsgTime()) {
            carGb.setCurrent_time(csMessage.getCsmMsgTime());
        }
        carGb.setGb_data(csMessage.getCsmData());
        carGb.setGb_type(convertToInterger(csMessage.getCsmType()));
        return carGb;
    }



}
