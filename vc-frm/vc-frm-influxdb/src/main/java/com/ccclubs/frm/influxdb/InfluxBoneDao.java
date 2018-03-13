package com.ccclubs.frm.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by kevin on 16/11/21.
 */

public class InfluxBoneDao<T> implements Serializable {
    protected static InfluxDB influxDB = null;
    @Value(value="${spring.influx.url}")
    private static String url;

    static
    {
//        influxDB = InfluxDBFactory.connect("http://192.168.102.211:8086", "root", "root");
//        influxDB = InfluxDBFactory.connect("http://192.168.102.245:8086", "root", "root");
        influxDB = InfluxDBFactory.connect("http://192.168.102.243:8086", "root", "root");
        // Flush every 200 Points, at least every 100ms

//        Pong pong = influxDB.ping();
    }
    protected String dbName = "monitor";
    protected String retentionPolicy = "bone";

       /* public static void main(String args[]) throws TableNotDefinedExcetion {
        InfluxBoneDao<BoneInfo> dao  =new InfluxBoneDao<BoneInfo>();
//         BoneNetworkDevice bone = new BoneNetworkDevice("22f4---ffff---22222");
//        bone.setDeviceName("zte2--2221212");
//        List<BoneNetworkDevice> t =  new ArrayList<BoneNetworkDevice>();
//        t.add(bone);
//        dao.save(bone);
       // System.out.print(dao.convertToPoint("bone",bone));
      //  String sql = "SELECT * from t_r_bone_network_device order by time desc limit 10";

        //    dao.query(BoneInfo.class,sql);
//        System.out.println(dao.insertBar("deviceNameInfo"));
//        System.out.println(dao.insertBar("uuid"));
//        System.out.println(dao.trimBar("device_name_info"));

//            List<BoneInfo> tlist = new ArrayList<BoneInfo>();
//
//            long t1 = System.currentTimeMillis();
//            for(int i=0;i<20;i++)
//            {
//                BoneInfo boneInfo = new BoneInfo();
//                boneInfo.setUuid("uuid_"+i);
//                boneInfo.setDeviceName("devcie_name_"+i);
//                tlist.add(boneInfo);
//                //dao.save(boneInfo);
//            }
//            dao.save(tlist);
//            System.out.println(System.currentTimeMillis()-t1);
            OnuFlowModel onuFlowModel = new OnuFlowModel();
            onuFlowModel.setOnuId("test");
            List<OnuFlowModel> onuFlowModels = new ArrayList<>();
            OnuFlowDAO onuFlowDAO = new OnuFlowDAO();
            onuFlowDAO.save(onuFlowModels);
            CmFlowModel cmFlowModel = new CmFlowModel();
            cmFlowModel.setCmId("test");
            CmFlowDAO cmFlowDAO = new CmFlowDAO();
            cmFlowDAO.save(cmFlowModel);
    }*/

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

      // if (!influxDB.isBatchEnabled())
      //      influxDB.enableBatch(5, 5, TimeUnit.MILLISECONDS);
//        for (T point:points)
//               save(point);

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
        builder.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
//        builder.tag("port","2");
//        builder.tag("boardid","2");
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
            //System.out.println(fieldName);
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
               //  System.out.println(columnName+":" + field.getName() + ":" + field.getType());
                 Boolean present = field.isAnnotationPresent(InfluxTag.class);

                 switch (field.getType().getName()) {
                        case "java.lang.String":
                            if (present) {
                                builder.tag(columnName, (String) value);
                            } else {
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
                            if (present) {
                                builder.tag(columnName, (String) value);
                            } else {
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
                            System.out.print("can't find type to convert to point:" + field.getName() + ":" + field.getType());
                    }

            }
                //long number double string boolean
        }
        return builder.build();
    }

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