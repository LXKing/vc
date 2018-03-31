package com.ccclubs.storage.tasks.processor;

import com.ccclubs.phoenix.orm.model.CarGb;
import com.ccclubs.pub.orm.model.CsMessage;
import com.ccclubs.storage.impl.PhoenixStorageService;
import com.ccclubs.storage.inf.BaseHbaseStorageInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryMessageUtils extends ConvertUtils  implements BaseHbaseStorageInf<CsMessage> {
    private static Logger logger = LoggerFactory.getLogger(HistoryMessageUtils.class);

    @Autowired
    private PhoenixStorageService phoenixStorageService;


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


    /**
     * 存储T类型的历史数据到mongoDB，此方法现在已经废弃。
     *
     * @param data
     */
    @Override
    public void saveHistoryData(CsMessage data) {
        return;
    }

    /**
     * 存储T类型的历史数据到HBASE。
     *
     * @param data
     */
    @Override
    public void saveHistoryDataToHbase(CsMessage data) {

        //CarGb carGb=dealCsMessageToCarGbHistory(data);
        return;

    }

    /**
     * 存储T类型的历史数据的集合到HBASE。
     *
     * @param listData
     */
    @Override
    public void saveHistoryDataToHbase(List<CsMessage> listData) {

        logger.info("即将转换国标数据");
        List<CarGb> carGbList=dealCsMessageListToCarGbHistoryLsit(listData);
        if(null==carGbList||carGbList.size()<1){
            logger.warn("carGbList is null! nothing history gb date saved");
            return ;
        }
        logger.info("即将存储国标数据");
        phoenixStorageService.saveOrUpdate(carGbList);
        logger.info("国标数据存储完成");

    }
}
