package com.liwenguang.dingtalk.asyncsend;


import com.alibaba.fastjson.JSON;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:04 PM
 * @Description
 */
public class BadSmellCodeUtil {

    public static AsyncSendResponse to(AsyncSendResponse asyncSendResponse, BadSmellCodeBean badSmellCodeBean) {
        asyncSendResponse.setSuc(badSmellCodeBean.getResponse().getResult().isSuccess());
        asyncSendResponse.setRequestId(badSmellCodeBean.getResponse().getRequestId());
        if (asyncSendResponse.isSuc()) {
            AsyncSendResponse.SucDetail sucDetail = new AsyncSendResponse().new SucDetail();
            sucDetail.setTaskId(badSmellCodeBean.getResponse().getResult().getTaskId());
            asyncSendResponse.setSucDetail(sucDetail);
        } else {
            AsyncSendResponse.ErrDetail errDetail = new AsyncSendResponse().new ErrDetail();
            errDetail.setErrCode(badSmellCodeBean.getResponse().getResult().getErrCode());
            errDetail.setErrMsg(badSmellCodeBean.getResponse().getResult().getErrMsg());
            asyncSendResponse.setErrDetail(errDetail);
        }
        return asyncSendResponse;
    }

    public static AsyncSendResponse to(AsyncSendResponse asyncSendResponse, BadSmellCodeBean2 badSmellCodeBean) {
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
            return to(asyncSendResponse, JSON.parseObject(response, BadSmellCodeBean2.class));
        } else {
            return to(asyncSendResponse, JSON.parseObject(response, BadSmellCodeBean.class));
        }
    }
}