package com.zed.dingtalk.service.contact.user;

import lombok.Data;

/**
 * @Author liwenguang
 * @Date 2018/11/29 12:44 AM
 * @Description 获取部门用户详情
 */
@Data
public class UserDetailDeptRequest {

    private int offset;
    private int size;
    private String deptId;

}