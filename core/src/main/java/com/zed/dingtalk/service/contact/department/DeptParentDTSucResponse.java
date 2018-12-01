package com.zed.dingtalk.service.contact.department;

import com.zed.dingtalk.common.BaseDTFailResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/11/25 9:48 PM
 * @Description 部门成员详情
 */
@ToString(callSuper = true)
@Data
public class DeptParentDTSucResponse extends BaseDTFailResponse {
    private List<String> parentIds;
}