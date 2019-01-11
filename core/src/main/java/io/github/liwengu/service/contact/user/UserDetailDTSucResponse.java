package io.github.liwengu.service.contact.user;

import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/25 1:00 AM
 * @Description
 */
@Data
public class UserDetailDTSucResponse {
    private String mobile;
    private String name;
    private String userId;
    private List<String> department;
}