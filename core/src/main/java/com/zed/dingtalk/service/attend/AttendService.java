package com.zed.dingtalk.service.attend;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.zed.dingtalk.common.BaseResponse;
import com.zed.dingtalk.type.DingTalkEcoEnum;
import com.zed.dingtalk.util.ResponseTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liwenguang
 * @Date 2018/11/26 2:28 PM
 * @Description 考勤打卡
 */
@Service
public class AttendService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取考勤打卡
     *
     * @return
     */
    public AttendResponse listResult(String accessToken, AttendRequest attendRequest) {
        AttendResponse attendResponse = checkDay(attendRequest.getWorkDateFrom(), attendRequest.getWorkDateTo());
        if (attendResponse != null) {
            return attendResponse;
        }
        String response = restTemplate.postForObject(
                DingTalkEcoEnum.ATTENDS_LIST.getUrl() + "?access_token={accessToken}", attendRequest,
                String.class, accessToken);
        return ResponseTransferUtil.to(new AttendResponse(), response);
    }

    /**
     * 判断时间跨度是否超过 7 天
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    private AttendResponse checkDay(String fromDate, String toDate) {
        long day = DateUtil.between(DateUtil.parse(fromDate), DateUtil.parse(toDate), DateUnit.DAY);
        if (day > 7) {
            AttendResponse attendResponse = new AttendResponse();
            BaseResponse.FailDetail failDetail = new BaseResponse().new FailDetail();
            failDetail.setErrCode("41041");
            failDetail.setErrMsg("时间跨度不能超过7天");
            attendResponse.setFailDetail(failDetail);
            return attendResponse;
        } else {
            return null;
        }
    }

}