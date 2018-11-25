package com.zed.dingtalk.service.department;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/25 9:47 PM
 * @Description
 */
@Data
public class DeptUserDetailDTSucResponse {
    private List<User> userlist;

    @Data
    public class User {
        private String mobile;
        private String name;
        private String userId;
        @JSONField(name = "department")
        private List<String> deptIds;
    }

}