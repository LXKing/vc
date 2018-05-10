package com.ccclubs.storage.impl;

import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.pub.orm.dto.Jt808PositionData;
import com.ccclubs.storage.inf.BaseHistoryInf;
import org.apache.commons.lang.StringUtils;
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
 * @Time: 16:59
 * @Description: 全新808协议存储Phoenix实现类！
 */
@Service
public class Jt808StorageImpl implements BaseHistoryInf<Jt808PositionData> {

    static Logger logger = LoggerFactory.getLogger(Jt808StorageImpl.class);
    @Autowired
    private BaseInfImpl baseImpl;

    private static String baseJt808UpsertSql = "UPSERT INTO ? (" +
            "TE_NUMBER,CURRENT_TIME,VIN,TE_NO,ICCID,ADD_TIME,MOBILE,ALARM_FLAG," +
            "STATUS,LONGITUDE,LATITUDE,ALTITUDE,GPS_SPEED,COURSE,NET_STRENGTH," +
            "GPS_VALID,SOURCE_HEX ) values (" +
            "?, ?, ?, ?, ?, ?, ?, ?, " +//2-9
            "?, ?, ?, ?, ?, ?, ?, " +//10-16
            "?, ? )";//17-18

    @Override
    public void insertBulid(Jt808PositionData historyDate, PreparedStatement preparedStatement, String tableName) throws SQLException {
        preparedStatement.setString(1, tableName);
        //2-9  TE_NUMBER,CURRENT_TIME,VIN,TE_NO,ICCID,ADD_TIME,MOBILE,ALARM_FLAG
        String teNumber = historyDate.getTeNumber();
        preparedStatement.setString(2, teNumber);
        Long currentTime = historyDate.getCurrentTime();
        preparedStatement.setLong(3, currentTime);
        String vin = historyDate.getVin();
        preparedStatement.setString(4, vin);
        String teNo = historyDate.getTeNo();
        preparedStatement.setString(5, teNo);
        String iccid = historyDate.getIccid();
        preparedStatement.setString(6, iccid);
        Long addTime = historyDate.getAddTime();
        if (addTime == null) {
            addTime = System.currentTimeMillis();
        }
        preparedStatement.setLong(7, addTime);
        String mobile = historyDate.getMobile();
        preparedStatement.setString(8, mobile);
        Integer alarmFlag = historyDate.getAlarmFlag();
        if (null == alarmFlag) {
            preparedStatement.setNull(9, Types.INTEGER);
        } else {
            preparedStatement.setInt(9, alarmFlag);
        }

        //10-16  STATUS,LONGITUDE,LATITUDE,ALTITUDE,GPS_SPEED,COURSE,NET_STRENGTH

        Integer status = historyDate.getStatus();
        if (null == status) {
            preparedStatement.setNull(10, Types.INTEGER);
        } else {
            preparedStatement.setInt(10, status);
        }
        Double longitude = null;
        if (null != historyDate.getLongitude()) {
            longitude = historyDate.getLongitude().doubleValue();
        }
        if (null == longitude) {
            preparedStatement.setNull(11, Types.DOUBLE);
        } else {
            preparedStatement.setDouble(11, longitude);
        }
        Double latitude = null;
        if (null != historyDate.getLatitude()) {
            latitude = historyDate.getLatitude().doubleValue();
        }
        if (null == latitude) {
            preparedStatement.setNull(12, Types.DOUBLE);
        } else {
            preparedStatement.setDouble(12, latitude);
        }
        Double altitude = null;
        if (null != historyDate.getAltitude()) {
            altitude = historyDate.getAltitude().doubleValue();
        }
        if (null == altitude) {
            preparedStatement.setNull(13, Types.DOUBLE);
        } else {
            preparedStatement.setDouble(13, altitude);
        }
        Float gpsSpeed = null;
        if (null != historyDate.getSpeed()) {
            gpsSpeed = historyDate.getSpeed().floatValue();
        }
        if (null == gpsSpeed) {
            preparedStatement.setNull(14, Types.FLOAT);
        } else {
            preparedStatement.setFloat(14, gpsSpeed);
        }
        Double course = null;
        if (null != historyDate.getCourse()) {
            course = historyDate.getCourse().doubleValue();
        }
        if (null == course) {
            preparedStatement.setNull(15, Types.DOUBLE);
        } else {
            preparedStatement.setDouble(15, course);
        }
        Integer netStrength = convertToInterger(historyDate.getNetStrength());
        if (null == netStrength) {
            preparedStatement.setNull(16, Types.INTEGER);
        } else {
            preparedStatement.setInt(16, netStrength);
        }

        //17-18  GPS_VALID,SOURCE_HEX
        Integer gpsValid = historyDate.getGpsValid();
        if (null == gpsValid) {
            preparedStatement.setNull(17, Types.INTEGER);
        } else {
            preparedStatement.setInt(17, gpsValid);
        }
        String sourceHex = historyDate.getSourceHex();
        preparedStatement.setString(18, sourceHex);
        preparedStatement.addBatch();
    }

    @Override
    public void saveOrUpdate(List<Jt808PositionData> records) {

        if (null == records || records.size() < 1) {
            return;
        }
        if (!StringUtils.isEmpty(records.get(0).getVin())) {
            baseImpl.saveOrUpdate(records, this,
                    baseJt808UpsertSql, PhoenixConst.PHOENIX_CAR_808_POSITION_HISTORY);
        } else {
            baseImpl.saveOrUpdate(records, this,
                    baseJt808UpsertSql, PhoenixConst.PHOENIX_CAR_808_POSITION_HISTORY_EXP);
        }

    }
}
