package com.zed.dingtalk.common;

import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/25 1:05 AM
 * @Description 如果有 sub_code，则使用 | 分割，例如获取审批实例详情时错误时，这时候 errMsg = msg | sub_msg
 */
@Data
public class BaseDTFailResponse {
    private String errMsg;
    private String errCode;
}