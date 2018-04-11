package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.CarGbHistoryInf;
import com.ccclubs.phoenix.input.CarGbHistoryParam;
import com.ccclubs.phoenix.orm.model.CarGb;
import com.ccclubs.phoenix.output.CarGbHistoryOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
@Service(version="1.0.0")
public class CarGbHistoryInfImpl implements CarGbHistoryInf {

    static Logger logger= LoggerFactory.getLogger(CarGbHistoryInfImpl.class);

    /*static final String insert_sql="upsert into " +
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
            ")";*/

    static final String count_sql = "select " +
            "count(cs_vin) as total " +
            "from phoenix_car_gb_history " +
            "where cs_vin=? " +
            "and add_time>=? " +
            "and add_time<=? ";

    @Autowired
    private PhoenixTool phoenixTool;

//    @Autowired
//    private BaseInfImpl baseImpl;

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
        ResultSet resultSet=null;
        try {
            String cs_vin = carGbHistoryParam.getCs_vin();
            long start_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);

            preparedStatement = connection.prepareStatement(query_sql);
            preparedStatement.setString(1,cs_vin);
            preparedStatement.setLong(2,start_time);
            preparedStatement.setLong(3,end_time);
            resultSet = preparedStatement.executeQuery();
            JSONArray jsonArray = BaseQueryInfImpl.queryRecords(resultSet);
            BaseQueryInfImpl.parseJosnArrayToObjects(jsonArray,queryFields,carGbList,CarGb.class);

        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,resultSet,"CarGb queryCarGbListNoPage");
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
        ResultSet resultSet=null;
        try {
            String cs_vin = carGbHistoryParam.getCs_vin();
            long start_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);

            preparedStatement=connection.prepareStatement(query_sql);
            preparedStatement.setString(1,cs_vin);
            preparedStatement.setLong(2,start_time);
            preparedStatement.setLong(3,end_time);
            preparedStatement.setInt(4,limit);
            preparedStatement.setInt(5,offset);
            resultSet = preparedStatement.executeQuery();
            JSONArray jsonArray = BaseQueryInfImpl.queryRecords(resultSet);
            BaseQueryInfImpl.parseJosnArrayToObjects(jsonArray,queryFields,carGbList,CarGb.class);

        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,resultSet,"CarGb queryCarGbListWithPage");
        }
        return carGbList;
    }

    @Override
    public Long queryCarGbListCount(final CarGbHistoryParam carGbHistoryParam) {
        long total=0L;
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {
            String cs_vin = carGbHistoryParam.getCs_vin();
            long start_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);

            preparedStatement=connection.prepareStatement(count_sql);
            preparedStatement.setString(1,cs_vin);
            preparedStatement.setLong(2,start_time);
            preparedStatement.setLong(3,end_time);
            resultSet = preparedStatement.executeQuery();
            JSONArray jsonArray = BaseQueryInfImpl.queryRecords(resultSet);
            if(jsonArray!=null&&jsonArray.size()>0){
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                total=jsonObject.getLong("TOTAL");
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,resultSet,"CarGb queryCarGbListCount");
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

   /* @Override
    public void insertBulid(CarGb carGb,PreparedStatement preparedStatement) throws SQLException {
        String cs_vin = carGb.getCs_vin();
        Long add_time = carGb.getAdd_time();
        Long current_time = carGb.getCurrent_time();
        String gb_data = carGb.getGb_data();
        Integer cs_access = carGb.getCs_access();
        Integer cs_protocol = carGb.getCs_protocol();
        Integer gb_type = carGb.getGb_type();
        Integer cs_verify = carGb.getCs_verify();
        preparedStatement.setString(1,cs_vin);
        preparedStatement.setLong(2,add_time);
        //logger.info("国标赋值前判断。");
        if (current_time == null) {
            preparedStatement.setNull(3, Types.BIGINT);
        } else {
            preparedStatement.setLong(3, current_time);
        }
        preparedStatement.setString(4,gb_data);
        if (cs_access == null){
            preparedStatement.setNull(5,Types.INTEGER);
        }else {
            preparedStatement.setInt(5, cs_access);
        }
        if (cs_protocol == null){
            preparedStatement.setNull(6,Types.INTEGER);
        }else {
            preparedStatement.setInt(6, cs_protocol);
        }
        if (gb_type == null){
            preparedStatement.setNull(7,Types.INTEGER);
        }else {
            preparedStatement.setInt(7, gb_type);
        }
        if (cs_verify == null){
            preparedStatement.setNull(8,Types.INTEGER);
        }else {
            preparedStatement.setInt(8, cs_verify);
        }
        //logger.info("国标赋值完。");
        preparedStatement.addBatch();
    }

    @Override
    public void saveOrUpdate(final List<CarGb> records) {
        baseImpl.saveOrUpdate(records,this,insert_sql,"CarGb");
    }*/

}
