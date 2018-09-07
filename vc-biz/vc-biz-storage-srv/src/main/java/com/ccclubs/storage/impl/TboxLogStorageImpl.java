package com.ccclubs.storage.impl;

import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.pub.orm.dto.TboxLog;
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
 * @Time: 16:55
 * @Description: 全新GBMessage协议存储Phoenix实现类！
 */

@Service
public class TboxLogStorageImpl implements BaseHistoryInf<TboxLog> {

    static Logger logger = LoggerFactory.getLogger(TboxLogStorageImpl.class);
    @Autowired
    private BaseInfImpl baseImpl;

    private static String baseTboxLogUpsertNorSql = "UPSERT INTO " + PhoenixConst.PHOENIX_CAR_TBOX_LOG_NOR + " (" +
            "VIN,ADD_TIME,UUID,TE_NUMBER,LOG_INFO,ORDER_NO,SOURCE_HEX ) values (" +
            "?, ?, ?, ?, ?, ?)";//1-6
    private static String baseTboxLogUpsertExpSql = "UPSERT INTO " + PhoenixConst.PHOENIX_CAR_TBOX_LOG_EXP + " (" +
            "VIN,ADD_TIME,UUID,TE_NUMBER,LOG_INFO,ORDER_NO,SOURCE_HEX ) values (" +
            "?, ?, ?, ?, ?, ?)";//1-6

    @Override
    public void insertBulid(TboxLog tboxLog, PreparedStatement preparedStatement) throws SQLException {

        //1-7  VIN,ADD_TIME,UUID,TE_NUMBER,LOG_INFO,ORDER_NO,SOURCE_HEX

        String vin = tboxLog.getVin();
        preparedStatement.setString(1, vin);
        Long addTime = tboxLog.getAddTime();
        preparedStatement.setLong(2, addTime);
        String uuid = tboxLog.getUuid();
        preparedStatement.setString(3, uuid);
        String teNumber = tboxLog.getTeNumber();
        preparedStatement.setString(4, teNumber);
        String logInfo = tboxLog.getLogInfo();
        preparedStatement.setString(5, logInfo);
        Long orderNo = tboxLog.getOrderNo();
        preparedStatement.setLong(6, orderNo);
        String sourceHex = tboxLog.getSourceHex();
        preparedStatement.setString(7, sourceHex);
        preparedStatement.addBatch();
    }

    @Override
    public void saveOrUpdate(List<TboxLog> records) {
        if (null == records || records.size() < 1) {
            return;
        }
        if (!StringUtils.isEmpty(records.get(0).getVin())) {
            baseImpl.saveOrUpdate(records, this,
                    baseTboxLogUpsertNorSql, PhoenixConst.PHOENIX_CAR_TBOX_LOG_NOR);
            logger.debug("Save nor TboxLog end." + records.size());
        } else {
            baseImpl.saveOrUpdate(records, this,
                    baseTboxLogUpsertExpSql, PhoenixConst.PHOENIX_CAR_TBOX_LOG_EXP);
            logger.debug("Save exp TboxLog end." + records.size());
        }

    }


}
