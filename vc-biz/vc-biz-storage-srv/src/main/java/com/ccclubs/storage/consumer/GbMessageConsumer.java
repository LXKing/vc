package com.ccclubs.storage.consumer;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.pub.orm.dto.CsMessage;
import com.ccclubs.storage.impl.GbMessageStorageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_CONSUMER_GROUP_STORAGE_GB_MESSAGE;
import static com.ccclubs.frm.spring.constant.KafkaConst.KAFKA_TOPIC_GB_MESSAGE;

/**
 * GB实时报文存入HBase
 *
 * @author jianghaiyang
 * @create 2018-04-20
 **/
@Component
public class GbMessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(GbMessageConsumer.class);

    @Autowired
    GbMessageStorageImpl gbMessageStorage;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_GB_MESSAGE + "}", topics = "${" + KAFKA_TOPIC_GB_MESSAGE + "}", containerFactory = "batchFactory")
    public void processNor(List<String> messageList) {
        List<CsMessage> csMessageList = new ArrayList<>();
        for (String message : messageList) {
            CsMessage csMessage = JSONObject.parseObject(message, CsMessage.class);
            if (csMessage == null) {
                continue;
            }
            csMessageList.add(csMessage);
        }
        try {
            gbMessageStorage.saveOrUpdate(csMessageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    /*private static final String SQL = "UPSERT INTO PHOENIX_CAR_GB_HISTORY " +
            "(CS_VIN,ADD_TIME,CURRENT_TIME,GB_DATA,CS_ACCESS,CS_PROTOCOL," +
            "GB_TYPE,CS_VERIFY ) VALUES (" +
            "?, " + //CS_VIN
            "?, " + //ADD_TIME
            "?, " + //CURRENT_TIME
            "?, " + //GB_DATA
            "?, " + //CS_ACCESS
            "?, " + //CS_PROTOCOL
            "?, " + //GB_TYPE
            "? " + //CS_VERIFY
            ")";

    @Autowired
    private PhoenixProperties phoenixProperties;

    @KafkaListener(id = "${" + KAFKA_CONSUMER_GROUP_STORAGE_GB_MESSAGE + "}", topics = "${" + KAFKA_TOPIC_GB_MESSAGE + "}", containerFactory = "batchFactory")
    public void process(List<String> records) {
        logger.debug("Fetch Size:{}", records.size());
        logger.debug("CsMessageConsumer start process records of CsMessage. StartTime:{}", System.currentTimeMillis());
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            connection = DriverManager.getConnection("jdbc:phoenix:" + phoenixProperties.getZk_url());
            preparedStatement = connection.prepareStatement(SQL);
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
            return;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            return;
        }
        try {
            for (String record : records) {
                CsMessage csMessage;
                try {
                    csMessage = JSONObject.parseObject(record, CsMessage.class);
                } catch (Exception e) {
                    continue;
                }
                // 构造SQL
                setPreparedStatement(preparedStatement, csMessage);
                // 执行，暂不提交
                preparedStatement.execute();
            }
            // 提交
            connection.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeAll(connection, preparedStatement);
            logger.debug("CsMessageConsumer end process records of CsMessage. EndTime:{}", System.currentTimeMillis());
        }

    }

    private void setPreparedStatement(PreparedStatement preparedStatement, CsMessage csMessage) throws SQLException {
        preparedStatement.setString(1, csMessage.getCsmVin());
        preparedStatement.setLong(2, null == csMessage.getCsmAddTime() ? System.currentTimeMillis() : csMessage.getCsmAddTime());
        if (csMessage.getCsmMsgTime() == null) {
            preparedStatement.setNull(3, Types.BIGINT);
        } else {
            preparedStatement.setLong(3, csMessage.getCsmMsgTime());
        }
        preparedStatement.setString(4, csMessage.getCsmData());
        if (csMessage.getCsmAccess() == null) {
            preparedStatement.setNull(5, Types.INTEGER);
        } else {
            preparedStatement.setInt(5, csMessage.getCsmAccess());
        }
        if (convertToInterger(csMessage.getCsmProtocol()) == null) {
            preparedStatement.setNull(6, Types.INTEGER);
        } else {
            preparedStatement.setInt(6, convertToInterger(csMessage.getCsmProtocol()));
        }
        if (convertToInterger(csMessage.getCsmType()) == null) {
            preparedStatement.setNull(7, Types.INTEGER);
        } else {
            preparedStatement.setInt(7, convertToInterger(csMessage.getCsmType()));
        }
        if (convertToInterger(csMessage.getCsmType()) == null) {
            preparedStatement.setNull(8, Types.INTEGER);
        } else {
            preparedStatement.setInt(8, convertToInterger(csMessage.getCsmType()));
        }
    }

    static Integer convertToInterger(Short param) {
        Integer result = null;
        try {
            result = param.intValue();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public void closeAll(Connection connection,
                         PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }*/
}
