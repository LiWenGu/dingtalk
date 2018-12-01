package com.zed.dingtalk.service.msgnotify.sendnotify;

import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/21 8:05 PM
 * @Description 企业会话消息异步发送
 */
@Data
public class AsyncSendRequest {

    private String method;
    private String sign_method;
    private String v;
    private String format;
    private String timestamp;
    private String session;

    private String msgtype;
    private String agent_id;
    private List<String> userid_list;
    private String msgcontent;

}