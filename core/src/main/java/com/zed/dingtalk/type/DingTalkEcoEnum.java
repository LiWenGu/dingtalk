package com.zed.dingtalk.type;

public enum DingTalkEcoEnum {

    // 身份验证-应用免登
    ACCESS_TOKEN("dingtalk.corp.message.corpconversation.asyncsend", "企业应用免登获取access_token", "https://oapi.dingtalk.com/gettoken", false),

    // 消息通知-工作通知消息
    SEND_ASYNC_SEND("dingtalk.corp.message.corpconversation.asyncsend", "企业会话消息异步发送", "https://eco.taobao.com/router/rest", true),
    SEND_ASYNC_NOFITY_MSG("SEND_ASYNC_NOFITY_MSG", "发送工作通知消息", "https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2", true),

    // 回调接口-回调接口
    CALL_BACK_REGISTER("call_back_register", "注册回调接口", "https://oapi.dingtalk.com/call_back/register_call_back", true),
    CALL_BACK_DELETE("call_back_delete", "删除回调接口", "https://oapi.dingtalk.com/call_back/delete_call_back", true),
    CALL_BACK_SELECT("call_back_get", "查询回调接口", "https://oapi.dingtalk.com/call_back/get_call_back", true),
    CALL_BACK_UPDATE("call_back_update", "更新回调接口", "https://oapi.dingtalk.com/call_back/update_call_back", true),

    // 审批-获取审批详情
    BPMS_GET("dingtalk.smartwork.bpms.processinstance.get", "获取某个审批详情", "https://eco.taobao.com/router/rest", true),

    // 通讯录管理-用户管理
    CONTACTS_USER_DETAIL_GET("contacts_user_detail_get", "获取用户详情", "https://oapi.dingtalk.com/user/get", true),
    CONTACTS_USER_DEPT_SIMPLE_GET("contacts_user_dept_simple_get", "获取部门用户简单", "https://oapi.dingtalk.com/user/simplelist", true),
    CONTACTS_USER_DEPT_DETAIL_GET("contacts_user_dept_detail_get", "获取部门用户详情", "https://oapi.dingtalk.com/user/listbypage", true),
    CONTACTS_USER_DEPT_USERID_GET("contacts_user_dept_userId_get", "获取部门用户userid列表", "https://oapi.dingtalk.com/user/getDeptMember", true),
    // 通讯录管理-部门管理
    CONTACTS_DEPT_ALL_LIST_GET("contacts_dept_all_list_get", "获取部门列表", "https://oapi.dingtalk.com/department/list", true), // ISV无调用权限
    CONTACTS_DEPT_CHILDREN_LIST_GET("contacts_dept_children_list_get", "获取子部门ID列表", "https://oapi.dingtalk.com/department/list_ids", true), // ISV无调用权限
    CONTACTS_DEPT_PARENT_BY_DEPT_GET("contacts_dept_parent_by_dept_get", "查询部门的所有上级父部门路径", "https://oapi.dingtalk.com/department/list_parent_depts_by_dept", true), // ISV无调用权限
    CONTACTS_DEPT_PARENT_BY_USERID_GET("contacts_dept_parent_by_user_get", "查询指定用户的所有上级父部门路径", "https://oapi.dingtalk.com/department/list_parent_depts", true), // ISV无调用权限

    // 考勤-获取打卡结果
    ATTENDS_LIST("attendance_list", "考勤打卡结果开放", "https://oapi.dingtalk.com/attendance/list", true); // ISV无调用权限

    private String code;
    private String msg;
    private String url;
    /**
     * 接口是否需要授权，即是否需要 access_token
     */
    private Boolean auth;

    DingTalkEcoEnum(String code, String msg, String url, Boolean auth) {
        this.code = code;
        this.msg = msg;
        this.url = url;
        this.auth = auth;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getAuth() {
        return auth;
    }
}
