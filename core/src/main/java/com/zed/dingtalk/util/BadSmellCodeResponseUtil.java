package com.zed.dingtalk.util;


import com.alibaba.fastjson.JSON;
import com.zed.dingtalk.service.accesstoken.AccessTokenResponse;
import com.zed.dingtalk.service.asyncsend.AsyncSendResponse;
import com.zed.dingtalk.service.common.BaseResponse;
import com.zed.dingtalk.service.callback.CallBackResponse;
import com.zed.dingtalk.service.callback.DingTalkSelectResponse;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:04 PM
 * @Description
 */
public class BadSmellCodeResponseUtil {

    private static AsyncSendResponse to(AsyncSendResponse asyncSendResponse, com.zed.dingtalk.service.asyncsend.DingTalkResponse badSmellCodeResponse) {
        asyncSendResponse.setSuc(badSmellCodeResponse.getResponse().getResult().isSuccess());
        asyncSendResponse.setRequestId(badSmellCodeResponse.getResponse().getRequestId());
        if (asyncSendResponse.isSuc()) {
            AsyncSendResponse.SucDetail sucDetail = new AsyncSendResponse().new SucDetail();
            sucDetail.setTaskId(badSmellCodeResponse.getResponse().getResult().getTaskId());
            asyncSendResponse.setSucDetail(sucDetail);
        } else {
            AsyncSendResponse.ErrDetail errDetail = new AsyncSendResponse().new ErrDetail();
            errDetail.setErrCode(badSmellCodeResponse.getResponse().getResult().getErrCode());
            errDetail.setErrMsg(badSmellCodeResponse.getResponse().getResult().getErrMsg());
            asyncSendResponse.setErrDetail(errDetail);
        }
        return asyncSendResponse;
    }

    private static AsyncSendResponse to(AsyncSendResponse asyncSendResponse, com.zed.dingtalk.service.asyncsend.DingTalkResponse2 badSmellCodeBean) {
        asyncSendResponse.setSuc(false);
        asyncSendResponse.setRequestId(badSmellCodeBean.getErrorResponse().getRequestId());
        AsyncSendResponse.ErrDetail errDetail = new AsyncSendResponse().new ErrDetail();
        errDetail.setErrCode(badSmellCodeBean.getErrorResponse().getCode() + "|" + badSmellCodeBean.getErrorResponse().getSubCode());
        errDetail.setErrMsg(badSmellCodeBean.getErrorResponse().getMsg() + "|" + badSmellCodeBean.getErrorResponse().getSubMsg());
        asyncSendResponse.setErrDetail(errDetail);
        return asyncSendResponse;
    }

    public static AsyncSendResponse to(AsyncSendResponse asyncSendResponse, String response) {
        // 如果是错误
        if (response.startsWith("{\"e")) {
            return to(asyncSendResponse, JSON.parseObject(response, com.zed.dingtalk.service.asyncsend.DingTalkResponse2.class));
        } else {
            return to(asyncSendResponse, JSON.parseObject(response, com.zed.dingtalk.service.asyncsend.DingTalkResponse.class));
        }
    }


    public static AccessTokenResponse to(AccessTokenResponse accessTokenResponse, com.zed.dingtalk.service.accesstoken.DingTalkResponse dingTalkResponse) {
        // 成功
        if (dingTalkResponse.getErrCode().equals(0) && dingTalkResponse.getErrMsg().equals("ok")) {
            accessTokenResponse.setSuc(true);
            AccessTokenResponse.SucDetail sucDetail = new AccessTokenResponse().new SucDetail();
            sucDetail.setExpires(dingTalkResponse.getExpires());
            sucDetail.setAccessToken(dingTalkResponse.getAccessToken());
            accessTokenResponse.setSucDetail(sucDetail);
        } else {
            accessTokenResponse.setSuc(false);
            AccessTokenResponse.FailDetail failDetail = new AccessTokenResponse().new FailDetail();
            failDetail.setErrMsg(dingTalkResponse.getErrMsg());
            failDetail.setErrCode(dingTalkResponse.getErrCode());
            accessTokenResponse.setFailDetail(failDetail);
        }
        return accessTokenResponse;
    }

    /**
     * callback
     * @param baseResponse
     * @param response
     * @return
     */
    public static BaseResponse to(BaseResponse baseResponse, com.zed.dingtalk.service.callback.DingTalkResponse response) {
        if (response.getErrCode().equals(0) && response.getErrMsg().equals("ok")) {
            baseResponse.setSuc(true);
        } else {
            baseResponse.setSuc(false);
            BaseResponse.FailDetail failDetail = new BaseResponse().new FailDetail();
            failDetail.setErrCode(response.getErrCode());
            failDetail.setErrMsg(response.getErrMsg());
            baseResponse.setFailDetail(failDetail);
        }
        return baseResponse;
    }

    /**
     * 回调查看
     * @param callBackSelectResponse
     * @param response
     * @return
     */
    public static BaseResponse to(CallBackResponse callBackSelectResponse, DingTalkSelectResponse response) {
        if (response.getErrCode().equals(0) && response.getErrMsg().equals("ok")) {
            callBackSelectResponse.setSuc(true);
            CallBackResponse.SucDetail sucDetail = new CallBackResponse().new SucDetail();
            sucDetail.setUrl(response.getUrl());
            sucDetail.setAesKey(response.getAesKey());
            sucDetail.setToken(response.getToken());
            sucDetail.setCallBackTag(response.getCallBackTag());
            callBackSelectResponse.setSucDetail(sucDetail);
        } else {
            callBackSelectResponse.setSuc(false);
            BaseResponse.FailDetail failDetail = new BaseResponse().new FailDetail();
            failDetail.setErrCode(response.getErrCode());
            failDetail.setErrMsg(response.getErrMsg());
            callBackSelectResponse.setFailDetail(failDetail);
        }
        return callBackSelectResponse;
    }
}