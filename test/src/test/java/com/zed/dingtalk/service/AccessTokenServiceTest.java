package com.zed.dingtalk.service;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.accesstoken.AccessTokenResponse;
import com.zed.dingtalk.service.accesstoken.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author liwenguang
 * @Date 2018/11/22 10:54 PM
 * @Description 获取系统级 access_token
 */
@Slf4j
public class AccessTokenServiceTest extends DingTalkAppTest {

    @Autowired
    private AccessTokenService accessTokenService;

    @Test
    public void asyncSend() {
        AccessTokenResponse accessTokenResponse = accessTokenService.getAccessToken();
        if (accessTokenResponse.isSuc()) {
            log.debug(accessTokenResponse.getSucDetail().getAccessToken());
            assert accessTokenResponse.getSucDetail().getExpires().equals(7200);
        } else {
            assert accessTokenResponse.getFailDetail().getErrCode().equals(40089);
            assert accessTokenResponse.getFailDetail().getErrMsg().equals("不合法的corpid或corpsecret");
        }
    }
}