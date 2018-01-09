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
        if(redisTemplate.opsForZSet().size(RedisConst.REDIS_KEY_RT_STATES_ZSET)<3) {
            redisTemplate.opsForHash().put(RedisConst.REDIS_KEY_RT_STATES_HASH, "LJ8E3C1MXGB008909",
                "232302FE4C4A38453343314D5847423030383930390101151201080A083301010301006E00003BC00CD027153A011E03400012020101FF3850D4000036000027060500073C465801B16B3A0601310EA101240E89010800010800070000000000000000000801010CD0271500580001580E950E970E9D0E8F0E980E950E980E9A0E950E970E920E970E950E950E940E8B0E920E910E8F0E8C0E920E950E970E940E970E940E970E8E0E8E0E920E890E8E0E940E8F0E8F0E890E8B0E910E910E9A0E9B0E980E980E950E9E0E9E0E9B0EA00EA10E9E0E9E0E9D0E920E9A0E910E9A0E9B0E9A0E980E920E9A0E980E9B0E8F0E980E950E950E950E9A0E980E980E970E970E9A0E970E940E8F0E940E910E940E8F0E910E940E940E980E8E0E950E8C09010100080000000000000000B9");
            redisTemplate.opsForZSet().add(RedisConst.REDIS_KEY_RT_STATES_ZSET, "LJ8E3C1MXGB008909",
                DateTimeUtil
                    .date2UnixFormat("2018-01-08 11:17",
                        DateTimeUtil.UNIX_FORMAT));

            redisTemplate.opsForHash().put(RedisConst.REDIS_KEY_RT_STATES_HASH, "LJ8E3C1M8GB009931",
                "232302FE4C4A38453343314D3847423030393933310100251201080A08090102030100000000151D0C92271A33011F0445004D05000700D828024F29D548");
            redisTemplate.opsForZSet().add(RedisConst.REDIS_KEY_RT_STATES_ZSET, "LJ8E3C1M8GB009931",
                DateTimeUtil
                    .date2UnixFormat("2018-01-08 11:17",
                        DateTimeUtil.UNIX_FORMAT));
            redisTemplate.opsForHash().put(RedisConst.REDIS_KEY_RT_STATES_HASH, "LA91TY3NXHTPLT001",
                "232302FE4C4139315459334E584854504C5430303101011B1201080F2C00010103010000000006BF0D4227153E01100199006402010103344E204E20370D7927100500072839B801B9365D0601130ED301170EC4010A2F01042E070000000000000000000801010D422715005A00015A0EC80ECA0EC80ECA0ECA0ECB0EC80ECA0EC80ECB0EC80ECA0EC50EC70EC50EC50EC80EC50ED30EC50EC70EC50EC40EC50ECB0ECA0ECB0ECB0ECA0EC70EC80ECA0EC80EC70EC80ECA0EC80EC70ECA0EC80EC80EC80EC80EC70EC80EC50EC50EC80EC80EC50EC80ECA0EC70EC80EC80ECA0EC80EC70EC80ECA0EC70EC80ECA0ECA0EC70EC80EC80EC80ECB0EC80ECA0ECA0ECB0EC80EC80ECA0ECA0EC80EC80EC80ECB0ECB0ECA0ECA0EC80ECA0EC70EC70EC80EC5090101000A2E2F2F2E2F2F2F2F2F2FC8");
            redisTemplate.opsForZSet().add(RedisConst.REDIS_KEY_RT_STATES_ZSET, "LA91TY3NXHTPLT001",
                DateTimeUtil
                    .date2UnixFormat("2018-01-08 11:17",
                        DateTimeUtil.UNIX_FORMAT));
        }

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
