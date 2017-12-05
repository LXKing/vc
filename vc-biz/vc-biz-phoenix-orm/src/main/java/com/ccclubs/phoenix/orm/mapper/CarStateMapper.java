package com.ccclubs.phoenix.orm.mapper;

import com.alibaba.fastjson.JSONObject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　 ┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
public class CarStateMapper implements RowMapper<JSONObject> {

    @Override
    public JSONObject mapRow(ResultSet rs, int index) throws SQLException {
        ResultSetMetaData metaData=rs.getMetaData();
        JSONObject jsonObject = new JSONObject();
        for(int i=1;i<=metaData.getColumnCount();i++){
            String columnName = metaData.getColumnName(i);
            Object columnValue = rs.getObject(columnName);
            jsonObject.put(columnName,columnValue);
        }
        return jsonObject;
    }
}
