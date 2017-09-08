package com.ccclubs.quota.tools;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class ClassUtil {

    public static  String[] getClassAttribute(Class cl){

        //标题行
        String[] headers ={"vin码","车机号","月均行驶里程(km)","平均单日运行时间(h)","百公里耗电量(kw/100km)","纯电续航里程(km)"
                ,"最大充电功率(kw/h)","车辆一次充满电所用最少时间(h)","累计行驶里程(km)","累计充电量(kw)"};
//        try {
//            if (cl!=null){
//                int i=0;
//                Class	clazz = Class.forName(cl.getName());
//                Object object=clazz.newInstance();
//                Field[] fields = object.getClass().getDeclaredFields();
//                headers =new String[fields.length-1];
//                for (Field field : fields){
//                    // 对于每个属性，获取属性名
//                    if(!"serialVersionUID".equals(field.getName())){
//                        headers[i++]=field.getName();
//                    }
//                }
//            }
//        }catch (Exception e ){
//            e.printStackTrace();
//        }
        return  headers;
    }
}
