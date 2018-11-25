package com.zed.dingtalk.service;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.bpms.BpmsRequest;
import com.zed.dingtalk.service.bpms.BpmsResponse;
import com.zed.dingtalk.service.bpms.BpmsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author liwenguang
 * @Date 2018/11/24 3:04 PM
 * @Description 审批实例
 */
@Slf4j
public class BpmsServiceTest extends DingTalkAppTest {

    @Autowired
    private BpmsService bpmsService;

    @Test
    public void getDetail() {
        BpmsRequest request = new BpmsRequest();
        request.setSession(accessToken);
        request.setProcess_instance_id("6713ef32-7d3a-4d6b-ad0c-fb747ce29e3e");
        BpmsResponse bpmsResponse = bpmsService.getDetail(request);
        if (bpmsResponse.isSuc()) {
            System.out.println(bpmsResponse.toString());
        } else {
            System.out.println(bpmsResponse.toString());
        }
    }
}