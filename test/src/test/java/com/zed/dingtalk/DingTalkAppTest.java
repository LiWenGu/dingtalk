package com.zed.dingtalk;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.zed.dingtalk")
public class DingTalkAppTest {
    protected String accessToken = "aca953b0c1ec377489fa1b8232283072";
}
