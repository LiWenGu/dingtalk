package com.zed.dingtalk.service.callback;

import com.zed.dingtalk.common.BaseResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/21 8:05 PM
 * @Description 注册和更新回调地址的返回 Bean
 */
@ToString(callSuper = true)
public class CallBackResponse extends BaseResponse<CallBackResponse.SucDetail> {

    @Data
    public class SucDetail {
        private String aesKey;
        private String token;
        private List<String> callBackTag;
        private String url;
    }
}