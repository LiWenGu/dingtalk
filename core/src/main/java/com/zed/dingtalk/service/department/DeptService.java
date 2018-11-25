package com.zed.dingtalk.service.department;

import com.zed.dingtalk.type.DingTalkEcoEnum;
import com.zed.dingtalk.util.ResponseTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liwenguang
 * @Date 2018/11/25 10:07 PM
 * @Description 部门服务
 */
@Service
public class DeptService {

    @Autowired
    private RestTemplate restTemplate;

    public DeptUserDetailResponse getUserDetail(String accessToken, String deptId) {
        String response = restTemplate.getForObject(DingTalkEcoEnum.DEPT_USER_DETAIL_GET.getUrl() +
                "?access_token={accessToken}&department_id={deptId}", String.class, accessToken, deptId);
        return ResponseTransferUtil.to(new DeptUserDetailResponse(), response);
    }
}