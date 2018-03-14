package com.ccclubs.phoenix.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.BaseHistoryInf;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA2017.
 * \* User: Alban
 * \* Date: 2018/3/13
 * \* Time: 14:23
 * \* Description:phoenix 代码复用模块，集成了大量冗余代码的通用版本。
 * \
 */
@Service
public class BaseInfImpl {

    private static Logger logger= LoggerFactory.getLogger(BaseInfImpl.class);

    @Autowired
    private PhoenixTool phoenixTool;
    /**
     * 将查询记录转化为 JSONArray
     * */
    public static JSONArray queryRecords(ResultSet rs){
        JSONArray jsonArray = new JSONArray();
        ResultSetMetaData metaData=null;
        try{
            JSONObject obj = null;
            metaData = rs.getMetaData();
            while(rs.next()){
                obj = new JSONObject();
                for(int i=1;i<=metaData.getColumnCount();i++){
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = rs.getObject(columnName);
                    obj.put(columnName,columnValue);
                }
                jsonArray.add(obj);
            }
        }
        catch (SQLException exception){
            logger.error(exception.getMessage());
            exception.printStackTrace();
        }
        finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return jsonArray;
    }


    /**
     * 将jsonarray转化为对应类的实例列表并由参数@resultList带出
     * @param clazz 要接受数据的类类型  此方法中的泛型即为与此参数相同的类型。
     * @param jsonArray {@link #queryRecords(ResultSet)}方法得到的json结果集
     * @param queryFields 需要转换的字段名
     * @param resultList 最后存储数据的结果列表
     * */
    public static <T> void parseJosnArrayToObjects(JSONArray jsonArray, String queryFields, List<T> resultList,Class<T> clazz){
        T tObject=null;
        for (Object object:jsonArray
                ) {
            JSONObject jsonObject = (JSONObject)object;
            try {
                tObject=clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }

            String[] fields = queryFields.split(",");
            for(String field:fields){
                try{
                    BeanUtils.setProperty(tObject,field,jsonObject.get(StringUtils.upperCase(field)));
                }
                catch (Exception ex){
                    logger.error(ex.getMessage());
                }
            }
            resultList.add(tObject);
        }
    }

    public <T> void saveOrUpdate(final List<T> records , BaseHistoryInf<T> baseHistoryInf,String insertSql,String className) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = phoenixTool.getConnection();
            preparedStatement = connection.prepareStatement(insertSql);
            Long count =0L;
            for(T historyDate:records){
                count++;
                baseHistoryInf.insertBulid(historyDate,preparedStatement);
                if(count%500==0){

                    preparedStatement.executeBatch();
                    connection.commit();

                }
            }
            preparedStatement.executeBatch();
            connection.commit();
        }
        catch (Exception e) {
            logger.info(className+" phoenix throw a error"+e.getMessage());
            e.printStackTrace();
        }
        finally {
            phoenixTool.closeResource(connection,preparedStatement,null,className+" saveOrUpdate ");
        }
    }
}
