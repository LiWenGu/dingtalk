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
public class DeptParentResponse extends BaseResponse<DeptParentResponse.SucDetail> {

    @Data
    public class SucDetail {
        /**
         * 级别由最近的到最顶级的排序
         */
        private List<String> deptIds;
    }

}