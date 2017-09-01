package com.ccclubs.upgrade.srv.event;

import com.ccclubs.upgrade.dto.UpgradeInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

import java.util.Date;

/**
 * 升级成功事件
 *
 * @author jianghaiyang
 * @create 2017-08-15
 **/
public class UpgradeSuccessEvent extends ApplicationEvent {
    private static final Logger logger = LoggerFactory.getLogger(UpgradeProcessEvent.class);

    private UpgradeInput input;

    public UpgradeSuccessEvent(UpgradeInput input) {
        super(input);
        this.input = input;
    }

    public UpgradeInput getInput() {
        return input;
    }

    public void setInput(UpgradeInput input) {
        this.input = input;
    }

    public void success() {
        logger.info("upgrade request of {} succeed at {}.", input.getVin(), new Date(this.getTimestamp()));
    }
}
