package ${package}.service;

import ${package}.domain.${className};
import ${package}.service.dto.${className}QueryCriteria;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ${author}
* @date ${date}
*/
//@CacheConfig(cacheNames = "${changeClassName}")
public interface ${className}Service extends IService<${className}>{

    /**
    * queryAll 分页
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    IPage<${className}> queryAll(${className}QueryCriteria criteria, IPage<${className}> page);


    /**
    * queryAll 不分页
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public List<${className}> queryAll(${className}QueryCriteria criteria);

    /**
     * findById
     * @param ${pkChangeColName}
     * @return
     */
    //@Cacheable(key = "#p0")
    ${className} findById(${pkColumnType} ${pkChangeColName});

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    ${className} create(${className} resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(${className} resources);

    /**
     * delete
     * @param ${pkChangeColName}
     */
    //@CacheEvict(allEntries = true)
    void delete(${pkColumnType} ${pkChangeColName});
}