package com.zed.dingtalk.util;

import com.alibaba.fastjson.JSON;
import com.zed.dingtalk.common.BaseDTFailResponse;
import com.zed.dingtalk.common.BaseResponse;
import com.zed.dingtalk.service.accesstoken.AccessTokenDTResponse;
import com.zed.dingtalk.service.accesstoken.AccessTokenResponse;
import com.zed.dingtalk.service.asyncsend.AsyncSendDTFailResponse;
import com.zed.dingtalk.service.asyncsend.AsyncSendDTSucResponse;
import com.zed.dingtalk.service.asyncsend.AsyncSendResponse;
import com.zed.dingtalk.service.attend.AttendDTSucResponse;
import com.zed.dingtalk.service.attend.AttendResponse;
import com.zed.dingtalk.service.bpms.BpmsDTFailResponse;
import com.zed.dingtalk.service.bpms.BpmsDTSucResponse;
import com.zed.dingtalk.service.bpms.BpmsResponse;
import com.zed.dingtalk.service.callback.CallBackDTSucResponse;
import com.zed.dingtalk.service.callback.CallBackResponse;
import com.zed.dingtalk.service.contact.department.*;
import com.zed.dingtalk.service.contact.user.UserDetailDTSucResponse;
import com.zed.dingtalk.service.contact.user.UserDetailDeptDTSucResponse;
import com.zed.dingtalk.service.contact.user.UserDetailDeptResponse;
import com.zed.dingtalk.service.contact.user.UserDetailResponse;

/**
 * @Author liwenguang
 * @Date 2018/11/25 1:40 AM
 * @Description 用于响应的转换
 */
public class ResponseTransferUtil {

    private static <R extends BaseResponse> R switchType(TransferHandler<R> handler) {
        return handler.transfer();
    }

    private interface TransferHandler<R extends BaseResponse> {
        R transfer();
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/25 9:52 PM
     * @Description 获取部门成员详情
     */
    public static UserDetailDeptResponse to(UserDetailDeptResponse userDetailDeptResponse, String response) {
        if (!response.startsWith("{\"e")) {
            UserDetailDeptDTSucResponse userDetailDeptDTSucResponse = JSON.parseObject(response, UserDetailDeptDTSucResponse.class);
            return switchType(() -> BadSmellCodeResponseUtil.to(userDetailDeptResponse, userDetailDeptDTSucResponse));
        } else {
            BaseDTFailResponse baseDTFailResponse = JSON.parseObject(response, BaseDTFailResponse.class);
            return (UserDetailDeptResponse) switchType(() -> BadSmellCodeResponseUtil.to(userDetailDeptResponse, baseDTFailResponse));
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
            return (UserDetailResponse) switchType(() -> BadSmellCodeResponseUtil.to(userDetailResponse, baseDTFailResponse));
        }
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/26 11:56 PM
     * @Description 获取部门的所有父部门
     */
    public static DeptParentResponse to(DeptParentResponse deptParentResponse, String response) {
        DeptParentDTSucResponse deptParentDTSucResponse = JSON.parseObject(response, DeptParentDTSucResponse.class);
        return switchType(() -> BadSmellCodeResponseUtil.to(deptParentResponse, deptParentDTSucResponse));
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/26 11:56 PM
     * @Description 获取用户的所有父部门
     */
    public static DeptParentResponse to2(DeptParentResponse deptParentResponse, String response) {
        DeptParent2DTSucResponse deptParentDTSucResponse = JSON.parseObject(response, DeptParent2DTSucResponse.class);
        return switchType(() -> BadSmellCodeResponseUtil.to(deptParentResponse, deptParentDTSucResponse));
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/27 12:39 AM
     * @Description 获取当前能获取到的所有的部门
     */
    public static DeptAllResponse to(DeptAllResponse deptAllResponse, String response) {
        DeptAllDTResponse deptAllDTResponse = JSON.parseObject(response, DeptAllDTResponse.class);
        return switchType(() -> BadSmellCodeResponseUtil.to(deptAllResponse, deptAllDTResponse));
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

    /**
     * @Author liwenguang
     * @Date 2018/11/26 2:54 PM
     * @Description 打卡结果的转换
     */
    public static AttendResponse to(AttendResponse attendResponse, String response) {
        if (!response.startsWith("{\"e")) {
            AttendDTSucResponse attendDTSucResponse = JSON.parseObject(response, AttendDTSucResponse.class);
            return switchType(() -> BadSmellCodeResponseUtil.to(attendResponse, attendDTSucResponse));
        } else {
            BaseDTFailResponse baseDTFailResponse = JSON.parseObject(response, BaseDTFailResponse.class);
            return (AttendResponse) switchType(() -> BadSmellCodeResponseUtil.to(attendResponse, baseDTFailResponse));
        }
    }

}