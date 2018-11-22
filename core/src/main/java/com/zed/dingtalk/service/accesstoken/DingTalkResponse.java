package com.zed.dingtalk.service.accesstoken;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:09 PM
 * @Description DT 真正返回的 Bean 类
 */
@Data
public class DingTalkResponse {

    @JSONField(name = "expiresIn")
    private Integer expires;
    @JSONField(name = "errmsg")
    private String errMsg;
    private String accessToken;
    @JSONField(name = "errcode")
    private Integer errCode;
}