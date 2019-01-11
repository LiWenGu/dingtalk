package io.github.liwengu.service.callback;

import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/23 5:55 PM
 * @Description
 */
@Data
public class CallBackDTRequest {

    private List<String> call_back_tag;
    private String token;
    private String aes_key;
    private String url;

}