package com.zed.dingtalk.service;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.contacts.department.DeptAllResponse;
import com.zed.dingtalk.service.contacts.department.DeptParentResponse;
import com.zed.dingtalk.service.contacts.department.DeptService;
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
    public void listPageDeptIds() {
        DeptParentResponse deptParentResponse = deptService.listPageDeptIds(accessToken, "83118467");
        System.out.println(deptParentResponse.toString());
    }

    @Test
    public void listDeptIds() {
        DeptAllResponse deptAllResponse = deptService.listDeptIds(accessToken);
        System.out.println(deptAllResponse.toString());
    }
}