package com.liwenguang.dingtalk.exception;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:56 PM
 * @Description
 */
public class DingTalkRequestException extends Exception{

    public DingTalkRequestException() {
    }

    public DingTalkRequestException(String message) {
        super(message);
    }

    public DingTalkRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public DingTalkRequestException(Throwable cause) {
        super(cause);
    }

    public DingTalkRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}