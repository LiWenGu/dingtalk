package com.zed.dingtalk.service.accesstoken;

import cn.hutool.core.bean.BeanUtil;
import com.zed.dingtalk.type.DingTalkEcoEnum;
import com.zed.dingtalk.util.BadSmellCodeResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liwenguang
 * @Date 2018/11/22 10:54 PM
 * @Description 获取系统级 access_token
 */
public class AccessTokenService {

    @Autowired
    private RestTemplate restTemplate;
    private String corpId;
    private String corpSecret;

    public AccessTokenService(String corpId, String corpSecret) {
        this.corpId = corpId;
        this.corpSecret = corpSecret;
    }

    /**
     * 获取 access_token
     * @return
     */
    public AccessTokenResponse getAccessToken() {
        AccessTokenResponse accessTokenResponse = new AccessTokenResponse();
        DingTalkResponse dingTalkResponse = restTemplate.getForObject(
                DingTalkEcoEnum.ACCESS_TOKEN.getUrl() + "?corpid={corpId}&corpsecret={corpSecret}",
                DingTalkResponse.class, corpId, corpSecret);
        return BadSmellCodeResponseUtil.to(accessTokenResponse, dingTalkResponse);
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
        return BadSmellCodeResponseUtil.to(accessTokenResponse, dingTalkResponse);
    }
}