package com.ccclubs.upgrade.srv.event;

import com.ccclubs.upgrade.dto.UpgradeInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

/**
 * 升级处理事件
 *
 * @author jianghaiyang
 * @create 2017-08-15
 **/
public class UpgradeProcessEvent extends ApplicationEvent {

    private static final Logger logger = LoggerFactory.getLogger(UpgradeProcessEvent.class);

    private UpgradeInput input;

    public UpgradeProcessEvent(UpgradeInput input) {
        super(input);
        this.input = input;
    }

    public UpgradeInput getInput() {
        return input;
    }

    public void setInput(UpgradeInput input) {
        this.input = input;
    }

    public void process() {
        logger.info("begin process upgrade request of {}.", input.getVin());
    }
}
