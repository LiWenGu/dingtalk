package com.zed.dingtalk.service.bpms;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/24 2:02 PM
 * @Description
 */
@Data
public class BpmsDTSucResponse {

    @JSONField(name = "dingtalk_smartwork_bpms_processinstance_get_response")
    private Response response;

    @Data
    public static class Response {
        private Result result;
        private String requestId;
    }

    @Data
    public static class Result {

        @JSONField(name = "ding_open_errcode")
        private Integer errCode;
        @JSONField(name = "error_msg")
        private String errMsg;
        private ProcessInstance processInstance;
        private boolean success;

        @Data
        public static class ProcessInstance {
            private String createTime;
            private String finishTime;
            @JSONField(name = "originator_userid")
            private String originatorUserId;
            private String originatorDeptId;
            private String originatorDeptName;
            private ResultEnum result;
            private OperationRecords operationRecords;
            private String title;
            private FormComponentValues formComponentValues;

            @Data
            public static class OperationRecords {
                private List<OperationRecordsVo> operationRecordsVo;

                @Data
                public static class OperationRecordsVo {
                    @JSONField(name = "date")
                    private String operationTime;
                    private Result2Enum operationResult;
                    @JSONField(name = "userid")
                    private String operationUserId;
                    private String remark;
                }
            }

            @Data
            public static class FormComponentValues {
                private List<FormComponentValueVo> formComponentValueVo;

                @Data
                public static class FormComponentValueVo {
                    private String name;
                    private String value;
                }
            }
        }
    }
}