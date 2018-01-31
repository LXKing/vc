package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.CarGbHistoryInf;
import com.ccclubs.phoenix.input.CarGbHistoryParam;
import com.ccclubs.phoenix.orm.mapper.CarGbMapper;
import com.ccclubs.phoenix.orm.model.CarGb;
import com.ccclubs.phoenix.output.CarGbHistoryOutput;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
@Service(version="1.0.0")
public class CarGbHistoryInfImpl implements CarGbHistoryInf {

    static Logger logger= LoggerFactory.getLogger(CarGbHistoryInfImpl.class);

    static final String insert_sql="upsert into " +
            "PHOENIX_CAR_GB_HISTORY " +
            "(" +
            "CS_VIN," +
            "ADD_TIME," +
            "CURRENT_TIME," +
            "GB_DATA," +
            "CS_ACCESS," +
            "CS_PROTOCOL," +
            "GB_TYPE," +
            "CS_VERIFY" +
            " " +
            ") " +
            "values " +
            "(" +
            "?, " + //CS_VIN
            "?, " + //ADD_TIME
            "?, " + //CURRENT_TIME
            "?, " + //GB_DATA
            "?, " + //CS_ACCESS
            "?, " + //CS_PROTOCOL
            "?, " + //GB_TYPE
            "? " + //CS_VERIFY
            ")";

    static final String count_sql = "select " +
            "count(cs_vin) as total " +
            "from phoenix_car_gb_history " +
            "where cs_vin=? " +
            "and add_time>=? " +
            "and add_time<=? ";

    @Autowired
    private PhoenixTool phoenixTool;

    @Override
    public List<CarGb> queryCarGbListNoPage(final CarGbHistoryParam carGbHistoryParam) {
        final String queryFields = carGbHistoryParam.getQuery_fields();
        String query_sql = "select " +
                queryFields+" " +
                "from phoenix_car_gb_history " +
                "where cs_vin=? " +
                "and add_time>=? " +
                "and add_time<=? " +
                "order by add_time  "+carGbHistoryParam.getOrder()+" ";

        List<CarGb> carGbList = new ArrayList<CarGb>();
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query_sql);
            String cs_vin = carGbHistoryParam.getCs_vin();
            long start_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
            preparedStatement.setString(1,cs_vin);
            preparedStatement.setLong(2,start_time);
            preparedStatement.setLong(3,end_time);
            ResultSet resultSet = preparedStatement.executeQuery();
            JSONArray jsonArray = phoenixTool.queryRecords(resultSet);
            CarGb carGb=null;
            for (Object object:jsonArray
                 ) {
                JSONObject jsonObject = (JSONObject)object;
                carGb=new CarGb();
                String[] fields = queryFields.split(",");
                for(String field:fields){
                    try{
                        BeanUtils.setProperty(carGb,field,jsonObject.get(StringUtils.upperCase(field)));
                    }
                    catch (Exception ex){
                        logger.error(ex.getMessage());
                    }
                }
                carGbList.add(carGb);
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
        return carGbList;
    }

