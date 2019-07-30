package ${package}.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.zhengjie.tool.WrapperFactory;
import ${package}.domain.${className};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package}.service.${className}Service;
import ${package}.service.dto.${className}QueryCriteria;
import ${package}.service.mapper.${className}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




/**
* @author ${author}
* @date ${date}
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}> implements ${className}Service {

    @Autowired
    private ${className}Mapper ${changeClassName}Mapper;

    @Override
    public IPage<${className}> queryAll(${className}QueryCriteria criteria, IPage<${className}> page){
        QueryWrapper<${className}> queryWrapper=new WrapperFactory<${className}>().dtoToQueryWrapper(criteria,null);
        return ${changeClassName}Mapper.selectPage(page,queryWrapper);
    }

    @Override
    public List<${className}> queryAll(${className}QueryCriteria criteria){
        QueryWrapper<${className}> queryWrapper=new WrapperFactory<${className}>().dtoToQueryWrapper(criteria,null);
        return ${changeClassName}Mapper.selectList(queryWrapper);
    }

    @Override
    public ${className} findById(${pkColumnType} ${pkChangeColName}) {
        return ${changeClassName}Mapper.selectById(${pkChangeColName});
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${className} create(${className} resources) {
<#if !auto && pkColumnType = 'Long'>
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        resources.set${pkCapitalColName}(snowflake.nextId()); 
</#if>
<#if !auto && pkColumnType = 'String'>
        resources.set${pkCapitalColName}(IdUtil.simpleUUID()); 
</#if>
<#if columns??>
    <#list columns as column>
    <#if column.columnKey = 'UNI'>
        if(${changeClassName}Repository.findBy${column.capitalColumnName}(resources.get${column.capitalColumnName}()) != null){
            throw new EntityExistException(${className}.class,"${column.columnName}",resources.get${column.capitalColumnName}());
        }
    </#if>
    </#list>
</#if>
        ${changeClassName}Mapper.insert(resources);
        return resources;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(${className} resources) {
        ${changeClassName}Mapper.update(resources,null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(${pkColumnType} ${pkChangeColName}) {
        ${changeClassName}Mapper.deleteById(${pkChangeColName});
    }
}