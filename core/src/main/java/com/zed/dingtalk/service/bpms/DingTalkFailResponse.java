package com.zed.dingtalk.service.bpms;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/24 2:02 PM
 * @Description
 */
@Data
public class DingTalkFailResponse {

    @JSONField(name = "error_response")
    private Response response;

    @Data
    public class Response {
        private Integer code;
        private Integer subCode;
        private String msg;
        private String subMsg;
        private String requestId;

    }
}