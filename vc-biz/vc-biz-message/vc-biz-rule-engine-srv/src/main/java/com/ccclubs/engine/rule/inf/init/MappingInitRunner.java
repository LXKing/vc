package com.ccclubs.engine.rule.inf.init;

import com.ccclubs.engine.core.util.MachineMapping;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计数器初始化
 *
 * @author jianghaiyang
 * @create 2017-08-15
 **/
@Component
@Order(1)
public class MappingInitRunner implements CommandLineRunner {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public void run(String... strings) throws Exception {
        String sql = "select cs_machine.csm_number as number,cs_machine.csm_mobile as mobile,cs_machine.csm_id as machine,cs_machine.csm_te_no as teno,cs_machine.csm_access as access,cs_machine.csm_host as host,cs_vehicle.csv_id as car,cs_vehicle.csv_vin as vin,cs_state.css_id as state,cs_can.csc_id as can from cs_machine LEFT JOIN cs_vehicle on cs_vehicle.csv_machine=cs_machine.csm_id LEFT JOIN cs_state on cs_state.css_number=cs_machine.csm_number LEFT JOIN cs_can on cs_can.csc_number=cs_machine.csm_number  where cs_machine.csm_number IS NOT NULL";
        List<MachineMapping> list = jdbcTemplate.query(sql, new Object[]{}, (RowMapper) (rs, rowNum) -> {
            MachineMapping mapping = new MachineMapping();
            mapping.setAccess(rs.getInt("access"));
            mapping.setCan(rs.getLong("can"));
            mapping.setCar(rs.getLong("car"));
            mapping.setHost(rs.getLong("host"));
            mapping.setMachine(rs.getLong("machine"));
            mapping.setMobile(rs.getString("mobile"));
            mapping.setNumber(rs.getString("number"));
            mapping.setState(rs.getLong("state"));
            mapping.setTeno(rs.getString("teno"));
            mapping.setVin(rs.getString("vin"));
            return mapping;
        });

        Map<String, Object> vinMap = new HashMap<>();
        Map<String, Object> simNoMap = new HashMap<>();
        Map<String, Object> carNumMap = new HashMap<>();

        for (MachineMapping rela : list) {
            if (StringUtils.isNotEmpty(rela.getVin())) {
                vinMap.put(rela.getVin(), rela);
            }
            if (StringUtils.isNotEmpty(rela.getMobile())) {
                simNoMap.put(rela.getMobile(), rela);
            }

            carNumMap.put(rela.getNumber(), rela);
        }

        HashOperations hashOps = redisTemplate.opsForHash();
        hashOps.putAll(RuleEngineConstant.REDIS_KEY_VIN, vinMap);
        hashOps.putAll(RuleEngineConstant.REDIS_KEY_SIMNO, simNoMap);
        hashOps.putAll(RuleEngineConstant.REDIS_KEY_CARNUM, carNumMap);

    }
}
