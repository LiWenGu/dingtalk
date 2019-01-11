package io.github.liwengu.service.msgnotify.sendnotify;

import io.github.liwengu.common.BaseResponse;
import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/21 8:05 PM
 * @Description 工作通知消息_发送工作通知消息
 */
@Data
public class SendWorkResponse extends BaseResponse<SendWorkResponse.SucDatail> {

    @Data
    public class SucDatail {
        private String requestId;
        private String taskId;
    }

}