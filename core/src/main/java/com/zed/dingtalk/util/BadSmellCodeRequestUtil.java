package com.zed.dingtalk.util;


import com.zed.dingtalk.service.callback.CallBackRegisterRequest;
import com.zed.dingtalk.service.callback.CallBackDTRequest;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:04 PM
 * @Description
 */
public class BadSmellCodeRequestUtil {


    public static CallBackDTRequest to(CallBackRegisterRequest registerRequest) {
        CallBackDTRequest callBackDTRequest = new CallBackDTRequest();
        callBackDTRequest.setUrl(registerRequest.getUrl());
        callBackDTRequest.setAes_key(registerRequest.getAesKey());
        callBackDTRequest.setToken(registerRequest.getToken());
        callBackDTRequest.setCall_back_tag(registerRequest.getCallBackTag());
        return callBackDTRequest;
    }
}