package com.ccclubs.frm.influxdb;

import com.ccclubs.frm.spring.entity.DateTimeUtil;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.influxdb.InfluxDBTemplate;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by kevin on 16/11/21.
 * * Edited by alban on 18/3/15
 * description: 用于执行influxdb的通用存储基方法类。
 */

public class InfluxBoneDao<T> implements Serializable {

    private static Logger logger= LoggerFactory.getLogger(InfluxBoneDao.class);
    //@Value(value="${spring.influx.url}")
    //private static String url;
    protected static InfluxDB influxDB = null;
    static
    {
        influxDB = InfluxDBFactory.connect("http://120.27.192.237:8086", "admin", "ahdd34534e");
        // Flush every 200 Points, at least every 100ms

//        Pong pong = influxDB.ping();
    }
    /*@Autowired
    private InfluxDBTemplate<Point> influxDBTemplate;*/

    protected String dbName = "mydb";
    protected String retentionPolicy = "autogen";

    public void save(List<Point> points, String tagName, String  tagValue) {
            //针对不同的表的多次写入,可以用一次写入来提高效率
            BatchPoints batchPoints = BatchPoints
                    .database(dbName)
                    .tag(tagName,tagValue)
                    .retentionPolicy(retentionPolicy)
                    .consistency(InfluxDB.ConsistencyLevel.ALL)
                    .build();
            for (Point point:points) {
                batchPoints.point(point);
            }
            influxDB.write(batchPoints);

    }

    /*
    @List<T> 实体列表
    * 传入的实体中字段必须有缺省值,否则对应列不会写入到数据库
    * */
    public void save(List<T> points) throws TableNotDefinedExcetion{

        //针对不同的表的多次写入,可以用一次写入来提高效率
            BatchPoints batchPoints = BatchPoints
                    .database(dbName)
                    .retentionPolicy(retentionPolicy)
                    .consistency(InfluxDB.ConsistencyLevel.ALL)
                    .build();
            for (T t : points)
            {

                if (t.getClass().isAnnotationPresent(InfluxTable.class)) {
                    InfluxTable table = (InfluxTable) t.getClass().getAnnotation(InfluxTable.class);
                    String name = table.name();
                    Point point = convertToPoint(name, t);
                    batchPoints.point(point);
                } else {
                    throw new TableNotDefinedExcetion("table is not defined in annotation yet");
                }
            }
            influxDB.write(batchPoints);
    }

    public void save(T entity) throws TableNotDefinedExcetion{
            if(entity.getClass().isAnnotationPresent(InfluxTable.class)) {
                InfluxTable table = entity.getClass().getAnnotation(InfluxTable.class);
                String name = table.name();
                Point point = convertToPoint(name, entity);

                influxDB.write(dbName,retentionPolicy,point);
                //influxDB.disableBatch();
            }
            else
            {
                throw new TableNotDefinedExcetion("table is not defined in annotation yet");
            }
    }

    private Field getMatchField(Field[] fields,String fieldName) {
        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(fieldName)) {
                return field;
            }
        }
        return null;
    }

    private Point convertToPoint(String table, T target)
    {
        Point.Builder builder = Point.measurement(table);
        Boolean haveInfluxTimeAnnotation=false;

        Class actualEditable = target.getClass();
        Field[] fields = actualEditable.getDeclaredFields();
        Method[] methods = actualEditable.getMethods();
        Field[] superFields = target.getClass().getSuperclass().getDeclaredFields();

        for(Method method:methods){

            String methodName = method.getName();
            if(!methodName.contains("get")) {
                continue;
            }
            String fieldName = methodName.substring(3,methodName.length());
            Object value = null;
            try {
                    value = method.invoke(target,new Object[]{});
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
            }


            if(null == value) {
                continue;
            }
            Field field = getMatchField(fields,fieldName);
            if (null == field) {
                field = getMatchField(superFields, fieldName);
            }
            if(field != null)
             {

                    String columnName = insertBar(field.getName());
                 Boolean present = field.isAnnotationPresent(InfluxTag.class);
                 Boolean isTime=field.isAnnotationPresent(InfluxTime.class);
                 switch (field.getType().getName()) {
                        case "java.lang.String":
                            if (present&&!isTime) {
                                builder.tag(columnName, (String) value);
                            } else if (!present&&isTime){
                                builder.time(DateTimeUtil.
                                                date2UnixFormat((String) value,DateTimeUtil.UNIX_FORMAT),
                                        TimeUnit.MILLISECONDS);
                                haveInfluxTimeAnnotation=true;
                            }else {
                                builder.addField(columnName, (String) value);
                            }
                            break;
                        case "java.lang.Integer":
                            if (present) {
                                builder.tag(columnName, (String) value);
                            } else {
                                builder.addField(columnName, (Integer) value);
                            }
                            break;
                        case "java.lang.Long":
                            if (present&&!isTime) {
                                builder.tag(columnName, (String) value);
                            } else if (!present&&isTime){
                                builder.time((Long) value,
                                        TimeUnit.MILLISECONDS);
                                haveInfluxTimeAnnotation=true;
                            }else {
                                builder.addField(columnName, (Long) value);
                            }
                            break;
                        case "java.lang.Double":
                            if (present) {
                                builder.tag(columnName, (String) value);
                            } else {
                                builder.addField(columnName, (Double) value);
                            }
                            break;
                        case "java.lang.Float":
                            if (present) {
                                builder.tag(columnName, (String) value);
                            } else {
                                builder.addField(columnName, (Float) value);
                            }
                            break;
                        case "java.lang.Number":
                            if (present) {
                                builder.tag(columnName, (String) value);
                            } else {
                                builder.addField(columnName, (Number) value);
                            }
                            break;
                        case "java.lang.Boolean":
                            if (present) {
                                builder.tag(columnName, (String) value);
                            } else {
                                builder.addField(columnName, (Boolean) value);
                            }
                            break;
                        default:
                            logger.info("can't find type to convert to point:" + field.getName() + ":" + field.getType());
                    }

            }
                //long number double string boolean
        }
        if (!haveInfluxTimeAnnotation){
            builder.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
        return builder.build();
    }

    /**
     * 将下划线分隔的命名的字段名变换为驼峰命名的字段名
     * */
    public String insertBar(String column)
    {
        char arr[] = column.toCharArray();
        StringBuffer buf = new StringBuffer();
        boolean first = true;
        for(char ch:arr)
        {
            if(Character.isUpperCase(ch))
            {
                buf.append('_');
                buf.append(Character.toLowerCase(ch));
            }
            else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }

    /**
     * 将驼峰命名的字段名变换为下划线分隔的命名的字段名
     * */
    public String trimBar(String column) {
        String arr[] = column.split("_");
        StringBuffer buf = new StringBuffer();
        boolean first = true;
        for (String subColumn : arr) {
            if (first) {
                first = false;
                buf.append(subColumn);
            } else {
                buf.append(subColumn.replaceFirst(subColumn.substring(0, 1), subColumn.substring(0, 1).toUpperCase()));
            }
        }
        return buf.toString();
    }
}