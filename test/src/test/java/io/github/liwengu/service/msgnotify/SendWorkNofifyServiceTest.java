package io.github.liwengu.service.msgnotify;

import io.github.liwengu.DingTalkAppTest;
import io.github.liwengu.service.msgnotify.sendnotify.SendWorkAsyncSendRequest;
import io.github.liwengu.service.msgnotify.sendnotify.SendWorkNotifyService;
import io.github.liwengu.service.msgnotify.sendnotify.SendWorkResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

/**
 * @Author liwenguang
 * @Date 2018/12/1 5:34 PM
 * @Description
 */
public class SendWorkNofifyServiceTest extends DingTalkAppTest {
    @Autowired
    private SendWorkNotifyService sendWorkNotifyService;

    @Test
    public void asyncSend2() {
        SendWorkAsyncSendRequest request = new SendWorkAsyncSendRequest();
        request.setUserid_list(Collections.singletonList("manager2090"));
        request.setMsg("{\"msgtype\":\"text\",\"text\":{\"content\":\"消息内容测试\"}}");
        SendWorkResponse response = sendWorkNotifyService.asyncSend(accessToken, request);
        System.out.println(response);
    }
}