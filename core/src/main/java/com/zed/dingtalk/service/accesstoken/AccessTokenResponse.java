package com.zed.dingtalk.service.accesstoken;

import com.zed.dingtalk.common.BaseResponse;
import lombok.Data;
import lombok.ToString;

/**
 * @Author liwenguang
 * @Date 2018/11/21 8:05 PM
 * @Description
 */
@ToString(callSuper = true)
public class AccessTokenResponse extends BaseResponse<AccessTokenResponse.SucDetail> {

    @Data
    public class SucDetail {
        private Integer expires;
        private String accessToken;
    }
}