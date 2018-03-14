package com.ccclubs.frm.influxdb;

import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kevin on 16/11/21.
 */
@Service
public class InfluxTermQuery<T> extends InfluxBoneDao<T> {

    public InfluxTermQuery()
    {

    }
    /*
    * 每行记录放在一个Map中
    * */
    public List<Map<String,Object>> query(String sql)
    {
        //sql = "SELECT used,free FROM disk order by time desc limit 10";
        Query query = new Query(sql, dbName);
        QueryResult ret = influxDB.query(query);
        System.out.println(">InfluxDB: " + ret);
        List<Map<String,Object>> rlst = new ArrayList<Map<String,Object>>();
        for(QueryResult.Result result : ret.getResults()) {
            List<String> columns = result.getSeries().get(0).getColumns();
            for (List<Object> values : result.getSeries().get(0).getValues()) {
                Map<String,Object> row = new HashMap<String,Object>();
                for(int idx = 0;idx<values.size();idx++) {
                    row.put(columns.get(idx), values.get(idx));
                }
                rlst.add(row);
            }

        }
        System.out.println("rlst: ");
        System.out.println(rlst);
        System.out.println("rlst end---------------");
        return rlst;
    }

    /*
    * entity为查询结果的facade
    * */
    public List<T> query(Class entity,String sql)
    {
        System.out.println(sql);
        Query query = new Query(sql, dbName);
        QueryResult ret = influxDB.query(query);
        System.out.println(ret);
        System.out.println("---end---");
        List<T> rlst = new ArrayList<T>();
        for(QueryResult.Result result : ret.getResults()) {
            List<String> columns = result.getSeries().get(0).getColumns();

            System.out.println(columns);
            T row  = null;
            try {
                row = (T)entity.newInstance();

            for (List<Object> values : result.getSeries().get(0).getValues()) {

                for(int idx = 0;idx<values.size();idx++)
                {
                   String column =  columns.get(idx);
//                   String methodName = "set"+ column.substring(0,1).toUpperCase()
//                           +columns.get(idx).substring(1,columns.get(idx).length());

//                    Method method = entity.getMethod(methodName,String.class);
//
//                    method.invoke(row,new Object[]{values.get(idx)});
                    Field field = null;
                    try {
                        field = entity.getDeclaredField(column);
                    } catch (NoSuchFieldException e) {
                        if(null==field) {
                            try {
                                field = entity.getSuperclass().getDeclaredField(column);
                            } catch (NoSuchFieldException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }

                    field.setAccessible(true);
                    field.set(row,values.get(idx));
                }
                rlst.add(row);
            }

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        System.out.println("rlst: ");
        System.out.println(rlst);
        System.out.println("rlst end---------------");
        return rlst;
    }


    /*
    * @entity 查询结果对应的facade,它必须使用InfluxTable注解指定对应的表
    * @params 查询参数,名字-value 对
    * @whereClause  可选,可以定义 desc limit, order by等
    * */
    public List<T> query(Class entity,Map<String,Object> params,String ...whereClause)
    {
        //String sql = "SELECT used,free FROM disk order by time desc limit 10";
        InfluxTable table = entity.getClass().getAnnotation(InfluxTable.class);
        Field[] fields = entity.getDeclaredFields();
        StringBuffer sql = new StringBuffer(256);
        sql.append("select ");
        int i= 0;
        for(Field field:fields)
        {
            sql.append(field.getName());
            if(i++<fields.length) {
                sql.append(',');
            }
        }
        sql.append(" from ").append(table.name());
        sql.append(" where ");
        boolean first = true;
        for(Map.Entry<String,Object> param:params.entrySet())
        {
            if(!first)
            {
                sql.append(" and ");
            }
            sql.append(param.getKey()).append('=');
            Field field = null;
            try {
                field = entity.getDeclaredField(param.getKey());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            if("java.lang.String".equals(field.getType().getName())) {
                sql.append('\'').append(param.getValue()).append('\'');
            } else {
                sql.append(param.getValue());
            }
            first = false;
        }
        sql.append(' ').append(whereClause);

        Query query = new Query(sql.toString(), dbName);
        QueryResult ret = influxDB.query(query);
        // System.out.println(ret);
        List<T> rlst = new ArrayList<T>();
        for(QueryResult.Result result : ret.getResults()) {
            List<String> columns = result.getSeries().get(0).getColumns();

            System.out.println(columns);
            T row  = null;
            try {
                row = (T)entity.newInstance();

                for (List<Object> values : result.getSeries().get(0).getValues()) {

                    for(int idx = 0;idx<values.size();idx++)
                    {
                        String column =  trimBar(columns.get(idx));
                        Field field = null;
                        try {
                            field = entity.getDeclaredField(column);
                        } catch (NoSuchFieldException e) {
                            //如果找不到,到父类中找
                            if(null==field) {
                                try {
                                    field = entity.getSuperclass().getDeclaredField(column);
                                } catch (NoSuchFieldException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                        field.setAccessible(true);
                        field.set(row,values.get(idx));
                    }
                    rlst.add(row);
                }

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        System.out.println(rlst);
        return rlst;
    }


    /*
    * @entity 查询结果对应的facade,它必须使用InfluxTable注解指定对应的表
    * @params 查询参数,名字-value 对
    * @whereClause  可选,可以定义 desc limit, order by等
    * */
    public T queryLast(Class entity,Map<String,Object> params,String ...whereClause)
    {
        //String sql = "SELECT used,free FROM disk order by time desc limit 10";
        InfluxTable table = entity.getClass().getAnnotation(InfluxTable.class);
        Field[] fields = entity.getDeclaredFields();
        StringBuffer sql = new StringBuffer(256);
        sql.append("select ");
        int i= 0;
        for(Field field:fields)
        {
            sql.append("last(");
            sql.append(field.getName());
            sql.append(") as ");
            sql.append(field.getName());

            if(i++<fields.length) {
                sql.append(',');
            }
        }
        sql.append(" from ").append(table.name());
        sql.append(" where ");
        boolean first = true;
        for(Map.Entry<String,Object> param:params.entrySet())
        {
            if(!first)
            {
                sql.append(" and ");
            }
            sql.append(param.getKey()).append('=');
            Field field = null;
            try {
                field = entity.getDeclaredField(param.getKey());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            if("java.lang.String".equals(field.getType().getName())) {
                sql.append('\'').append(param.getValue()).append('\'');
            } else {
                sql.append(param.getValue());
            }
            first = false;
        }
        sql.append(' ').append(whereClause);

        Query query = new Query(sql.toString(), dbName);
        QueryResult ret = influxDB.query(query);
        // System.out.println(ret);


        for(QueryResult.Result result : ret.getResults()) {
            List<String> columns = result.getSeries().get(0).getColumns();

            System.out.println(columns);
            T row  = null;
            try {
                row = (T)entity.newInstance();

                for (List<Object> values : result.getSeries().get(0).getValues()) {

                    for(int idx = 0;idx<values.size();idx++)
                    {
                        String column =  trimBar(columns.get(idx));
                        Field field = null;
                        try {
                            field = entity.getDeclaredField(column);
                        } catch (NoSuchFieldException e) {
                            //如果找不到,到父类中找
                            if(null==field) {
                                try {
                                    field = entity.getSuperclass().getDeclaredField(column);
                                } catch (NoSuchFieldException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                        field.setAccessible(true);
                        field.set(row,values.get(idx));
                    }
                    return row;
                }

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        return null;
    }


    @Override
    public String trimBar(String column)
    {
        String arr[] = column.split("_");
        StringBuffer buf = new StringBuffer();
        boolean first = true;
        for(String subColumn:arr)
        {
            if(first)
            {
                first = false;
                buf.append(subColumn);
            }
            else {
                buf.append(subColumn.replaceFirst(subColumn.substring(0, 1), subColumn.substring(0, 1).toUpperCase()));
            }
        }
        return buf.toString();
    }




    //    public static void main(String args[]) throws TableNotDefinedExcetion {
//        InfluxBoneDao<BoneInfo> dao  =new InfluxBoneDao<BoneInfo>();
////         BoneNetworkDevice bone = new BoneNetworkDevice("22f4---ffff---22222");
////        bone.setDeviceName("zte2--2221212");
////        List<BoneNetworkDevice> t =  new ArrayList<BoneNetworkDevice>();
////        t.add(bone);
////        dao.save(bone);
//       // System.out.print(dao.convertToPoint("bone",bone));
//        String sql = "SELECT * from t_r_bone_network_device order by time desc limit 10";
//        //dao.query(BoneInfo.class,sql);
//        System.out.println(dao.insertBar("deviceNameInfo"));
//        System.out.println(dao.insertBar("uuid"));
//        System.out.println(dao.trimBar("device_name_info"));
//
//    }
}