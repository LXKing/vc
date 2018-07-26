package com.ccclubs.admin.task.jobs;

import com.ccclubs.admin.model.CsMachine;
import com.ccclubs.admin.model.VerSoftHardware;
import com.ccclubs.admin.model.VerUpgrade;
import com.ccclubs.admin.model.VerUpgradeRecord;
import com.ccclubs.admin.service.ICsMachineService;
import com.ccclubs.admin.service.IVerSoftHardwareService;
import com.ccclubs.admin.service.IVerUpgradeRecordService;
import com.ccclubs.admin.service.IVerUpgradeService;
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

    @Autowired
    private IVerUpgradeService verUpgradeService;

    @Autowired
    private IVerSoftHardwareService verSoftHardwareService;

    @Autowired
    private ICsMachineService csMachineService;

    @Override
    public void run() {
        /**
         * 查询出所有升级中的记录
         */
        VerUpgradeRecord queryAll = new VerUpgradeRecord();
        queryAll.setstatus((short)1);
        List<VerUpgradeRecord> upgradingRecords = verUpgradeRecordService.select(queryAll);
        if (Objects.nonNull(upgradingRecords) && upgradingRecords.size() > 0) {
            /**
             * 对于升级中的任务，检查升级是否已完成，完成则标记升级状态为：升级完成
             * 未完成检查是否超时，超时则升级失败
             */
            upgradingRecords.forEach(record -> {
                // 查询目标升级版本
                VerUpgrade destVersion = verUpgradeService.selectByPrimaryKey(record.getToVersion());
                if (Objects.nonNull(destVersion) && Objects.nonNull(destVersion.getSoftVerId())) {
                    // 获取目标版本中的插件版本信息
                    VerSoftHardware softHardware = verSoftHardwareService.selectByPrimaryKey(destVersion.getSoftVerId());
                    if (Objects.nonNull(softHardware) && Objects.nonNull(softHardware.getVerNo())) {
                        // 目标版本的插件版本号
                        String destPluginVerNo = softHardware.getVerNo();

                        /**
                         * 查询当前车机信息
                         */
                        CsMachine machineQuery = new CsMachine();
                        machineQuery.setCsmTeType(record.getTeType());
                        machineQuery.setCsmTeNo(record.getTeNumber());
                        CsMachine currMachine = csMachineService.selectOne(machineQuery);
                        if (Objects.nonNull(currMachine) && Objects.nonNull(currMachine.getCsmTlV2())) {
                            /**
                             * 如果当前车机的插件版本与目标升级版本中的插件版本相同，则认为升级完成
                             */
                            if (String.valueOf(currMachine.getCsmTlV2()).equals(destPluginVerNo)) {
                                // 升级完成
                                updateUpgradeStatus(record.getid(), true);
                                return;
                            }
                        }
                    }
                }

                /**
                 * 即使前一步有些参数没有查询到，判断如果超时，则仍标记为升级失败
                 */
                if (isTimeout(record)) {
                    updateUpgradeStatus(record.getid(), false);
                    return;
                }
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

    private int updateUpgradeStatus(Integer id, Boolean isSuccess) {
        VerUpgradeRecord updateParam = new VerUpgradeRecord();
        updateParam.setid(id);
        updateParam.setUpdateTime(new Date());
        // 更新升级状态
        if (isSuccess) {
            updateParam.setstatus((short) 2);
        } else {
            updateParam.setstatus((short) 3);
        }
        return verUpgradeRecordService.updateByPrimaryKeySelective(updateParam);
    }

    public static void main(String[] args) throws Exception{
        VerUpgradeRecord record = new VerUpgradeRecord();
        record.setAddTime(new Date());

        TimeUnit.SECONDS.sleep(1);


        System.out.println(new VerUpgradeTimeoutCheckJob().isTimeout(record));
    }
}
