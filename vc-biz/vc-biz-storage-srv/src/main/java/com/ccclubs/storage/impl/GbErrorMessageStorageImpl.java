package com.ccclubs.storage.impl;

import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.frm.spring.gateway.ExpMessageDTO;
import com.ccclubs.storage.inf.BaseHistoryInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * GB错误报文存储
 *
 * @author jianghaiyang
 * @create 2018-05-17
 **/
@Service
public class GbErrorMessageStorageImpl implements BaseHistoryInf<ExpMessageDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GbErrorMessageStorageImpl.class);

    @Autowired
    private BaseInfImpl baseImpl;

    private static String baseGbErrorMessageUpsertSql = "UPSERT INTO " + PhoenixConst.PHOENIX_CAR_GB_ERROR_MESSAGE_HISTORY
            + " (CODE,VIN,ACCESS,MOBILE,TE_NO,TE_TYPE,TE_NUMBER,ICCID,SOURCE_HEX,ERR_INDEX,REASON,MSG_TIME) values (" +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";//1-12

    @Override
    public void insertBulid(ExpMessageDTO expMessageDTO, PreparedStatement preparedStatement) throws SQLException {

        preparedStatement.setString(1, expMessageDTO.getCode());
        preparedStatement.setString(2, expMessageDTO.getVin());
        Integer access = expMessageDTO.getAccess();
        if (null == access) {
            preparedStatement.setNull(3, Types.INTEGER);
        } else {
            preparedStatement.setInt(3, access);
        }
        preparedStatement.setString(4, expMessageDTO.getMobile());
        preparedStatement.setString(5, expMessageDTO.getTeNo());
        Byte teType = expMessageDTO.getTeType();
        if (null == teType) {
            preparedStatement.setNull(6, Types.TINYINT);
        } else {
            preparedStatement.setByte(6, teType);
        }
        preparedStatement.setString(7, expMessageDTO.getTeNumber());
        preparedStatement.setString(8, expMessageDTO.getIccid());
        preparedStatement.setString(9, expMessageDTO.getSourceHex());
        Integer index = expMessageDTO.getIndex();
        if (null == index) {
            preparedStatement.setNull(10, Types.INTEGER);
        } else {
            preparedStatement.setInt(10, index);
        }
        preparedStatement.setString(11, expMessageDTO.getReason());
        Long msgTime = expMessageDTO.getMsgTime();
        if (null == msgTime) {
            msgTime = System.currentTimeMillis();
        }
        preparedStatement.setLong(12, msgTime);

        preparedStatement.addBatch();
    }

    @Override
    public void saveOrUpdate(List<ExpMessageDTO> records) {
        if (null == records || records.size() < 1) {
            return;
        }
        baseImpl.saveOrUpdate(records, this,
                baseGbErrorMessageUpsertSql, PhoenixConst.PHOENIX_CAR_GB_ERROR_MESSAGE_HISTORY);
        LOGGER.debug("Save gb error end." + records.size());
    }

}
