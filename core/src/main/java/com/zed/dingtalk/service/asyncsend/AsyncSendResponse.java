package com.zed.dingtalk.service.asyncsend;

import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/21 8:05 PM
 * @Description
 */
@Data
public class AsyncSendResponse {

    private boolean suc;
    private String requestId;
    private SucDetail sucDetail;
    private ErrDetail errDetail;

    @Data
    public class SucDetail {
        private String taskId;
    }

    @Data
    public class ErrDetail {
        private String errCode;
        private String errMsg;
    }
}