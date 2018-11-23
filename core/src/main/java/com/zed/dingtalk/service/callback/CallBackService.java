package com.zed.dingtalk.service.callback;

import com.zed.dingtalk.service.common.BaseResponse;
import com.zed.dingtalk.type.DingTalkEcoEnum;
import com.zed.dingtalk.util.BadSmellCodeRequestUtil;
import com.zed.dingtalk.util.BadSmellCodeResponseUtil;
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
    public BaseResponse register(String accessToken, CallBackRegisterRequest registerRequest) {
        DingTalkResponse response = restTemplate.postForObject(DingTalkEcoEnum.CALL_BACK_REGISTER.getUrl() +
                "?access_token={accessToken}", BadSmellCodeRequestUtil.to(registerRequest), DingTalkResponse.class, accessToken);
        return BadSmellCodeResponseUtil.to(new BaseResponse(), response);
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/23 5:18 PM
     * @Description 删除回调地址
     */
    public BaseResponse delete(String accessToken) {
        DingTalkResponse response = restTemplate.getForObject(DingTalkEcoEnum.CALL_BACK_DELETE.getUrl() +
                "?access_token={accessToken}", DingTalkResponse.class, accessToken);
        return BadSmellCodeResponseUtil.to(new BaseResponse(), response);
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/23 5:18 PM
     * @Description 更新回调地址
     */
    public BaseResponse update(String accessToken, CallBackRegisterRequest registerRequest) {
        DingTalkResponse response = restTemplate.postForObject(DingTalkEcoEnum.CALL_BACK_UPDATE.getUrl() +
                "?access_token={accessToken}", BadSmellCodeRequestUtil.to(registerRequest), DingTalkResponse.class, accessToken);
        return BadSmellCodeResponseUtil.to(new BaseResponse(), response);
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/23 5:18 PM
     * @Description 查看回调地址
     */
    public BaseResponse select(String accessToken) {
        DingTalkSelectResponse response = restTemplate.getForObject(DingTalkEcoEnum.CALL_BACK_SELECT.getUrl() +
                "?access_token={accessToken}", DingTalkSelectResponse.class, accessToken);
        return BadSmellCodeResponseUtil.to(new CallBackResponse(), response);
    }
}