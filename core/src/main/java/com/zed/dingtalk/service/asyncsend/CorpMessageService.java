package com.zed.dingtalk.service.asyncsend;

import com.zed.dingtalk.type.DingTalkEcoEnum;
import com.zed.dingtalk.util.BadSmellCodeResponseUtil;
import com.zed.dingtalk.util.BeanUtils;
import com.zed.dingtalk.util.ResponseTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liwenguang
 * @Date 2018/11/21 7:51 PM
 * @Description 企业消息
 */
public class CorpMessageService {

    @Autowired
    private RestTemplate restTemplate;
    private String agentId;

    public CorpMessageService(String agentId) {
        this.agentId = agentId;
    }

    /**
     * 钉钉异步通知
     * @param request
     * @return
     */
    public AsyncSendResponse asyncSend(AsyncSendRequest request) {
        AsyncSendResponse resultResponse = new AsyncSendResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        request.setAgent_id(agentId);
        request.setMethod(DingTalkEcoEnum.ASYNC_SEND.getCode());
        request.setV("2.0");
        request.setFormat("json");
        request.setSign_method("hmac-sha256");
        params.putAll(BeanUtils.BeanToMultiValueMap(request));
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity(params, headers);
        String response = restTemplate.postForObject(DingTalkEcoEnum.ASYNC_SEND.getUrl(), httpEntity, String.class);
        return ResponseTransferUtil.to(resultResponse, response);
    }
}