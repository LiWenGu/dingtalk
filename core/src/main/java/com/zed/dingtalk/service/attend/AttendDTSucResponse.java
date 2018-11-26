package com.zed.dingtalk.service.attend;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/26 2:30 PM
 * @Description
 */
@Data
public class AttendDTSucResponse {
    private boolean hasMore;
    private List<RecordResult> recordResult;

    @Data
    public class RecordResult {
        private String userId;
        private Long workDate;
        @JSONField(name = "userCheckTime")
        private Long checkDate;
        private AttendCheckTypeEnum checkType;
        private AttendSourceTypeEnum sourceType;
    }
}