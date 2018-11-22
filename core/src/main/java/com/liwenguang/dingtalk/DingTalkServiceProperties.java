package com.liwenguang.dingtalk;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author liwenguang
 * @Date 2018/11/22 5:26 PM
 * @Description
 */
@ConfigurationProperties("dingtalk")
@Data
public class DingTalkServiceProperties {

    /**
     * 应用ID
     */
    private String agentId;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}