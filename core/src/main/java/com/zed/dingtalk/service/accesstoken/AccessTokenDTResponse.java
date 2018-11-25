package com.zed.dingtalk.service.accesstoken;

import com.alibaba.fastjson.annotation.JSONField;
import com.zed.dingtalk.common.BaseDTFailResponse;
import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:09 PM
 * @Description DT 真正返回的 Bean 类
 */
@Data
public class AccessTokenDTResponse extends BaseDTFailResponse {

    @JSONField(name = "expiresIn")
    private Integer expires;
    private String accessToken;
}