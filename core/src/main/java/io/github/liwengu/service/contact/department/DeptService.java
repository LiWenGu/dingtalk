package io.github.liwengu.service.contact.department;

import io.github.liwengu.type.DingTalkEcoEnum;
import io.github.liwengu.util.ResponseTransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @Author liwenguang
 * @Date 2018/11/25 10:07 PM
 * @Description 部门管理
 */
public class DeptService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 部门管理_查询部门的所有上级父部门路径
     *
     * @param accessToken
     * @param deptId
     * @return
     */
    public DeptParentResponse listParentDeptsByDeptId(String accessToken, String deptId) {
        String response = restTemplate.getForObject(DingTalkEcoEnum.CONTACTS_DEPT_PARENT_BY_DEPT_GET.getUrl() +
                "?access_token={accessToken}&id={deptId}", String.class, accessToken, deptId);
        return ResponseTransferUtil.to(new DeptParentResponse(), response);
    }

    /**
     * 部门管理_获取部门列表
     *
     * @param accessToken
     * @return
     */
    public DeptAllResponse listDeptIds(String accessToken) {
        String response = restTemplate.getForObject(DingTalkEcoEnum.CONTACTS_DEPT_ALL_LIST_GET.getUrl() +
                "?access_token={accessToken}", String.class, accessToken);
        return ResponseTransferUtil.to(new DeptAllResponse(), response);
    }

    /**
     * 部门管理_查询指定用户的所有上级父部门路径
     *
     * @param accessToken
     * @return
     */
    public DeptParentResponse listParentDeptsByUserId(String accessToken, String userId) {
        String response = restTemplate.getForObject(DingTalkEcoEnum.CONTACTS_DEPT_PARENT_BY_USERID_GET.getUrl() +
                "?access_token={accessToken}&userId={userId}", String.class, accessToken, userId);
        return ResponseTransferUtil.to2(new DeptParentResponse(), response);
    }
}