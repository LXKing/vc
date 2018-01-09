package com.ccclubs.admin.service.impl;

import com.ccclubs.admin.service.IGbCsStateService;
import com.ccclubs.frm.spring.constant.RedisConst;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.protocol.dto.gb.GBMessage;
import com.ccclubs.protocol.util.Tools;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 国标实时状态
 *
 * @author jianghaiyang
 * @create 2018-01-04
 **/
@Service
public class GbCsStateServiceImpl implements IGbCsStateService {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 分页
     *
     * @param t
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageInfo<GBMessage> getPage(Object t, int page, int rows) {
        int offset = page == 1 ? 0 : (page - 1) * rows;
        List<GBMessage> list = new ArrayList<>();
        Set<String> set = redisTemplate.opsForZSet().reverseRangeByScore(RedisConst.REDIS_KEY_RT_STATES_ZSET, -1, Long.MAX_VALUE, offset, rows);
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            GBMessage gbMessage = new GBMessage();
            String vin = iterator.next();
            gbMessage.ReadFromBytes(Tools.HexString2Bytes((String) redisTemplate.opsForHash().get(RedisConst.REDIS_KEY_RT_STATES_HASH, vin)));
            list.add((gbMessage));
        }
        PageInfo<GBMessage> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(rows);
        pageInfo.setPageNum(page);
        pageInfo.setTotal(redisTemplate.opsForZSet().size(RedisConst.REDIS_KEY_RT_STATES_ZSET));
        pageInfo.setList(list);
        return pageInfo;
    }

    /**
     * 详情
     *
     * @param vin
     * @return
     */
    @Override
    public GBMessage detail(String vin) {
        String hexString = (String) redisTemplate.opsForHash().get(RedisConst.REDIS_KEY_RT_STATES_HASH, vin);
        GBMessage gbMessage = new GBMessage();
        gbMessage.ReadFromBytes(Tools.HexString2Bytes(hexString));
        return gbMessage;
    }
}
