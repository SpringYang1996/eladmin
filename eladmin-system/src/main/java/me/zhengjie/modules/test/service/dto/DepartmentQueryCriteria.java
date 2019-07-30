package me.zhengjie.modules.test.service.dto;

import lombok.Data;
import me.zhengjie.tool.QueryCondition;

/**
* @author YnagXu
* @date 2019-07-30
*/
@Data
public class DepartmentQueryCriteria extends DepartmentDTO{
    // 精确
    @QueryCondition(condition=QueryCondition.Condition.EQ)
    private Long dId;
    // 模糊
    @QueryCondition(condition=QueryCondition.Condition.LIKE)
    private String dName;
}