//package com.ccclubs.storage.tasks.runner;
//
//
//import com.ccclubs.storage.inf.BaseHbaseStorageInf;
//import com.ccclubs.storage.tasks.processor.HistoryCanUtils;
//import com.ccclubs.storage.tasks.processor.HistoryMessageUtils;
//import com.ccclubs.storage.tasks.processor.HistoryStateUtils;
//import com.ccclubs.storage.tasks.util.RedisConstant;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//
///**
// * Created with IntelliJ IDEA2017.
// *
// * @Author: Alban
// * @Date: 2018/3/30
// * @Time: 16:00
// * @Description: 此类用于添加BatchHistoryRunner的任务。
// * 这是一个不优雅的类，需要改进。
// */
//
///*@Deprecated
//@Component
//public class InsertToHbaseMap {
//
//    @Autowired
//    HistoryCanUtils historyCanUtils;
//    @Autowired
//    HistoryMessageUtils historyMessageUtils;
//    @Autowired
//    HistoryStateUtils historyStateUtils;
//
//    private final Map<String,BaseHbaseStorageInf> map=new HashMap();
//
//    public InsertToHbaseMap() {
//        map.put(RedisConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_HBASE_QUEUE
//                ,historyMessageUtils);
//        map.put(RedisConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE
//                ,historyCanUtils);
//        map.put(RedisConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE
//                ,historyStateUtils);
//    }
//
//    public Map<String,BaseHbaseStorageInf> getMap(){
//        return map;
//    }
//
//}*/
//
//@Component
//public class InsertToHbaseMap{
//
//    @Autowired
//    HistoryCanUtils historyCanUtils;
//    @Autowired
//    HistoryMessageUtils historyMessageUtils;
//    @Autowired
//    HistoryStateUtils historyStateUtils;
//    private static HashMap<String,BaseHbaseStorageInf> map=null;
//    InsertToHbaseMap() {
//
//    }
//    private synchronized void  initMap(){
//        map=new HashMap<>();
//        map.put(RedisConstant.REDIS_KEY_HISTORY_MESSAGE_BATCH_INSERT_HBASE_QUEUE
//                ,historyMessageUtils);
//        map.put(RedisConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE
//                ,historyCanUtils);
//        map.put(RedisConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE
//                ,historyStateUtils);
//    }
//    public HashMap<String,BaseHbaseStorageInf> getInstance() {
//        synchronized (this){
//            if(map==null){
//                initMap();
//            }
//        }
//        return (HashMap<String,BaseHbaseStorageInf>)map.clone();
//    }
//
//}
