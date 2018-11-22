package com.liwenguang.dingtalk.type;

public enum DingTalkEcoEnum {

    GET_BPMS("dingtalk.smartwork.bpms.processinstance.get", "获取单个审批实例详情", "https://eco.taobao.com/router/rest"),
    ASYNC_SEND("dingtalk.corp.message.corpconversation.asyncsend", "企业会话消息异步发送", "https://eco.taobao.com/router/rest");

    private String code;
    private String msg;
    private String url;

    DingTalkEcoEnum(String code, String msg, String url) {
        this.code = code;
        this.msg = msg;
        this.url = url;
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
}
