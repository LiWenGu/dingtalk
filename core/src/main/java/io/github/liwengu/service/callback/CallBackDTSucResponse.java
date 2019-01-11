package io.github.liwengu.service.callback;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.liwengu.common.BaseDTFailResponse;
import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/22 12:09 PM
 * @Description DT 真正返回的 Bean 类，回调地址失败的 Bean： {@link BaseDTFailResponse}
 */
@Data
public class CallBackDTSucResponse {

    private String aesKey;
    private String token;
    private List<String> callBackTag;
    @JSONField(name = "errmsg")
    private String errMsg;
    private String url;
    @JSONField(name = "errcode")
    private Integer errCode;

}