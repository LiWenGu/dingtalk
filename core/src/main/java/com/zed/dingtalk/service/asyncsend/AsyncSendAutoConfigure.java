package com.zed.dingtalk.service.asyncsend;

import com.zed.dingtalk.DingTalkServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DingTalkServiceProperties.class)
public class AsyncSendAutoConfigure {

    private final DingTalkServiceProperties properties;

    @Autowired
    public AsyncSendAutoConfigure(DingTalkServiceProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    CorpMessageService corpMessageService (){
        return new CorpMessageService(properties.getAgentId());
    }
}

