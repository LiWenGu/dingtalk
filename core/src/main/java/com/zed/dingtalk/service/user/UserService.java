package com.zed.dingtalk.service.user;

import com.zed.dingtalk.type.DingTalkEcoEnum;
import com.zed.dingtalk.util.ResponseTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liwenguang
 * @Date 2018/11/25 12:57 AM
 * @Description
 */
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public UserDetailResponse getUserDetail(String accessToken, String userId) {
        String response = restTemplate.getForObject(DingTalkEcoEnum.USER_DETAIL_GET.getUrl() +
                "?access_token={accessToken}&userid={userId}", String.class, accessToken, userId);
        return ResponseTransferUtil.to(new UserDetailResponse(), response);
    }
}