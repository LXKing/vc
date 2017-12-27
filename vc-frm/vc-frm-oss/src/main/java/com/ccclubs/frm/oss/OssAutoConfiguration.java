package com.ccclubs.frm.oss;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableConfigurationProperties(OssProperties.class)
public class OssAutoConfiguration {

    /*@Value("${aliyun.oss.access-key-id}")
    String accessKeyId;
    @Value("${aliyun.oss.access-key-secret}")
    String accessKeySecret;
    @Value("${aliyun.oss.endpoint}")
    String endpoint;*/
    @Autowired
    private OssProperties ossProperties;

    @Bean(name = "ossClient")
    public OSSClient ossClient() {
        return new OSSClient("https://" + ossProperties.getEndpoint(), ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret());
    }

}