package com.ccclubs.report.main.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.ccclubs.report.constant.ConsumerProps;
import com.ccclubs.report.service.listener.TianJingReportListener;

@Configuration
@EnableKafka
@EnableConfigurationProperties(ConsumerProps.class)
public class KafkaConfig {
    @Autowired
    private ConsumerProps props;

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        // factory.setConcurrency(concurrency);
        factory.getContainerProperties().setPollTimeout(1500);
        return factory;
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    public Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, props.getBootstrapServers());
        /*
         * propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
         * propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,
         * autoCommitInterval); propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,
         * sessionTimeout);
         */
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, props.getKeySerializer());// StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, props.getValueSerializer());// StringDeserializer.class);
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, props.getGroupId());
        /* propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset); */
        return propsMap;
    }

    @Bean
    public TianJingReportListener testListener() {
        return new TianJingReportListener();
    }

}
