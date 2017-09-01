package com.ccclubs.olap.service;

import com.ccclubs.olap.bean.*;
import com.ccclubs.olap.util.BlockUtil;
import com.ccclubs.olap.util.DBHelper;
import com.ccclubs.olap.util.DateTimeUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//执法平台车辆数据服务
public class ZhiFaService {
    //驾驶阶段计算
    public List<DrivePace> calDrivePaceList(Map<Long,PaceBlock> blockMap,List<Vehicle_zhifa> vehicle_zhifa_list){
        List<DrivePace> drivePaceList = new ArrayList<>();
        //得到状态数据块
        Map<Long,PaceBlock> insertBlockMap = BlockUtil.getInsertBlockMap(blockMap,vehicle_zhifa_list);
        Iterator<Map.Entry<Long,PaceBlock>> iterator= insertBlockMap.entrySet().iterator();
        List<PaceBlock> paceBlockList = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<Long,PaceBlock> entry = iterator.next();
            PaceBlock paceBlock = entry.getValue();
            BlockUtil.makeBlockInfo(paceBlock);
            paceBlockList.add(paceBlock);
        }

        List<PaceBlock> tempList = new ArrayList<>();
        int pace_status=3;
        PaceBlock currentPaceBlock = paceBlockList.get(0);
        PaceBlock previousPaceBlock = paceBlockList.get(0);

        for(PaceBlock paceBlock:paceBlockList){
            previousPaceBlock=currentPaceBlock;
            currentPaceBlock=paceBlock;
            //取得数据块状态
            int block_status = paceBlock.getBlock_status();
            //判断是否为驾驶状态
            if(block_status==2){
                //判断间隔是否超过半小时
                if(calIntervalTimeMills(currentPaceBlock,tempList)>1800000){
                    //创建新阶段
                    DrivePace drivePace = createNewDrivePace(tempList);
                    tempList=new ArrayList<>();
                    if(drivePace!=null){
                        //如果行驶里程大于0.5公里
                        if(drivePace.getPace_miles()>=0.5){
                            drivePaceList.add(drivePace);
                        }
                    }
                }
                tempList.add(paceBlock);
            }
            //不是驾驶状态
            else{
                DrivePace drivePace = createNewDrivePace(tempList);
                tempList=new ArrayList<>();
                //创建新阶段
                if(drivePace!=null){
                    //如果行驶里程大于0.5公里
                    if(drivePace.getPace_miles()>=0.5){
                        drivePaceList.add(drivePace);
                    }
                }
            }
        }

