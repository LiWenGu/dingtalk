package io.github.liwengu.service.contact.department;

import io.github.liwengu.common.BaseResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @Author liwenguang
 * @Date 2018/11/27 12:32 AM
 * @Description 获取所有部门列表
 */
@ToString(callSuper = true)
public class DeptAllResponse extends BaseResponse<DeptAllResponse.SucDetail> {

    @Data
    public static class SucDetail {
        /**
         * key 为 depId, value 为该 deptId 的详情
         */
        Map<String, DeptDetail> deptDetailMap;

        @Data
        public static class DeptDetail {
            private String deptName;
            private String depId;
            private String parentDeptId;
            private List<String> childrenDeptId;
        }
    }

}