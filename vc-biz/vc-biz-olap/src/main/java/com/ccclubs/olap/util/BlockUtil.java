package com.ccclubs.olap.util;

import com.ccclubs.olap.bean.PaceBlock;
import com.ccclubs.olap.bean.Vehicle_zhifa;

import java.util.List;
import java.util.Map;

public class BlockUtil {

    public static Map<Long,PaceBlock> getInsertBlockMap(Map<Long,PaceBlock> blockMap,List<Vehicle_zhifa> vehicle_zhifa_list){

        for(Vehicle_zhifa vehicle_zhifa:vehicle_zhifa_list){
            long key_timemills = DateTimeUtil.getTimeMillsFixByInterval(DateTimeUtil.date2UnixFormat(vehicle_zhifa.getAdd_time(),DateTimeUtil.format1));
            if(blockMap.containsKey(key_timemills)){
                PaceBlock paceBlock = blockMap.get(key_timemills);
                paceBlock.setCs_number(vehicle_zhifa.getCs_number());
                List<Vehicle_zhifa> recordList = paceBlock.getRecordList();
                recordList.add(vehicle_zhifa);
            }
        }
        return blockMap;
    }

    //设置数据块里的基本信息
    public static PaceBlock makeBlockInfo(PaceBlock paceBlock){
        //判断数据块状态
        int block_status = judgeBlockStatus(paceBlock);
        List<Vehicle_zhifa> recordList = paceBlock.getRecordList();
        //如果是充电状态
        if(block_status==1){
            int block_changed_soc=0;
            for(int i=1;i<recordList.size();i++){
                Vehicle_zhifa vehicle_zhifa2=recordList.get(i);
                Vehicle_zhifa vehicle_zhifa1=recordList.get(i-1);
                block_changed_soc+=vehicle_zhifa2.getSoc()-vehicle_zhifa1.getSoc();
            }
            //设置数据块的电量信息
            paceBlock.setBlock_changed_soc(block_changed_soc);
            //起始电量
            paceBlock.setBlock_start_soc(recordList.get(0).getSoc());
            //结束电量
            paceBlock.setBlock_end_soc(recordList.get(recordList.size()-1).getSoc());
        }
        //如果是驾驶状态
        else if(block_status==2){
            double block_distance = 0.00d;
            for(int i=1;i<recordList.size();i++){
                Vehicle_zhifa vehicle_zhifa2=recordList.get(i);
                Vehicle_zhifa vehicle_zhifa1=recordList.get(i-1);
                block_distance+=getDistance(vehicle_zhifa1.getLongitude(),vehicle_zhifa1.getLatitude(),vehicle_zhifa2.getLongitude(),vehicle_zhifa2.getLatitude());
            }
            //设置数据块的行驶信息
            paceBlock.setBlock_distance(block_distance);
        }
        //如果是其它状态
        else{

        }
        paceBlock.setBlock_status(block_status);
        return paceBlock;
    }

    //判断数据块状态
    public static int judgeBlockStatus(PaceBlock paceBlock){
        int block_status = 3;
        List<Vehicle_zhifa> recordList = paceBlock.getRecordList();
        if(recordList.size()>1) {
            //判断平均速度
            float total_speed = 0.00f;
            for(Vehicle_zhifa vehicle_zhifa:recordList){
                total_speed+=vehicle_zhifa.getSpeed();
            }
            float block_avg_speed = total_speed/recordList.size();
            //如果平均速度大于0
            if(block_avg_speed>0){
                block_status=2;
            }
            else{
                int increment_soc=0;
                //判断是否是充电状态
                for(int i=1;i<recordList.size();i++){
                    Vehicle_zhifa vehicle_zhifa2=recordList.get(i);
                    Vehicle_zhifa vehicle_zhifa1=recordList.get(i-1);
                    increment_soc+=vehicle_zhifa2.getSoc()-vehicle_zhifa1.getSoc();
                }
                if(increment_soc>0){
                    block_status=1;
                }
            }
        }
        return block_status;
    }


    //计算两经纬度点之间的距离(单位:米)
    public static double getDistance(double longitude_start,double latitude_start,double longitude_end,double latitude_end){
        double radLat1 = Math.toRadians(latitude_end);
        double radLat2 = Math.toRadians(latitude_start);
        double a = radLat1 - radLat2;
        double b = Math.toRadians(longitude_end) - Math.toRadians(longitude_start);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * 6378137.0;// 取WGS84标准参考椭球中的地球长半径(单位:m)
        s = Math.round(s * 10000) / 10000;
        return s;
    }
}
