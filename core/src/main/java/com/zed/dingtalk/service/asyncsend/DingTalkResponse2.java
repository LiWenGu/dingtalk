package com.zed.dingtalk.service.asyncsend;

import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:09 PM
 * @Description DT 真正返回的 Bean 类
 */
@Data
public class DingTalkResponse2 {
    private ErrorResponse errorResponse;

    @Data
    public class ErrorResponse {
        private Integer code;
        private String msg;
        private String subCode;
        private String subMsg;
        private String requestId;
    }
}