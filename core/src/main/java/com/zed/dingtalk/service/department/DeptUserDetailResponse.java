package com.zed.dingtalk.service.department;

import com.zed.dingtalk.common.BaseResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/25 9:48 PM
 * @Description 部门成员详情
 */
@ToString(callSuper = true)
public class DeptUserDetailResponse extends BaseResponse<DeptUserDetailResponse.SucDetail> {

    @Data
    public class SucDetail {
        private List<User> userList;

        @Data
        public class User {
            private String userId;
            private String name;
            private String mobile;
            private List<String> deptIds;
        }
    }

}