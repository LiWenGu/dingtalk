package com.zed.dingtalk.service;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.contacts.department.DeptUserDetailResponse;
import com.zed.dingtalk.service.contacts.user.UserDeptDetailRequest;
import com.zed.dingtalk.service.contacts.user.UserDetailResponse;
import com.zed.dingtalk.service.contacts.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author liwenguang
 * @Date 2018/11/25 1:12 AM
 * @Description
 */
public class UserServiceTest extends DingTalkAppTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserDetail() {
        UserDetailResponse userDetailResponse = userService.getUserDetail("bee5935db66536c0a73c8f3ea3179b90", "manager2090");
        System.out.println(userDetailResponse.toString());
    }

    @Test
    public void getUserDeptIdDetail() {
        UserDeptDetailRequest request = new UserDeptDetailRequest();
        request.setOffset(0);
        request.setSize(10);
        request.setDeptId("83118467");
        DeptUserDetailResponse deptUserDetailResponse = userService.getUserDeptIdDetail(accessToken, request);
        System.out.println(deptUserDetailResponse.toString());
    }
}