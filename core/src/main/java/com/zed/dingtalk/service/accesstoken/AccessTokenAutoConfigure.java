package com.zed.dingtalk.service.accesstoken;

import com.zed.dingtalk.DingTalkServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DingTalkServiceProperties.class)
public class AccessTokenAutoConfigure {

    private final DingTalkServiceProperties properties;

    @Autowired
    public AccessTokenAutoConfigure(DingTalkServiceProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    AccessTokenService accessTokenService (){
        return new AccessTokenService(properties.getCorpId(), properties.getCorpSecret());
    }
}

