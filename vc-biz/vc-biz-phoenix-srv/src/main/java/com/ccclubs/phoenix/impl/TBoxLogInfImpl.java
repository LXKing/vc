package com.ccclubs.phoenix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.constant.PhoenixConst;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.hbase.phoenix.config.PhoenixTool;
import com.ccclubs.phoenix.inf.TBoxLogInf;
import com.ccclubs.phoenix.input.TBoxLogParam;
import com.ccclubs.phoenix.orm.dto.TBoxLogDto;
import com.ccclubs.phoenix.output.TBoxLogOutput;
import com.ccclubs.phoenix.util.BaseTransformTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: GFA
 * @Project: vc
 * @Package: com.ccclubs.phoenix.impl
 * @Date: 2018/08/20  15:47
 * @Description:
 */
@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class TBoxLogInfImpl implements TBoxLogInf {

    static  final Logger logger= LoggerFactory.getLogger(TBoxLogInfImpl.class);

    @Autowired
    private PhoenixTool phoenixTool;

    @Override
    public List<TBoxLogDto> queryTBoxDtoList(TBoxLogParam param, Boolean isBound) {

        //根据绑定关系选择对应查询表
        String tableName = PhoenixConst.PHOENIX_CAR_TBOX_LOG_NOR;
        if(!isBound) {
            tableName = PhoenixConst.PHOENIX_CAR_TBOX_LOG_EXP;
        }

        String pageSql = "";
        if (param.getPageNum() > 0) {
            pageSql = "limit ? offset ? ";
        }

        //初始化查询语句
        String querySql = "";
        //只根据绑定关系来确定查询语句
        //默认为存在绑定关系，根据VIN码查询
        querySql = "select " + param.getQueryFields() + " from " + tableName +
                " where VIN=? and add_time>=? and add_time<=? order by add_time  "
                + param.getOrder() + " " + pageSql;
        //如果不存在绑定关系，就根据车机号查询
        if(!isBound) {
            querySql = "select " + param.getQueryFields() + " from " + tableName +
                    " where TE_NUMBER=? and add_time>=? and add_time<=? order by add_time  "
                    + param.getOrder() + " " + pageSql;
        }

        //格式化开始和结束时间
        long startTime = DateTimeUtil.date2UnixFormat(param.getStartTime(), DateTimeUtil.UNIX_FORMAT);
        long endTime = DateTimeUtil.date2UnixFormat(param.getEndTime(), DateTimeUtil.UNIX_FORMAT);

        List<TBoxLogDto> tBoxLogDtoList = new ArrayList<TBoxLogDto>();
        Connection connection = phoenixTool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {
            preparedStatement = connection.prepareStatement(querySql);
            if (isBound) {
                preparedStatement.setString(1, param.getVin());
            } else {
                preparedStatement.setString(1, param.getTeNumber());
            }
            preparedStatement.setLong(2, startTime);
            preparedStatement.setLong(3, endTime);

            //设置分页信息
            if (!StringUtils.isEmpty(pageSql)){
                Integer limit = param.getPageSize();
                Integer offset = (param.getPageNum() - 1) * limit;
                preparedStatement.setInt(4, limit);
                preparedStatement.setInt(5, offset);
            }

            resultSet = preparedStatement.executeQuery();
            tBoxLogDtoList= BaseTransformTool.resultSetToObjectList(
                    resultSet,TBoxLogDto.class);

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    preparedStatement,resultSet,"queryTBoxDtoList");
        }

        return tBoxLogDtoList;
    }

    @Override
    public Long queryListCount(TBoxLogParam param, Boolean isBound) {

        //根据绑定关系选择对应查询表
        String tableName = PhoenixConst.PHOENIX_CAR_TBOX_LOG_NOR;
        if(!isBound) {
            tableName = PhoenixConst.PHOENIX_CAR_TBOX_LOG_EXP;
        }

        //初始化计算语句
        String countSql = "";
        //根据绑定关系来确定查询语句
        //默认为存在绑定关系，根据VIN码来查询总数
        countSql = "select count(add_time) as total from "
                + tableName + " where VIN=? and add_time>=? and add_time<=? ";
        //如果不存在绑定关系，就根据车机号来查询总数
        if(!isBound) {
            countSql = "select count(add_time) as total from "
                    + tableName + " where TE_NUMBER=? and add_time>=? and add_time<=? ";
        }

        //参数初始化
        long total = 0L;
        PreparedStatement pst = null;
        long startTime = DateTimeUtil.date2UnixFormat(param.getStartTime(), DateTimeUtil.UNIX_FORMAT);
        long endTime = DateTimeUtil.date2UnixFormat(param.getEndTime(), DateTimeUtil.UNIX_FORMAT);
        Connection connection= phoenixTool.getConnection();
        ResultSet resultSet =null;

        try {
            pst = connection.prepareStatement(countSql);
            if(isBound) {
                pst.setString(1, param.getVin());
            } else {
                pst.setString(1, param.getTeNumber());
            }
            pst.setLong(2, startTime);
            pst.setLong(3, endTime);
            resultSet = pst.executeQuery();
            JSONArray jsonArray = BaseTransformTool.queryRecords(resultSet);
            if(jsonArray!=null&&jsonArray.size()>0){
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                total=jsonObject.getLong("TOTAL");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            phoenixTool.closeResource(connection,
                    pst,resultSet,"queryListCount");
        }
        return total;
    }

    @Override
    public TBoxLogOutput queryListByParam(TBoxLogParam param, Boolean isBound) {

        TBoxLogOutput gbMessageHistoryOutput=new TBoxLogOutput();
        gbMessageHistoryOutput.setList(queryTBoxDtoList(param, isBound));
        gbMessageHistoryOutput.setTotal(queryListCount(param, isBound));
        return gbMessageHistoryOutput;
    }
}
