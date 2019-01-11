package io.github.liwengu.service.accesstoken;

import io.github.liwengu.type.DingTalkEcoEnum;
import io.github.liwengu.util.ResponseTransferUtil;
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
        AccessTokenDTResponse accessTokenDTResponse = restTemplate.getForObject(
                DingTalkEcoEnum.ACCESS_TOKEN.getUrl() + "?corpid={corpId}&corpsecret={corpSecret}",
                AccessTokenDTResponse.class, corpId, corpSecret);
        return ResponseTransferUtil.to(accessTokenResponse, accessTokenDTResponse);
    }
}