package com.ccclubs.influxdb.Service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.influxdb.inf.CarGbHistoryInf;
import com.ccclubs.influxdb.input.CarGbHistoryParam;
import com.ccclubs.influxdb.model.CarGb;
import com.ccclubs.influxdb.version.InfluxdbServiceVersion;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.influxdb.InfluxDBTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/30 0030.
 */

@Service(version= InfluxdbServiceVersion.V1)
public class CarGbHistoryService  implements  CarGbHistoryInf{
    Logger logger= LoggerFactory.getLogger(CarGbHistoryService.class);

    @Autowired
    private InfluxDBTemplate<Point> influxDBTemplate;

    private InfluxDBResultMapper resultMapper = new InfluxDBResultMapper() ;
    //
    public void insert( List<CarGb> recordList) {
        int i = 0;
        List<Point> pointList=new ArrayList<>();
        for (CarGb carGb : recordList) {
            Point point = Point.measurement("INFLUXDB_CAR_GB_HISTORY")
                    .time(DateTimeUtil.date2UnixFormat(carGb.getCurrent_time(),"yyyy-MM-dd HH:mm:ss"), TimeUnit.MILLISECONDS)  //报文上传时间
                    .tag("cs_vin",carGb.getCs_vin())
                    .addField("add_time",carGb.getAdd_time())
                    .addField("gb_data",carGb.getGb_data())
                    .addField("cs_access",carGb.getCs_access())
                    .addField("cs_protocol",carGb.getCs_protocol())
                    .addField("gb_type", carGb.getGb_type())
                    .addField("cs_verify",carGb.getCs_verify())
                    .build();
            //将单条数据存储到集合中
            pointList.add(point);
            i++;
            //每读取6千条数据提交到influxdb存储一次
            if (i / 6000== 1) {
                i = 0;
                logger.info("influxdb 6千条CarGb数据开始批量插入");
                influxDBTemplate.write(pointList);
                pointList.clear();
            }
        }
        logger.info("influxdb 不到6千条CarGb数据开始批量插入");
        influxDBTemplate.write(pointList);
    }
    @Override
    public List<CarGb> selectCarGbListByCondition(CarGbHistoryParam carGbHistoryParam) {
        String sql = "select  cs_vin, add_time,  gb_data, cs_access, cs_protocol, gb_type, cs_verify ,time from  INFLUXDB_CAR_GB_HISTORY  ";
        StringBuffer sb=new StringBuffer();
        if (carGbHistoryParam!=null) {
            if(carGbHistoryParam.getCs_vin()!=null) {
                sb.append("where  cs_vin=" + "\'"+carGbHistoryParam.getCs_vin()+"\'");
            }
            //
            if (carGbHistoryParam.getStart_time()!=null&&carGbHistoryParam.getEnd_time()!=null){
                if(sb.length()>1){
                    sb.append(" and time >= "+ DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000+ " and  time<="+DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000);
                }else{
                    sb.append("where time >= "+ DateTimeUtil.date2UnixFormat(carGbHistoryParam.getStart_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000+ " and  time<="+DateTimeUtil.date2UnixFormat(carGbHistoryParam.getEnd_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000);
                }
            }
            sb.append(" order by time "+carGbHistoryParam.getOrder());
            //
            if(carGbHistoryParam.getPage_no()!=null&&carGbHistoryParam.getPage_size()!=null){
                int startPage=carGbHistoryParam.getPage_no()+1;
                int endPage=startPage*carGbHistoryParam.getPage_size()+carGbHistoryParam.getPage_size();
                sb.append(" limit ").append(endPage).append(" offset ").append(startPage);
            }
            //
            sql=sql+sb.toString();
        }
        Query query = new Query(sql, influxDBTemplate.getDatabase());
        //
        logger.info("influxdb 查询CarGb数据");
        QueryResult result = influxDBTemplate.query(query);
        List<CarGb> carGbList = resultMapper.toPOJO(result, CarGb.class);
        return carGbList;
    }



}
