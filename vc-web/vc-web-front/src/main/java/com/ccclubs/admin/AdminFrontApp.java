package com.ccclubs.admin;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.ccclubs.frm.ons.OnsProperties;
import com.ccclubs.frm.oss.OssAutoConfiguration;
import com.ccclubs.frm.redis.RedisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * 后台页面
 *
 * @author jianghaiyang
 * @create 2017-09-15
 **/
@SpringBootApplication(scanBasePackages = "com.ccclubs")
@Import({RedisAutoConfiguration.class, OssAutoConfiguration.class})
public class AdminFrontApp extends SpringBootServletInitializer {

    /**
     * war打包用，相当于web.xml配置
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminFrontApp.class);
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AdminFrontApp.class);
        springApplication.addListeners(new AppContext());
        springApplication.run(args);
    }

    @Resource
    private OnsProperties onsProperties;

    @Bean(name = "onsPublishClient", initMethod = "start", destroyMethod = "shutdown")
    public Producer getProducer() {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ProducerId, onsProperties.getProducerId());
        properties.put(PropertyKeyConst.AccessKey, onsProperties.getAccessKey());
        properties.put(PropertyKeyConst.SecretKey, onsProperties.getSecretKey());
        return ONSFactory.createProducer(properties);
    }
}