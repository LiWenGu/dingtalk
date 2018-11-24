package com.zed.dingtalk.service.asyncsend;

import com.zed.dingtalk.common.BaseResponse;
import lombok.Data;
import lombok.ToString;

/**
 * @Author liwenguang
 * @Date 2018/11/21 8:05 PM
 * @Description
 */
@Data
@ToString(callSuper = true)
public class AsyncSendResponse extends BaseResponse<AsyncSendResponse.SucDetail> {

    private String requestId;

    @Data
    public class SucDetail {
        private String taskId;
    }
}