package io.github.liwengu.service;

import io.github.liwengu.DingTalkAppTest;
import io.github.liwengu.service.callback.CallBackRegisterRequest;
import io.github.liwengu.service.callback.CallBackResponse;
import io.github.liwengu.service.callback.CallBackService;
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
        CallBackResponse callBackResponse = callBackService.register(accessToken, callBackRegisterRequest);
        System.out.println(callBackResponse.toString());
    }

    @Test
    public void delete() {
        CallBackResponse callBackResponse = callBackService.delete(accessToken);
        System.out.println(callBackResponse.toString());
    }

    @Test
    public void select() {
        CallBackResponse callBackResponse = callBackService.select(accessToken);
        System.out.println(callBackResponse.toString());
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
        CallBackResponse callBackResponse = callBackService.update(accessToken, callBackRegisterRequest);
        System.out.println(callBackResponse.toString());
    }
}