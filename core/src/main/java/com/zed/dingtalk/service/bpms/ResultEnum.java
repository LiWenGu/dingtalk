package com.zed.dingtalk.service.bpms;

/**
 * @Author liwenguang
 * @Date 2018/11/24 2:11 PM
 * @Description 某个审批的最终审批结果，审批结果是小写
 */
public enum ResultEnum {
    agree(1, "agree", "同意"),
    refuse(2, "refuse", "拒绝");

    Integer code;
    String msg;
    String remark;

    ResultEnum(Integer code, String msg, String remark) {
        this.code = code;
        this.msg = msg;
        this.remark = remark;
    }
}