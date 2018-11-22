package com.zed.dingtalk.type;

public enum DingTalkEcoEnum {

    GET_BPMS("dingtalk.smartwork.bpms.processinstance.get", "获取单个审批实例详情", "https://eco.taobao.com/router/rest", true),
    ASYNC_SEND("dingtalk.corp.message.corpconversation.asyncsend", "企业会话消息异步发送", "https://eco.taobao.com/router/rest", true),
    ACCESS_TOKEN("dingtalk.corp.message.corpconversation.asyncsend", "获取 access_token", "https://oapi.dingtalk.com/gettoken", false);

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
