package com.ccclubs.quota.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.olap.orm.mapper.CsCarMapper;
import com.ccclubs.olap.orm.mapper.CsHistoryStateMapper;
import com.ccclubs.olap.orm.mapper.DriveMilesBasicZhifaMapper;
import com.ccclubs.olap.orm.mapper.SocMilesBasicZhifaMapper;
import com.ccclubs.olap.orm.model.*;
import com.ccclubs.quota.vo.WeekBeanOutput;
import com.ccclubs.quota.inf.ZhiFaMilesBasicInf;
import com.ccclubs.quota.util.BlockUtil;
import com.ccclubs.quota.util.DBHelper;
import com.ccclubs.quota.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
@Service(version = "1.0.0")
public class  ZhiFaMilesBasicService implements ZhiFaMilesBasicInf{

    @Resource
    DriveMilesBasicZhifaMapper driveMilesBasicZhifaMapper;

    @Resource
    SocMilesBasicZhifaMapper socMilesBasicZhifaMapper;

    @Resource
    CsHistoryStateMapper csHistoryStateMapper;

    @Resource
    CsCarMapper csCarMapper;

    @Autowired
    private DBHelper dbHelper;

    //插入驾驶阶段数据
    public void insertDriveMilses(List<DriveMilesBasicZhifa> drivePaceList,String startTime,String endTime) {
        //添加前再删除
        if(drivePaceList!=null&&drivePaceList.size()>0){
            //
            DriveMilesBasicZhifaExample example=new DriveMilesBasicZhifaExample();
            DriveMilesBasicZhifaExample.Criteria criteria=example.createCriteria();
            criteria.andCsNumberEqualTo(drivePaceList.get(0).getCsNumber());
            criteria.andStartTimeBetween(startTime,endTime);
            driveMilesBasicZhifaMapper.deleteByExample(example);

            //插入数据到socMilesBasicZhifa中
            int row_no=0;
            for(DriveMilesBasicZhifa  driveMilesBasicZhifa:drivePaceList){
                row_no++;
                driveMilesBasicZhifa.setRowNo(row_no);
                driveMilesBasicZhifaMapper.insert(driveMilesBasicZhifa);
            }
        }
    }

    //插入充电阶段数据
    public void insertSocMiles(List<SocMilesBasicZhifa> socPaceList,String startTime,String endTime) {
        //添加前再删除
        if(socPaceList!=null&&socPaceList.size()>0){
            //
            SocMilesBasicZhifaExample example=new SocMilesBasicZhifaExample();
            SocMilesBasicZhifaExample.Criteria criteria=example.createCriteria();
            criteria.andCsNumberEqualTo(socPaceList.get(0).getCsNumber());
            criteria.andStartTimeBetween(startTime,endTime);
            socMilesBasicZhifaMapper.deleteByExample(example);

            //插入数据到socMilesBasicZhifa中
            int row_no=0;
            for(SocMilesBasicZhifa  socMilesBasicZhifa :socPaceList){
                row_no++;
                socMilesBasicZhifa.setRowNo(row_no);
                socMilesBasicZhifaMapper.insert(socMilesBasicZhifa);
            }
        }
    }

    /**
     * 获取周的选择数据
     * @return
     */
    @Override
    public List<WeekBeanOutput> getWeekCount() {
        return DateTimeUtil.getWeekCount();
    }

