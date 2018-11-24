package com.zed.dingtalk.service.callback;

import com.zed.dingtalk.common.BaseDingTalkFailResponse;
import com.zed.dingtalk.common.BaseResponse;
import com.zed.dingtalk.type.DingTalkEcoEnum;
import com.zed.dingtalk.util.BadSmellCodeRequestUtil;
import com.zed.dingtalk.util.BadSmellCodeResponseUtil;
import com.zed.dingtalk.util.ResponseTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liwenguang
 * @Date 2018/11/23 5:00 PM
 * @Description 注册回调地址
 */
@Service
public class CallBackService {

    @Autowired
    private RestTemplate restTemplate;

    public CallBackService() {
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/23 5:18 PM
     * @Description 注册回调地址
     */
    public CallBackResponse register(String accessToken, CallBackRegisterRequest registerRequest) {
        BaseDingTalkFailResponse response = restTemplate.postForObject(DingTalkEcoEnum.CALL_BACK_REGISTER.getUrl() +
                "?access_token={accessToken}", BadSmellCodeRequestUtil.to(registerRequest), BaseDingTalkFailResponse.class, accessToken);
        return ResponseTransferUtil.to(new CallBackResponse(), response);
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/23 5:18 PM
     * @Description 删除回调地址
     */
    public CallBackResponse delete(String accessToken) {
        BaseDingTalkFailResponse response = restTemplate.getForObject(DingTalkEcoEnum.CALL_BACK_DELETE.getUrl() +
                "?access_token={accessToken}", BaseDingTalkFailResponse.class, accessToken);
        return ResponseTransferUtil.to(new CallBackResponse(), response);
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/23 5:18 PM
     * @Description 更新回调地址
     */
    public CallBackResponse update(String accessToken, CallBackRegisterRequest registerRequest) {
        BaseDingTalkFailResponse response = restTemplate.postForObject(DingTalkEcoEnum.CALL_BACK_UPDATE.getUrl() +
                "?access_token={accessToken}", BadSmellCodeRequestUtil.to(registerRequest), BaseDingTalkFailResponse.class, accessToken);
        return ResponseTransferUtil.to(new CallBackResponse(), response);
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/23 5:18 PM
     * @Description 查看回调地址
     */
    public CallBackResponse select(String accessToken) {
        CallBackDTSucResponse response = restTemplate.getForObject(DingTalkEcoEnum.CALL_BACK_SELECT.getUrl() +
                "?access_token={accessToken}", CallBackDTSucResponse.class, accessToken);
        return ResponseTransferUtil.to(new CallBackResponse(), response);
    }
}