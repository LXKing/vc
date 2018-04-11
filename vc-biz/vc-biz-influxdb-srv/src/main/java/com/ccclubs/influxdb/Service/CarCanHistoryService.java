package com.ccclubs.influxdb.Service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.influxdb.inf.CarCanHistoryInf;
import com.ccclubs.influxdb.input.CarCanHistoryParam;
import com.ccclubs.influxdb.model.CarCan;
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
public class CarCanHistoryService implements CarCanHistoryInf{
    Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private InfluxDBTemplate<Point> influxDBTemplate;

    private InfluxDBResultMapper resultMapper = new InfluxDBResultMapper() ;
//

    public void insert( List<CarCan> recordList) {
        int i = 0;
        List<Point> pointList=new ArrayList<>();
        for (CarCan carCan : recordList) {
            Point point = Point.measurement("INFLUXDB_CAR_CAN_HISTORY")
                    .time(DateTimeUtil.date2UnixFormat(carCan.getCurrent_time(),"yyyy-MM-dd HH:mm:ss")  , TimeUnit.MILLISECONDS)
                    .tag("cs_number", carCan.getCs_number())
                    .addField("can_data", carCan.getCan_data())
                    .addField("add_time", carCan.getAdd_time())
                    .build();
            //将单条数据存储到集合中
            pointList.add(point);
            i++;
            //每读取6千条数据提交到influxdb存储一次
            if (i / 6000== 1) {
                i = 0;
                logger.info("influxdb 6千条CarCan数据开始批量插入");
                influxDBTemplate.write(pointList);
                pointList.clear();
            }
        }
        logger.info("influxdb 不到6千条CarCan数据开始批量插入");
        influxDBTemplate.write(pointList);
    }


    public List<CarCan> selectCarCanListByCondition(CarCanHistoryParam carCanHistoryParam) {
        String sql = "select  cs_number,can_data,add_time,time  from  INFLUXDB_CAR_CAN_HISTORY  ";
        StringBuffer sb=null;
        if (carCanHistoryParam!=null) {
            sb=new StringBuffer();
            if(carCanHistoryParam.getCs_number()!=null) {
                sb.append("where cs_number=" +"\'"+carCanHistoryParam.getCs_number()+"\'");
            }
            if (carCanHistoryParam.getStart_time()!=null&&carCanHistoryParam.getEnd_time()!=null){
                if(sb.length()>1){
                    sb.append(" and time >= "+DateTimeUtil.date2UnixFormat(carCanHistoryParam.getStart_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000+ " and  time<="+DateTimeUtil.date2UnixFormat( carCanHistoryParam.getEnd_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000);
                }else{
                    sb.append(" where time >= "+DateTimeUtil.date2UnixFormat(carCanHistoryParam.getStart_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000+ " and  time<="+DateTimeUtil.date2UnixFormat( carCanHistoryParam.getEnd_time(),"yyyy-MM-dd HH:mm:ss")*1000*1000);
                }
            }
            sb.append(" order by time "+carCanHistoryParam.getOrder());
            //
            if(carCanHistoryParam.getPage_no()!=null&&carCanHistoryParam.getPage_size()!=null){
                int startPage=carCanHistoryParam.getPage_no()+1;
                int endPage=startPage*carCanHistoryParam.getPage_size()+carCanHistoryParam.getPage_size();
                sb.append(" limit ").append(endPage).append(" offset ").append(startPage);
            }
            //
            sql=sql+sb.toString();
        }
        List<CarCan> carCanList=null;
        Query query = new Query(sql, influxDBTemplate.getDatabase());
        //
        logger.info("influxdb 查询CarCan数据");
        QueryResult result = influxDBTemplate.query(query);
        carCanList = resultMapper.toPOJO(result, CarCan.class);
        return carCanList;
    }


}
