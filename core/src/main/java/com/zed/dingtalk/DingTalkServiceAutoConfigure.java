package com.zed.dingtalk;

import com.zed.dingtalk.service.accesstoken.AccessTokenService;
import com.zed.dingtalk.service.asyncsend.CorpMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author liwenguang
 * @Date 2018/11/25 1:33 AM
 * @Description
 */
@Configuration
@EnableConfigurationProperties(DingTalkServiceProperties.class)
public class DingTalkServiceAutoConfigure {

    private final DingTalkServiceProperties properties;

    @Autowired
    public DingTalkServiceAutoConfigure(DingTalkServiceProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    AccessTokenService accessTokenService (){
        return new AccessTokenService(properties.getCorpId(), properties.getCorpSecret());
    }

    @Bean
    @ConditionalOnMissingBean
    CorpMessageService corpMessageService (){
        return new CorpMessageService(properties.getAgentId());
    }
}