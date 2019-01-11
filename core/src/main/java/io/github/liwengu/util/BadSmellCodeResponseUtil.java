package io.github.liwengu.util;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.github.liwengu.common.BaseDTFailResponse;
import io.github.liwengu.common.BaseResponse;
import io.github.liwengu.service.accesstoken.AccessTokenDTResponse;
import io.github.liwengu.service.accesstoken.AccessTokenResponse;
import io.github.liwengu.service.attend.AttendDTSucResponse;
import io.github.liwengu.service.attend.AttendResponse;
import io.github.liwengu.service.bpms.BpmsDTFailResponse;
import io.github.liwengu.service.bpms.BpmsDTSucResponse;
import io.github.liwengu.service.bpms.BpmsResponse;
import io.github.liwengu.service.callback.CallBackDTSucResponse;
import io.github.liwengu.service.callback.CallBackResponse;
import io.github.liwengu.service.contact.department.*;
import io.github.liwengu.service.contact.user.UserDetailDTSucResponse;
import io.github.liwengu.service.contact.user.UserDetailDeptDTSucResponse;
import io.github.liwengu.service.contact.user.UserDetailDeptResponse;
import io.github.liwengu.service.contact.user.UserDetailResponse;
import io.github.liwengu.service.msgnotify.sendnotify.SendWorkDTSucResponse;
import io.github.liwengu.service.msgnotify.sendnotify.SendWorkResponse;

import java.util.*;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:04 PM
 * @Description 真正的进行响应转换
 */
public class BadSmellCodeResponseUtil {

    // ----------------------------------------------------------------------------------------------------------------------人员详情
    protected static UserDetailResponse to(UserDetailResponse userDetailResponse, UserDetailDTSucResponse userDetailDTSucResponse) {
        userDetailResponse.setSuc(true);
        UserDetailResponse.SucDetail sucDetail = new UserDetailResponse.SucDetail();
        sucDetail.setMobile(userDetailDTSucResponse.getMobile());
        sucDetail.setName(userDetailDTSucResponse.getName());
        sucDetail.setUserId(userDetailDTSucResponse.getUserId());
        // 部门
        sucDetail.setDeptIds(userDetailDTSucResponse.getDepartment());
        userDetailResponse.setSucDetail(sucDetail);
        return userDetailResponse;
    }
    // ----------------------------------------------------------------------------------------------------------------------人员详情
    // ----------------------------------------------------------------------------------------------------------------------异步通知新
    protected static SendWorkResponse to(SendWorkResponse sendWorkResponse, SendWorkDTSucResponse sendWorkDTSucResponse) {
        // 成功
        if (sendWorkDTSucResponse.getErrCode().equals(0)) {
            sendWorkResponse.setSuc(true);
            SendWorkResponse.SucDatail sucDatail = new SendWorkResponse().new SucDatail();
            sucDatail.setTaskId(sendWorkDTSucResponse.getTaskId());
            sucDatail.setRequestId(sendWorkDTSucResponse.getRequestId());
            sendWorkResponse.setSucDetail(sucDatail);
        } else {
            SendWorkResponse.FailDetail failDetail = new SendWorkResponse().new FailDetail();
            failDetail.setErrCode(sendWorkDTSucResponse.getErrCode());
            failDetail.setErrMsg(sendWorkDTSucResponse.getErrMsg());
            sendWorkResponse.setFailDetail(failDetail);
        }
        return sendWorkResponse;
    }
    // ----------------------------------------------------------------------------------------------------------------------异步通知新

    // ----------------------------------------------------------------------------------------------------------------------access_token
    protected static AccessTokenResponse to(AccessTokenResponse accessTokenResponse, AccessTokenDTResponse accessTokenDTResponse) {
        // 成功
        if (Objects.equals(accessTokenDTResponse.getErrCode(), "0") && accessTokenDTResponse.getErrMsg().equals("ok")) {
            accessTokenResponse.setSuc(true);
            AccessTokenResponse.SucDetail sucDetail = new AccessTokenResponse.SucDetail();
            sucDetail.setExpires(accessTokenDTResponse.getExpires());
            sucDetail.setAccessToken(accessTokenDTResponse.getAccessToken());
            accessTokenResponse.setSucDetail(sucDetail);
        } else {
            accessTokenResponse.setSuc(false);
            AccessTokenResponse.FailDetail failDetail = new AccessTokenResponse().new FailDetail();
            failDetail.setErrMsg(accessTokenDTResponse.getErrMsg());
            failDetail.setErrCode(accessTokenDTResponse.getErrCode());
            accessTokenResponse.setFailDetail(failDetail);
        }
        return accessTokenResponse;
    }
    // ----------------------------------------------------------------------------------------------------------------------access_token

