//package com.ccclubs.quota.thread;
//
//import com.ccclubs.quota.orm.mapper.CsIndexReportMapper;
//import com.ccclubs.quota.orm.mapper.CsMiddleReportMapper;
//import com.ccclubs.quota.orm.model.CsIndexReport;
//import com.ccclubs.quota.orm.model.CsMiddleReport;
//import com.ccclubs.quota.orm.model.CsMiddleReportExample;
//import com.ccclubs.quota.util.DBHelperZt;
//import com.ccclubs.quota.util.DateTimeUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.util.*;
//
///**
// * Created by Administrator on 2018/1/3 0003.
// */
//
//@Component
//public class ReportMiddleThreadZt {
//
//    @Autowired
//    private DBHelperZt dbHelperZt;
//
//    @Autowired
//    private CsMiddleReportMapper csMiddleReportMapper;
//    @Autowired
//    private CsIndexReportMapper csIndexReportMapper;
//
//
//
//
//    public void scheduleThread(){
//        CsMiddleReportExample example=new CsMiddleReportExample();
//        CsMiddleReportExample.Criteria criteria=example.createCriteria();
//        criteria.andCsmrStatusEqualTo((short)2);//获取最新添加的数据
//        List<CsMiddleReport> middleList= csMiddleReportMapper.selectByExample(example);
//        //
//        Map<String,CsMiddleReport> oldMiddleMap=new HashMap<>();
//        for(CsMiddleReport csMiddleReport:middleList){
//            String key=csMiddleReport.getCsmrVin()+"-"+csMiddleReport.getCsmrNumber();
//            oldMiddleMap.put(key,csMiddleReport);
//        }
//        //
//        dbHelperZt.getDBConnect();
//        List<Map<String,Object>> currentList=dbHelperZt.getMiddleReportData();
//        dbHelperZt.dbClose();
//        //更新中间报表状态车机条件
//        List<String>numberList=new ArrayList<>();
//        //
//        if (currentList!=null&&currentList.size()>0){
//            List<CsMiddleReport> dataList=new ArrayList<>();
//            CsMiddleReport csMiddleReport=null;
//            for (Map map:currentList){
//                csMiddleReport=new CsMiddleReport();
//                String csmrVin=map.get("csmrVin").toString();
//                String csmrNumber=map.get("csmrNumber").toString();
//                String csmrCarNo=null;
//                if(map.get("csmrCarNo")!=null){
//                    csmrCarNo =map.get("csmrCarNo").toString();
//                }
//                Integer csmrModel=Integer.parseInt(map.get("csmrModel").toString());
//                //判断obd数据
//                BigDecimal csmrObdMile=new BigDecimal(map.get("csmrObdMile").toString());
//
//                //找出最新对应的obdMile里程
//                BigDecimal oldObdMile=new BigDecimal(0)  ;
//                CsMiddleReport oldVinMap= oldMiddleMap.get(csmrVin+"-"+csmrNumber);
//                if(oldVinMap!=null){
//                        String oldVin=oldVinMap.getCsmrVin();
//                        String oldNumber=oldVinMap.getCsmrNumber();
//                        if(csmrVin.equals(oldVin)&&csmrNumber.equals(oldNumber)){
//                            oldObdMile=oldVinMap.getCsmrObdMile();
//                        }
//
//                }
//                BigDecimal csmrExceptionMile=null;
//                Short   csmrMileState=2;
//                if(csmrObdMile.compareTo(oldObdMile)==-1){
//                    csmrObdMile=oldObdMile;
//                    csmrExceptionMile=csmrObdMile;
//                    csmrMileState=1;
//                }
//                Short csmrDomain=Short.parseShort(map.get("csmrDomain").toString());
//                //
//                Date csmrProdTime=null;
//                if(map.get("csmrProdTime")!=null){
//                    csmrProdTime= DateTimeUtil.getStringToDate(map.get("csmrProdTime").toString());
//                }
//                //
//                csMiddleReport.setCsmrVin(csmrVin);
//                csMiddleReport.setCsmrNumber(csmrNumber);
//                csMiddleReport.setCsmrCarNo(csmrCarNo);
//                csMiddleReport.setCsmrModel(csmrModel);
//                //
//                csMiddleReport.setCsmrObdMile(csmrObdMile);
//                csMiddleReport.setCsmrExceptionMile(csmrExceptionMile);
//                csMiddleReport.setCsmrMileState(csmrMileState);
//                csMiddleReport.setCsmrStatus((short) 2);
//                csMiddleReport.setCsmrDomain(csmrDomain);
//                csMiddleReport.setCsmrAddTime(new Date());
//                csMiddleReport.setCsmrProdTime(csmrProdTime);
//                csMiddleReport.setCsmrSaleTime(csmrProdTime);
//                dataList.add(csMiddleReport);
//                numberList.add(csmrNumber);
//            }
//            // 假如vinList=中数据不为空，更新数据
//            if(!numberList.isEmpty()){
//                CsMiddleReport record=new CsMiddleReport();
//                record.setCsmrStatus((short)1);
//                //
//                example=new CsMiddleReportExample();
//                criteria=example.createCriteria();
//                criteria.andCsmrStatusEqualTo((short)2).andCsmrNumberIn(numberList);//获取最新添加的数据
//                csMiddleReportMapper.updateByExampleSelective(csMiddleReport,example);
//            }
//            //往中间报表（cs_middle_report）添加数据
//            csMiddleReportMapper.insertBatchSelective(dataList);
//            //更新众泰指标表中的数据
////            updateReportData();
//        }
//    }
//
//    /**
//     * 1.向众泰表更新数据
//     * 1)先统计数据-2)清数据-3)添加
//     */
////    @Scheduled(cron = "0 0/1 * * * ?")
//    public void updateReportData(){
//        CsMiddleReportExample example=new CsMiddleReportExample();
//        CsMiddleReportExample.Criteria criteria=example.createCriteria();
//        criteria.andCsmrStatusEqualTo((short)2);//获取最新添加的数据
//        example.setOrderByClause("csmr_vin");
//        List<CsMiddleReport> middleList= csMiddleReportMapper.selectByExample(example);
//        //把待统计的数据归类
//        Map<String,List<CsMiddleReport>>middleTemp=new HashMap<>();
//        for (CsMiddleReport csMiddleReport:middleList){
//            String csmrVin=csMiddleReport.getCsmrVin();
//            if(middleTemp.containsKey(csmrVin)){
//                middleTemp.get(csmrVin).add(csMiddleReport);
//            }else{
//                List<CsMiddleReport> list=new ArrayList<>();
//                list.add(csMiddleReport);
//                middleTemp.put(csmrVin,list);
//            }
//        }
//        //数据统计
//        List<CsIndexReport> insertData=new ArrayList<>();
//        CsIndexReport csIndexReport=null;
//        for (String key : middleTemp.keySet()){
//            middleList=middleTemp.get(key);
//            //
//            String csVinTemp=middleList.get(0).getCsmrVin();
//            String csNumberTemp=middleList.get(0).getCsmrNumber();
//            BigDecimal  mileTemp=middleList.get(0).getCsmrObdMile();
//            Date csAddTimeTemp=middleList.get(0).getCsmrAddTime();
//            Date csProdTimeTemp=middleList.get(0).getCsmrProdTime();
//
//            for (int i=1;i<middleList.size();i++){
//                String csVin=middleList.get(i).getCsmrVin();
//                String csNumber=middleList.get(i).getCsmrNumber();
//                BigDecimal  mile=middleList.get(i).getCsmrObdMile();
//                Date csAddTime=middleList.get(i).getCsmrAddTime();
//                Date csProdTime=middleList.get(i).getCsmrProdTime();
//                //vin码相同，里程相加
//                if(csVinTemp.equals(csVin)){
//                    mileTemp=mileTemp.add(mile);
//                    //通过时间判断当前vin码绑定的车机号
//                    if(csAddTimeTemp.getTime()<csAddTime.getTime()){
//                        csNumberTemp=csNumber;
//                        csAddTimeTemp=csProdTime;
//                        csProdTimeTemp=csProdTime;
//                    }
//                }
//            }
//            csIndexReport=new CsIndexReport();
//            csIndexReport.setCsVin(csVinTemp);
//            csIndexReport.setCsNumber(csNumberTemp);
//            //月均行驶里程
//            BigDecimal monthlyAvgMile = dbHelperZt.getObdByMonth(csProdTimeTemp, new Date(), mileTemp.intValue());
//            csIndexReport.setMonthlyAvgMile(monthlyAvgMile);
//            //平均单日运行时间
//            BigDecimal avgDriveTimePerDay = dbHelperZt.getAvgDriveTimePerDay(mileTemp.intValue());
//            csIndexReport.setAvgDriveTimePerDay(avgDriveTimePerDay);
//            //纯电行驶里程
//            BigDecimal electricRange = dbHelperZt.getElectricRange();
//            csIndexReport.setElectricRange(electricRange);
//            // 百公里耗电量
//            BigDecimal powerConsumePerHundred = dbHelperZt.getPowerConsumePerHundred(electricRange);
//            csIndexReport.setPowerConsumePerHundred(powerConsumePerHundred);
//            //累计充电量
//            BigDecimal cumulativeCharge =  dbHelperZt.getCumulativeCharge(mileTemp.intValue(), powerConsumePerHundred);
//            csIndexReport.setCumulativeCharge(cumulativeCharge);
//            //车辆一次充满电所用最少时间
//            BigDecimal minChargeTime =  dbHelperZt.getMinChargeTime();
//            csIndexReport.setMinChargeTime(minChargeTime);
//            //最大充电功率
//            BigDecimal maxChargePower =  dbHelperZt.getMaxChargePower();
//            csIndexReport.setMaxChargePower(maxChargePower);
//            //累计行驶里程
//            csIndexReport.setCumulativeMileage(mileTemp);
//            csIndexReport.setModifyDate(new Date());
//            csIndexReport.setFacTime(csProdTimeTemp);
//            insertData.add(csIndexReport);
//        }
//        //更新cs_index_report中数据
//        if(insertData!=null&&!insertData.isEmpty()){
//            csIndexReportMapper.deleteByExample(null);
//            csIndexReportMapper.insertBatch(insertData);
//        }
//    }
//
//}