    @Override
    public List<CarGb> queryCarGbListWithPage(final CarGbHistoryParam carGbHistoryParam) {
        Integer page_size = carGbHistoryParam.getPage_size();
        Integer page_no = carGbHistoryParam.getPage_no();
        final Integer limit = page_size;
        final Integer offset = (page_no-1)*page_size;
        final String queryFields = carGbHistoryParam.getQuery_fields();
        String query_sql = "select " +
                queryFields+" " +
                "from phoenix_car_gb_history " +
                "where cs_vin=? " +
                "and add_time>=? " +
                "and add_time<=? " +
                "order by add_time  "+carGbHistoryParam.getOrder()+" "+
                "limit ? offset ? ";

        List<CarGb> carGbList = new ArrayList<CarGb>();
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement=connection.prepareStatement(query_sql);
            String cs_vin = carGbHistoryParam.getCs_vin();
            long start_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
            preparedStatement.setString(1,cs_vin);
            preparedStatement.setLong(2,start_time);
            preparedStatement.setLong(3,end_time);
            preparedStatement.setInt(4,limit);
            preparedStatement.setInt(5,offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            JSONArray jsonArray = phoenixTool.queryRecords(resultSet);
            CarGb carGb=null;
            for (Object object:jsonArray
                    ) {
                JSONObject jsonObject = (JSONObject)object;
                carGb=new CarGb();
                String[] fields = queryFields.split(",");
                for(String field:fields){
                    try{
                        BeanUtils.setProperty(carGb,field,jsonObject.get(StringUtils.upperCase(field)));
                    }
                    catch (Exception ex){
                        logger.error(ex.getMessage());
                    }
                }
                carGbList.add(carGb);
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
        return carGbList;
    }

    @Override
    public Long queryCarGbListCount(final CarGbHistoryParam carGbHistoryParam) {
        long total=0L;
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement=connection.prepareStatement(count_sql);
            String cs_vin = carGbHistoryParam.getCs_vin();
            long start_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
            preparedStatement.setString(1,cs_vin);
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
    public CarGbHistoryOutput queryCarGbListByOutput(final CarGbHistoryParam carGbHistoryParam) {
        CarGbHistoryOutput carGbHistoryOutput = new CarGbHistoryOutput();
        long total=-1L;
        //首先判断是否是分页查询
        if(carGbHistoryParam.getPage_no()>0){

            total = queryCarGbListCount(carGbHistoryParam);
            List<CarGb> carGbList = queryCarGbListWithPage(carGbHistoryParam);
            carGbHistoryOutput.setTotal(total);
            carGbHistoryOutput.setList(carGbList);

        }
        //非分页查询
        else{
            List<CarGb> carGbList = queryCarGbListNoPage(carGbHistoryParam);
            carGbHistoryOutput.setList(carGbList);
        }
        return carGbHistoryOutput;
    }

    @Override
    public void saveOrUpdate(final List<CarGb> records) {
        //logger.info("执行了国标saveOrUpdate.");

        Connection connection = null;
        PreparedStatement carGbPs = null;

        try {
            connection = phoenixTool.getConnection();
            carGbPs = connection.prepareStatement(insert_sql);
            Long count =0L;
            //logger.info("国标赋值for循环外部。");
            for(CarGb carGb:records){
                count++;
                String cs_vin = carGb.getCs_vin();
                Long add_time = carGb.getAdd_time();
                Long current_time = carGb.getCurrent_time();
                String gb_data = carGb.getGb_data();
                Integer cs_access = carGb.getCs_access();
                Integer cs_protocol = carGb.getCs_protocol();
                Integer gb_type = carGb.getGb_type();
                Integer cs_verify = carGb.getCs_verify();
                carGbPs.setString(1,cs_vin);
                carGbPs.setLong(2,add_time);
                //logger.info("国标赋值前判断。");
                if (current_time == null) {
                    carGbPs.setNull(3, Types.BIGINT);
                } else {
                    carGbPs.setLong(3, current_time);
                }
                carGbPs.setString(4,gb_data);
                if (cs_access == null){
                    carGbPs.setNull(5,Types.INTEGER);
                }else {
                    carGbPs.setInt(5, cs_access);
                }
                if (cs_protocol == null){
                    carGbPs.setNull(6,Types.INTEGER);
                }else {
                    carGbPs.setInt(6, cs_protocol);
                }
                if (gb_type == null){
                    carGbPs.setNull(7,Types.INTEGER);
                }else {
                    carGbPs.setInt(7, gb_type);
                }
                if (cs_verify == null){
                    carGbPs.setNull(8,Types.INTEGER);
                }else {
                    carGbPs.setInt(8, cs_verify);
                }
                //logger.info("国标赋值完。");
                carGbPs.addBatch();
                if(count%500==0){
                    logger.info("执行了一次国标存储（executeBatch）。count size："+count);
                    carGbPs.executeBatch();
                    connection.commit();

                }
            }
            carGbPs.executeBatch();
            connection.commit();
            //logger.info("执行了一次国标存储（executeBatch）。");
        }
        catch (Exception e) {
            logger.info("国标赋值出现了异常。");
            e.printStackTrace();
        }
        finally {
            if(carGbPs!=null){
                try {
                    carGbPs.close();
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
