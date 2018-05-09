package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.CarStateHistoryInf;
import com.ccclubs.phoenix.input.CarStateHistoryParam;
import com.ccclubs.phoenix.input.CarStateHistoryUpdateParam;
import com.ccclubs.phoenix.input.StateHistoryParam;
import com.ccclubs.phoenix.orm.consts.PhoenixConsts;
import com.ccclubs.phoenix.orm.consts.VehicleConsts;
import com.ccclubs.phoenix.orm.model.*;
import com.ccclubs.phoenix.output.CarStateHistoryOutput;
import com.ccclubs.phoenix.output.HistoryNoQueryOutput;
import com.ccclubs.phoenix.output.StateHistoryOutput;
import com.ccclubs.phoenix.util.VehicleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class CarStateHistoryInfImpl implements CarStateHistoryInf {

    static  final Logger logger= LoggerFactory.getLogger(CarStateHistoryInfImpl.class);



    private static final String count_sql = "select " +
            "count(cs_number) as total " +
            "from phoenix_car_state_history " +
            "where cs_number=? " +
            "and current_time>=? " +
            "and current_time<=? ";

    private static final String UPDATE_SQL = "UPSERT INTO "
            + PhoenixConsts.PHOENIX_CAR_STATE_HISTORY+
            " ( CS_NUMBER, CURRENT_TIME , OBD_MILES ) VALUES ( ?, ?, ? )";


    @Autowired
    private PhoenixTool phoenixTool;


    @Override
    public StateHistoryOutput queryCarStateListWithLimit(final StateHistoryParam stateHistoryParam) {
        final String queryFields = stateHistoryParam.getQueryFields();
        String querySqlDesc = "select " +
                queryFields + " " +
                "from "+PhoenixConsts.PHOENIX_CAR_STATE_HISTORY+" " +
                "where cs_number=? " +
                "and current_time<=? " +
                "order by current_time desc limit ? ";
        String querySqlAsc = "select " +
                queryFields + " " +
                "from "+PhoenixConsts.PHOENIX_CAR_STATE_HISTORY+" " +
                "where cs_number=? " +
                "and current_time>? " +
                "order by current_time asc limit ? ";

        List<CarState> carStateDescList = new ArrayList<CarState>();
        List<CarState> carStateAscList = new ArrayList<CarState>();
        String csNumber = stateHistoryParam.getTeNumber();
        long startTime = DateTimeUtil.date2UnixFormat(stateHistoryParam.getTimePoint(), DateTimeUtil.UNIX_FORMAT);
        int limit=stateHistoryParam.getLimit();
        Connection connectionDesc = phoenixTool.getConnection();
        Connection connectionAsc = phoenixTool.getConnection();
        PreparedStatement preparedStatementDesc = null;
        PreparedStatement preparedStatementAsc = null;
        ResultSet resultSetDesc=null;
        ResultSet resultSetAsc=null;
        try {

            preparedStatementDesc = connectionDesc.prepareStatement(querySqlDesc);
            preparedStatementAsc = connectionAsc.prepareStatement(querySqlAsc);


            preparedStatementDesc.setString(1, csNumber);
            preparedStatementDesc.setLong(2, startTime);
            preparedStatementDesc.setInt(3,limit);
            resultSetDesc = preparedStatementDesc.executeQuery();
            JSONArray jsonArrayDesc = BaseQueryInfImpl.queryRecords(resultSetDesc);
            BaseQueryInfImpl.parseJosnArrayToObjects(jsonArrayDesc,queryFields,carStateDescList,CarState.class);

            preparedStatementAsc.setString(1, csNumber);
            preparedStatementAsc.setLong(2, startTime);
            preparedStatementAsc.setInt(3,limit);
            resultSetAsc = preparedStatementAsc.executeQuery();
            JSONArray jsonArrayAsc = BaseQueryInfImpl.queryRecords(resultSetAsc);
            BaseQueryInfImpl.parseJosnArrayToObjects(jsonArrayAsc,queryFields,carStateAscList,CarState.class);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connectionAsc,
                    preparedStatementAsc,resultSetAsc,"carState queryCarStateListNoPage");
            phoenixTool.closeResource(connectionDesc,
                    preparedStatementDesc,resultSetDesc,"carState queryCarStateListNoPage");
        }
        StateHistoryOutput stateHistoryOutput=new StateHistoryOutput();
        List<VehicleState> beforeList=new ArrayList<>();
        List<VehicleState> afterList=new ArrayList<>();
        for (CarState carState:carStateAscList
             ) {
            afterList.add(TransforCarStateToVehicleState.transforCarStateToVehicleState(carState));
        }
        for (CarState carState:carStateDescList
                ) {
            beforeList.add(TransforCarStateToVehicleState.transforCarStateToVehicleState(carState));
        }
        stateHistoryOutput.setAfterList(afterList);
        stateHistoryOutput.setBeforeList(beforeList);
        return stateHistoryOutput;
    }

    @Override
    public List<CarState> queryCarStateListNoPage(final CarStateHistoryParam carStateHistoryParam) {
        final String queryFields = carStateHistoryParam.getQuery_fields();
        String query_sql = "select " +
                queryFields + " " +
                "from phoenix_car_state_history " +
                "where cs_number=? " +
                "and current_time>=? " +
                "and current_time<=? " +
                "order by current_time  " + carStateHistoryParam.getOrder() + " ";

        List<CarState> carStateList = new ArrayList<CarState>();

        Connection connection = phoenixTool.getConnection();
        PreparedStatement pst = null;
        ResultSet resultSet=null;
        try {
            String cs_number = carStateHistoryParam.getCs_number();
            long start_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getStart_time(), DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getEnd_time(), DateTimeUtil.UNIX_FORMAT);

            pst = connection.prepareStatement(query_sql);
            pst.setString(1, cs_number);
            pst.setLong(2, start_time);
            pst.setLong(3, end_time);
            resultSet = pst.executeQuery();
            JSONArray jsonArray = BaseQueryInfImpl.queryRecords(resultSet);
            BaseQueryInfImpl.parseJosnArrayToObjects(jsonArray,queryFields,carStateList,CarState.class);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    pst,resultSet,"carState queryCarStateListNoPage");
        }
        return carStateList;


    }

    @Override
    public List<CarState> queryCarStateListWithPage(final CarStateHistoryParam carStateHistoryParam) {
        Integer page_size = carStateHistoryParam.getPage_size();
        Integer page_no = carStateHistoryParam.getPage_no();
        final Integer limit = page_size;
        final Integer offset = (page_no - 1) * page_size;
        final String queryFields = carStateHistoryParam.getQuery_fields();
        String query_sql = "select " +
                queryFields + " " +
                "from phoenix_car_state_history " +
                "where cs_number=? " +
                "and current_time>=? " +
                "and current_time<=? " +
                "order by current_time  " + carStateHistoryParam.getOrder() + " " +
                "limit ? offset ? ";
        List<CarState> carStateList = new ArrayList<CarState>();
        Connection connection = phoenixTool.getConnection();
        PreparedStatement pst = null;
        ResultSet resultSet=null;
        try {
            String cs_number = carStateHistoryParam.getCs_number();
            long start_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getStart_time(), DateTimeUtil.UNIX_FORMAT);
            long end_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getEnd_time(), DateTimeUtil.UNIX_FORMAT);

            pst = connection.prepareStatement(query_sql);
            pst.setString(1, cs_number);
            pst.setLong(2, start_time);
            pst.setLong(3, end_time);
            pst.setInt(4, limit);
            pst.setInt(5, offset);
            resultSet= pst.executeQuery();
            JSONArray jsonArray = BaseQueryInfImpl.queryRecords(resultSet);
            BaseQueryInfImpl.parseJosnArrayToObjects(jsonArray,queryFields,carStateList,CarState.class);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,pst,resultSet,"carState queryCarStateListWithPage");
        }
        return carStateList;
    }

    @Override
    public Long queryCarStateListCount(final CarStateHistoryParam carStateHistoryParam) {
        long total = 0L;
        Connection connection = null;
        PreparedStatement pst = null;
        String cs_number = carStateHistoryParam.getCs_number();
        long start_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getStart_time(), DateTimeUtil.UNIX_FORMAT);
        long end_time = DateTimeUtil.date2UnixFormat(carStateHistoryParam.getEnd_time(), DateTimeUtil.UNIX_FORMAT);
        connection= phoenixTool.getConnection();
        ResultSet resultSet =null;
        try {
            pst = connection.prepareStatement(count_sql);
            pst.setString(1, cs_number);
            pst.setLong(2, start_time);
            pst.setLong(3, end_time);
            resultSet = pst.executeQuery();
            JSONArray jsonArray = BaseQueryInfImpl.queryRecords(resultSet);
            if(jsonArray!=null&&jsonArray.size()>0){
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                total=jsonObject.getLong("TOTAL");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    pst,resultSet,"carState queryCarStateListCount");
        }
        return total;
    }

    @Override
    public CarStateHistoryOutput queryCarStateListByOutput(CarStateHistoryParam carStateHistoryParam) {
        CarStateHistoryOutput carStateHistoryOutput = new CarStateHistoryOutput();
        long total = -1L;
        //首先判断是否是分页查询
        if (carStateHistoryParam.getPage_no() > 0) {
            total = queryCarStateListCount(carStateHistoryParam);
            List<CarState> carStateList = queryCarStateListWithPage(carStateHistoryParam);
            carStateHistoryOutput.setTotal(total);
            carStateHistoryOutput.setList(carStateList);
        }
        //非分页查询
        else {
            List<CarState> carStateList = queryCarStateListNoPage(carStateHistoryParam);
            carStateHistoryOutput.setList(carStateList);
        }
        return carStateHistoryOutput;
    }

    @Override
    public HistoryNoQueryOutput updateCarStateObdMiles(CarStateHistoryUpdateParam param) {
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        HistoryNoQueryOutput historyNoQueryOutput =new HistoryNoQueryOutput();
        try{
            long timePointLong= param.getTimePoint();
            preparedStatement = connection.prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1 , param.getUpdateKey());
            preparedStatement.setLong(2 , timePointLong);
            preparedStatement.setFloat(3,param.getObdMiles());
            preparedStatement.execute();
            connection.commit();
            historyNoQueryOutput.setSuccessCount(preparedStatement.getUpdateCount());
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,null,UPDATE_SQL);
        }
        return historyNoQueryOutput;
    }

    @Override
    public HistoryNoQueryOutput updateCarStateObdMiles(List<CarStateHistoryUpdateParam> paramList) {
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        HistoryNoQueryOutput historyNoQueryOutput =new HistoryNoQueryOutput();
        try{
            Integer count=0;
            preparedStatement = connection.prepareStatement(UPDATE_SQL);
            for (CarStateHistoryUpdateParam param:paramList){
                count++;
                long timePointLong= param.getTimePoint();
                preparedStatement.setString(1 , param.getUpdateKey());
                preparedStatement.setLong(2 , timePointLong);
                preparedStatement.setFloat(3,param.getObdMiles());
                preparedStatement.addBatch();
                if (count%500==0){
                    preparedStatement.executeBatch();
                    connection.commit();
                }
            }
            preparedStatement.executeBatch();
            connection.commit();
            //historyNoQueryOutput.setSuccessCount(preparedStatement.getUpdateCount());
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,null,UPDATE_SQL);
        }
        return historyNoQueryOutput;
    }

    @Override
    //驾驶阶段数据计算
    public List<Pace> calDrivePaceList(List<CarState> carStateList){
        List<Pace> paceList = null;
        Iterator<CarState> carStateIterator = carStateList.iterator();
        PaceService paceService = new PaceService();
        PaceBlock paceBlock = null;
        while (carStateIterator.hasNext()){
            CarState carState = carStateIterator.next();
            long current_time = carState.getCurrent_time();
            long fix_current_time = DateTimeUtil.getTimeMillsFixByInterval(current_time, VehicleConsts.DRIVE_MINUTES_INTERVAL);
            if(paceBlock==null){
                paceBlock=new PaceBlock();
                long block_start_timemills = fix_current_time;
                long block_end_timemills = fix_current_time+VehicleConsts.DRIVE_MINUTES_INTERVAL*60*1000;
                paceBlock.setCs_number(carState.getCs_number());
                paceBlock.setBlock_start_timemills(block_start_timemills);
                paceBlock.setBlock_end_timemills(block_end_timemills);
                List<CarState> recordList = paceBlock.getRecordList();
                recordList.add(carState);
            }
            else{
                long block_start_timemills = paceBlock.getBlock_start_timemills();
                long block_end_timemills = paceBlock.getBlock_end_timemills();
                if(current_time>=block_start_timemills&&current_time<block_end_timemills){
                    List<CarState> recordList = paceBlock.getRecordList();
                    recordList.add(carState);
                }
                else{
                    paceBlock = VehicleUtil.configPaceBlock(paceBlock,VehicleConsts.CAL_PACE_TYPE_DRIVE);
                    if(paceBlock!=null) {
                        paceService.addDrivePaceBlock(paceBlock);
                    }
                    paceBlock=new PaceBlock();
                    block_start_timemills = fix_current_time;
                    block_end_timemills = fix_current_time+VehicleConsts.DRIVE_MINUTES_INTERVAL*60*1000;
                    paceBlock.setCs_number(carState.getCs_number());
                    paceBlock.setBlock_start_timemills(block_start_timemills);
                    paceBlock.setBlock_end_timemills(block_end_timemills);
                    List<CarState> recordList = paceBlock.getRecordList();
                    recordList.add(carState);
                }
            }
        }
        if(paceBlock!=null){
            paceBlock=VehicleUtil.configPaceBlock(paceBlock,VehicleConsts.CAL_PACE_TYPE_DRIVE);
            paceService.addDrivePaceBlock(paceBlock);

        }
        paceList= paceService.getPaceList();
        return paceList;
    }

    @Override
    //充电阶段数据计算
    public List<Pace> calChargingPaceList(List<CarState> carStateList){
        List<Pace> paceList = null;
        Iterator<CarState> carStateIterator = carStateList.iterator();
        PaceService paceService = new PaceService();
        PaceBlock paceBlock = null;
        while (carStateIterator.hasNext()){
            CarState carState = carStateIterator.next();
            long current_time = carState.getCurrent_time();
            long fix_current_time = DateTimeUtil.getTimeMillsFixByInterval(current_time, VehicleConsts.CHARGING_MINUTES_INTERVAL);
            if(paceBlock==null){
                paceBlock=new PaceBlock();
                long block_start_timemills = fix_current_time;
                long block_end_timemills = fix_current_time+VehicleConsts.CHARGING_MINUTES_INTERVAL*60*1000;
                paceBlock.setCs_number(carState.getCs_number());
                paceBlock.setBlock_start_timemills(block_start_timemills);
                paceBlock.setBlock_end_timemills(block_end_timemills);
                List<CarState> recordList = paceBlock.getRecordList();
                recordList.add(carState);
            }
            else if(paceBlock!=null){
                long block_start_timemills = paceBlock.getBlock_start_timemills();
                long block_end_timemills = paceBlock.getBlock_end_timemills();
                if(current_time>=block_start_timemills&&current_time<block_end_timemills){
                    List<CarState> recordList = paceBlock.getRecordList();
                    recordList.add(carState);
                }
                else{
                    paceBlock = VehicleUtil.configPaceBlock(paceBlock,VehicleConsts.CAL_PACE_TYPE_CHARGING);
                    if(paceBlock!=null) {
                        paceService.addChargingPaceBlock(paceBlock);
                    }
                    paceBlock=new PaceBlock();
                    block_start_timemills = fix_current_time;
                    block_end_timemills = fix_current_time+VehicleConsts.CHARGING_MINUTES_INTERVAL*60*1000;
                    paceBlock.setCs_number(carState.getCs_number());
                    paceBlock.setBlock_start_timemills(block_start_timemills);
                    paceBlock.setBlock_end_timemills(block_end_timemills);
                    List<CarState> recordList = paceBlock.getRecordList();
                    recordList.add(carState);
                }
            }
        }
        if(paceBlock!=null){
            paceBlock= VehicleUtil.configPaceBlock(paceBlock, VehicleConsts.CAL_PACE_TYPE_CHARGING);
            paceService.addChargingPaceBlock(paceBlock);

        }
        paceList= paceService.getPaceList();
        return paceList;
    }



}
