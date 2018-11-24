package com.zed.dingtalk.service;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.user.UserService;
import com.zed.dingtalk.service.user.UserDetailResponse;
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
        UserDetailResponse userDetailResponse = userService.getUserDetail("cee85031be3739318b50a1f060425e60", "manager20902");
        if (userDetailResponse.isSuc()) {

        } else {
            System.out.println(userDetailResponse.toString());
        }
    }
}