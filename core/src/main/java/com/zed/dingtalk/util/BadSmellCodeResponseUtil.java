package com.zed.dingtalk.util;


import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.zed.dingtalk.service.accesstoken.AccessTokenResponse;
import com.zed.dingtalk.service.asyncsend.AsyncSendResponse;
import com.zed.dingtalk.service.bpms.BpmsResponse;
import com.zed.dingtalk.service.bpms.DingTalkFailResponse;
import com.zed.dingtalk.service.bpms.DingTalkSucResponse;
import com.zed.dingtalk.service.callback.CallBackResponse;
import com.zed.dingtalk.service.callback.DingTalkSelectResponse;
import com.zed.dingtalk.service.common.BaseResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     *
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
            failDetail.setErrCode(response.getErrCode().toString());
            failDetail.setErrMsg(response.getErrMsg());
            baseResponse.setFailDetail(failDetail);
        }
        return baseResponse;
    }

    /**
     * 回调查看
     *
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
            failDetail.setErrCode(response.getErrCode().toString());
            failDetail.setErrMsg(response.getErrMsg());
            callBackSelectResponse.setFailDetail(failDetail);
        }
        return callBackSelectResponse;
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/24 4:30 PM
     * @Description 成功的情况，钉钉失败有三种情况，其中一种情况和成功情况类似，因此作为同一个返回对象，这里需要判断是否是真的成功
     * 但是审批的系统错误，测试来看是审批实例 id 错误的问题
     */
    private static BpmsResponse to(BpmsResponse bpmsResponse, DingTalkSucResponse dingTalkSucResponse) {
        // 真的成功
        if (dingTalkSucResponse.getResponse().getResult().isSuccess() && dingTalkSucResponse.getResponse().getResult().getErrCode().equals(0)) {
            bpmsResponse.setSuc(true);
            BpmsResponse.SucDetail sucDetail = new BpmsResponse().new SucDetail();
            sucDetail.setRequestId(dingTalkSucResponse.getResponse().getRequestId());
            sucDetail.setCreateTime(dingTalkSucResponse.getResponse().getResult().getProcessInstance().getCreateTime());
            sucDetail.setFinishTime(dingTalkSucResponse.getResponse().getResult().getProcessInstance().getFinishTime());
            sucDetail.setFromUserId(dingTalkSucResponse.getResponse().getResult().getProcessInstance().getOriginatorUserId());
            sucDetail.setFromDeptId(dingTalkSucResponse.getResponse().getResult().getProcessInstance().getOriginatorDeptId());
            sucDetail.setFromDeptName(dingTalkSucResponse.getResponse().getResult().getProcessInstance().getOriginatorDeptName());
            sucDetail.setResult(dingTalkSucResponse.getResponse().getResult().getProcessInstance().getResult());
            sucDetail.setTitle(dingTalkSucResponse.getResponse().getResult().getProcessInstance().getTitle());
            // 审批抄送
            List<BpmsResponse.SucDetail.ToDetail> toDetailList = new ArrayList(8);
            for (DingTalkSucResponse.Result.ProcessInstance.OperationRecords.OperationRecordsVo operationRecordsVo :
                    dingTalkSucResponse.getResponse().getResult().getProcessInstance().getOperationRecords().getOperationRecordsVo()) {
                BpmsResponse.SucDetail.ToDetail toDetail = new BpmsResponse().new SucDetail().new ToDetail();
                toDetail.setUserId(operationRecordsVo.getOperationUserId());
                toDetail.setRemark(operationRecordsVo.getRemark());
                toDetail.setOperationTime(operationRecordsVo.getOperationTime());
                toDetail.setResult(operationRecordsVo.getOperationResult());
                toDetailList.add(toDetail);
            }
            sucDetail.setToDetailList(toDetailList);
            // 审批表单，是否要用 LinkedHashMap 保存顺序？
            Map<String, String> formMap = new HashMap<>(16);
            for (DingTalkSucResponse.Result.ProcessInstance.FormComponentValues.FormComponentValueVo formComponentValueVo :
                    dingTalkSucResponse.getResponse().getResult().getProcessInstance().getFormComponentValues().getFormComponentValueVo()) {
                formMap.put(formComponentValueVo.getName(), formComponentValueVo.getValue());
            }
            sucDetail.setFormData(formMap);
            bpmsResponse.setSucDetail(sucDetail);
        } else {
            BpmsResponse.FailDetail failDetail = new BpmsResponse().new FailDetail();
            failDetail.setErrCode(dingTalkSucResponse.getResponse().getResult().getErrCode().toString());
            failDetail.setErrMsg("不合法的 process_instance_id | " + dingTalkSucResponse.getResponse().getResult().getErrMsg());
            bpmsResponse.setFailDetail(failDetail);
        }
        return bpmsResponse;
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/24 4:46 PM
     * @Description 获取审批实例详情错误
     */
    private static BpmsResponse to(BpmsResponse bpmsResponse, DingTalkFailResponse dingTalkFailResponse) {
        BpmsResponse.FailDetail failDetail = new BpmsResponse().new FailDetail();
        failDetail.setErrCode(dingTalkFailResponse.getResponse().getSubCode() + "|" + dingTalkFailResponse.getResponse().getCode());
        failDetail.setErrMsg(dingTalkFailResponse.getResponse().getSubMsg() + "|" + dingTalkFailResponse.getResponse().getMsg());
        bpmsResponse.setFailDetail(failDetail);
        return bpmsResponse;
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/24 4:25 PM
     * @Description 将钉钉原始 json 字符串转化为对应的 Response
     */
    public static BpmsResponse to(BpmsResponse bpmsResponse, String response) {
        // 先走成功，因为大部分都是成功的
        if (!response.startsWith("{\"e")) {
            DingTalkSucResponse dingTalkSucResponse = JSON.parseObject(response, DingTalkSucResponse.class);
            return switchType(() -> to(bpmsResponse, dingTalkSucResponse));
        } else {
            DingTalkFailResponse dingTalkFailResponse = JSON.parseObject(response, DingTalkFailResponse.class);
            return switchType(() -> to(bpmsResponse, dingTalkFailResponse));
        }
    }

    private static <R> R switchType(TransferHandler<R> handler) {
        return handler.transfer();
    }

    private interface TransferHandler<R> {
        R transfer();
    }
}