    // ----------------------------------------------------------------------------------------------------------------------回调地址
    /**
     * @Author liwenguang
     * @Date 2018/11/25 2:04 AM
     * @Description 回调地址增删改
     */
    protected static CallBackResponse to(CallBackResponse callBackResponse, BaseDTFailResponse response) {
        if (response.getErrCode().equals("0") && response.getErrMsg().equals("ok")) {
            callBackResponse.setSuc(true);
        } else {
            callBackResponse.setSuc(false);
            BaseResponse.FailDetail failDetail = new BaseResponse().new FailDetail();
            failDetail.setErrCode(response.getErrCode());
            failDetail.setErrMsg(response.getErrMsg());
            callBackResponse.setFailDetail(failDetail);
        }
        return callBackResponse;
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/25 2:04 AM
     * @Description 回调地址查看
     */
    protected static CallBackResponse to(CallBackResponse callBackSelectResponse, CallBackDTSucResponse response) {
        if (response.getErrCode().equals(0) && response.getErrMsg().equals("ok")) {
            callBackSelectResponse.setSuc(true);
            CallBackResponse.SucDetail sucDetail = new CallBackResponse.SucDetail();
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
    // ----------------------------------------------------------------------------------------------------------------------回调地址

    // ----------------------------------------------------------------------------------------------------------------------审批详情
    /**
     * @Author liwenguang
     * @Date 2018/11/24 4:30 PM
     * @Description 成功的情况，钉钉失败有三种情况，其中一种情况和成功情况类似，因此作为同一个返回对象，这里需要判断是否是真的成功
     * 但是审批的系统错误，测试来看是审批实例 id 错误的问题
     */
    protected static BpmsResponse to(BpmsResponse bpmsResponse, BpmsDTSucResponse bpmsDTSucResponse) {
        // 真的成功
        if (bpmsDTSucResponse.getResponse().getResult().isSuccess() && bpmsDTSucResponse.getResponse().getResult().getErrCode().equals(0)) {
            bpmsResponse.setSuc(true);
            BpmsResponse.SucDetail sucDetail = new BpmsResponse.SucDetail();
            sucDetail.setRequestId(bpmsDTSucResponse.getResponse().getRequestId());
            sucDetail.setCreateTime(bpmsDTSucResponse.getResponse().getResult().getProcessInstance().getCreateTime());
            sucDetail.setFinishTime(bpmsDTSucResponse.getResponse().getResult().getProcessInstance().getFinishTime());
            sucDetail.setFromUserId(bpmsDTSucResponse.getResponse().getResult().getProcessInstance().getOriginatorUserId());
            sucDetail.setFromDeptId(bpmsDTSucResponse.getResponse().getResult().getProcessInstance().getOriginatorDeptId());
            sucDetail.setFromDeptName(bpmsDTSucResponse.getResponse().getResult().getProcessInstance().getOriginatorDeptName());
            sucDetail.setResult(bpmsDTSucResponse.getResponse().getResult().getProcessInstance().getResult());
            sucDetail.setTitle(bpmsDTSucResponse.getResponse().getResult().getProcessInstance().getTitle());
            // 审批抄送
            List<BpmsResponse.SucDetail.ToDetail> toDetailList = new ArrayList(8);
            for (BpmsDTSucResponse.Result.ProcessInstance.OperationRecords.OperationRecordsVo operationRecordsVo :
                    bpmsDTSucResponse.getResponse().getResult().getProcessInstance().getOperationRecords().getOperationRecordsVo()) {
                BpmsResponse.SucDetail.ToDetail toDetail = new BpmsResponse.SucDetail.ToDetail();
                toDetail.setUserId(operationRecordsVo.getOperationUserId());
                toDetail.setRemark(operationRecordsVo.getRemark());
                toDetail.setOperationTime(operationRecordsVo.getOperationTime());
                toDetail.setResult(operationRecordsVo.getOperationResult());
                toDetailList.add(toDetail);
            }
            sucDetail.setToDetailList(toDetailList);
            // 审批表单，是否要用 LinkedHashMap 保存顺序？
            Map<String, String> formMap = new HashMap<>(16);
            for (BpmsDTSucResponse.Result.ProcessInstance.FormComponentValues.FormComponentValueVo formComponentValueVo :
                    bpmsDTSucResponse.getResponse().getResult().getProcessInstance().getFormComponentValues().getFormComponentValueVo()) {
                formMap.put(formComponentValueVo.getName(), formComponentValueVo.getValue());
            }
            sucDetail.setFormData(formMap);
            bpmsResponse.setSucDetail(sucDetail);
        } else {
            BpmsResponse.FailDetail failDetail = new BpmsResponse().new FailDetail();
            failDetail.setErrCode(bpmsDTSucResponse.getResponse().getResult().getErrCode().toString());
            failDetail.setErrMsg("不合法的 process_instance_id | " + bpmsDTSucResponse.getResponse().getResult().getErrMsg());
            bpmsResponse.setFailDetail(failDetail);
        }
        return bpmsResponse;
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/24 4:46 PM
     * @Description 获取审批实例详情错误
     */
    protected static BpmsResponse to(BpmsResponse bpmsResponse, BpmsDTFailResponse bpmsDTFailResponse) {
        BpmsResponse.FailDetail failDetail = new BpmsResponse().new FailDetail();
        failDetail.setErrCode(bpmsDTFailResponse.getResponse().getSubCode() + "|" + bpmsDTFailResponse.getResponse().getCode());
        failDetail.setErrMsg(bpmsDTFailResponse.getResponse().getSubMsg() + "|" + bpmsDTFailResponse.getResponse().getMsg());
        bpmsResponse.setFailDetail(failDetail);
        return bpmsResponse;
    }
    //-----------------------------------------------------------------------------------------------------------------------审批详情

    //-----------------------------------------------------------------------------------------------------------------------部门人员详情
    public static UserDetailDeptResponse to(UserDetailDeptResponse userDetailDeptResponse, UserDetailDeptDTSucResponse userDetailDeptDTSucResponse) {
        userDetailDeptResponse.setSuc(true);
        UserDetailDeptResponse.SucDetail sucDetail = new UserDetailDeptResponse.SucDetail();
        // 成员详情
        List<UserDetailDeptResponse.SucDetail.User> user = new ArrayList(8);
        for (UserDetailDeptDTSucResponse.User sourceUser : userDetailDeptDTSucResponse.getUserlist()) {
            UserDetailDeptResponse.SucDetail.User targetUser = new UserDetailDeptResponse.SucDetail.User();
            BeanUtil.copyProperties(sourceUser, targetUser);
            user.add(targetUser);
        }
        sucDetail.setUserList(user);
        userDetailDeptResponse.setSucDetail(sucDetail);
        return userDetailDeptResponse;
    }

    //-----------------------------------------------------------------------------------------------------------------------部门人员详情
    //-----------------------------------------------------------------------------------------------------------------------打卡结果
    public static AttendResponse to(AttendResponse attendResponse, AttendDTSucResponse attendDTSucResponse) {
        attendResponse.setSuc(true);
        AttendResponse.SucDetail sucDetail = new AttendResponse.SucDetail();
        sucDetail.setHasMore(attendDTSucResponse.isHasMore());
        List<AttendResponse.SucDetail.Record> recordList = new ArrayList(8);
        for (AttendDTSucResponse.RecordResult sourceRecord : attendDTSucResponse.getRecordResult()) {
            AttendResponse.SucDetail.Record targetRecord = new AttendResponse.SucDetail.Record();
            BeanUtil.copyProperties(sourceRecord, targetRecord);
            targetRecord.setWorkDate(DateUtil.date(sourceRecord.getWorkDate()).toDateStr());
            targetRecord.setCheckDate(DateUtil.date(sourceRecord.getCheckDate()).toString());
            recordList.add(targetRecord);
        }
        sucDetail.setRecordList(recordList);
        attendResponse.setSucDetail(sucDetail);
        return attendResponse;
    }
    //----------------------------------------------------------------------------------------------------------------------打卡结果

    //----------------------------------------------------------------------------------------------------------------------获取部门的父部门列表
    public static DeptParentResponse to(DeptParentResponse deptParentResponse, DeptParentDTSucResponse deptParentDTSucResponse) {
        if (deptParentDTSucResponse.getErrCode().equals("0") && deptParentDTSucResponse.getErrMsg().equals("ok")) {
            deptParentResponse.setSuc(true);
            DeptParentResponse.SucDetail sucDetail = new DeptParentResponse.SucDetail();
            sucDetail.setDeptIds(deptParentDTSucResponse.getParentIds());
            deptParentResponse.setSucDetail(sucDetail);
        } else {
            DeptParentResponse.FailDetail failDetail = new DeptParentResponse().new FailDetail();
            failDetail.setErrCode(deptParentDTSucResponse.getErrCode());
            failDetail.setErrMsg(deptParentDTSucResponse.getErrMsg());
            deptParentResponse.setFailDetail(failDetail);
        }
        return deptParentResponse;
    }
    //----------------------------------------------------------------------------------------------------------------------获取部门的父部门列表
    //----------------------------------------------------------------------------------------------------------------------获取用户的父部门列表
    public static DeptParentResponse to(DeptParentResponse deptParentResponse, DeptParent2DTSucResponse deptParent2DTSucResponse) {
        if (deptParent2DTSucResponse.getErrCode().equals("0") && deptParent2DTSucResponse.getErrMsg().equals("ok")) {
            deptParentResponse.setSuc(true);
            DeptParentResponse.SucDetail sucDetail = new DeptParentResponse.SucDetail();
            sucDetail.setDeptIds(deptParent2DTSucResponse.getParentIds());
            deptParentResponse.setSucDetail(sucDetail);
        } else {
            DeptParentResponse.FailDetail failDetail = new DeptParentResponse().new FailDetail();
            failDetail.setErrCode(deptParent2DTSucResponse.getErrCode());
            failDetail.setErrMsg(deptParent2DTSucResponse.getErrMsg());
            deptParentResponse.setFailDetail(failDetail);
        }
        return deptParentResponse;
    }

    //----------------------------------------------------------------------------------------------------------------------获取用户的父部门列表
    //----------------------------------------------------------------------------------------------------------------------获取当前所授权的所有部门列表
    public static DeptAllResponse to(DeptAllResponse deptAllResponse, DeptAllDTResponse deptAllDTResponse) {
        if (deptAllDTResponse.getErrCode().equals("0") && deptAllDTResponse.getErrMsg().equals("ok")) {
            deptAllResponse.setSuc(true);
            DeptAllResponse.SucDetail sucDetail = new DeptAllResponse.SucDetail();
            Map<String, DeptAllResponse.SucDetail.DeptDetail> deptDetailMap = new HashMap<>(1024);
            // 设置基本属性
            for (DeptAllDTResponse.Department sourceDepartment : deptAllDTResponse.getDepartment()) {
                DeptAllResponse.SucDetail.DeptDetail deptDetail = new DeptAllResponse.SucDetail.DeptDetail();
                String deptId = sourceDepartment.getId();
                deptDetail.setDepId(deptId);
                deptDetail.setDeptName(sourceDepartment.getName());
                deptDetail.setParentDeptId(sourceDepartment.getParentId());
                deptDetailMap.put(deptId, deptDetail);
            }
            // 设置子部门
            // TODO 这里有子部门的顺序问题
            for (DeptAllDTResponse.Department sourceDepartment : deptAllDTResponse.getDepartment()) {
                String deptId = sourceDepartment.getId();
                DeptAllResponse.SucDetail.DeptDetail deptDetail = deptDetailMap.get(deptId);
                String parentDeptId = deptDetail.getParentDeptId();
                if (StrUtil.isNotEmpty(parentDeptId)) {
                    List<String> children = deptDetailMap.get(parentDeptId).getChildrenDeptId();
                    if (children == null) {
                        children = new ArrayList<>(8);
                    }
                    children.add(deptId);
                    deptDetailMap.get(parentDeptId).setChildrenDeptId(children);
                }
            }
            sucDetail.setDeptDetailMap(deptDetailMap);
            deptAllResponse.setSucDetail(sucDetail);
        } else {
            DeptAllResponse.FailDetail failDetail = new DeptAllResponse().new FailDetail();
            failDetail.setErrCode(deptAllDTResponse.getErrCode());
            failDetail.setErrMsg(deptAllDTResponse.getErrMsg());
            deptAllResponse.setFailDetail(failDetail);
        }
        return deptAllResponse;
    }

    //----------------------------------------------------------------------------------------------------------------------获取当前所授权的所有部门列表
    //-----------------------------------------------------------------------------------------------------------------------通用错误转换
    public static BaseResponse to(BaseResponse baseResponse, BaseDTFailResponse baseDTFailResponse) {
        BaseResponse.FailDetail failDetail = new BaseResponse().new FailDetail();
        failDetail.setErrCode(baseDTFailResponse.getErrCode());
        failDetail.setErrMsg(baseDTFailResponse.getErrMsg());
        baseResponse.setFailDetail(failDetail);
        return baseResponse;
    }
    //-----------------------------------------------------------------------------------------------------------------------通用错误转换

}