package com.zed.dingtalk.service.bpms;

import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/24 3:00 PM
 * @Description 审批请求体
 */
@Data
public class BpmsRequest {
    private String method;
    private String session;
    private String v;
    private String process_instance_id;
    private String format;
}