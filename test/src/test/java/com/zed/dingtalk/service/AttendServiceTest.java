package com.zed.dingtalk.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.attend.AttendCheckTypeEnum;
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

    @Test
    public void listGood() {
        String startDate = "2018-11-01 00:00:00";
        println(startDate, "083041355426244518");
        System.out.println("xxxxxxx");
        println(startDate, "125408486920028979");
    }

    private void println(String startDate, String userId) {
        DateTime base = DateUtil.parse(startDate);
        for (int i = 0; i < 31; i += 8) {
            DateTime from = DateUtil.offsetDay(base, i);
            DateTime to = DateUtil.offsetDay(from, 7);
            AttendRequest attendRequest = new AttendRequest();
            attendRequest.setWorkDateFrom(from.toString());
            attendRequest.setWorkDateTo(to.toString());
            attendRequest.setOffset(0);
            attendRequest.setLimit(14);
            attendRequest.setUserIdList(Collections.singletonList(userId));
            AttendResponse attendResponse = attendService.listResult(accessToken, attendRequest);
            for (AttendResponse.SucDetail.Record record : attendResponse.getSucDetail().getRecordList()) {
                if (record.getCheckType().equals(AttendCheckTypeEnum.OffDuty)) {
                    System.out.println(record.getCheckDate());
                }
            }
        }
    }
}