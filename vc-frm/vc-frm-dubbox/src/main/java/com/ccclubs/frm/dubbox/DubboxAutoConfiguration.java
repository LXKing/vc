package com.ccclubs.frm.dubbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
@EnableConfigurationProperties(DubboxProperties.class)
public class DubboxAutoConfiguration {
	@Autowired
    private DubboxProperties dubboxProperties;

    @Bean
    public ApplicationConfig requestApplicationConfig() {
        return dubboxProperties.getApplication();
    }

    @Bean
    public RegistryConfig requestRegistryConfig() {
        return dubboxProperties.getRegistry();
    }

    @Bean
    public ProtocolConfig requestProtocolConfig() {
        return dubboxProperties.getProtocol();
    }
    
    @Bean
    public ProviderConfig requestProviderConfig() {
    	ProviderConfig pc = dubboxProperties.getProvider();
    	if(null == pc){
    	    return pc;
        }
    	pc.setFilter("-exception,DubboxException");
        return pc;
    }
    
    @Bean
    public ConsumerConfig requestConsumerConfig(){
    	ConsumerConfig cc = dubboxProperties.getConsumer();
    	return cc;
    }

    @Bean
    public MonitorConfig requestMonitorConfig() {
    	MonitorConfig mc = dubboxProperties.getMonitor();
    	if(null == mc){
    		mc = new MonitorConfig();
    		mc.setDefault(false);
    	}else if(null == mc.getProtocol() || "".equals(mc.getProtocol())){
    		mc.setDefault(false);
    	}
        return mc;
    }
}
