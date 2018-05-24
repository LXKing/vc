package com.ccclubs.storage.impl;

import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.pub.orm.model.CsCan;
import com.ccclubs.storage.inf.BaseHistoryInf;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/10
 * @Time: 17:00
 * @Description: 全新CAN协议存储Phoenix实现类！
 */
@Service
public class CanStorageImpl implements BaseHistoryInf<CsCan> {

    static Logger logger = LoggerFactory.getLogger(CanStorageImpl.class);
    @Autowired
    private BaseInfImpl baseImpl;

    private static String baseCanUpsertNorSql = "UPSERT INTO " + PhoenixConst.PHOENIX_CAR_CAN_HISTORY_NOR + " (" +
            "VIN,CURRENT_TIME,TE_NUMBER,TE_NO,ICCID,MOBILE,SOURCE_HEX,ADD_TIME" +
            " ) values (" +
            "?, ?, ?, ?, ?, ?, ?, ? )";//1-8
    private static String baseCanUpsertExpSql = "UPSERT INTO " + PhoenixConst.PHOENIX_CAR_CAN_HISTORY_EXP + " (" +
            "VIN,CURRENT_TIME,TE_NUMBER,TE_NO,ICCID,MOBILE,SOURCE_HEX,ADD_TIME" +
            " ) values (" +
            "?, ?, ?, ?, ?, ?, ?, ? )";//1-8

    @Override
    public void insertBulid(CsCan historyDate, PreparedStatement preparedStatement) throws SQLException {

        //1-8  VIN,CURRENT_TIME,TE_NUMBER,TE_NO,ICCID,MOBILE,SOURCE_HEX,ADD_TIME
        String vin = historyDate.getCscVin();
        preparedStatement.setString(1, vin);
        Long currentTime = historyDate.getCscUploadTime().getTime();
        preparedStatement.setLong(2, currentTime);
        String teNumber = historyDate.getCscNumber();
        preparedStatement.setString(3, teNumber);
        String teNo = historyDate.getTeNo();
        preparedStatement.setString(4, teNo);
        String iccid = historyDate.getIccid();
        preparedStatement.setString(5, iccid);
        String mobile = historyDate.getMobile();
        preparedStatement.setString(6, mobile);
        String sourceHex = historyDate.getCscData();
        preparedStatement.setString(7, sourceHex);
        Long addTime = historyDate.getCscAddTime().getTime();
        if (null == addTime) {
            addTime = System.currentTimeMillis();
        }
        preparedStatement.setLong(8, addTime);

        preparedStatement.addBatch();
    }

    @Override
    public void saveOrUpdate(List<CsCan> records) {
        if (null == records || records.size() < 1) {
            return;
        }
        if (!StringUtils.isEmpty(records.get(0).getCscVin())) {
            baseImpl.saveOrUpdate(records, this,
                    baseCanUpsertNorSql, PhoenixConst.PHOENIX_CAR_CAN_HISTORY_NOR);
            logger.debug("Save nor can end." + records.size());
        } else {
            baseImpl.saveOrUpdate(records, this,
                    baseCanUpsertExpSql, PhoenixConst.PHOENIX_CAR_CAN_HISTORY_EXP);
            logger.debug("Save exp can end." + records.size());
        }
    }
}
