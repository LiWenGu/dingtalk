package io.github.liwengu.service.attend;

import io.github.liwengu.common.BaseResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/26 2:30 PM
 * @Description
 */
@ToString(callSuper = true)
public class AttendResponse extends BaseResponse<AttendResponse.SucDetail> {

    @Data
    public static class SucDetail {
        private boolean hasMore;
        private List<Record> recordList;

        @Data
        public static class Record {
            private String userId;
            private String workDate;
            private String checkDate;
            private AttendCheckTypeEnum checkType;
            private AttendSourceTypeEnum sourceType;
        }
    }
}