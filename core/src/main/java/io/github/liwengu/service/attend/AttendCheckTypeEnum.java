package io.github.liwengu.service.attend;

/**
 * @Author liwenguang
 * @Date 2018/11/26 2:37 PM
 * @Description
 */
public enum AttendCheckTypeEnum {
    OnDuty("OnDuty", "上班"),
    OffDuty("OffDuty", "下班");

    private String code;
    private String msg;

    AttendCheckTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}