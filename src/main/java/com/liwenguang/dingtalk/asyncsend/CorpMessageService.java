package com.liwenguang.dingtalk.asyncsend;

import com.liwenguang.dingtalk.type.DingTalkEcoEnum;
import com.liwenguang.dingtalk.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liwenguang
 * @Date 2018/11/21 7:51 PM
 * @Description 企业消息
 */
@Service
public class CorpMessageService {

    @Autowired
    private RestTemplate restTemplate;

    public AsyncSendResponse asyncSend(AsyncSendRequest request) {
        AsyncSendResponse resultResponse = new AsyncSendResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        request.setMethod(DingTalkEcoEnum.ASYNC_SEND.getCode());
        request.setV("2.0");
        request.setFormat("json");
        request.setSign_method("hmac-sha256");
        params.putAll(BeanUtil.BeanToMultiValueMap(request));
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity(params, headers);
        String response = restTemplate.postForObject(DingTalkEcoEnum.ASYNC_SEND.getUrl(), httpEntity, String.class);
        BadSmellCodeUtil.to(resultResponse, response);
        return resultResponse;
    }
}