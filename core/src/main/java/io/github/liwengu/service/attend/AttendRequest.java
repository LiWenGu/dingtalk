package io.github.liwengu.service.attend;

import lombok.Data;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/26 2:30 PM
 * @Description
 */
@Data
public class AttendRequest {
    private String workDateFrom;
    private String workDateTo;
    private List<String> userIdList;
    private Integer offset;
    private Integer limit;
}