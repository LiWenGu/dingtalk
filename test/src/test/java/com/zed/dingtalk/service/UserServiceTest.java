package com.zed.dingtalk.service;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.user.UserDetailResponse;
import com.zed.dingtalk.service.user.UserService;
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
}