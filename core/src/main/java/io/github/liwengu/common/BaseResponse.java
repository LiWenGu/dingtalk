package io.github.liwengu.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author liwenguang
 * @Date 2018/11/21 8:05 PM
 * @Description
 */
@Data
public class BaseResponse<T> {

    protected boolean suc;
    protected T sucDetail;
    protected FailDetail failDetail;

    @Getter
    @Setter
    @ToString
    public class FailDetail {
        private String errCode;
        private String errMsg;
    }
}