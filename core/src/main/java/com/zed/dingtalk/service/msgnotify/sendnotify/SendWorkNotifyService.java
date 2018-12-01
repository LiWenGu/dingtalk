package com.zed.dingtalk.service.msgnotify.sendnotify;

import com.zed.dingtalk.type.DingTalkEcoEnum;
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
 * 注意：同一个微应用相同消息内容同一个用户一天只能接收一次，重复发送会发送成功但用户接收不到。
 */
public class SendWorkNotifyService {

    @Autowired
    private RestTemplate restTemplate;
    private String agentId;

    public SendWorkNotifyService(String agentId) {
        this.agentId = agentId;
    }

    /**
     * 钉钉异步通知
     *
     * @param request
     * @return
     * @deprecated 可以请求成功，但是在钉钉官方文档中没有写明，因此建议使用官方文档的：{@link SendWorkNotifyService#asyncSend(String, SendWorkAsyncSendRequest) }
     */
    public AsyncSendResponse asyncSend(AsyncSendRequest request) {
        AsyncSendResponse resultResponse = new AsyncSendResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        request.setAgent_id(agentId);
        request.setMethod(DingTalkEcoEnum.SEND_ASYNC_SEND.getCode());
        request.setV("2.0");
        request.setFormat("json");
        request.setSign_method("hmac-sha256");
        params.putAll(BeanUtils.BeanToMultiValueMap(request));
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity(params, headers);
        String response = restTemplate.postForObject(DingTalkEcoEnum.SEND_ASYNC_SEND.getUrl(), httpEntity, String.class);
        return ResponseTransferUtil.to(resultResponse, response);
    }

    /**
     * 钉钉异步通知
     *
     * @param request
     * @return
     */
    public SendWorkResponse asyncSend(String accessToken, SendWorkAsyncSendRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        request.setAgent_id(agentId);
        params.putAll(BeanUtils.BeanToMultiValueMap(request));
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity(params, headers);
        String response = restTemplate.postForObject(DingTalkEcoEnum.SEND_ASYNC_NOFITY_MSG.getUrl() +
                "?access_token={accessToken}", httpEntity, String.class, accessToken);
        return ResponseTransferUtil.to(new SendWorkResponse(), response);
    }
}