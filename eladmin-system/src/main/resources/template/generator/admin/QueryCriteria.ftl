package ${package}.service.dto;

import lombok.Data;
<#if hasTimestamp>
import java.sql.Timestamp;
</#if>
import me.zhengjie.tool.QueryCondition;
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>

/**
* @author ${author}
* @date ${date}
*/
@Data
public class ${className}QueryCriteria extends ${className}DTO{
<#if queryColumns??>
    <#list queryColumns as column>
    <#if column.columnQuery = '1'>
    // 模糊
    @QueryCondition(condition=QueryCondition.Condition.LIKE)
    </#if>
    <#if column.columnQuery = '2'>
    // 精确
    @QueryCondition(condition=QueryCondition.Condition.EQ)
    </#if>
    private ${column.columnType} ${column.changeColumnName};
    </#list>
</#if>
}