package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.CarCanHistoryInf;
import com.ccclubs.phoenix.input.CarCanHistoryParam;
import com.ccclubs.phoenix.orm.mapper.CarCanMapper;
import com.ccclubs.phoenix.orm.model.CarCan;
import com.ccclubs.phoenix.output.CarCanHistoryOutput;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class CarCanHistoryInfImpl implements CarCanHistoryInf {

    static Logger logger= LoggerFactory.getLogger(CarCanHistoryInfImpl.class);
    static final String insert_sql="upsert into " +
            "PHOENIX_CAR_CAN_HISTORY " +
            "(" +
            "CS_NUMBER," +
            "CURRENT_TIME," +
            "CAN_DATA," +
            "ADD_TIME " +
            " " +
            ") " +
            "values " +
            "(" +
            "?, " + //CS_NUMBER
            "?, " + //CURRENT_TIME
            "?, " + //CAN_DATA
            "? " + //ADD_TIME
            ")";

    static  final String count_sql = "select " +
            "count(cs_number) as total " +
            "from phoenix_car_can_history " +
            "where cs_number=? " +
            "and current_time>=? " +
            "and current_time<=? ";
    @Autowired
    private PhoenixTool phoenixTool;

    @Override
    public List<CarCan> queryCarCanListNoPage(final CarCanHistoryParam carCanHistoryParam) {
        final String queryFields = carCanHistoryParam.getQuery_fields();
        String query_sql = "select " +
                queryFields+" " +
                "from phoenix_car_can_history " +
                "where cs_number=? " +
                "and current_time>=? " +
                "and current_time<=? " +
                "order by current_time  "+carCanHistoryParam.getOrder()+" ";

        List<CarCan> carCanList = new ArrayList<CarCan>();
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query_sql);
            String cs_number = carCanHistoryParam.getCs_number();
            long start_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
            preparedStatement.setString(1,cs_number);
            preparedStatement.setLong(2,start_time);
            preparedStatement.setLong(3,end_time);
            ResultSet resultSet = preparedStatement.executeQuery();
            JSONArray jsonArray = phoenixTool.queryRecords(resultSet);
            CarCan carCan=null;
            for (Object object:jsonArray
                    ) {
                JSONObject jsonObject = (JSONObject)object;
                carCan=new CarCan();
                String[] fields = queryFields.split(",");
                for(String field:fields){
                    try{
                        BeanUtils.setProperty(carCan,field,jsonObject.get(StringUtils.upperCase(field)));
                    }
                    catch (Exception ex){
                        logger.error(ex.getMessage());
                    }
                }
                carCanList.add(carCan);
            }

        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }

            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }

        return carCanList;
    }

    @Override
    public List<CarCan> queryCarCanListWithPage(final CarCanHistoryParam carCanHistoryParam) {
        Integer page_size = carCanHistoryParam.getPage_size();
        Integer page_no = carCanHistoryParam.getPage_no();
        final Integer limit = page_size;
        final Integer offset = (page_no-1)*page_size;
        final String queryFields = carCanHistoryParam.getQuery_fields();
        String query_sql = "select " +
                queryFields+" " +
                "from phoenix_car_can_history " +
                "where cs_number=? " +
                "and current_time>=? " +
                "and current_time<=? " +
                "order by current_time  "+carCanHistoryParam.getOrder()+" "+
                "limit ? offset ? ";

        List<CarCan> carCanList = new ArrayList<CarCan>();
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query_sql);
            String cs_number = carCanHistoryParam.getCs_number();
            long start_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
            preparedStatement.setString(1,cs_number);
            preparedStatement.setLong(2,start_time);
            preparedStatement.setLong(3,end_time);
            preparedStatement.setInt(4,limit);
            preparedStatement.setInt(5,offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            JSONArray jsonArray = phoenixTool.queryRecords(resultSet);
            CarCan carCan=null;
            for (Object object:jsonArray
                    ) {
                JSONObject jsonObject = (JSONObject)object;
                carCan=new CarCan();
                String[] fields = queryFields.split(",");
                for(String field:fields){
                    try{
                        BeanUtils.setProperty(carCan,field,jsonObject.get(StringUtils.upperCase(field)));
                    }
                    catch (Exception ex){
                        logger.error(ex.getMessage());
                    }
                }
                carCanList.add(carCan);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }

            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return carCanList;
    }

    @Override
    public Long queryCarCanListCount(final CarCanHistoryParam carCanHistoryParam) {
        long total=0;

        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(count_sql);
            String cs_number = carCanHistoryParam.getCs_number();
            long start_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
            preparedStatement.setString(1,cs_number);
            preparedStatement.setLong(2,start_time);
            preparedStatement.setLong(3,end_time);
            ResultSet resultSet = preparedStatement.executeQuery();
            JSONArray jsonArray = phoenixTool.queryRecords(resultSet);
            if(jsonArray!=null&&jsonArray.size()>0){
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                total=jsonObject.getLong("TOTAL");
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }

            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }

        return total;
    }

    @Override
    public CarCanHistoryOutput queryCarCanListByOutput(final CarCanHistoryParam carCanHistoryParam) {
        CarCanHistoryOutput carCanHistoryOutput = new CarCanHistoryOutput();
        long total=-1L;
        //首先判断是否是分页查询
        if(carCanHistoryParam.getPage_no()>0){
            total = queryCarCanListCount(carCanHistoryParam);
            List<CarCan> carCanList = queryCarCanListWithPage(carCanHistoryParam);
            carCanHistoryOutput.setTotal(total);
            carCanHistoryOutput.setList(carCanList);
        }
        //非分页查询
        else{
            List<CarCan> carCanList = queryCarCanListNoPage(carCanHistoryParam);
            carCanHistoryOutput.setList(carCanList);
        }
        return carCanHistoryOutput;
    }

    @Override
    public void saveOrUpdate(final List<CarCan> records) {

        Connection connection = null;
        PreparedStatement carCanPs = null;
        try {
            connection = phoenixTool.getConnection();
            carCanPs = connection.prepareStatement(insert_sql);
            Long count =0L;
            for(CarCan carCan:records){
                count++;
                String cs_number = carCan.getCs_number();
                Long current_time = carCan.getCurrent_time();
                String can_data = carCan.getCan_data();
                Long add_time = carCan.getAdd_time();
                carCanPs.setString(1,cs_number);
                carCanPs.setLong(2,current_time);
                carCanPs.setString(3,can_data);
                carCanPs.setLong(4,add_time);
                carCanPs.addBatch();
                if(count%500==0){

                    carCanPs.executeBatch();
                    connection.commit();

                }
            }
            carCanPs.executeBatch();
            connection.commit();
        }
        catch (Exception e) {
            logger.info("car can phoenix throw a error"+e.getMessage());
            e.printStackTrace();
        }
        finally {
            if(carCanPs!=null){
                try {
                    carCanPs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
