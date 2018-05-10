package com.ccclubs.storage.impl;

import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.pub.orm.model.CsState;
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
 * @Description: 全新MqttState存储Phoenix实现类！
 */
@Service
public class MqttStateStorageImpl implements BaseHistoryInf<CsState> {

    static Logger logger = LoggerFactory.getLogger(MqttStateStorageImpl.class);
    @Autowired
    private BaseInfImpl baseImpl;

    private static String baseMqttStateUpsertSql = "UPSERT INTO ? " +
            "(VIN,CURRENT_TIME,TE_NUMBER,TE_NO,ICCID,MOBILE,ACCESS,ADD_TIME," +
            "RENT_FLG,WARN_CODE,RFID,USER_RFID,OBD_MILES,ENGINE_TEMPE,TOTAL_MILES," +
            "SPEED,MOTOR_SPEED,OIL_COST,POWER_RESERVE,EV_BATTERY,CHARGING_STATUS," +
            "FUEL_MILES,ELEC_MILES,ENDUR_MILES,TEMPE,GPS_NUM,GPS_STRENGTH,GPS_VALID," +
            "NET_STRENGTH,LONGITUDE,LATITUDE,DIRECTION_ANGLE,CIRCULAR_MODE,PTC_STATUS," +
            "COMPRE_STATUS,FAN_MODE,SAVING_MODE,DOOR_STATUS,ENGINE_STATUS,KEY_STATUS," +
            "LIGHT_STATUS,LOCK_STATUS,NET_TYPE,BASE_LAC,BASE_CI,CUR_ORDER,GEAR," +
            "AUTOPILOT_STATUS,HANDBRAKE_STATUS,SOURCE_HEX ) values ( " +
            "?, ?, ?, ?, ?, ?, ?, ?, " +//2-9
            "?, ?, ?, ?, ?, ?, ?, " +//10-16
            "?, ?, ?, ?, ?, ?, " +//17-22
            "?, ?, ?, ?, ?, ?, ?, " +//23-29
            "?, ?, ?, ?, ?, ?, " +//30-35
            "?, ?, ?, ?, ?, ?, " +//36-41
            "?, ?, ?, ?, ?, ?, ?, " +//42-48
            "?, ?, ? )";//49-51

