package com.zed.dingtalk.type;

public enum DingTalkEcoEnum {

    ASYNC_SEND("dingtalk.corp.message.corpconversation.asyncsend", "企业会话消息异步发送", "https://eco.taobao.com/router/rest", true),
    ACCESS_TOKEN("dingtalk.corp.message.corpconversation.asyncsend", "获取 access_token", "https://oapi.dingtalk.com/gettoken", false),
    CALL_BACK_REGISTER("call_back_register", "注册回调接口", "https://oapi.dingtalk.com/call_back/register_call_back", true),
    CALL_BACK_DELETE("call_back_delete", "删除回调接口", "https://oapi.dingtalk.com/call_back/delete_call_back", true),
    CALL_BACK_SELECT("call_back_get", "查询回调接口", "https://oapi.dingtalk.com/call_back/get_call_back", true),
    CALL_BACK_UPDATE("call_back_update", "更新回调接口", "https://oapi.dingtalk.com/call_back/update_call_back", true),
    BPMS_GET("dingtalk.smartwork.bpms.processinstance.get", "获取某个审批详情", "https://eco.taobao.com/router/rest", true),
    USER_DETAIL_GET("user_detail_get", "获取成员详情", "https://oapi.dingtalk.com/user/get", true),
    DEPT_USER_DETAIL_GET("dept_user_detail_get", "获取部门成员详情", "https://oapi.dingtalk.com/user/list", true),
    ATTENDS_LIST("attendance_list", "考勤打卡结果开放", "https://oapi.dingtalk.com/attendance/list", true), // ISV无调用权限
    DEPTS_LIST_PARENT_BY_DEPT("depts_list_parent_by_dept", "查询部门的所有上级父部门路径", "https://oapi.dingtalk.com/department/list_parent_depts_by_dept", true), // ISV无调用权限
    DEPTS_LIST("depts_list", "获取部门列表", "https://oapi.dingtalk.com/department/list", true); // ISV无调用权限

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
