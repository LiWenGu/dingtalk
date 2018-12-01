package com.zed.dingtalk;

import com.zed.dingtalk.service.accesstoken.AccessTokenService;
import com.zed.dingtalk.service.contact.department.DeptService;
import com.zed.dingtalk.service.contact.user.UserService;
import com.zed.dingtalk.service.msgnotify.sendnotify.SendWorkNotifyService;
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
    SendWorkNotifyService corpMessageService() {
        return new SendWorkNotifyService(properties.getAgentId());
    }

    @Bean
    @ConditionalOnMissingBean
    DeptService deptService() {
        return new DeptService();
    }

    @Bean
    @ConditionalOnMissingBean
    UserService userService() {
        return new UserService();
    }
}