package com.zed.dingtalk.service;

import com.zed.dingtalk.DingTalkAppTest;
import com.zed.dingtalk.service.callback.CallBackRegisterRequest;
import com.zed.dingtalk.service.common.BaseResponse;
import com.zed.dingtalk.service.callback.CallBackService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/23 5:31 PM
 * @Description 回调地址
 */
@Slf4j
public class CallBackServiceTest extends DingTalkAppTest {

    @Autowired
    private CallBackService callBackService;

    @Test
    public void register() {
        CallBackRegisterRequest callBackRegisterRequest = new CallBackRegisterRequest();
        List<String> tag = new ArrayList<>(8);
        tag.add("bpms_task_change");
        tag.add("bpms_instance_change");
        callBackRegisterRequest.setCallBackTag(tag);
        callBackRegisterRequest.setAesKey("cIWtQgvtTEWhdvyOHPXrMtGM88yzzAyF7FYVXqxHwPZ");
        callBackRegisterRequest.setUrl("https://torder.baletu.com/dd/bpmsChangeData");
        callBackRegisterRequest.setToken("123456");
        BaseResponse response = callBackService.register("6c877443dc733b09ad5e598c93bf5c27", callBackRegisterRequest);
        if (response.isSuc()) {
            System.out.println();
        } else {
            System.out.println(response.getFailDetail().getErrCode() + response.getFailDetail().getErrMsg());
        }
    }

    @Test
    public void delete() {
        BaseResponse response = callBackService.delete("6c877443dc733b09ad5e598c93bf5c27");
        if (response.isSuc()) {
            System.out.println();
        } else {
            System.out.println(response.getFailDetail().getErrCode() + response.getFailDetail().getErrMsg());
        }
    }

    @Test
    public void select() {
        BaseResponse response = callBackService.select("6c877443dc733b09ad5e598c93bf5c27");
        if (response.isSuc()) {
            System.out.println();
        } else {
            System.out.println(response.getFailDetail().getErrCode() + response.getFailDetail().getErrMsg());
        }
    }

    @Test
    public void update() {
        CallBackRegisterRequest callBackRegisterRequest = new CallBackRegisterRequest();
        List<String> tag = new ArrayList<>(8);
        tag.add("bpms_task_change");
        tag.add("bpms_instance_change");
        callBackRegisterRequest.setCallBackTag(tag);
        callBackRegisterRequest.setAesKey("cIWtQgvtTEWhdvyOHPXrMtGM88yzzAyF7FYVXqxHwPZ");
        callBackRegisterRequest.setUrl("https://torder.baletu.com/dd/bpmsChangeData");
        callBackRegisterRequest.setToken("123456");
        BaseResponse response = callBackService.update("6c877443dc733b09ad5e598c93bf5c27", callBackRegisterRequest);
        if (response.isSuc()) {
            System.out.println();
        } else {
            System.out.println(response.getFailDetail().getErrCode() + response.getFailDetail().getErrMsg());
        }
    }
}