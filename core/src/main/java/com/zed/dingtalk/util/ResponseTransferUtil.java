package com.zed.dingtalk.util;

import com.alibaba.fastjson.JSON;
import com.zed.dingtalk.common.BaseDTFailResponse;
import com.zed.dingtalk.service.accesstoken.AccessTokenDTResponse;
import com.zed.dingtalk.service.accesstoken.AccessTokenResponse;
import com.zed.dingtalk.service.asyncsend.AsyncSendDTFailResponse;
import com.zed.dingtalk.service.asyncsend.AsyncSendDTSucResponse;
import com.zed.dingtalk.service.asyncsend.AsyncSendResponse;
import com.zed.dingtalk.service.bpms.BpmsDTFailResponse;
import com.zed.dingtalk.service.bpms.BpmsDTSucResponse;
import com.zed.dingtalk.service.bpms.BpmsResponse;
import com.zed.dingtalk.service.callback.CallBackDTSucResponse;
import com.zed.dingtalk.service.callback.CallBackResponse;
import com.zed.dingtalk.service.department.DeptUserDetailDTSucResponse;
import com.zed.dingtalk.service.department.DeptUserDetailResponse;
import com.zed.dingtalk.service.user.UserDetailDTSucResponse;
import com.zed.dingtalk.service.user.UserDetailResponse;

/**
 * @Author liwenguang
 * @Date 2018/11/25 1:40 AM
 * @Description 用于响应的转换
 */
public class ResponseTransferUtil {

    private static <R> R switchType(TransferHandler<R> handler) {
        return handler.transfer();
    }

    private interface TransferHandler<R> {
        R transfer();
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/25 9:52 PM
     * @Description 获取部门成员详情
     */
    public static DeptUserDetailResponse to(DeptUserDetailResponse deptUserDetailResponse, String response) {
        if (!response.startsWith("{\"e")) {
            DeptUserDetailDTSucResponse deptUserDetailDTSucResponse = JSON.parseObject(response, DeptUserDetailDTSucResponse.class);
            return switchType(() -> BadSmellCodeResponseUtil.to(deptUserDetailResponse, deptUserDetailDTSucResponse));
        } else {
            BaseDTFailResponse baseDTFailResponse = JSON.parseObject(response, BaseDTFailResponse.class);
            return switchType(() -> BadSmellCodeResponseUtil.to(deptUserDetailResponse, baseDTFailResponse));
        }
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/25 1:54 AM
     * @Description 获取 access_token
     */
    public static AccessTokenResponse to(AccessTokenResponse accessTokenResponse, AccessTokenDTResponse accessTokenDTResponse) {
        return switchType(() -> BadSmellCodeResponseUtil.to(accessTokenResponse, accessTokenDTResponse));
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/24 4:25 PM
     * @Description 审批实例详情获取的转换
     */
    public static BpmsResponse to(BpmsResponse bpmsResponse, String response) {
        if (!response.startsWith("{\"e")) {
            BpmsDTSucResponse bpmsDTSucResponse = JSON.parseObject(response, BpmsDTSucResponse.class);
            return switchType(() -> BadSmellCodeResponseUtil.to(bpmsResponse, bpmsDTSucResponse));
        } else {
            BpmsDTFailResponse bpmsDTFailResponse = JSON.parseObject(response, BpmsDTFailResponse.class);
            return switchType(() -> BadSmellCodeResponseUtil.to(bpmsResponse, bpmsDTFailResponse));
        }
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/25 1:08 AM
     * @Description 人员详情获取的转换
     */
    public static UserDetailResponse to(UserDetailResponse userDetailResponse, String response) {
        if (!response.startsWith("{\"e")) {
            UserDetailDTSucResponse userDetailDTSucResponse = JSON.parseObject(response, UserDetailDTSucResponse.class);
            return switchType(() -> BadSmellCodeResponseUtil.to(userDetailResponse, userDetailDTSucResponse));
        } else {
            BaseDTFailResponse baseDTFailResponse = JSON.parseObject(response, BaseDTFailResponse.class);
            return switchType(() -> BadSmellCodeResponseUtil.to(userDetailResponse, baseDTFailResponse));
        }
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/25 1:50 AM
     * @Description 异步通知的转换
     */
    public static AsyncSendResponse to(AsyncSendResponse asyncSendResponse, String response) {
        if (!response.startsWith("{\"e")) {
            AsyncSendDTSucResponse asyncSendDTSucResponse = JSON.parseObject(response, AsyncSendDTSucResponse.class);
            return switchType(() -> BadSmellCodeResponseUtil.to(asyncSendResponse, asyncSendDTSucResponse));
        } else {
            AsyncSendDTFailResponse asyncSendDTFailResponse = JSON.parseObject(response, AsyncSendDTFailResponse.class);
            return switchType(() -> BadSmellCodeResponseUtil.to(asyncSendResponse, asyncSendDTFailResponse));
        }
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/25 2:04 AM
     * @Description 回调地址增删改的转换
     */
    public static CallBackResponse to(CallBackResponse callBackResponse, BaseDTFailResponse response) {
        return switchType(() -> BadSmellCodeResponseUtil.to(callBackResponse, response));
    }
    
    /**
     * @Author liwenguang
     * @Date 2018/11/25 1:59 AM
     * @Description 回调地址查的转换
     */
    public static CallBackResponse to(CallBackResponse callBackResponse, CallBackDTSucResponse response) {
        return switchType(() -> BadSmellCodeResponseUtil.to(callBackResponse, response));
    }
}