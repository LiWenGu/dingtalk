package com.zed.dingtalk.util;


import com.zed.dingtalk.service.callback.CallBackRegisterRequest;
import com.zed.dingtalk.service.callback.DingTalkRegisterRequest;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:04 PM
 * @Description
 */
public class BadSmellCodeRequestUtil {


    public static DingTalkRegisterRequest to(CallBackRegisterRequest registerRequest) {
        DingTalkRegisterRequest dingTalkRegisterRequest = new DingTalkRegisterRequest();
        dingTalkRegisterRequest.setUrl(registerRequest.getUrl());
        dingTalkRegisterRequest.setAes_key(registerRequest.getAesKey());
        dingTalkRegisterRequest.setToken(registerRequest.getToken());
        dingTalkRegisterRequest.setCall_back_tag(registerRequest.getCallBackTag());
        return dingTalkRegisterRequest;
    }
}