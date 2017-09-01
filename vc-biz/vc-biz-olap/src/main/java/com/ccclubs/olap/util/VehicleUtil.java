package com.ccclubs.olap.util;


import com.ccclubs.olap.bean.Cs_vehicle_machine_rel;

import java.util.ArrayList;
import java.util.List;

public class VehicleUtil {
    public static String generateCsVinSqlSegement(List<Cs_vehicle_machine_rel> list){
        String sql=null;
        if(list!=null&&list.size()>0){
            sql="";
            for(int i=0;i<list.size();i++){
                Cs_vehicle_machine_rel cs_vehicle_machine_rel = list.get(i);
                if(i>0){
                    sql+=" or ";
                }
                String cs_vin = cs_vehicle_machine_rel.getCs_vin();
                sql+= "a.cs_vin='"+cs_vin+"' ";
            }
            sql="("+sql+")";
        }
        return sql;
    }

    public static void main(String[] args) {
        Cs_vehicle_machine_rel cs_vehicle_machine_rel1=new Cs_vehicle_machine_rel();
        Cs_vehicle_machine_rel cs_vehicle_machine_rel2=new Cs_vehicle_machine_rel();
        Cs_vehicle_machine_rel cs_vehicle_machine_rel3=new Cs_vehicle_machine_rel();

        cs_vehicle_machine_rel1.setCs_vin("1a");
        cs_vehicle_machine_rel2.setCs_vin("2b");
        cs_vehicle_machine_rel3.setCs_vin("3c");

        List<Cs_vehicle_machine_rel> list = new ArrayList<>();
        list.add(cs_vehicle_machine_rel1);
        list.add(cs_vehicle_machine_rel2);
        list.add(cs_vehicle_machine_rel3);

        System.out.println(VehicleUtil.generateCsVinSqlSegement(list));
    }
}
