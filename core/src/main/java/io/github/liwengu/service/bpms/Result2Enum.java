package io.github.liwengu.service.bpms;

/**
 * @Author liwenguang
 * @Date 2018/11/24 2:11 PM
 * @Description 多个审批人的审批结果，返回值是大写
 */
public enum Result2Enum {
    NONE(0, "none", "未操作"),
    AGREE(1, "agree", "同意"),
    REFUSE(2, "refuse", "拒绝");

    Integer code;
    String msg;
    String remark;

    Result2Enum(Integer code, String msg, String remark) {
        this.code = code;
        this.msg = msg;
        this.remark = remark;
    }
}