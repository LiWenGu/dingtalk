package com.zed.dingtalk.service.user;

import com.zed.dingtalk.common.BaseResponse;
import lombok.Data;
import lombok.ToString;

/**
 * @Author liwenguang
 * @Date 2018/11/25 1:02 AM
 * @Description
 */
@ToString(callSuper = true)
public class UserDetailResponse extends BaseResponse<UserDetailResponse.SucDetail> {

    @Data
    public class SucDetail {

    }

}