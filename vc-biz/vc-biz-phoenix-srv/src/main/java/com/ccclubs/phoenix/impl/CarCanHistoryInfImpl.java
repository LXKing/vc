package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixHelper;
import com.ccclubs.phoenix.inf.CarCanHistoryInf;
import com.ccclubs.phoenix.input.CarCanHistoryParam;
import com.ccclubs.phoenix.orm.mapper.CarCanMapper;
import com.ccclubs.phoenix.orm.model.CarCan;
import com.ccclubs.phoenix.output.CarCanHistoryOutput;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
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
    @Autowired
    private JdbcTemplate phoenixJdbcTemplate;

    @Autowired
    private PhoenixHelper phoenixHelper;

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
        List<JSONObject> jsonObjList = phoenixJdbcTemplate.query(query_sql,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        String cs_number = carCanHistoryParam.getCs_number();
                        long start_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
                        long end_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
                        ps.setString(1,cs_number);
                        ps.setLong(2,start_time);
                        ps.setLong(3,end_time);
                    }
                },
                new CarCanMapper());
        CarCan carCan = null;
        System.out.println("");
        for(JSONObject jsonObject:jsonObjList){
            carCan = new CarCan();
            String[] fields = queryFields.split(",");
            for(String field:fields){
                try{
                    BeanUtils.setProperty(carCan,field,jsonObject.get(StringUtils.upperCase(field)));
                }
                catch (Exception ex){

                }
            }
            carCanList.add(carCan);
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
        List<JSONObject> jsonObjList = phoenixJdbcTemplate.query(query_sql,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        String cs_number = carCanHistoryParam.getCs_number();
                        long start_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
                        long end_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
                        ps.setString(1,cs_number);
                        ps.setLong(2,start_time);
                        ps.setLong(3,end_time);
                        ps.setInt(4,limit);
                        ps.setInt(5,offset);
                        System.out.println();
                    }
                },
                new CarCanMapper());
        CarCan carCan = null;
        for(JSONObject jsonObject:jsonObjList){
            carCan = new CarCan();
            String[] fields = queryFields.split(",");
            for(String field:fields){
                try{
                    BeanUtils.setProperty(carCan,field,jsonObject.get(StringUtils.upperCase(field)));
                }
                catch (Exception ex){

                }
            }
            carCanList.add(carCan);
        }
        return carCanList;
    }

    @Override
    public Long queryCarCanListCount(final CarCanHistoryParam carCanHistoryParam) {
        long total=0;
        String count_sql = "select " +
                "count(cs_number) as total " +
                "from phoenix_car_can_history " +
                "where cs_number=? " +
                "and current_time>=? " +
                "and current_time<=? ";
        total=phoenixJdbcTemplate.execute(count_sql, new PreparedStatementCallback<Long>() {
            @Override
            public Long doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                String cs_number = carCanHistoryParam.getCs_number();
                long start_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
                long end_time = DateTimeUtil.date2UnixFormat(carCanHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
                ps.setString(1,cs_number);
                ps.setLong(2,start_time);
                ps.setLong(3,end_time);
                ResultSet rs = ps.executeQuery();
                long record_count=0;
                while(rs.next()){
                    record_count = rs.getLong(1);
                }
                return record_count;
            }
        });
        return total;
    }

    @Override
    public CarCanHistoryOutput queryCarCanListByOutput(final CarCanHistoryParam carCanHistoryParam) {
        CarCanHistoryOutput carCanHistoryOutput = new CarCanHistoryOutput();
        long total=-1L;
        //首先判断是否是分页查询
        if(carCanHistoryParam.getPage_no()>0){
//            //判断是否已获取过记录总数
//            total=carCanHistoryParam.getTotal();
//            //已经获取过记录总数
//            if(total>-1){
//                total = carCanHistoryParam.getTotal();
//            }
//            else{
//                total = queryCarCanListCount(carCanHistoryParam);
//            }
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
        String insert_sql="upsert into " +
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
        Connection connection = null;
        PreparedStatement carCanPs = null;
        try {
            connection = phoenixHelper.getConnection();
            carCanPs = connection.prepareStatement(insert_sql);
            Long count =0L;
            for(CarCan carCan:records){
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
                    long start_timemills = System.currentTimeMillis();
                    //System.out.println("我提交了"+count+"条!");
                    carCanPs.executeBatch();
                    connection.commit();
//                    long end_timemills = System.currentTimeMillis();
//                    long cost_timemills = end_timemills-start_timemills;
//                    System.out.println("插入耗时:"+cost_timemills+"毫秒");
                }
            }
            carCanPs.executeBatch();
            connection.commit();
        }
        catch (Exception e) {
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
