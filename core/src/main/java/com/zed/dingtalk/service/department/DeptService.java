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

    /**
     * @Author liwenguang
     * @Date 2018/11/26 11:51 PM
     * @Description 获取某个部门下所有的人员详情
     */
    public DeptUserDetailResponse getUserDetail(String accessToken, String deptId) {
        String response = restTemplate.getForObject(DingTalkEcoEnum.DEPT_USER_DETAIL_GET.getUrl() +
                "?access_token={accessToken}&department_id={deptId}", String.class, accessToken, deptId);
        return ResponseTransferUtil.to(new DeptUserDetailResponse(), response);
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/26 11:52 PM
     * @Description 获取某个部门的所有上级部门
     */
    public DeptParentResponse listPageDeptIds(String accessToken, String deptId) {
        String response = restTemplate.getForObject(DingTalkEcoEnum.DEPTS_LIST_PARENT_BY_DEPT.getUrl() +
                "?access_token={accessToken}&id={deptId}", String.class, accessToken, deptId);
        return ResponseTransferUtil.to(new DeptParentResponse(), response);
    }

    /**
     * @Author liwenguang
     * @Date 2018/11/27 12:30 AM
     * @Description 获取当前授权的所有部门列表
     */
    public DeptAllResponse listDeptIds(String accessToken) {
        String response = restTemplate.getForObject(DingTalkEcoEnum.DEPTS_LIST.getUrl() +
                "?access_token={accessToken}", String.class, accessToken);
        return ResponseTransferUtil.to(new DeptAllResponse(), response);
    }
}