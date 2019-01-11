package io.github.liwengu.service.msgnotify.sendnotify;

import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/21 8:05 PM
 * @Description 工作通知消息_发送工作通知消息
 */
@Data
public class SendWorkAsyncSendRequest {

    private String agent_id;
    private List<String> userid_list;
    private String dept_id_list;
    private Boolean to_all_user;
    private String msg;

}