package com.ccclubs.quota.inf;



import com.ccclubs.olap.orm.model.ZhiFABean;
import com.ccclubs.quota.vo.WeekBeanOutput;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public interface ZhiFaMilesBasicInf {

//    //插入驾驶阶段数据
//    void insertDriveMilses(List<DriveMilesBasicZhifa> drivePaceList,String startTime,String endTime);
//
//    //插入充电阶段数据
//    void insertSocMiles(List<SocMilesBasicZhifa> socPaceList,String startTime,String endTime);
    //

    //获取执法数据
    Map<String,List<ZhiFABean>> queryZhiFaData(String startTime,String endTime);
    // 获取每周的时间
    List<WeekBeanOutput> getWeekCount();

}
