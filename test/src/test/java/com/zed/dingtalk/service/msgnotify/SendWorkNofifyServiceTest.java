package com.zed.dingtalk.service.msgnotify;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.msgnotify.sendnotify.*;
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
    public void asyncSend() {
        AsyncSendRequest asyncSendRequest = new AsyncSendRequest();
        asyncSendRequest.setSession(accessToken);
        asyncSendRequest.setMsgtype("oa");
        asyncSendRequest.setMsgcontent("{\"message_url\": \"http://dingtalk.com\",\"head\": {\"bgcolor\": \"FFBBBBBB\",\"text\": \"头部标题\"},\"body\": {\"title\": \"正文标题\",\"form\": [{\"key\": \"姓名:\",\"value\": \"张三\"},{\"key\": \"爱好:\",\"value\": \"打球、听音乐\"}],\"rich\": {\"num\": \"15.6\",\"unit\": \"元\"},\"content\": \"大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本\",\"image\": \"@lADOADmaWMzazQKA\",\"file_count\": \"3\",\"author\": \"李四 \"}}");
        asyncSendRequest.setUserid_list(Collections.singletonList("manager2090"));
        AsyncSendResponse asyncSendResponse = sendWorkNotifyService.asyncSend(asyncSendRequest);
        asyncSendResponse.getRequestId();
        if (asyncSendResponse.isSuc()) {
            asyncSendResponse.getSucDetail();
        } else {
            asyncSendResponse.getFailDetail();
        }
    }

    @Test
    public void asyncSend2() {
        SendWorkAsyncSendRequest request = new SendWorkAsyncSendRequest();
        request.setUserid_list(Collections.singletonList("manager2090"));
        request.setMsg("{\"msgtype\":\"text\",\"text\":{\"content\":\"消息内容测试\"}}");
        SendWorkResponse response = sendWorkNotifyService.asyncSend(accessToken, request);
        System.out.println(response);
    }
}