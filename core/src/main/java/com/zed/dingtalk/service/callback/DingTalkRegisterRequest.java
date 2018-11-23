package com.zed.dingtalk.service.callback;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/23 5:55 PM
 * @Description
 */
@Data
public class DingTalkRegisterRequest {

    private List<String> call_back_tag;
    private String token;
    private String aes_key;
    private String url;

}