    /**
     * 获取执法中的数据
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public Map<String, List<ZhiFABean>> queryZhiFaData(String startTime, String endTime) {

        //取出DriveMiles中的数据
        DriveMilesBasicZhifaExample driveExample = new DriveMilesBasicZhifaExample();
        DriveMilesBasicZhifaExample.Criteria driveCriteria = driveExample.createCriteria();
        driveCriteria.andStartTimeBetween(startTime, endTime);
        List<ZhiFABean> zhiFABeansList = driveMilesBasicZhifaMapper.selectByExample(driveExample);

        //取出socMiles中的数据
        SocMilesBasicZhifaExample socExample = new SocMilesBasicZhifaExample();
        SocMilesBasicZhifaExample.Criteria socCriteria = socExample.createCriteria();
        socCriteria.andStartTimeBetween(startTime, endTime);
        List<SocMilesBasicZhifa> socMilesBasicZhifaList = socMilesBasicZhifaMapper.selectByExample(socExample);
        //
        Map<String, List<Float>> sortMap = new HashMap<>();//排序map
        Map<String, List<ZhiFABean>> mapDate = new HashMap<>();
        //在zhiFaBean中设置充电次数
        for (ZhiFABean zhiFABean : zhiFABeansList) {
            String driveCsNumber = zhiFABean.getCs_number();
            String driveStartTime = zhiFABean.getStart_time();
            for (SocMilesBasicZhifa socMilesBasicZhifa : socMilesBasicZhifaList) {
                String socCsNumber = socMilesBasicZhifa.getCsNumber();
                String socStartTime = socMilesBasicZhifa.getStartTime();
                if (driveCsNumber.equals(socCsNumber) && driveStartTime.equals(socStartTime)) {
                    int count=socMilesBasicZhifa.getChargeCount();
                    zhiFABean.setChargecount(count);
                }
            }
            //统计每周的数据放入mapDate中
            String beginEndOfWeek = getStartEndOfWeek(driveStartTime);
            if (mapDate.containsKey(beginEndOfWeek)) {
                mapDate.get(beginEndOfWeek).add(zhiFABean);
            } else {
                List<ZhiFABean> zhiFABeanList = new ArrayList<>();
                zhiFABeanList.add(zhiFABean);
                mapDate.put(beginEndOfWeek, zhiFABeanList);
            }
            //
            String sortKey = beginEndOfWeek + "~" + driveCsNumber;
            if (sortMap.containsKey(sortKey)) {
                sortMap.get(sortKey).add(zhiFABean.getChanged_miles());
            } else {
                List<Float> floatList = new ArrayList<>();
                floatList.add(zhiFABean.getChanged_miles());
                sortMap.put(sortKey, floatList);
            }
        }
        //一周内里程的排序
        for (String weekkey : mapDate.keySet()) {

            List<ZhiFABean> listZhiFaBean = mapDate.get(weekkey);
            Map<String, List<Float>> map = new HashMap<>();
            for (ZhiFABean zhiFABean : listZhiFaBean) {
                String sortKey = weekkey + "~" + zhiFABean.getCs_number();
                float maxValue = Collections.max(sortMap.get(sortKey));
                float minValue = Collections.min(sortMap.get(sortKey));
                if (zhiFABean.getChanged_miles() == maxValue) {
                    zhiFABean.setFlag("波峰");//波峰
                } else if (zhiFABean.getChanged_miles() == minValue) {
                    zhiFABean.setFlag("波谷");//波谷
                }
            }
            ZhiFABean kongFABean = new ZhiFABean();
            kongFABean.setCsc_car_no("kong");
            mapDate.get(weekkey).add(kongFABean);
            //
            ZhiFABean kongFABean2 = new ZhiFABean();
            kongFABean2.setCsc_car_no("一周内未使用的车辆");
            mapDate.get(weekkey).add(kongFABean2);
        }
        //csCar所有数中取需要的字段值==一周内未使用的数据
        List<CsCar> csCarsList = csCarMapper.selectByExample(null);
        for (CsCar csCar : csCarsList) {
            String carNo = csCar.getCscCarNo();
            String carCsNumber = csCar.getCscNumber();
            for (String weekkey : mapDate.keySet()) {
                List<ZhiFABean> listZhiFaBean = mapDate.get(weekkey);
                boolean flag = false;
                for (ZhiFABean zhiFABean : listZhiFaBean) {
                    if (zhiFABean != null) {
                        String driveCsNumber = zhiFABean.getCs_number();
                        if (carCsNumber.equals(driveCsNumber)) {//从cs_car中查询到的数据插入到zhifaBean类中，组装数据
                            zhiFABean.setCsc_car_no(csCar.getCscCarNo());
                            zhiFABean.setCsc_code(csCar.getCscCode());
                            int csc_model = csCar.getCscModel();
                            if (csc_model == 1 || csc_model == 2) {
                                zhiFABean.setCsc_model("电动车");
                            } else {
                                zhiFABean.setCsc_model("油车");
                            }
                            flag = true;
                        }
                    }
                }
                if (!flag) {
                    ZhiFABean zhiFABean = new ZhiFABean();

                    zhiFABean.setCsc_car_no(csCar.getCscCarNo());
                    zhiFABean.setCsc_code(csCar.getCscCode());

                    int csc_model = csCar.getCscModel();
                    if (csc_model == 1 || csc_model == 2) {
                        zhiFABean.setCsc_model("电动车");
                    } else {
                        zhiFABean.setCsc_model("油车");
                    }
                    mapDate.get(weekkey).add(zhiFABean);
                }
            }
        }
        return mapDate;
    }


    public static String getStartEndOfWeek(String date){

        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
            Calendar cal = Calendar.getInstance();
            Date time=sdf.parse(date);
            cal.setTime(time);
            //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
            if(1 == dayWeek) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
            }
            cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
            int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
            cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
            String start=sdf.format(cal.getTime());
            //
            cal.add(Calendar.DATE, 6);
            //
            String end=sdf.format(cal.getTime());
            return start+"~"+end;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    ////获取指定时间范围内的所有汽车状态数据
    public   Map<String,List<Vehicle_zhifa>> getZhiFaCarStateMap(String start_time, String end_time) {

//        //获取历史状态数据cs_history_state
//        CsHistoryStateExample example=new CsHistoryStateExample();
//        CsHistoryStateExample.Criteria criteria=example.createCriteria();
//        criteria.andCsHsAddTimeGreaterThanOrEqualTo(start_time);
//        criteria.andCsHsAddTimeLessThanOrEqualTo(end_time);
//        example.setOrderByClause("cshs_number,cshs_add_time asc");
//        List<CsHistoryState>  csHistoryStateList= csHistoryStateMapper.selectByExample(example);
//        Vehicle_zhifa vehicle_zhifa = null;
//        Map<String,List<Vehicle_zhifa>> vehicle_map = new HashMap<>();
//
//        for (CsHistoryState csHistoryState:csHistoryStateList){
//             String cs_number=csHistoryState.getCsHsNumber();
//             float speed= csHistoryState.getCsHsSpeed();
//             int soc=csHistoryState.getCsHsEvBattery();
//             double latitude=csHistoryState.getCsHsLatitude();
//             double longitude=csHistoryState.getCsHsLongitude();
//             String add_time =csHistoryState.getCsHsAddTime();
//
//
//            vehicle_zhifa = new Vehicle_zhifa();
//            vehicle_zhifa.setCs_number(cs_number);
//            vehicle_zhifa.setSoc(soc);
//            vehicle_zhifa.setSpeed(speed);
//            vehicle_zhifa.setLongitude(longitude);
//            vehicle_zhifa.setLatitude(latitude);
//            vehicle_zhifa.setAdd_time(add_time);
//            if(vehicle_map.containsKey(cs_number)){
//                List<Vehicle_zhifa>  Vehicle_zhifa_list= vehicle_map.get(cs_number);
//                Vehicle_zhifa_list.add(vehicle_zhifa);
//            }
//            else{
//                List<Vehicle_zhifa>  Vehicle_zhifa_list= new ArrayList<>();
//                Vehicle_zhifa_list.add(vehicle_zhifa);
//                vehicle_map.put(cs_number,Vehicle_zhifa_list);
//            }
//        }
        Map<String,List<Vehicle_zhifa>> vehicle_map = new HashMap<>();
        try{
            String sql = " select a.cshs_number,a.cshs_add_time,cshs_speed,cshs_ev_battery,cshs_longitude,cshs_latitude from ccclubs_cg_platform.cs_history_state a where a.cshs_add_time>='%s' and a.cshs_add_time<='%s' order by a.cshs_number,a.cshs_add_time asc ";
            sql = String.format(sql,start_time,end_time);
//            DBHelper dbHelper=new DBHelper();
            dbHelper.getDBConnect();
            JSONArray array = dbHelper.queryRecords(sql);
            Vehicle_zhifa vehicle_zhifa = null;
            for(Object object:array){
                JSONObject jsonObject = (JSONObject)object;
                //车机号
                String cs_number = jsonObject.getString("cshs_number");
                //车速
                float speed = 0;
                try {
                    speed = Float.parseFloat(jsonObject.getString("cshs_speed"));
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                //电量
                int soc=0;
                try {
                    soc = Integer.parseInt(jsonObject.getString("cshs_ev_battery"));
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                //经度
                double longitude=0.000000d;
                try {
                    longitude = Double.parseDouble(jsonObject.getString("cshs_longitude"));
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                //纬度
                double latitude=0.000000d;
                try {
                    latitude = Double.parseDouble(jsonObject.getString("cshs_latitude"));
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                //发生时间
                String add_time = jsonObject.getString("cshs_add_time");

                vehicle_zhifa = new Vehicle_zhifa();
                vehicle_zhifa.setCs_number(cs_number);
                vehicle_zhifa.setSoc(soc);
                vehicle_zhifa.setSpeed(speed);
                vehicle_zhifa.setLongitude(longitude);
                vehicle_zhifa.setLatitude(latitude);
                vehicle_zhifa.setAdd_time(add_time);
                if(vehicle_map.containsKey(cs_number)){
                    List<Vehicle_zhifa>  Vehicle_zhifa_list= vehicle_map.get(cs_number);
                    Vehicle_zhifa_list.add(vehicle_zhifa);
                }
                else{
                    List<Vehicle_zhifa>  Vehicle_zhifa_list= new ArrayList<>();
                    Vehicle_zhifa_list.add(vehicle_zhifa);
                    vehicle_map.put(cs_number,Vehicle_zhifa_list);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return vehicle_map;
    }

    //驾驶阶段计算
    public List<DriveMilesBasicZhifa> calDrivePaceList(Map<Long,PaceBlock> blockMap, List<Vehicle_zhifa> vehicle_zhifa_list){
        List<DriveMilesBasicZhifa> drivePaceList = new ArrayList<>();
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
                    DriveMilesBasicZhifa drivePace = createNewDrivePace(tempList);
                    tempList=new ArrayList<>();
                    if(drivePace!=null){
                        //如果行驶里程大于0.5公里
                        if(drivePace.getChangedMiles()>=0.5){
                            drivePaceList.add(drivePace);
                        }
                    }
                }
                tempList.add(paceBlock);
            }
            //不是驾驶状态
            else{
                DriveMilesBasicZhifa drivePace = createNewDrivePace(tempList);
                tempList=new ArrayList<>();
                //创建新阶段
                if(drivePace!=null){
                    //如果行驶里程大于0.5公里
                    if(drivePace.getChangedMiles()>=0.5){
                        drivePaceList.add(drivePace);
                    }
                }
            }
        }

        return drivePaceList;
    }
    //计算当前记录距离缓存序列最后一条记录的间隔时间
    private long calIntervalTimeMills(PaceBlock currentPaceBlock, List<PaceBlock> tempList){
        long timeMills=0;
        if(tempList!=null&&tempList.size()>0){
            PaceBlock paceBlock = tempList.get(tempList.size()-1);
            timeMills=currentPaceBlock.getBlock_start_timemills()-paceBlock.getBlock_end_timemills();
        }
        return timeMills;
    }

    //生成驾驶阶段
    private DriveMilesBasicZhifa createNewDrivePace(List<PaceBlock> tempList){
        DriveMilesBasicZhifa drivePace = null;
        if(tempList!=null&&tempList.size()>0){
            drivePace = new DriveMilesBasicZhifa();
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

            drivePace.setCsNumber(cs_number);
            drivePace.setStartTime(pace_start_time);
            drivePace.setEndTime(pace_end_time);
            drivePace.setPaceTimemills(pace_timemills);
            drivePace.setChangedMiles(pace_miles);
        }
        return drivePace;
    }


    //充电阶段计算
    public List<SocMilesBasicZhifa> calSocPaceList(Map<Long,PaceBlock> blockMap, List<Vehicle_zhifa> vehicle_zhifa_list){
        List<SocMilesBasicZhifa> socPaceList = new ArrayList<>();

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
                    SocMilesBasicZhifa socPace = createNewSocPace(tempList);
                    tempList=new ArrayList<>();
                    if(socPace!=null){
                        //如果充电电量百分比大于1
                        if(socPace.getChangedSoc()>1){
                            socPaceList.add(socPace);
                        }
                    }
                }
                tempList.add(paceBlock);
            }
            //不是驾驶状态
            else{
                SocMilesBasicZhifa socPace = createNewSocPace(tempList);
                tempList=new ArrayList<>();
                //创建新阶段
                if(socPace!=null){
                    //如果充电电量百分比大于1
                    if(socPace.getChangedSoc()>1){
                        socPaceList.add(socPace);
                    }
                }
            }
        }

        return socPaceList;
    }

    //生成充电阶段
    private SocMilesBasicZhifa createNewSocPace(List<PaceBlock> tempList){
        SocMilesBasicZhifa socPace = null;
        if(tempList!=null&&tempList.size()>0){
            socPace = new SocMilesBasicZhifa();
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

            socPace.setCsNumber(cs_number);
            socPace.setStartTime(pace_start_time);
            socPace.setEndTime(pace_end_time);
            socPace.setPaceTimemills(pace_timemills);
            socPace.setStartSoc(pace_start_soc);
            socPace.setEndSoc(pace_end_soc);
            socPace.setChangedSoc(pace_changed_soc);
        }
        return socPace;
    }
}
