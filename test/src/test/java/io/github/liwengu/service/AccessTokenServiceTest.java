package io.github.liwengu.service;

import io.github.liwengu.DingTalkAppTest;
import io.github.liwengu.service.accesstoken.AccessTokenResponse;
import io.github.liwengu.service.accesstoken.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

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
    public void getAccessToken() {
        AccessTokenResponse accessTokenResponse = accessTokenService.getAccessToken();
        if (accessTokenResponse.isSuc()) {
            log.debug(accessTokenResponse.getSucDetail().getAccessToken());
            assert Objects.equals(accessTokenResponse.getSucDetail().getExpires(), 7200);
        } else {
            assert Objects.equals(accessTokenResponse.getFailDetail().getErrCode(), "40089");
            assert Objects.equals(accessTokenResponse.getFailDetail().getErrMsg(), "不合法的corpid或corpsecret");
        }
    }
}