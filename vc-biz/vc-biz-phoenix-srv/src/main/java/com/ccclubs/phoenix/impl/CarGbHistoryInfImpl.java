package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixHelper;
import com.ccclubs.phoenix.inf.CarGbHistoryInf;
import com.ccclubs.phoenix.input.CarGbHistoryParam;
import com.ccclubs.phoenix.orm.mapper.CarGbMapper;
import com.ccclubs.phoenix.orm.model.CarGb;
import com.ccclubs.phoenix.output.CarGbHistoryOutput;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service(version="1.0.0")
public class CarGbHistoryInfImpl implements CarGbHistoryInf {
    @Autowired
    private JdbcTemplate phoenixJdbcTemplate;

    @Autowired
    private PhoenixHelper phoenixHelper;

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
        List<JSONObject> jsonObjList = phoenixJdbcTemplate.query(query_sql,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        String cs_vin = carGbHistoryParam.getCs_vin();
                        long start_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
                        long end_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
                        ps.setString(1,cs_vin);
                        ps.setLong(2,start_time);
                        ps.setLong(3,end_time);
                    }
                },
                new CarGbMapper());
        CarGb carGb = null;
        System.out.println("");
        for(JSONObject jsonObject:jsonObjList){
            carGb = new CarGb();
            String[] fields = queryFields.split(",");
            for(String field:fields){
                try{
                    BeanUtils.setProperty(carGb,field,jsonObject.get(StringUtils.upperCase(field)));
                }
                catch (Exception ex){

                }
            }
            carGbList.add(carGb);
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
        List<JSONObject> jsonObjList = phoenixJdbcTemplate.query(query_sql,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        String cs_vin = carGbHistoryParam.getCs_vin();
                        long start_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
                        long end_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
                        ps.setString(1,cs_vin);
                        ps.setLong(2,start_time);
                        ps.setLong(3,end_time);
                        ps.setInt(4,limit);
                        ps.setInt(5,offset);
                        System.out.println();
                    }
                },
                new CarGbMapper());
        CarGb carGb = null;
        for(JSONObject jsonObject:jsonObjList){
            carGb = new CarGb();
            String[] fields = queryFields.split(",");
            for(String field:fields){
                try{
                    BeanUtils.setProperty(carGb,field,jsonObject.get(StringUtils.upperCase(field)));
                }
                catch (Exception ex){

                }
            }
            carGbList.add(carGb);
        }
        return carGbList;
    }

    @Override
    public Long queryCarGbListCount(final CarGbHistoryParam carGbHistoryParam) {
        long total=0;
        String count_sql = "select " +
                "count(cs_vin) as total " +
                "from phoenix_car_gb_history " +
                "where cs_vin=? " +
                "and add_time>=? " +
                "and add_time<=? ";
        total=phoenixJdbcTemplate.execute(count_sql, new PreparedStatementCallback<Long>() {
            @Override
            public Long doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                String cs_vin = carGbHistoryParam.getCs_vin();
                long start_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),DateTimeUtil.UNIX_FORMAT);
                long end_time = DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),DateTimeUtil.UNIX_FORMAT);
                ps.setString(1,cs_vin);
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
    public CarGbHistoryOutput queryCarGbListByOutput(final CarGbHistoryParam carGbHistoryParam) {
        CarGbHistoryOutput carGbHistoryOutput = new CarGbHistoryOutput();
        long total=-1L;
        //首先判断是否是分页查询
        if(carGbHistoryParam.getPage_no()>0){
//            //判断是否已获取过记录总数
//            total=carGbHistoryParam.getTotal();
//            //已经获取过记录总数
//            if(total>-1){
//                total = carGbHistoryParam.getTotal();
//            }
//            else{
//                total = queryCarGbListCount(carGbHistoryParam);
//            }
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
        String insert_sql="upsert into " +
                "PHOENIX_CAR_GB_HISTORY " +
                "(" +
                "CS_VIN," +
                "ADD_TIME," +
                "YEAR," +
                "MONTH," +
                "DAY," +
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
                "?, " + //YEAR
                "?, " + //MONTH
                "?, " + //DAY
                "?, " + //CURRENT_TIME
                "?, " + //GB_DATA
                "?, " + //CS_ACCESS
                "?, " + //CS_PROTOCOL
                "?, " + //GB_TYPE
                "? " + //CS_VERIFY
                ")";
        Connection connection = null;
        PreparedStatement carGbPs = null;

        try {
            connection = phoenixHelper.getConnection();
            carGbPs = connection.prepareStatement(insert_sql);
            Long count =0L;
            for(CarGb carGb:records){
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
                carGbPs.addBatch();
                if(count%500==0){
                    long start_timemills = System.currentTimeMillis();
                    //System.out.println("我提交了"+count+"条!");
                    carGbPs.executeBatch();
                    connection.commit();
//                    long end_timemills = System.currentTimeMillis();
//                    long cost_timemills = end_timemills-start_timemills;
//                    System.out.println("插入耗时:"+cost_timemills+"毫秒");
                }
            }
            carGbPs.executeBatch();
            connection.commit();
        }
        catch (Exception e) {
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
