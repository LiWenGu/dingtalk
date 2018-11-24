package com.zed.dingtalk.service.callback;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:09 PM
 * @Description DT 真正返回的 Bean 类，回调地址失败的 Bean： {@link com.zed.dingtalk.common.BaseDingTalkFailResponse}
 */
@Data
public class CallBackDTSucResponse {

    private String aesKey;
    private String token;
    private List<String> callBackTag;
    @JSONField(name = "errmsg")
    private String errMsg;
    private String url;
    @JSONField(name = "errcode")
    private Integer errCode;

}