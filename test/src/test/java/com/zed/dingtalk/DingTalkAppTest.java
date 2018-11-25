package com.zed.dingtalk;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.zed.dingtalk")
public class DingTalkAppTest {
    protected String accessToken = "bee5935db66536c0a73c8f3ea3179b90";
}
