package com.zed.dingtalk.service.common;

import com.zed.dingtalk.service.accesstoken.AccessTokenResponse;
import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/21 8:05 PM
 * @Description
 */
@Data
public class BaseResponse<T> {

    private boolean suc;
    private T sucDetail;
    private FailDetail failDetail;

    @Data
    public class FailDetail {
        private String errCode;
        private String errMsg;
    }
}