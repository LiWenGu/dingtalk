package com.zed.dingtalk.service.contact.department;

import com.zed.dingtalk.common.BaseDTFailResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/27 12:32 AM
 * @Description 获取所有部门列表，钉钉原生接口，兼容成功和失败返回
 */
@ToString(callSuper = true)
@Data
public class DeptAllDTResponse extends BaseDTFailResponse {
    private List<Department> department;

    @Data
    public class Department {
        private String id;
        private String name;
        private String parentId;
    }
}