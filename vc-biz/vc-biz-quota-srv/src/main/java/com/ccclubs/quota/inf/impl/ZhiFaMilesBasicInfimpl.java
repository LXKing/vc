package com.ccclubs.quota.inf.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.olap.orm.mapper.DriveMilesBasicZhifaMapper;
import com.ccclubs.olap.orm.mapper.SocMilesBasicZhifaMapper;
import com.ccclubs.olap.orm.model.*;
import com.ccclubs.quota.vo.WeekBeanOutput;
import com.ccclubs.quota.inf.ZhiFaMilesBasicInf;
import com.ccclubs.quota.util.DBHelperZf;
import com.ccclubs.quota.util.DateTimeUtil;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
@Service(version = "1.0.0")
public class ZhiFaMilesBasicInfimpl implements ZhiFaMilesBasicInf{

    @Resource
    DriveMilesBasicZhifaMapper driveMilesBasicZhifaMapper;

    @Resource
    SocMilesBasicZhifaMapper socMilesBasicZhifaMapper;

//    @Autowired
//    private DBHelperZf dbHelper;


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
        DBHelperZf dbHelperZf= new DBHelperZf();
        dbHelperZf.getDBConnect();
        List<CsCar> csCarsList =dbHelperZf.getCsCarALL() ;
        dbHelperZf.dbClose();
        //
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



}
