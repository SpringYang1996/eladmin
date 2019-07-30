package ${package}.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

<#if hasTimestamp>
import java.sql.Timestamp;
</#if>
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>
import java.io.Serializable;

/**
* @author ${author}
* @date ${date}
*/

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ${className} extends Model<${className}>  implements Serializable {
<#if columns??>
    <#list columns as column>

    <#if column.columnComment != ''>
    // ${column.columnComment}
    </#if>
    <#if column.columnKey = 'PRI'>
    <#if auto>
<#--    @GeneratedValue(strategy = GenerationType.IDENTITY)-->
    @TableId(value = "${column.columnComment}", type = IdType.AUTO)
    </#if>
    </#if>
<#--    @Column(name = "${column.columnName}"<#if column.columnKey = 'UNI'>,unique = true</#if><#if column.isNullable = 'NO' && column.columnKey != 'PRI'>,nullable = false</#if>)-->
    private ${column.columnType} ${column.changeColumnName};
    </#list>


</#if>

<#--    public void copy(${className} source){-->
<#--        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));-->
<#--    }-->
}