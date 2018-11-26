package com.zed.dingtalk.service;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.attend.AttendRequest;
import com.zed.dingtalk.service.attend.AttendResponse;
import com.zed.dingtalk.service.attend.AttendService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

/**
 * @Author liwenguang
 * @Date 2018/11/26 3:06 PM
 * @Description
 */
public class AttendServiceTest extends DingTalkAppTest {
    @Autowired
    private AttendService attendService;

    @Test
    public void listResult() {
        AttendRequest attendRequest = new AttendRequest();
        attendRequest.setWorkDateFrom("2018-11-22 00:00:00");
        attendRequest.setWorkDateTo("2018-11-30 00:00:00");
        attendRequest.setOffset(0);
        attendRequest.setLimit(10);
        attendRequest.setUserIdList(Collections.singletonList("083041355426244518"));
        AttendResponse attendResponse = attendService.listResult(accessToken, attendRequest);
        System.out.println(attendResponse);
    }
}