        return drivePaceList;
    }

    //充电阶段计算
    public List<SocPace> calSocPaceList(Map<Long,PaceBlock> blockMap,List<Vehicle_zhifa> vehicle_zhifa_list){
        List<SocPace> socPaceList = new ArrayList<>();

        //得到状态数据块
        Map<Long,PaceBlock> insertBlockMap = BlockUtil.getInsertBlockMap(blockMap,vehicle_zhifa_list);
        Iterator<Map.Entry<Long,PaceBlock>> iterator= insertBlockMap.entrySet().iterator();
        List<PaceBlock> paceBlockList = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<Long,PaceBlock> entry = iterator.next();
            PaceBlock paceBlock = entry.getValue();
            BlockUtil.makeBlockInfo(paceBlock);
            paceBlockList.add(paceBlock);
        }

        List<PaceBlock> tempList = new ArrayList<>();
        int pace_status=3;
        PaceBlock currentPaceBlock = paceBlockList.get(0);
        PaceBlock previousPaceBlock = paceBlockList.get(0);

        for(PaceBlock paceBlock:paceBlockList){
            previousPaceBlock=currentPaceBlock;
            currentPaceBlock=paceBlock;
            //取得数据块状态
            int block_status = paceBlock.getBlock_status();
            //判断是否为充电
            if(block_status==1){
                //判断间隔是否超过半小时
                if(calIntervalTimeMills(currentPaceBlock,tempList)>1800000){
                    //创建新阶段
                    SocPace socPace = createNewSocPace(tempList);
                    tempList=new ArrayList<>();
                    if(socPace!=null){
                        //如果充电电量百分比大于1
                        if(socPace.getPace_changed_soc()>1){
                            socPaceList.add(socPace);
                        }
                    }
                }
                tempList.add(paceBlock);
            }
            //不是驾驶状态
            else{
                SocPace socPace = createNewSocPace(tempList);
                tempList=new ArrayList<>();
                //创建新阶段
                if(socPace!=null){
                    //如果充电电量百分比大于1
                    if(socPace.getPace_changed_soc()>1){
                        socPaceList.add(socPace);
                    }
                }
            }
        }

        return socPaceList;
    }

    //计算当前记录距离缓存序列最后一条记录的间隔时间
    private long calIntervalTimeMills(PaceBlock currentPaceBlock,List<PaceBlock> tempList){
        long timeMills=0;
        if(tempList!=null&&tempList.size()>0){
            PaceBlock paceBlock = tempList.get(tempList.size()-1);
            timeMills=currentPaceBlock.getBlock_start_timemills()-paceBlock.getBlock_end_timemills();
        }
        return timeMills;
    }

    //生成驾驶阶段
    private DrivePace createNewDrivePace(List<PaceBlock> tempList){
        DrivePace drivePace = null;
        if(tempList!=null&&tempList.size()>0){
            drivePace = new DrivePace();
            PaceBlock headPaceBlock = tempList.get(0);
            PaceBlock tailPaceBlock = tempList.get(tempList.size()-1);

            //车机号
            String cs_number = headPaceBlock.getCs_number();
            //阶段开始时间(毫秒)
            long pace_start_timemills = headPaceBlock.getBlock_start_timemills();
            //阶段结束时间(毫秒)
            long pace_end_timemills = tailPaceBlock.getBlock_end_timemills();
            //阶段经历时间
            long pace_timemills = pace_end_timemills-pace_start_timemills;
            //阶段开始时间
            String pace_start_time = DateTimeUtil.getDateTimeByFormat1(headPaceBlock.getBlock_start_timemills());
            //阶段结束时间
            String pace_end_time = DateTimeUtil.getDateTimeByFormat1(tailPaceBlock.getBlock_end_timemills());
            //行驶公里数
            double pace_miles = 0d;
            for(PaceBlock pb:tempList){
                pace_miles+=pb.getBlock_distance()/1000;
            }

            drivePace.setCs_number(cs_number);
            drivePace.setPace_start_time(pace_start_time);
            drivePace.setPace_end_time(pace_end_time);
            drivePace.setPace_timemills(pace_timemills);
            drivePace.setPace_miles(pace_miles);
        }
        return drivePace;
    }

    //生成充电阶段
    private SocPace createNewSocPace(List<PaceBlock> tempList){
        SocPace socPace = null;
        if(tempList!=null&&tempList.size()>0){
            socPace = new SocPace();
            PaceBlock headPaceBlock = tempList.get(0);
            PaceBlock tailPaceBlock = tempList.get(tempList.size()-1);

            //车机号
            String cs_number = headPaceBlock.getCs_number();
            //阶段起始电量
            int pace_start_soc = headPaceBlock.getBlock_start_soc();
            //阶段结束电量
            int pace_end_soc = tailPaceBlock.getBlock_end_soc();
            //阶段消耗电量
            int pace_changed_soc = pace_end_soc-pace_start_soc;
            //阶段开始时间(毫秒)
            long pace_start_timemills = headPaceBlock.getBlock_start_timemills();
            //阶段结束时间(毫秒)
            long pace_end_timemills = tailPaceBlock.getBlock_end_timemills();
            //阶段经历时间
            long pace_timemills = pace_end_timemills-pace_start_timemills;
            //阶段开始时间
            String pace_start_time = DateTimeUtil.getDateTimeByFormat1(headPaceBlock.getBlock_start_timemills());
            //阶段结束时间
            String pace_end_time = DateTimeUtil.getDateTimeByFormat1(tailPaceBlock.getBlock_end_timemills());

            socPace.setCs_number(cs_number);
            socPace.setPace_start_time(pace_start_time);
            socPace.setPace_end_time(pace_end_time);
            socPace.setPace_timemills(pace_timemills);
            socPace.setPace_start_soc(pace_start_soc);
            socPace.setPace_end_soc(pace_end_soc);
            socPace.setPace_changed_soc(pace_changed_soc);


        }
        return socPace;
    }

    //插入驾驶阶段数据
    public void insertDriveData(List<DrivePace> drivePaceList){
        DBHelper dbHelper = new DBHelper();
        if(drivePaceList!=null&&drivePaceList.size()>0){
            DrivePace firstDrivePace = drivePaceList.get(0);
            String first_cs_number = firstDrivePace.getCs_number();
            //先删除该车统计数据
            String delete_sql = " DELETE FROM ccclubs_cg_platform.drive_miles_basic_zhifa WHERE cs_number='%s'  ";
            try {
                delete_sql = String.format(delete_sql, first_cs_number);
                dbHelper.deleteRecords(delete_sql);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            //生成插入语句
            List<String> sql_list = new ArrayList<>();
            int row_no=0;
            for(DrivePace drivePace:drivePaceList){
                row_no++;
                String insetSql = "INSERT INTO  ccclubs_cg_platform.drive_miles_basic_zhifa" +
                        "(cs_number,row_no,changed_miles,start_time,end_time,pace_timemills) "+
                        "values('%s',%d,%f,'%s','%s',%d)";
                insetSql=String.format(insetSql,
                        drivePace.getCs_number(),
                        row_no,
                        drivePace.getPace_miles(),
                        drivePace.getPace_start_time(),
                        drivePace.getPace_end_time(),
                        drivePace.getPace_timemills());
                sql_list.add(insetSql);
            }
            try {
                dbHelper.insertRecords(sql_list);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //插入充电阶段数据
    public void insertSocData(List<SocPace> socPaceList){
        DBHelper dbHelper = new DBHelper();
        if(socPaceList!=null&&socPaceList.size()>0){
            SocPace firstSocPace = socPaceList.get(0);
            String first_cs_number = firstSocPace.getCs_number();
            //先删除该车统计数据
            String delete_sql = " DELETE FROM ccclubs_cg_platform.soc_miles_basic_zhifa WHERE cs_number='%s'  ";
            try {
                delete_sql = String.format(delete_sql, first_cs_number);
                dbHelper.deleteRecords(delete_sql);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            //生成插入语句
            List<String> sql_list = new ArrayList<>();
            int row_no=0;
            for(SocPace socPace:socPaceList){
                row_no++;
                String insetSql = "INSERT INTO  ccclubs_cg_platform.soc_miles_basic_zhifa" +
                        "(cs_number,row_no,start_soc,end_soc,changed_soc,start_time,end_time,pace_timemills) "+
                        "values('%s',%d,%d,%d,%d,'%s','%s',%d)";
                insetSql=String.format(insetSql,
                        socPace.getCs_number(),
                        row_no,
                        socPace.getPace_start_soc(),
                        socPace.getPace_end_soc(),
                        socPace.getPace_changed_soc(),
                        socPace.getPace_start_time(),
                        socPace.getPace_end_time(),
                        socPace.getPace_timemills()
                        );
                sql_list.add(insetSql);
            }
            try {
                dbHelper.insertRecords(sql_list);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
