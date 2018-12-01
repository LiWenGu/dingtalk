package com.zed.dingtalk.service.bpms;

import com.zed.dingtalk.type.DingTalkEcoEnum;
import com.zed.dingtalk.util.BeanUtils;
import com.zed.dingtalk.util.ResponseTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liwenguang
 * @Date 2018/11/24 2:02 PM
 * @Description
 */
@Service
public class BpmsService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取单个审批实例详细信息
     * 这里使用 post 或 get 请求钉钉接口都行！
     * @param request
     * @return
     */
    public BpmsResponse getDetail(BpmsRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        request.setMethod(DingTalkEcoEnum.BPMS_GET.getCode());
        request.setV("2.0");
        request.setFormat("json");
        params.putAll(BeanUtils.BeanToMultiValueMap(request));
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity(params, headers);
        String response = restTemplate.postForObject(DingTalkEcoEnum.BPMS_GET.getUrl(), httpEntity, String.class);
        return ResponseTransferUtil.to(new BpmsResponse(), response);
    }
}