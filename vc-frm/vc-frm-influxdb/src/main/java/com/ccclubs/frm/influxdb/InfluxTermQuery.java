package com.ccclubs.frm.influxdb;

import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.frm.spring.entity.StringTool;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kevin on 16/11/21.
 * Edited by alban on 18/3/15
 * description: 用于执行influxdb的通用查询基方法类。
 */
@Service
public class InfluxTermQuery<T> extends InfluxBoneDao<T> {
    private static Logger logger= LoggerFactory.getLogger(InfluxTermQuery.class);

    public InfluxTermQuery()
    {
    }
    /*
    * 每行记录放在一个Map中
    * */
    public List<Map<String,Object>> query(String sql)
    {
        Query query = new Query(sql, dbName);
        QueryResult ret = influxDB.query(query);
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
        return rlst;
    }

    /*
    * entity为查询结果的facade
    * */
    public List<T> query(Class entity,String sql)
    {
        Query query = new Query(sql, dbName);
        QueryResult ret = influxDB.query(query);
        List<T> rlst = new ArrayList<T>();
        for(QueryResult.Result result : ret.getResults()) {
            List<String> columns = result.getSeries().get(0).getColumns();


            T row  = null;
            try {
                row = (T)entity.newInstance();

            for (List<Object> values : result.getSeries().get(0).getValues()) {

                for(int idx = 0;idx<values.size();idx++)
                {
                   String column =  columns.get(idx);
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
        return rlst;
    }


    /*
    * @entity 查询结果对应的facade,它必须使用InfluxTable注解指定对应的表
    * @params 查询参数,名字-value 对
    * @whereClause  可选,可以定义 desc limit, order by等
    * */

    public List<T> query(T entity, @NotNull Map<String,Object> params, String ...whereClause)
    {
        InfluxTable table = entity.getClass().getAnnotation(InfluxTable.class);
        Field[] fields = entity.getClass().getDeclaredFields();
        StringBuffer sql = new StringBuffer(256);
        sql.append("select ");
        int i= 0;
        for(Field field:fields)
        {
            sql.append(StringTool.camelToUnderline(field.getName()));
            if(++i<fields.length) {
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
            sql.append(StringTool.camelToUnderline(param.getKey())).append('=');
            Field field = null;
            try {
                field = entity.getClass().getDeclaredField(param.getKey());
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
        //FIXME 这里有拼接附加条件的sql语句问题。
        if (null!=whereClause) {
            sql.append(' ').append(whereClause);
        }

        Query query = new Query(sql.toString(), dbName);
        QueryResult ret = influxDB.query(query);
        List<T> rlst = new ArrayList<T>();
        for(QueryResult.Result result : ret.getResults()) {
            List<String> columns = result.getSeries().get(0).getColumns();

            T row  = null;
            try {
                row = (T)entity.getClass().newInstance();

                for (List<Object> values : result.getSeries().get(0).getValues()) {

                    for(int idx = 0;idx<values.size();idx++)
                    {
                        String column =  StringTool.underlineToCamel(columns.get(idx));
                        Field field = null;
                        Boolean needSearchField=true;
                        if ("time".equals(column)){
                            for (Field f:fields){
                                if(f.isAnnotationPresent(InfluxTime.class)){
                                    field=f;
                                    needSearchField=false;
                                    break;
                                }
                            }
                        }
                        if (needSearchField){
                            try {
                                field = entity.getClass().getDeclaredField(column);
                            } catch (NoSuchFieldException e) {
                                //如果找不到,到父类中找
                                if(null==field) {
                                    try {
                                        field = entity.getClass().getSuperclass().getDeclaredField(column);
                                    } catch (NoSuchFieldException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                            }
                        }

                        if (!needSearchField){
                            field.setAccessible(true);
                            field.set(row,
                                    DateTimeUtil.date2UnixFormat((String) values.get(idx),
                                    DateTimeUtil.GMT_LONG_FORMAT)+8*60*60*1000);
                        }
                        else {
                            field.setAccessible(true);
                            Double doubleValue=null;
                            if (null==values.get(idx)){
                                field.set(row,null);
                            }else {
                                //TODO 用switch判断如何转换数值类型
                                switch (field.getType().getName()){
                                    case "java.lang.Float":
                                        doubleValue=(Double) values.get(idx);
                                        field.set(row,doubleValue.floatValue());
                                        break;
                                    case "java.lang.Integer":
                                        doubleValue=(Double) values.get(idx);
                                        field.set(row,doubleValue.intValue());
                                        break;
                                    case "java.lang.Short":
                                        doubleValue=(Double) values.get(idx);
                                        field.set(row,doubleValue.shortValue());
                                        break;
                                    case "java.lang.Double":
                                        doubleValue=(Double) values.get(idx);
                                        field.set(row,doubleValue);
                                        break;
                                    case "java.lang.Long":
                                        doubleValue=(Double) values.get(idx);
                                        field.set(row,doubleValue.longValue());
                                        break;
                                    case "java.lang.Number":
                                        doubleValue=(Double) values.get(idx);
                                        field.set(row,doubleValue);
                                        break;
                                    case "java.lang.Byte":
                                        doubleValue=(Double) values.get(idx);
                                        field.set(row,doubleValue.byteValue());
                                        break;
                                    default:
                                        field.set(row,values.get(idx));
                                        break;
                                }

                            }

                        }
                    }
                    rlst.add(row);
                }

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
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
            sql.append(StringTool.camelToUnderline(field.getName()));
            sql.append(") as ");
            sql.append(StringTool.camelToUnderline(field.getName()));

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
            sql.append(StringTool.camelToUnderline(param.getKey())).append('=');
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
        for(QueryResult.Result result : ret.getResults()) {
            List<String> columns = result.getSeries().get(0).getColumns();
            T row  = null;
            try {
                row = (T)entity.newInstance();

                for (List<Object> values : result.getSeries().get(0).getValues()) {

                    for(int idx = 0;idx<values.size();idx++)
                    {
                        String column =  StringTool.underlineToCamel(columns.get(idx));
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

}