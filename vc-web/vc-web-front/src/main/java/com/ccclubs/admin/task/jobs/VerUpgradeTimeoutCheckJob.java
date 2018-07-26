package com.ccclubs.admin.task.jobs;

import com.ccclubs.admin.model.VerUpgradeRecord;
import com.ccclubs.admin.service.IVerUpgradeRecordService;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author: yeanzi
 * @Date: 2018/7/26
 * @Time: 15:19
 * Email:  yeanzhi@ccclubs.com
 * 车机升级超时检查
 *      超时时：标记为升级状态为升级失败
 */
@Component
public class VerUpgradeTimeoutCheckJob implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(VerUpgradeTimeoutCheckJob.class);

    /**
     * 升级超时时间（10分钟）
     */
    private static final int UPGRADE_TIMEOUT_MINUTE = 10;

    @Autowired
    private IVerUpgradeRecordService verUpgradeRecordService;

    @Override
    public void run() {
        VerUpgradeRecord queryAll = new VerUpgradeRecord();
        queryAll.setstatus((short)1);
        List<VerUpgradeRecord> upgradingRecords = verUpgradeRecordService.select(queryAll);
        if (Objects.nonNull(upgradingRecords) && upgradingRecords.size() > 0) {
            Date now = new Date();
            /**
             * 筛选出所有超时任务
             */
            upgradingRecords = upgradingRecords.stream().filter(this::isTimeout).collect(Collectors.toList());
            upgradingRecords.forEach(r -> {
                VerUpgradeRecord updateParam = new VerUpgradeRecord();
                updateParam.setUpdateTime(now);
                // 更新为升级失败
                updateParam.setstatus((short) 3);
                int updateCount = verUpgradeRecordService.updateByPrimaryKeySelective(updateParam);
            });
        }
    }

    /**
     * 判断当前版本升级是否超时
     * @param record
     * @return
     */
    private boolean isTimeout(VerUpgradeRecord record) {
        Date addTime = record.getAddTime();
        if (Objects.nonNull(addTime)) {
            DateTime dateTime = new DateTime(addTime);
            /**
             * 与添加时间10分钟后比较
             */
            dateTime = dateTime.plusMinutes(UPGRADE_TIMEOUT_MINUTE);
            LocalDateTime recordDateTime = dateTime.toLocalDateTime();

            LocalDateTime nowTime = LocalDateTime.now();
            if (nowTime.compareTo(recordDateTime) > 0) {
                return true;
            }
        } else {
            LOG.error("param [addTime] is null while check upgrade timeout: id={}", record.getid());
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        VerUpgradeRecord record = new VerUpgradeRecord();
        record.setAddTime(new Date());

        TimeUnit.SECONDS.sleep(1);


        System.out.println(new VerUpgradeTimeoutCheckJob().isTimeout(record));
    }
}
