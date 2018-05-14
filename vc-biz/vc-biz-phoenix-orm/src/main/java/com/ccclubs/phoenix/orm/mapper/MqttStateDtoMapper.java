/*
package com.ccclubs.phoenix.orm.mapper;

import com.alibaba.fastjson.JSONObject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

*/
/**
 * Created with IntelliJ IDEA2017.
 *
 * @Author: Alban
 * @Date: 2018/5/14
 * @Time: 10:52
 * @Description: 请填写描述！
 *//*


public class MqttStateDtoMapper implements RowMapper<JSONObject> {
    @Override
    public JSONObject mapRow(ResultSet resultSet, int index) throws SQLException {
        ResultSetMetaData metaData=resultSet.getMetaData();
        JSONObject jsonObject = new JSONObject();
        for(int i=1;i<=metaData.getColumnCount();i++){
            String columnName = metaData.getColumnName(i);
            Object columnValue = resultSet.getObject(columnName);
            jsonObject.put(columnName,columnValue);
        }
        return jsonObject;
    }

}
*/
