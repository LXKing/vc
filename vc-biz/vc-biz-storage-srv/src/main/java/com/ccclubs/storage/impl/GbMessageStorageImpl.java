package com.ccclubs.storage.impl;

import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.pub.orm.dto.CsMessage;
import com.ccclubs.storage.inf.BaseHistoryInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import static com.ccclubs.storage.util.ConvertUtils.*;

/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/10
 * @Time: 16:55
 * @Description: 全新GBMessage协议存储Phoenix实现类！
 */

@Service
public class GbMessageStorageImpl implements BaseHistoryInf<CsMessage> {

    static Logger logger = LoggerFactory.getLogger(GbMessageStorageImpl.class);
    @Autowired
    private BaseInfImpl baseImpl;

    private static String baseGbMessageUpsertSql = "UPSERT INTO "+PhoenixConst.PHOENIX_CAR_GB_MESSAGE_HISTORY+" (" +
            "VIN,ADD_TIME,CURRENT_TIME,TE_NUMBER,TE_NO,ICCID,MOBILE,ACCESS," +
            "PROTOCOL,MESSAGE_TYPE,VERIFY,SOURCE_HEX ) values (" +
            "?, ?, ?, ?, ?, ?, ?, ?, " +//1-8
            "?, ?, ?, ? )";//9-12

    @Override
    public void insertBulid(CsMessage historyDate, PreparedStatement preparedStatement) throws SQLException {

        //1-8  VIN,ADD_TIME,CURRENT_TIME,TE_NUMBER,TE_NO,ICCID,MOBILE,ACCESS

        String vin = historyDate.getCsmVin();
        preparedStatement.setString(1, vin);
        Long addTime = historyDate.getCsmAddTime();
        if (null == addTime) {
            addTime = System.currentTimeMillis();
        }
        preparedStatement.setLong(2, addTime);
        Long currentTime = historyDate.getCsmMsgTime();
        if (null == currentTime) {
            preparedStatement.setNull(3, Types.BIGINT);
        } else {
            preparedStatement.setLong(3, currentTime);
        }
        String teNumber = historyDate.getCsmNumber();
        preparedStatement.setString(4, teNumber);
        String teNo = historyDate.getTeNo();
        preparedStatement.setString(5, teNo);
        String iccid = historyDate.getIccid();
        preparedStatement.setString(6, iccid);
        String mobile = historyDate.getMobile();
        preparedStatement.setString(7, mobile);
        Integer access = historyDate.getCsmAccess();
        if (null == access) {
            preparedStatement.setNull(8, Types.INTEGER);
        } else {
            preparedStatement.setInt(8, access);
        }

        //9-12  PROTOCOL,MESSAGE_TYPE,VERIFY,SOURCE_HEX
        Integer protocol = convertToInterger(historyDate.getCsmProtocol());
        if (null == protocol) {
            preparedStatement.setNull(9, Types.INTEGER);
        } else {
            preparedStatement.setInt(9, protocol);
        }
        Integer messageType = convertToInterger(historyDate.getCsmType());
        if (null == messageType) {
            preparedStatement.setNull(10, Types.INTEGER);
        } else {
            preparedStatement.setInt(10, messageType);
        }
        Integer verify = convertToInterger(historyDate.getCsmVerify());
        if (null == verify) {
            preparedStatement.setNull(11, Types.INTEGER);
        } else {
            preparedStatement.setInt(11, verify);
        }
        String sourceHex = historyDate.getCsmData();
        preparedStatement.setString(12, sourceHex);

        preparedStatement.addBatch();
    }


    @Override
    public void saveOrUpdate(List<CsMessage> records) {
        if (null == records || records.size() < 1) {
            return;
        }
        baseImpl.saveOrUpdate(records, this,
                baseGbMessageUpsertSql, PhoenixConst.PHOENIX_CAR_GB_MESSAGE_HISTORY);
        logger.debug("Save nor gb end."+records.size());
    }


}
