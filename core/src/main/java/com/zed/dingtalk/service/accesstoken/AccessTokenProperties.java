package com.zed.dingtalk.service.accesstoken;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author liwenguang
 * @Date 2018/11/22 10:43 PM
 * @Description 获取系统级别的 access_token
 */
@ConfigurationProperties("dingtalk")
@Data
public class AccessTokenProperties {

    /**
     * 企业 ID
     */
    private String corpId;
    /**
     * 企业秘钥
     */
    private String corpSecret;

}