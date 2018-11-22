package com.zed.dingtalk.service;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.asyncsend.AsyncSendRequest;
import com.zed.dingtalk.service.asyncsend.AsyncSendResponse;
import com.zed.dingtalk.service.asyncsend.CorpMessageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

/**
 * @Author liwenguang
 * @Date 2018/11/22 5:40 PM
 * @Description
 */
public class CorpMessageServiceTest extends DingTalkAppTest {

    @Autowired
    private CorpMessageService corpMessageService;

    @Test
    public void asyncSend() {
        AsyncSendRequest asyncSendRequest = new AsyncSendRequest();
        asyncSendRequest.setSession("12e48fd8411d3c769044190539fdbfc3");
        asyncSendRequest.setMsgtype("oa");
        asyncSendRequest.setMsgcontent("{\"message_url\": \"http://dingtalk.com\",\"head\": {\"bgcolor\": \"FFBBBBBB\",\"text\": \"头部标题\"},\"body\": {\"title\": \"正文标题\",\"form\": [{\"key\": \"姓名:\",\"value\": \"张三\"},{\"key\": \"爱好:\",\"value\": \"打球、听音乐\"}],\"rich\": {\"num\": \"15.6\",\"unit\": \"元\"},\"content\": \"大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本\",\"image\": \"@lADOADmaWMzazQKA\",\"file_count\": \"3\",\"author\": \"李四 \"}}");
        asyncSendRequest.setUserid_list(Collections.singletonList("manager2090"));
        AsyncSendResponse asyncSendResponse = corpMessageService.asyncSend(asyncSendRequest);
        asyncSendResponse.getRequestId();
        if (asyncSendResponse.isSuc()) {
            asyncSendResponse.getSucDetail();
        } else {
            asyncSendResponse.getErrDetail();
        }
    }
}