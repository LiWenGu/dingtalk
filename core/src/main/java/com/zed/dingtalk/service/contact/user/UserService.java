package com.zed.dingtalk.service.contact.user;

import com.zed.dingtalk.type.DingTalkEcoEnum;
import com.zed.dingtalk.util.ResponseTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liwenguang
 * @Date 2018/11/25 12:57 AM
 * @Description 用户管理
 */
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 用户管理_获取用户详情
     *
     * @param accessToken
     * @param userId
     * @return
     */
    public UserDetailResponse getUserDetail(String accessToken, String userId) {
        String response = restTemplate.getForObject(DingTalkEcoEnum.CONTACTS_USER_DETAIL_GET.getUrl() +
                "?access_token={accessToken}&userid={userId}", String.class, accessToken, userId);
        return ResponseTransferUtil.to(new UserDetailResponse(), response);
    }

    /**
     * 用户管理_获取部门用户详情
     *
     * @param accessToken
     * @param request
     * @return
     */
    public UserDetailDeptResponse getUserDeptIdDetail(String accessToken, UserDetailDeptRequest request) {
        String response = restTemplate.getForObject(DingTalkEcoEnum.CONTACTS_USER_DEPT_DETAIL_GET.getUrl() +
                        "?access_token={accessToken}&offset={offset}&size={size}&department_id={deptId}",
                String.class, accessToken, request.getOffset(), request.getSize(), request.getDeptId());
        return ResponseTransferUtil.to(new UserDetailDeptResponse(), response);
    }
}