package com.zed.dingtalk;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.zed.dingtalk")
public class DingTalkAppTest {
    protected String accessToken = "dcdc151a3f05366d95749859729b3c01";
}
