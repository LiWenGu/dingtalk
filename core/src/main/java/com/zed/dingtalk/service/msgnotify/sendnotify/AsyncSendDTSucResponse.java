package com.zed.dingtalk.service.msgnotify.sendnotify;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:09 PM
 * @Description DT 真正返回的 Bean 类，比较特殊，有失败的情况
 */
@Data
public class AsyncSendDTSucResponse {

    @JSONField(name = "dingtalk_corp_message_corpconversation_asyncsend_response")
    private Response response;

    @Data
    public class Response {
        private Result result;
        private String requestId;
    }

    @Data
    public class Result {

        @JSONField(name = "ding_open_errcode")
        private String errCode;
        @JSONField(name = "error_msg")
        private String errMsg;
        private boolean success;
        private String taskId;
    }

}