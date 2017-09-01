package com.ccclubs.upgrade.srv;

import com.ccclubs.frm.redis.RedisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

/**
 * 升级服务 start class
 *
 * @author jianghaiyang
 * @create 2017-07-20
 **/
@SpringBootApplication
@ImportAutoConfiguration({RedisAutoConfiguration.class})
//@RefreshScope
//@RestController
@EnableScheduling
public class UpgradeSrvApp extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(UpgradeSrvApp.class);

    /**
     * war打包用，相当于web.xml配置
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UpgradeSrvApp.class);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(UpgradeSrvApp.class, args);
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        for (String p : profiles) {
            logger.info("Env profile:{}", p);
        }
    }

//    @Resource
//    UpgradeService upgradeService;
//
////    @ApiSecurity
//    @PostMapping("upgrade")
//    public ApiMessage upgrade(@RequestHeader("appId") String appId, UpgradeInput input) {
//        input.setAppId(appId);
//        UpgradeOutput output = upgradeService.upgrade(input);
//        return new ApiMessage<>(output);
//    }

}