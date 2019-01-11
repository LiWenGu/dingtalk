package io.github.liwengu.service.attend;

/**
 * @Author liwenguang
 * @Date 2018/11/26 2:37 PM
 * @Description
 */
public enum AttendSourceTypeEnum {
    ATM("ATM", "考勤机"),
    BEACON("BEACON", "IBeacon"),
    DING_ATM("DING_ATM", "钉钉考勤机"),
    USER("USER", "用户打卡"),
    BOSS("BOSS", "老板改签"),
    APPROVE("APPROVE", "审批系统"),
    SYSTEM("SYSTEM", "考勤系统"),
    AUTO_CHECK("AUTO_CHECK", "自动打卡");

    private String code;
    private String msg;

    AttendSourceTypeEnum(String code, String msg) {
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