    @Override
    public void insertBulid(CsState historyDate, PreparedStatement preparedStatement, String tableName) throws SQLException {

        preparedStatement.setString(1, tableName);

        //2-9  VIN,CURRENT_TIME,TE_NUMBER,TE_NO,ICCID,MOBILE,ACCESS,ADD_TIME
        String vin = historyDate.getCssVin();
        preparedStatement.setString(2, vin);
        Long currentTime = historyDate.getCssCurrentTime().getTime();
        preparedStatement.setLong(3, currentTime);
        String teNumber = historyDate.getCssNumber();
        preparedStatement.setString(4, teNumber);
        String teNo = historyDate.getCssTeNo();
        preparedStatement.setString(5, teNo);
        String icccid = historyDate.getIccid();
        preparedStatement.setString(6, icccid);
        String mobile = historyDate.getMobile();
        preparedStatement.setString(7, mobile);
        Integer access = null;
        if (null != historyDate.getCssAccess()) {
            access = Integer.valueOf(historyDate.getCssAccess());
        }
        if (null == access) {
            preparedStatement.setNull(8, Types.INTEGER);
        } else {
            preparedStatement.setInt(8, access);
        }
        Long addTime;
        if (null == historyDate.getCssAddTime()) {
            addTime = System.currentTimeMillis();
        } else {
            addTime = historyDate.getCssAddTime().getTime();
        }
        if (null == addTime) {
            preparedStatement.setNull(9, Types.BIGINT);
        } else {
            preparedStatement.setLong(9, addTime);
        }

        //10-16  RENT_FLG,WARN_CODE,RFID,USER_RFID,OBD_MILES,ENGINE_TEMPE,TOTAL_MILES
        Integer rentFlg = convertToInterger(historyDate.getCssRented());
        if (null == rentFlg) {
            preparedStatement.setNull(10, Types.INTEGER);
        } else {
            preparedStatement.setInt(10, rentFlg);
        }

        String warnCode = convertToString(historyDate.getCssWarn());
        preparedStatement.setString(11, warnCode);
        String rfid = historyDate.getCssRfid();
        preparedStatement.setString(12, rfid);
        String userRfid = historyDate.getCssRfidDte();
        preparedStatement.setString(13, userRfid);
        Float obdMiles;
        if (historyDate.getCssObdMile() == null) {
            obdMiles = 0F;
        } else {
            obdMiles = historyDate.getCssObdMile().floatValue();
        }
        if (null == obdMiles) {
            preparedStatement.setNull(14, Types.FLOAT);
        } else {
            preparedStatement.setFloat(14, obdMiles);
        }

        Float engineTempe = null;
        if (null != historyDate.getCssEngineT()) {
            engineTempe = historyDate.getCssEngineT().floatValue();
        }
        if (null == engineTempe) {
            preparedStatement.setNull(15, Types.FLOAT);
        } else {
            preparedStatement.setFloat(15, engineTempe);
        }

        Float totalMiles = null;
        if (null != historyDate.getCssMileage()) {
            totalMiles = historyDate.getCssMileage().floatValue();
        }
        if (null == totalMiles) {
            preparedStatement.setNull(16, Types.FLOAT);
        } else {
            preparedStatement.setFloat(16, totalMiles);
        }


        //17-22  SPEED,MOTOR_SPEED,OIL_COST,POWER_RESERVE,EV_BATTERY,CHARGING_STATUS
        Float speed = null;
        if (null != historyDate.getCssSpeed()) {
            speed = historyDate.getCssSpeed().floatValue();
        }
        if (null == speed) {
            preparedStatement.setNull(17, Types.FLOAT);
        } else {
            preparedStatement.setFloat(17, speed);
        }

        Float motorSpeed = convertToFloat(historyDate.getCssMotor());
        if (null == motorSpeed) {
            preparedStatement.setNull(18, Types.FLOAT);
        } else {
            preparedStatement.setFloat(18, motorSpeed);

        }

        Float oilCost = null;
        if (null != historyDate.getCssOil()) {
            oilCost = historyDate.getCssOil().floatValue();
        }
        if (null == oilCost) {
            preparedStatement.setNull(19, Types.FLOAT);
        } else {
            preparedStatement.setFloat(19, oilCost);
        }

        Float powerReserve = convertToFloat(historyDate.getCssPower());
        if (null == powerReserve) {
            preparedStatement.setNull(20, Types.FLOAT);
        } else {
            preparedStatement.setFloat(20, powerReserve);
        }


        Float evBattery = convertToFloat(historyDate.getCssEvBattery());
        if (null == evBattery) {
            preparedStatement.setNull(21, Types.FLOAT);
        } else {
            preparedStatement.setFloat(21, evBattery);
        }


        Integer chargingStatus = convertToInterger(historyDate.getCssCharging());
        if (null == chargingStatus) {
            preparedStatement.setNull(22, Types.INTEGER);
        } else {
            preparedStatement.setInt(22, chargingStatus);
        }


        //23-29  FUEL_MILES,ELEC_MILES,ENDUR_MILES,TEMPE,GPS_NUM,GPS_STRENGTH,GPS_VALID
        Float fuelMiles = null;
        if (null != historyDate.getCssFuelMileage()) {
            fuelMiles = historyDate.getCssFuelMileage().floatValue();
        }
        if (null == fuelMiles) {
            preparedStatement.setNull(23, Types.FLOAT);
        } else {
            preparedStatement.setFloat(23, fuelMiles);
        }


        Float elecMiles = null;
        if (null != historyDate.getCssElectricMileage()) {
            elecMiles = historyDate.getCssElectricMileage().floatValue();
        }
        if (null == elecMiles) {
            preparedStatement.setNull(24, Types.FLOAT);
        } else {
            preparedStatement.setFloat(24, elecMiles);
        }


        Float endurMiles = null;
        if (null != historyDate.getCssEndurance()) {
            endurMiles = historyDate.getCssEndurance().floatValue();
        }
        if (null == endurMiles) {
            preparedStatement.setNull(25, Types.FLOAT);
        } else {
            preparedStatement.setFloat(25, endurMiles);
        }

        Float tempe = null;
        if (null != historyDate.getCssTemperature()) {
            tempe = historyDate.getCssTemperature().floatValue();
        }
        if (null == tempe) {
            preparedStatement.setNull(26, Types.FLOAT);
        } else {
            preparedStatement.setFloat(26, tempe);
        }

        Integer gpsNum = convertToInterger(historyDate.getCssGpsCount());
        if (null == gpsNum) {
            preparedStatement.setNull(27, Types.INTEGER);
        } else {
            preparedStatement.setInt(27, gpsNum);
        }


        Integer gpsStrength = convertToInterger(historyDate.getCssGpsCn());
        if (null == gpsStrength) {
            preparedStatement.setNull(28, Types.INTEGER);
        } else {
            preparedStatement.setInt(28, gpsStrength);
        }

        Integer gpsValid = convertToInterger(historyDate.getCssGpsValid());
        if (null == gpsValid) {
            preparedStatement.setNull(29, Types.INTEGER);
        } else {
            preparedStatement.setInt(29, gpsValid);
        }


        //30-35  NET_STRENGTH,LONGITUDE,LATITUDE,DIRECTION_ANGLE,CIRCULAR_MODE,PTC_STATUS
        Integer netStrength = convertToInterger(historyDate.getCssCsq());
        if (null == netStrength) {
            preparedStatement.setNull(30, Types.INTEGER);
        } else {
            preparedStatement.setInt(30, netStrength);
        }

        Double longitude = null;
        if (null != historyDate.getCssLongitude()) {
            longitude = historyDate.getCssLongitude().doubleValue();
        }
        if (null == longitude) {
            preparedStatement.setNull(31, Types.DOUBLE);
        } else {
            preparedStatement.setDouble(31, longitude);
        }

        Double latitude = null;
        if (null != historyDate.getCssLatitude()) {
            latitude = historyDate.getCssLatitude().doubleValue();
        }
        if (null == latitude) {
            preparedStatement.setNull(32, Types.DOUBLE);
        } else {
            preparedStatement.setDouble(32, latitude);
        }

        Float directionAngle = null;
        if (null != historyDate.getCssDir()) {
            directionAngle = historyDate.getCssDir().floatValue();
        }
        if (null == directionAngle) {
            preparedStatement.setNull(33, Types.FLOAT);
        } else {
            preparedStatement.setFloat(33, directionAngle);
        }

        Integer circularMode = convertToInterger(historyDate.getCssCircular());
        if (null == circularMode) {
            preparedStatement.setNull(34, Types.INTEGER);
        } else {
            preparedStatement.setInt(34, circularMode);
        }

        Integer ptcStatus = convertToInterger(historyDate.getCssPtc());
        if (null == ptcStatus) {
            preparedStatement.setNull(35, Types.INTEGER);
        } else {
            preparedStatement.setInt(35, ptcStatus);
        }


        //36-41  COMPRE_STATUS,FAN_MODE,SAVING_MODE,DOOR_STATUS,ENGINE_STATUS,KEY_STATUS
        Integer compreStatus = convertToInterger(historyDate.getCssCompres());
        if (null == compreStatus) {
            preparedStatement.setNull(36, Types.INTEGER);
        } else {
            preparedStatement.setInt(36, compreStatus);
        }

        Integer fanMode = convertToInterger(historyDate.getCssFan());
        if (null == fanMode) {
            preparedStatement.setNull(37, Types.INTEGER);
        } else {
            preparedStatement.setInt(37, fanMode);
        }

        Integer savingMode = convertToInterger(historyDate.getCssSaving());
        if (null == savingMode) {
            preparedStatement.setNull(38, Types.INTEGER);
        } else {
            preparedStatement.setInt(38, savingMode);
        }

        Integer doorStatus = convertToInterger(historyDate.getCssDoor());
        if (null == doorStatus) {
            preparedStatement.setNull(39, Types.INTEGER);
        } else {
            preparedStatement.setInt(39, doorStatus);
        }

        Integer engineStatus = convertToInterger(historyDate.getCssEngine());
        if (null == engineStatus) {
            preparedStatement.setNull(40, Types.INTEGER);
        } else {
            preparedStatement.setInt(40, engineStatus);
        }


        Integer keyStatus = convertToInterger(historyDate.getCssKey());
        if (null == keyStatus) {
            preparedStatement.setNull(41, Types.INTEGER);
        } else {
            preparedStatement.setInt(41, keyStatus);
        }

        //42-48  LIGHT_STATUS,LOCK_STATUS,NET_TYPE,BASE_LAC,BASE_CI,CUR_ORDER,GEAR

        Integer lightStatus = historyDate.getCssLight();
        if (null == lightStatus) {
            preparedStatement.setNull(42, Types.INTEGER);
        } else {
            preparedStatement.setInt(42, lightStatus);
        }

        Integer lockStatus = historyDate.getCssLock();
        if (null == lockStatus) {
            preparedStatement.setNull(43, Types.INTEGER);
        } else {
            preparedStatement.setInt(43, lockStatus);
        }

        String netType = convertToString(historyDate.getCssNetType());
        preparedStatement.setString(44, netType);
        String baseLac = convertToString(historyDate.getCssBaseLac());
        preparedStatement.setString(45, baseLac);
        String baseCi = convertToString(historyDate.getCssBaseCi());
        preparedStatement.setString(46, baseCi);
        String curOrder = convertToString(historyDate.getCssOrder());
        preparedStatement.setString(47, curOrder);
        Integer gear = convertToInterger(historyDate.getCssGear());
        if (null == gear) {
            preparedStatement.setNull(48, Types.INTEGER);
        } else {
            preparedStatement.setInt(48, gear);
        }


        //49-51  AUTOPILOT_STATUS,HANDBRAKE_STATUS,SOURCE_HEX

        Integer autopilotStatus = historyDate.getCssAutopilot();
        if (null == autopilotStatus) {
            preparedStatement.setNull(49, Types.INTEGER);
        } else {
            preparedStatement.setInt(49, autopilotStatus);
        }

        Integer handbrakeStatus = historyDate.getCssHandbrake();
        if (null == handbrakeStatus) {
            preparedStatement.setNull(50, Types.INTEGER);
        } else {
            preparedStatement.setInt(50, handbrakeStatus);
        }

        String sourceHex = historyDate.getCssMoData();
        preparedStatement.setString(51, sourceHex);


        preparedStatement.addBatch();

    }

    @Override
    public void saveOrUpdate(List<CsState> records) {
        /**
         * 判断正常还是异常数据，然后区分SQL进行存储
         * */
        if (null == records || records.size() < 1) {
            return;
        }
        if (!StringUtils.isEmpty(records.get(0).getCssVin())) {
            baseImpl.saveOrUpdate(records, this,
                    baseMqttStateUpsertSql, PhoenixConst.PHOENIX_CAR_STATE_HISTORY_NOR);
        } else {
            baseImpl.saveOrUpdate(records, this,
                    baseMqttStateUpsertSql, PhoenixConst.PHOENIX_CAR_STATE_HISTORY_EXP);
        }

    }


}
