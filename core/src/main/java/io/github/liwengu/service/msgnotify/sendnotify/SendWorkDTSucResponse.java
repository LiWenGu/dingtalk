package io.github.liwengu.service.msgnotify.sendnotify;

import io.github.liwengu.common.BaseDTFailResponse;
import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/12/1 5:25 PM
 * @Description 发送工作通知钉钉官方返回 Bean，成功失败同一个 Bean
 */
@Data
public class SendWorkDTSucResponse extends BaseDTFailResponse {
    private String taskId;
    private String requestId;
}