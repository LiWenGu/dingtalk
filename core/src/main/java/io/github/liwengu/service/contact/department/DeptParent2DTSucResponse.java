package io.github.liwengu.service.contact.department;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.liwengu.common.BaseDTFailResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author liwenguang
 * @Date 2018/12/1 4:59 PM
 * @Description 部门管理_查询指定用户的所有上级父部门路径
 */
@ToString(callSuper = true)
@Data
public class DeptParent2DTSucResponse extends BaseDTFailResponse {
    @JSONField(name = "department")
    private List<String> parentIds;
}