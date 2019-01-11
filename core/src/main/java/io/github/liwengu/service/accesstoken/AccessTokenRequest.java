package io.github.liwengu.service.accesstoken;

import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/22 10:43 PM
 * @Description 获取系统级别的 access_token
 */
@Data
public class AccessTokenRequest {

    private String corpId;
    private String corpSecret;

}