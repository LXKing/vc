package com.ccclubs.quota.thread;

import com.ccclubs.quota.inf.CsMiddleReportInf;
import com.ccclubs.quota.orm.mapper.CsIndexReportMapper;
        import com.ccclubs.quota.orm.mapper.CsMiddleReportMapper;
        import com.ccclubs.quota.orm.model.CsIndexReport;
        import com.ccclubs.quota.orm.model.CsMiddleReport;
        import com.ccclubs.quota.orm.model.CsMiddleReportExample;
        import com.ccclubs.quota.util.DBHelperZt;
        import com.ccclubs.quota.util.DateTimeUtil;
import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
        import java.util.*;

/**
 * Created by Administrator on 2018/1/3 0003.
 */

@Component
public class ReportMiddleThreadZt {

    private static Logger logger = LoggerFactory.getLogger(ReportMiddleThreadZt.class);

    @Autowired
    private CsMiddleReportInf csMiddleReportInf;

    /**
     * 国补指标统计数据（T+1模式）
     */
    @Scheduled(cron="${zt.threadInterval}")
    @Transactional(rollbackFor={RuntimeException.class,Exception.class})
    public void scheduleThread(){
        //更新指标中间表
        csMiddleReportInf.triggerMiddleReport();
    }
}
