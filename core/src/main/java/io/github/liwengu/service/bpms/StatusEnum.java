package io.github.liwengu.service.bpms;

/**
 * @Author liwenguang
 * @Date 2018/11/24 2:11 PM
 * @Description 审批状态，感觉没用，实际使用 {@link ResultEnum} 判断
 */
public enum StatusEnum {
    NEW(1, "NEW", "刚创建"),
    RUNNING(2, "RUNNING", "运行中"),
    TERMINATED(3, "TERMINATED", "被终止"),
    COMPLETED(4, "COMPLETED", "完成"),
    CANCELED(5, "CANCELED", "取消");

    Integer code;
    String msg;
    String remark;

    StatusEnum(Integer code, String msg, String remark) {
        this.code = code;
        this.msg = msg;
        this.remark = remark;
    }
}