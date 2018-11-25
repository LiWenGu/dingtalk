package com.zed.dingtalk.service;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.department.DeptService;
import com.zed.dingtalk.service.department.DeptUserDetailResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author liwenguang
 * @Date 2018/11/25 1:12 AM
 * @Description
 */
public class DeptServiceTest extends DingTalkAppTest {

    @Autowired
    private DeptService deptService;

    @Test
    public void getUserDetail() {
        DeptUserDetailResponse deptUserDetailResponse = deptService.getUserDetail(accessToken, "83118467");
        System.out.println(deptUserDetailResponse.toString());
    }
}