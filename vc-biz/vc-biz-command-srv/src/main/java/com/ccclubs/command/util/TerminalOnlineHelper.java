package com.ccclubs.command.util;

import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.protocol.util.ConstantUtils;
import com.ccclubs.pub.orm.model.CsMachine;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 下发车辆控制指令前，先检查一下终端是否在线 目前区分808协议 {@link com.ccclubs.protocol.util.ConstantUtils.ONLINE_REDIS_PRE}+SIM卡号，MQTT协议
 * {@link com.ccclubs.protocol.util.ConstantUtils.ONLINE_REDIS_PRE} + 车机号 TODO:后续添加国标协议
 *
 * @author qsxiaogang
 * @create 2018-01-03
 **/
@Component
public class TerminalOnlineHelper {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 判断终端是否在线，主要用于控制指令下发
     */
    public boolean isOnline(CsMachine csMachine) {
        if (null == csMachine) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_FOUND);
        }

        int protocol = null == csMachine.getCsmProtocol() ? -1 : csMachine.getCsmProtocol().intValue();
        boolean isOnline = true;
        switch (protocol) {
            case 1:
                isOnline = (null != redisTemplate.opsForValue()
                        .get(ConstantUtils.ONLINE_REDIS_PRE + csMachine.getCsmNumber()));
                break;
            case 2:
                isOnline = (null != redisTemplate.opsForValue()
                        .get(ConstantUtils.ONLINE_REDIS_PRE + csMachine.getCsmMobile()));
                break;
            default:
                break;
        }
        if (!isOnline) {
            throw new ApiException(ApiEnum.TERMINAL_NOT_ONLINE);
        }
        return isOnline;
    }

}
