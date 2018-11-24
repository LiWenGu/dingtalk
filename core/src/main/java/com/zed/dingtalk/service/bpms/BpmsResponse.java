package com.zed.dingtalk.service.bpms;

import com.zed.dingtalk.common.BaseResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @Author liwenguang
 * @Date 2018/11/24 3:00 PM
 * @Description
 */
@ToString(callSuper = true)
public class BpmsResponse extends BaseResponse<BpmsResponse.SucDetail> {

    @Data
    public class SucDetail {
        private String requestId;
        private String createTime;
        private String finishTime;
        private String fromUserId;
        private String fromDeptId;
        private String fromDeptName;
        private String title;
        private ResultEnum result;
        private List<ToDetail> toDetailList;
        // 如果审批表单为空，则 Value 为 null 字符串，因此判空需要使用 StringUtils.isEmpty()
        private Map<String, String> formData;

        @Data
        public class ToDetail {
            private String userId;
            private String operationTime;
            private String remark;
            private Result2Enum result;
        }
    }
}