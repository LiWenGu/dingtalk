package com.zed.dingtalk.service.callback;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/23 5:34 PM
 * @Description 注册事件回调地址
 */
@Data
public class CallBackRegisterRequest {

    private List<String> callBackTag;
    private String token;
    private String aesKey;
    private String url;

}