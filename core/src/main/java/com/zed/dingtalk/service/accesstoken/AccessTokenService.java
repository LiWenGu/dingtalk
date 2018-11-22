package com.zed.dingtalk.service.accesstoken;

import cn.hutool.core.bean.BeanUtil;
import com.zed.dingtalk.type.DingTalkEcoEnum;
import com.zed.dingtalk.util.BadSmellCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liwenguang
 * @Date 2018/11/22 10:54 PM
 * @Description 获取系统级 access_token
 */
public class AccessTokenService {

    @Autowired
    private RestTemplate restTemplate;
    private AccessTokenProperties properties;

    public AccessTokenService(AccessTokenProperties properties) {
        this.properties = properties;
    }

    /**
     * 获取 access_token
     * @return
     */
    public AccessTokenResponse getAccessToken() {
        AccessTokenResponse accessTokenResponse = new AccessTokenResponse();
        DingTalkResponse dingTalkResponse = restTemplate.getForObject(
                DingTalkEcoEnum.ACCESS_TOKEN.getUrl() + "?corpid={corpId}&corpsecret={corpSecret}",
                DingTalkResponse.class, BeanUtil.beanToMap(properties));
        return BadSmellCodeUtil.to(accessTokenResponse, dingTalkResponse);
    }

    /**
     * access_token
     * @param request
     * @return
     */
    public AccessTokenResponse getAccessToken(AccessTokenRequest request) {
        AccessTokenResponse accessTokenResponse = new AccessTokenResponse();
        DingTalkResponse dingTalkResponse = restTemplate.getForObject(
                DingTalkEcoEnum.ACCESS_TOKEN.getUrl() + "?corpid={corpId}&corpsecret={corpSecret}",
                DingTalkResponse.class, request);
        return BadSmellCodeUtil.to(accessTokenResponse, dingTalkResponse);
    }
}