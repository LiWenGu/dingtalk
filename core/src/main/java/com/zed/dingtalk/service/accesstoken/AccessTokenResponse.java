package com.zed.dingtalk.service.accesstoken;

import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/21 8:05 PM
 * @Description
 */
@Data
public class AccessTokenResponse {

    private boolean suc;
    private SucDetail sucDetail;
    private FailDetail failDetail;

    @Data
    public class SucDetail {
        private Integer expires;
        private String accessToken;
    }

    @Data
    public class FailDetail {
        private Integer errCode;
        private String errMsg;
    }
}