package com.zed.dingtalk.service.contact;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.contact.user.UserDetailDeptRequest;
import com.zed.dingtalk.service.contact.user.UserDetailDeptResponse;
import com.zed.dingtalk.service.contact.user.UserDetailResponse;
import com.zed.dingtalk.service.contact.user.UserService;
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
        UserDetailDeptRequest request = new UserDetailDeptRequest();
        request.setOffset(0);
        request.setSize(10);
        request.setDeptId("83118467");
        UserDetailDeptResponse deptUserDetailResponse = userService.getUserDeptIdDetail(accessToken, request);
        System.out.println(deptUserDetailResponse.toString());
    }
}